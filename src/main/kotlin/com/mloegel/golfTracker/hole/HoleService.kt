package com.mloegel.golfTracker.hole

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional
@Service
class HoleService(val db: HoleRepository) {

    fun findByHoleid(holeid: Int): Hole = db.findByHoleid(holeid)

    @Transactional
    fun postHole(hole: Hole) = db.save(hole)

    @Transactional
    fun deleteHole(hole: Hole) = db.delete(hole)

}