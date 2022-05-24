package com.mloegel.golfTracker.hole

import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class HoleController(val service: HoleService) {

    @PostMapping("/hole")
    fun postHole(@RequestBody hole: Hole): Hole {
        return service.postHole(hole)
    }

    @DeleteMapping("/hole/{holeid}")
    fun deletHole(@PathVariable holeid: Int) {
        try {
            val hole = service.findByHoleid(holeid)
            return service.deleteHole(hole)
        } catch (exception: EmptyResultDataAccessException) {
            throw Exception("Hole with id $holeid not found! Exception: $exception")
        }
    }

}