package com.jhkwim.commutealarm.data

import java.time.LocalTime

enum class WorkSchedule(val schedule: String) {
    WEEKDAY_WORK("평일9시"),
    ANNUAL_LEAVE_MORNING("오전반차"),
    ANNUAL_LEAVE_AFTERNOON("오후반차");

    companion object {
        fun getBySchedule(schedule: String) =
            values().find { it.schedule == schedule.replace("\\s".toRegex(), "") } ?: WEEKDAY_WORK
    }

    val fixedWorkingTime: Pair<LocalTime, LocalTime>
        get() {
            return when (this) {
                WEEKDAY_WORK -> Pair(LocalTime.of(8, 0), LocalTime.of(10, 0))
                ANNUAL_LEAVE_MORNING -> Pair(LocalTime.of(13, 30), LocalTime.of(13, 30))
                ANNUAL_LEAVE_AFTERNOON -> Pair(LocalTime.of(8, 0), LocalTime.of(10, 0))
            }
        }
}