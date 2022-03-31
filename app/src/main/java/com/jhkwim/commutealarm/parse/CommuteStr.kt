package com.jhkwim.commutealarm.parse

import com.jhkwim.commutealarm.data.WorkSchedule
import java.time.LocalDateTime

data class CommuteStr(
    val name: String,
    val workingTime: LocalDateTime,
    var workSchedule: WorkSchedule,
    val expectedQuittingTime: LocalDateTime
)

