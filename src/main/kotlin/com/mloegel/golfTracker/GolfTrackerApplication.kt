package com.mloegel.golfTracker

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GolfTrackerApplication

fun main(args: Array<String>) {
    runApplication<GolfTrackerApplication>(*args)
    SeedData()
}
