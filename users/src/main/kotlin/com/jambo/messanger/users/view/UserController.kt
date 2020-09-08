package com.jambo.messanger.users.view

import com.jambo.messanger.users.domain.UserService
import com.jambo.messanger.users.view.models.CheckUserPasswordRequest
import com.jambo.messanger.users.view.models.CreateUserRequest
import com.jambo.messanger.users.view.models.UserView
import groovy.util.logging.Slf4j
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@Slf4j
@RequestMapping("users")
class UserController(
    private val service: UserService
) {

    @PostMapping
    fun createUser(@RequestBody body: CreateUserRequest): Mono<UserView> = body.let { (nickname, phone, email, password) ->
        service.createUser(nickname, phone, email, password)
    }.map {
        UserView(
            it.id.toString(),
            it.nickname,
            it.email,
            it.phone,
            it.status
        )
    }

    @PostMapping("check-password")
    fun checkUserPassword(@RequestBody body: CheckUserPasswordRequest): Mono<Pair<String, Boolean>> = body.let { (nick, pass) ->
        service.checkPasswordForUser(nick, pass)
    }.map {
        Pair("success", it)
    }

}