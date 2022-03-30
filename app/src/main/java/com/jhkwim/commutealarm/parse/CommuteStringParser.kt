package com.jhkwim.commutealarm.parse

import com.jhkwim.commutealarm.data.OfficeHour
import com.jhkwim.commutealarm.utils.DateTimeUtils
import java.util.*

class CommuteStringParser(private val text: String) {

    companion object {
        private const val WORKING_DATE_PATTERN = "MM월dd일(E)"
        private const val WORKING_TIME_PATTERN = "ahh:mm"
        private const val QUITTING_TIME_PATTERN = "ahh:mm"
    }

    fun parse(): CommuteStr {
        val items = filterMainKeyword(text)

        return stringsToCommute(items)
    }

    fun filterMainKeyword(text: String): List<String> = text.split("\n").filter {
        it.isNotEmpty() && it.contains(":")
    }

    fun stringsToCommute(items: List<String>): CommuteStr {
        var name = ""
        var date = ""
        val officeHour = OfficeHour.FULL
        var time = ""
        var expected = ""

        items.forEach {
            val keywords = it.split(":")

            if (keywords.size < 2) return@forEach

            when (keywords[0].trim()) {
                CommuteKeyWord.NAME.keyword -> name = keywords[1].trim()
                CommuteKeyWord.DATE.keyword -> date = keywords[1].trim()
//                CommuteKeyWord.SCHEDULE.keyword -> officeHour =
                CommuteKeyWord.WORKING_TIME.keyword -> time = keywords[1].trim()
                CommuteKeyWord.EXPECTED_TIME.keyword -> expected = keywords[1].trim()
            }
        }

        val workingDate = DateTimeUtils.stringToDate(WORKING_DATE_PATTERN, date)
        val workingTime = DateTimeUtils.stringToTime(WORKING_TIME_PATTERN, time, Locale.ENGLISH)
        val workingDateTime = DateTimeUtils.dateTime(workingDate, workingTime)

        val expectedTime = DateTimeUtils.stringToTime(QUITTING_TIME_PATTERN, expected, Locale.ENGLISH)
        val expectedDateTime = DateTimeUtils.dateTime(workingDate, expectedTime)

        return CommuteStr(name, workingDateTime, officeHour, expectedDateTime)
    }
}
