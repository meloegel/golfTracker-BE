package com.mloegel.golfTracker.hole

import com.mloegel.golfTracker.round.Round
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

@Transactional
@Service
class HoleService(val db: HoleRepository) {

    fun findByHoleid(holeid: Int): Hole = db.findByHoleid(holeid)

    fun findHolesByRound(round: Round): List<Hole> = db.findHolesByRound(round)

    @Transactional
    fun postHole(hole: Hole) = db.save(hole)

    @Transactional
    fun deleteHole(hole: Hole) = db.delete(hole)

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    fun deleteAll() = db.deleteAll()
}