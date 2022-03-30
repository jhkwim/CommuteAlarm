package com.jhkwim.commutealarm.parse

import com.jhkwim.commutealarm.data.OfficeHour
import java.time.LocalDateTime

data class CommuteStr(
    val name: String,
    val workingTime: LocalDateTime,
    var officeHour: OfficeHour,
    val expectedQuittingTime: LocalDateTime
)

