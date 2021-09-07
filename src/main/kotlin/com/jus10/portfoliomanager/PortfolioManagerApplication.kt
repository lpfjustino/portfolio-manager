package com.jus10.portfoliomanager

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories

@SpringBootApplication
@EnableJdbcRepositories
class PortfolioManagerApplication

fun main(args: Array<String>) {
	runApplication<PortfolioManagerApplication>(*args)
}
