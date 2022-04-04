package com.jhkwim.commutealarm.data

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CommuteKeyWordTest: StringSpec ({

    "String to CommuteKeyWord" {
        CommuteKeyWord.getByKeyword("이 름") shouldBe CommuteKeyWord.NAME
        CommuteKeyWord.getByKeyword("날 짜") shouldBe CommuteKeyWord.DATE
        CommuteKeyWord.getByKeyword("근무 스케줄") shouldBe CommuteKeyWord.SCHEDULE
        CommuteKeyWord.getByKeyword("출근 시간") shouldBe CommuteKeyWord.WORKING_TIME
        CommuteKeyWord.getByKeyword("퇴근 예상 시간") shouldBe CommuteKeyWord.EXPECTED_TIME
        CommuteKeyWord.getByKeyword("테스트") shouldBe CommuteKeyWord.UNKNOWN
    }

})