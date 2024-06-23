package com.env.auth

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class EnvKotlinAuthApplication

fun main(args: Array<String>) {
	runApplication<EnvKotlinAuthApplication>(*args)
}
