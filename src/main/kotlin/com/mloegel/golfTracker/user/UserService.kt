package com.mloegel.golfTracker.user

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Transactional
@Service
class UserService(val db: UserRepository) {
    fun findAllUsers(): MutableIterable<User> = db.findAll()

    fun findByUserid(userid: Int): User = db.findUserByUserid(userid)
}