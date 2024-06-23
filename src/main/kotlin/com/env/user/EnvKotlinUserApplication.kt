package com.env.user

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class EnvKotlinUserApplication

fun main(args: Array<String>) {
	runApplication<EnvKotlinUserApplication>(*args)
}
