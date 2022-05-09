package com.mloegel.golfTracker

import javax.persistence.*
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDate

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

//    Ability to add score bt individual holes to be added later
//    @OneToMany(mappedBy = "round", cascade = [CascadeType.ALL], orphanRemoval = true)
//    @JsonIgnoreProperties(value = ["roundid"], allowSetters = true)
//    val score: List<Hole> = ArrayList<Hole>()
)
