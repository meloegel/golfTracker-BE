package com.mloegel.golfTracker

import com.mloegel.golfTracker.round.Round
import com.mloegel.golfTracker.round.RoundRepository
import com.mloegel.golfTracker.round.RoundService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDate

@Transactional
@ConditionalOnProperty(prefix = "command.line.runner", value = ["enabled"], havingValue = "true", matchIfMissing = true)
@Component
class SeedData : CommandLineRunner {
    @Autowired
    var roundService: RoundService? = null

    @Autowired
    var roundRepository: RoundRepository? = null

    var date =  LocalDate.of(2022, 5, 27)

    @Transactional
    @Throws(Exception::class)
    override fun run(args: Array<String?>?) {
        roundService?.deleteAll()

        roundRepository?.save(Round(0, date, 95, "Links of Novi", "Hot day, good first 9" ))
    }
}