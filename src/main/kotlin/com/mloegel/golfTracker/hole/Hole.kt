package com.mloegel.golfTracker.hole

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.mloegel.golfTracker.round.Round
import javax.persistence.Entity
import org.springframework.data.relational.core.mapping.Table
import javax.persistence.Column
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne


@Entity
@Table("HOLE")
data class Hole(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val holeid: Int?,

    @Column(nullable = false)
    val par: Int,

    @Column(nullable = false)
    val score: Int,

    @Column
    val putts: Int,

    @Column
    val notes: String,

    @ManyToOne
    @JoinColumn(name = "roundid", nullable = false)
    @JsonIgnoreProperties(value = ["date", "totalScore", "courseName", "description", "score"], allowSetters = true)
    var round: Round? = null
)
