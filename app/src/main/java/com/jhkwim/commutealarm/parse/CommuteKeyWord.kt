package com.jhkwim.commutealarm.parse

enum class CommuteKeyWord(val keyword: String) {
    NAME("이름"),
    DATE("날짜"),
    SCHEDULE("근무스케줄"),
    WORKING_TIME("출근시간"),
    EXPECTED_TIME("예상퇴근시간");
}