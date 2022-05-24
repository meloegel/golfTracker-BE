package com.mloegel.golfTracker.hole

import com.mloegel.golfTracker.round.Round
import org.springframework.data.repository.CrudRepository

interface HoleRepository : CrudRepository<Hole, String>{

    fun findByHoleid(holeid: Int): Hole

    fun findHolesByRound(round: Round): List<Hole>
}