package com.jhkwim.commutealarm.parse

import android.util.Log
import com.jhkwim.commutealarm.data.WorkSchedule
import com.jhkwim.commutealarm.utils.DateTimeUtils
import java.time.LocalDateTime
import java.util.*

class CommuteStringParser(private val date: LocalDateTime, private val text: String) {

    companion object {
        private const val TAG= "CommuteStringParser"
        private const val WORKING_DATE_PATTERN = "yyyy년MM월dd일(E)"
        private const val WORKING_TIME_PATTERN = "ahh:mm"
        private const val QUITTING_TIME_PATTERN = "ah:mm"
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
        var workSchedule = WorkSchedule.WEEKDAY_WORK
        var time = ""
        var expected = ""

        items.forEach {
            val keywords = it.split(": ")

            if (keywords.size < 2) throw Exception("Can't parse keywords : keywords size is ${keywords.size}")

            val keyword = CommuteKeyWord.getByKeyword(keywords[0].replace("\\s".toRegex(), ""))
            val value = keywords[1].replace("\\s".toRegex(), "")

            when (keyword) {
                CommuteKeyWord.NAME -> name = value
                CommuteKeyWord.DATE -> date = "${this.date.year}년$value"
                CommuteKeyWord.SCHEDULE -> workSchedule = WorkSchedule.getBySchedule(value)
                CommuteKeyWord.WORKING_TIME -> time = value
                CommuteKeyWord.EXPECTED_TIME -> expected = value
                else -> {
                    Log.w(TAG, "unknown keyword : $keywords")
                }
            }
        }

        val workingDate = DateTimeUtils.stringToDate(WORKING_DATE_PATTERN, date)
        val workingTime = DateTimeUtils.stringToTime(WORKING_TIME_PATTERN, time, Locale.ENGLISH)
        val workingDateTime = DateTimeUtils.dateTime(workingDate, workingTime)

        val expectedTime = DateTimeUtils.stringToTime(QUITTING_TIME_PATTERN, expected, Locale.ENGLISH)
        val expectedDateTime = DateTimeUtils.dateTime(workingDate, expectedTime)

        return CommuteStr(name, workingDateTime, workSchedule, expectedDateTime)
    }
}
