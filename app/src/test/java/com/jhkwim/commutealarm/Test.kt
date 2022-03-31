package com.jhkwim.commutealarm

import android.util.Log
import com.jhkwim.commutealarm.data.CommuteInfo
import com.jhkwim.commutealarm.parse.CommuteStringParser
import com.jhkwim.commutealarm.utils.DateTimeUtils
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.date.*
import io.mockk.every
import io.mockk.mockkStatic
import java.time.DayOfWeek
import java.time.LocalDateTime

class Test : StringSpec({

    beforeEach {
        mockkStatic(Log::class)
        every { Log.v(any(), any()) } returns 0
        every { Log.d(any(), any()) } returns 0
        every { Log.i(any(), any()) } returns 0
        every { Log.e(any(), any()) } returns 0
        every { Log.w(any(), any<String>()) } returns 0

    }

    "출퇴근 메일 파싱 테스트" {
        val text = "RPA 출퇴근 시간 알림 메일입니다.\n" +
                "\n" +
                "이름: 김재훈\n" +
                "\n" +
                "날짜: 03월29일(화)\n" +
                "\n" +
                "근무 스케쥴: 평일9시\n" +
                "\n" +
                "출근시간: AM 07:57\n" +
                "\n" +
                "퇴근 예상 시간: PM 5:00\n" +
                "\n"


        val commuteInfo: CommuteInfo = CommuteStringParser(LocalDateTime.now(), text).parse()

        println(commuteInfo)
    }

})