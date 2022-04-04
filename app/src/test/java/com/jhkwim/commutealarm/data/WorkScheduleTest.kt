package com.jhkwim.commutealarm.data

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class WorkScheduleTest : StringSpec({

    "String to WorkScheduleTest" {
        WorkSchedule.getBySchedule("평일 9시") shouldBe WorkSchedule.WEEKDAY_WORK
        WorkSchedule.getBySchedule("오전 반차") shouldBe WorkSchedule.ANNUAL_LEAVE_MORNING
        WorkSchedule.getBySchedule("오후 반차") shouldBe WorkSchedule.ANNUAL_LEAVE_AFTERNOON
        WorkSchedule.getBySchedule("휴 가") shouldBe WorkSchedule.WEEKDAY_WORK
    }

})