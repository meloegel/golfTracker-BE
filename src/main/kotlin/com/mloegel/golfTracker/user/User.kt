package com.mloegel.golfTracker.user

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.mloegel.golfTracker.round.Round
import org.springframework.data.relational.core.mapping.Table
import javax.persistence.*


@Entity
@Table("USERS")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var userid: Int?,

    @Column(nullable = false, unique = true)
    var username: String,

    @Column(nullable = false)
    var password: String,

    @Column(nullable = false, unique = true)
    var email: String,

    @OneToOne(mappedBy = "user", cascade = [CascadeType.ALL], orphanRemoval = true)
    @JsonIgnoreProperties(value = ["user"], allowSetters = true)
    var Rounds: List<Round>? = ArrayList<Round>()
)
