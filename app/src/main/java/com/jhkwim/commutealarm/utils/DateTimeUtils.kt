package com.jhkwim.commutealarm.utils

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException
import java.util.*

object DateTimeUtils {

    @Throws(
        NullPointerException::class,
        IllegalArgumentException::class,
        DateTimeParseException::class
    )
    fun stringToDateTime(
        pattern: String,
        dateTime: String,
        locale: Locale = Locale.KOREAN
    ): LocalDateTime {
        val dateFormat = DateTimeFormatter.ofPattern(pattern, locale)
        return LocalDateTime.parse(dateTime, dateFormat)
    }

    @Throws(
        NullPointerException::class
    )
    fun dateTime(date: LocalDate, time: LocalTime): LocalDateTime {
        return LocalDateTime.of(date, time)
    }

    @Throws(
        NullPointerException::class,
        IllegalArgumentException::class,
        DateTimeParseException::class
    )
    fun stringToDate(pattern: String, date: String, locale: Locale = Locale.KOREAN): LocalDate {
        val dateFormat = DateTimeFormatter.ofPattern(pattern, locale)
        return LocalDate.parse(date, dateFormat)
    }

    @Throws(
        NullPointerException::class,
        IllegalArgumentException::class,
        DateTimeParseException::class
    )
    fun stringToTime(pattern: String, time: String, locale: Locale = Locale.KOREAN): LocalTime {
        val dateFormat = DateTimeFormatter.ofPattern(pattern, locale)
        return LocalTime.parse(time, dateFormat)
    }

}