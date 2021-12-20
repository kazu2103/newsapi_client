package com.kazu.newsapi.client.config

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.jetbrains.exposed.sql.Database
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DatabaseConfig {

    @Value("\${spring.datasource.url}")
    lateinit var url: String

    @Value("\${spring.datasource.driver-class-name}")
    lateinit var driver: String

    @Value("\${spring.datasource.username}")
    lateinit var user: String

    @Value("\${spring.datasource.password}")
    lateinit var pass: String

    @Bean
    fun setup(): Unit {
        val config = HikariConfig().apply {
            jdbcUrl         = url
            driverClassName = driver
            username        = user
            password        = pass
            maximumPoolSize = 10
        }
        val dataSource = HikariDataSource(config)
        Database.connect(dataSource)
    }
}