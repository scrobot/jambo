package com.jambo.messanger.zipkin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class ZipkinApplication

fun main(args: Array<String>) {
	runApplication<ZipkinApplication>(*args)
}
