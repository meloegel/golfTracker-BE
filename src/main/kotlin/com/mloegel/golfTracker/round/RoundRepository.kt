package com.mloegel.golfTracker.round

import org.springframework.data.repository.CrudRepository

interface RoundRepository : CrudRepository<Round, String> {

    fun findByRoundid(roundid: Int): Round

    fun findRoundByCourseName(courseName: String): List<Round>

    fun findRoundByCourseNameContainingIgnoreCase(courseName: String): List<Round>
}