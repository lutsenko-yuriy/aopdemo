package com.iurii.aopdemo

import com.iurii.aopdemo.dao.AccountDAO
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class AopdemoApplication {

    @Bean
    fun commandLineRunner(accountDAO: AccountDAO): CommandLineRunner {
        return CommandLineRunner {
            accountDAO.addAccount()
        }
    }
}

fun main(args: Array<String>) {
    runApplication<AopdemoApplication>(*args)
}
