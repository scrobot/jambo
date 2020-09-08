package com.jambo.messanger.users.view

import com.jambo.messanger.users.data.UsersRepository
import com.jambo.messanger.users.data.models.User
import com.jambo.messanger.users.domain.UserService
import com.jambo.messanger.users.view.models.CheckUserPasswordRequest
import com.jambo.messanger.users.view.models.CreateUserRequest
import com.jambo.messanger.users.view.models.UserView
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("users")
class UserController(
    private val service: UserService,
    private val repo: UsersRepository
) {

    @GetMapping
    fun allUsers(): Flux<User> = repo.findAll()

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