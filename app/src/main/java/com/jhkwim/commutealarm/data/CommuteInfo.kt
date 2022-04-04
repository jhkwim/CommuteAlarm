package com.jhkwim.commutealarm.data

import java.time.LocalDateTime

data class CommuteInfo(
    val name: String,
    val workingDateTime: LocalDateTime,
    var workSchedule: WorkSchedule,
    var expectedQuittingTime: LocalDateTime? = null
)

