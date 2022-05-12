package com.mloegel.golfTracker.round

import org.springframework.data.repository.CrudRepository

interface RoundRepository : CrudRepository<Round, String> {

    fun findByRoundid(roundid: Int): Round

    fun findRoundsByCourseName(courseName: String): List<Round>
}