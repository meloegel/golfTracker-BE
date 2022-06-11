package com.mloegel.golfTracker

import com.mloegel.golfTracker.hole.Hole
import com.mloegel.golfTracker.hole.HoleService
import com.mloegel.golfTracker.round.Round
import com.mloegel.golfTracker.round.RoundRepository
import com.mloegel.golfTracker.round.RoundService
import com.mloegel.golfTracker.user.User
import com.mloegel.golfTracker.user.UserService
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
    var userService: UserService? = null

    @Autowired
    var holeService: HoleService? = null

    @Autowired
    var roundRepository: RoundRepository? = null

    var date: LocalDate = LocalDate.of(2022, 5, 27)

    @Transactional
    @Throws(Exception::class)
    override fun run(args: Array<String?>?) {
        roundService?.deleteAll()
        userService?.deleteAll()
        holeService?.deleteAll()

        val u1 = User(1, "fart", "password", "email@email.com")
        userService?.postUser(u1)

        val u2 = User(2, "User Blue", "password", "fart@email.com")
        userService?.postUser(u2)

        val u3 = User(3, "User Red", "password", "tird@email.com")
        userService?.postUser(u3)

        val r1 = Round(4, date, 95, "Links of Novi", "Hot day, good first 9", emptyList(), u1)
        roundRepository?.save(r1)

        val r2 = Round(5, date, 93, "Sanctuary Lake", "Solid day, chipped in 13", emptyList(), u2)
        roundRepository?.save(r2)

        val h1 = Hole(6, 4, 4, 2, "strong front wind", r2)
        holeService?.postHole(h1)
    }
}