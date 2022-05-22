package com.mloegel.golfTracker.hole

import com.mloegel.golfTracker.round.RoundRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional
@Service
class HoleService(val db: HoleRepository) {

    @Transactional
    fun postHole(hole: Hole) = db.save(hole)

    @Transactional
    fun deleteHole(hole: Hole) = db.delete(hole)

}