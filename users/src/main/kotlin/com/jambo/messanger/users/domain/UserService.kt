package com.jambo.messanger.users.domain

import com.jambo.messanger.users.data.models.User
import reactor.core.publisher.Mono

interface UserService {

    fun createUser(nickname: String, phone: String?, email: String?, password: String?): Mono<User>
    fun checkPasswordForUser(nick: String, pass: String): Mono<Boolean>

}