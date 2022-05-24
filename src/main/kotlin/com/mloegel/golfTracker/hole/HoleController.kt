package com.mloegel.golfTracker.hole

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class HoleController(val service: HoleService) {
    @PostMapping("/hole")
    fun postHole(@RequestBody hole: Hole): Hole {
        return service.postHole(hole)
    }

}