package com.mloegel.golfTracker.hole

import org.springframework.data.repository.CrudRepository

interface HoleRepository : CrudRepository<Hole, String>{

    fun findByHoleid(holeid: Int): Hole

}