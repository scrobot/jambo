package com.jambo.messanger.users.data

import com.jambo.messanger.users.data.models.User
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Mono
import java.util.*

interface UsersRepository: ReactiveCrudRepository<User, UUID> {

    fun findByNickname(nickname: String): Mono<User>

}