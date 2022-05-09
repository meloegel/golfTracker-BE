package com.mloegel.golfTracker.round

import org.springframework.data.repository.CrudRepository

interface RoundRepository : CrudRepository<Round, String> {
}