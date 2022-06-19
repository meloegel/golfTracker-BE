package com.mloegel.golfTracker.round

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.mloegel.golfTracker.hole.Hole
import com.mloegel.golfTracker.user.User
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table("ROUND")
data class Round(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val roundid: Int?,

    @Column(nullable = false)
    val date: LocalDate,

    @Column(nullable = false)
    val totalScore: Int,

    @Column
    val courseName: String,

    @Column
    val description: String,

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "round", cascade = [CascadeType.ALL], orphanRemoval = true)
    @JsonIgnoreProperties(value = ["holeid", "round"], allowSetters = true)
    var score: List<Hole> = ArrayList<Hole>(),

    @ManyToOne
    @JoinColumn(name = "userid", nullable = false)
    @JsonIgnoreProperties(value = ["rounds", "password"], allowSetters = true)
    var user: User
)
