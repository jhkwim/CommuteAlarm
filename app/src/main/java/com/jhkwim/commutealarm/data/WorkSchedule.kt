package com.jhkwim.commutealarm.data

enum class WorkSchedule(val schedule: String) {
    WEEKDAY_WORK("평일9시"),
    ANNUAL_LEAVE_MORNING("오전반차"),
    ANNUAL_LEAVE_AFTERNOON("오후반차");

    companion object {
        fun getBySchedule(schedule: String) =
            values().find { it.schedule == schedule } ?: WEEKDAY_WORK
    }
}