package com.mloegel.golfTracker.hole

import com.mloegel.golfTracker.round.RoundService
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

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
    fun postHole(@RequestBody hole: Hole): Hole {
        return holeService.postHole(hole)
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