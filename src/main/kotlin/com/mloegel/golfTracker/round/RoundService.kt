package com.mloegel.golfTracker.round

import org.springframework.stereotype.Service


@Service
class RoundService(val db: RoundRepository) {
    fun findAllRounds(): MutableIterable<Round> = db.findAll()

    fun findRoundById(roundid: Int): Round = db.findByRoundid(roundid)

    fun findRoundsByCourseName(courseName: String): List<Round> = db.findRoundsByCourseName(courseName)
}