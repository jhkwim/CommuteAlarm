package com.jhkwim.commutealarm

import com.jhkwim.commutealarm.utils.DateTimeUtils
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.date.*
import io.kotest.matchers.shouldBe
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.LocalTime
import java.util.*

class DateTimeUtilTest : StringSpec({

    "문자열 -> LocalTime 변환" {
        val pattern = "ahh:mm"
        var str = "오전11:14"
        var time = DateTimeUtils.stringToTime(pattern, str)

        time.hour shouldBe 11
        time.minute shouldBe 14

        str = "PM05:22"
        time = DateTimeUtils.stringToTime(pattern, str, Locale.ENGLISH)

        time.hour shouldBe 17
        time.minute shouldBe 22
    }

    "문자열 -> LocalDate 변환" {
        val pattern = "yyyy년MM월dd일(E)"
        val str = "2022년03월30일(수)"

        val date = DateTimeUtils.stringToDate(pattern, str)

        date.year shouldBe 2022
        date.monthValue shouldBe 3
        date.dayOfMonth shouldBe 30
        date.dayOfWeek shouldBe DayOfWeek.WEDNESDAY
    }

    "문자열 -> LocalDateTime 변환" {
        val pattern = "yyyy년MM월dd일(E)ahh:mm"
        val date = "2022년03월30일(수)오전11:14"

        val dateTime = DateTimeUtils.stringToDateTime(pattern, date)

        dateTime.year shouldBe 2022
        dateTime shouldHaveMonth 3
        dateTime shouldHaveDayOfMonth 30
        dateTime shouldHaveDayOfWeek DayOfWeek.WEDNESDAY
        dateTime shouldHaveHour 11
        dateTime shouldHaveMinute 14
    }

    "LocalDate + LocalTime -> LocalDateTime" {
        val date = LocalDate.of(2022, 4, 1)
        val time = LocalTime.of(0, 8)

        val dateTime = DateTimeUtils.dateTime(date, time)

        dateTime.year shouldBe 2022
        dateTime shouldHaveMonth 4
        dateTime shouldHaveDayOfMonth 1
        dateTime shouldHaveDayOfWeek DayOfWeek.FRIDAY
        dateTime shouldHaveHour 0
        dateTime shouldHaveMinute 8
    }
})