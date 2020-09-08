package com.jambo.messanger.users

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.cassandra.repository.config.EnableReactiveCassandraRepositories

@SpringBootApplication
@EnableReactiveCassandraRepositories
open class UsersApplication

fun main(args: Array<String>) {
	runApplication<UsersApplication>(*args)
}
