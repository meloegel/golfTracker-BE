package com.mloegel.golfTracker.hole

import com.mloegel.golfTracker.round.RoundService
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.web.bind.annotation.*

@RestController
class HoleController(val holeService: HoleService, val roundService: RoundService) {

    fun findHolesByRound(roundid: Int): List<Hole> {
        try {
            val round = roundService.findRoundById(roundid)
            return holeService.findHolesByRound(round)
        } catch (exception: EmptyResultDataAccessException) {
            throw Exception("Round with id $roundid not found! Exception: $exception")
        }
    }

    @PostMapping("/hole")
    fun postHole(@RequestBody hole: Hole, roundid: Int) {
        try {
            val round = roundService.findRoundById(roundid)
            return holeService.postHole(hole, round)
        } catch (exception: EmptyResultDataAccessException) {
            throw Exception("Round with id $roundid not found! Exception: $exception")
        }

    }

    @DeleteMapping("/hole/{holeid}")
    fun deleteHole(@PathVariable holeid: Int) {
        try {
            val hole = holeService.findByHoleid(holeid)
            return holeService.deleteHole(hole)
        } catch (exception: EmptyResultDataAccessException) {
            throw Exception("Hole with id $holeid not found! Exception: $exception")
        }
    }

}