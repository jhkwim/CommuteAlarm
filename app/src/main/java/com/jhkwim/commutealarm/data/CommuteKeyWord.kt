package com.jhkwim.commutealarm.data

enum class CommuteKeyWord(val keyword: String) {
    NAME("이름"),
    DATE("날짜"),
    SCHEDULE("근무스케줄"),
    WORKING_TIME("출근시간"),
    EXPECTED_TIME("퇴근예상시간"),
    UNKNOWN("알수없음");

    companion object {
        fun getByKeyword(keyword: String) = values().find { it.keyword == keyword } ?: UNKNOWN
    }
}