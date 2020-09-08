package com.jambo.messanger.users.domain

import com.jambo.messanger.users.data.UsersRepository
import com.jambo.messanger.users.data.models.User
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import java.util.*

@Service
class UserServiceImpl(
    private val repository: UsersRepository,
    private val crypt: PasswordEncoder
) : UserService {


    override fun createUser(nickname: String, phone: String?, email: String?, password: String?): Mono<User> =
        repository.save(
            User(
                id = UUID.randomUUID(),
                nickname = nickname,
                password = crypt.encode(password),
                email = email,
                phone = phone
            )
        )

    override fun checkPasswordForUser(nick: String, pass: String): Mono<Boolean> = repository.findByNickname(nick)
        .map { crypt.matches(pass, it.password) }
}