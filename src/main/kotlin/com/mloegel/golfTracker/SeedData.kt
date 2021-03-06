package com.mloegel.golfTracker

import com.mloegel.golfTracker.hole.Hole
import com.mloegel.golfTracker.hole.HoleRepository
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

    @Autowired
    var holeRepository: HoleRepository? = null

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
        holeRepository?.save(h1)

        val h2 = Hole(7, 3, 4, 2, "missed left", r2)
        holeRepository?.save(h2)

        val h3 = Hole(8, 5, 5, 2, "", r2)
        holeRepository?.save(h3)

        val h4 = Hole(9, 4, 6, 3, "", r2)
        holeRepository?.save(h4)

        val h5 = Hole(10, 4, 5, 2, "", r2)
        holeRepository?.save(h5)

        val h6 = Hole(11, 3, 5, 3, "", r2)
        holeRepository?.save(h6)

        val h7 = Hole(12, 4, 6, 3, "Bad putts", r2)
        holeRepository?.save(h7)

        val h8 = Hole(13, 5, 7, 3, "Hard hole", r2)
        holeRepository?.save(h8)

        val h9 = Hole(14, 4, 5, 2, "", r2)
        holeRepository?.save(h9)
    }
}