package com.mloegel.golfTracker.hole

import javax.persistence.Entity
import org.springframework.data.relational.core.mapping.Table
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id


@Entity
@Table("HOLE")
data class Hole(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val holeid: Int?,


)
