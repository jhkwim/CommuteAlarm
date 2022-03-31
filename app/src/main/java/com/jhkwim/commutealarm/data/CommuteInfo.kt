package com.jhkwim.commutealarm.data

import java.time.LocalDateTime

data class CommuteInfo(
    val name: String,
    val workingTime: LocalDateTime,
    var workSchedule: WorkSchedule,
    val expectedQuittingTime: LocalDateTime
)

