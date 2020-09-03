package com.jambo.messanger.panel

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class PanelApplication

fun main(args: Array<String>) {
	runApplication<PanelApplication>(*args)
}
