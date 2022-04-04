package com.jhkwim.commutealarm

import com.jhkwim.commutealarm.data.CommuteInfo
import com.jhkwim.commutealarm.data.WorkSchedule
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.date.shouldHaveDayOfMonth
import io.kotest.matchers.date.shouldHaveHour
import io.kotest.matchers.date.shouldHaveMinute
import io.kotest.matchers.date.shouldHaveMonth
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import java.time.LocalDateTime

class FinishTimeCalculatorTest : StringSpec({

    "퇴근시간 계산" {
        val commuteInfo = CommuteInfo("홍길동",
            LocalDateTime.of(2022, 4, 4, 7, 51),
            WorkSchedule.WEEKDAY_WORK)

        val quittingTime = FinishTimeCalculator(commuteInfo).calculate()

       quittingTime shouldNotBe null
       quittingTime.year shouldBe 2022
       quittingTime.shouldHaveMonth(4)
       quittingTime.shouldHaveDayOfMonth(4)
       quittingTime.shouldHaveHour(17)
       quittingTime.shouldHaveMinute(0)
    }

})