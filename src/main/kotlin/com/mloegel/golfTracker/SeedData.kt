package com.mloegel.golfTracker

import com.mloegel.golfTracker.round.RoundService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Transactional
@ConditionalOnProperty(prefix = "command.line.runner", value = ["enabled"], havingValue = "true", matchIfMissing = true)
@Component
class SeedData : CommandLineRunner {
    @Autowired
    var roundService: RoundService? = null

    @Transactional
    @Throws(Exception::class)
    override fun run(args: Array<String?>?) {
        roundService?.deleteAll()
    }
}