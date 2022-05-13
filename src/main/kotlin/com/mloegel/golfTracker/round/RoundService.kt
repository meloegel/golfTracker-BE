package com.mloegel.golfTracker.round

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

@Transactional
@Service
class RoundService(val db: RoundRepository) {
    fun findAllRounds(): MutableIterable<Round> = db.findAll()

    fun findRoundById(roundid: Int): Round = db.findByRoundid(roundid)

    fun findRoundsByCourseName(courseName: String): List<Round> = db.findRoundByCourseName(courseName)

    fun searchRoundsByCourseName(courseName: String): List<Round> = db.findRoundByNameContainingIgnoreCase(courseName)

    @Transactional
    fun postRound(round: Round) = db.save(round)

    @Transactional
    fun deleteRound(round: Round) = db.delete(round)

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    fun deleteAll() = db.deleteAll()
}