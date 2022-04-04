package com.jhkwim.commutealarm

import com.jhkwim.commutealarm.data.CommuteInfo
import com.jhkwim.commutealarm.data.WorkSchedule
import java.time.LocalDateTime

class FinishTimeCalculator(private val commuteInfo: CommuteInfo) {

    fun calculate(): LocalDateTime {
        val workingTime = getWorkingTime()
        val quittingTime: LocalDateTime =
        when (commuteInfo.workSchedule) {
            WorkSchedule.WEEKDAY_WORK -> workingTime.plusHours(9)
            WorkSchedule.ANNUAL_LEAVE_MORNING -> TODO()
            WorkSchedule.ANNUAL_LEAVE_AFTERNOON -> TODO()
        }

        return quittingTime
    }

    fun getWorkingTime(): LocalDateTime {
        val realWorkingTime = commuteInfo.workingDateTime.toLocalTime()
        val fixedWorkingTime = commuteInfo.workSchedule.fixedWorkingTime

        return when {
            realWorkingTime.isBefore(fixedWorkingTime.first) -> {
                LocalDateTime.of(
                    commuteInfo.workingDateTime.year,
                    commuteInfo.workingDateTime.monthValue,
                    commuteInfo.workingDateTime.dayOfMonth,
                    fixedWorkingTime.first.hour,
                    fixedWorkingTime.first.minute
                )
            }
            realWorkingTime.isAfter(fixedWorkingTime.second) -> {
                LocalDateTime.of(
                    commuteInfo.workingDateTime.year,
                    commuteInfo.workingDateTime.monthValue,
                    commuteInfo.workingDateTime.dayOfMonth,
                    fixedWorkingTime.second.hour,
                    fixedWorkingTime.second.minute
                )
            }
            else -> {
                LocalDateTime.of(
                    commuteInfo.workingDateTime.year,
                    commuteInfo.workingDateTime.monthValue,
                    commuteInfo.workingDateTime.dayOfMonth,
                    realWorkingTime.hour,
                    realWorkingTime.minute
                )
            }
        }
    }

}
