package com.jambo.messanger.admin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class AdminApplication

fun main(args: Array<String>) {
	runApplication<AdminApplication>(*args)
}
