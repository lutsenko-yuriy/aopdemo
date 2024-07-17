package com.iurii.aopdemo

import com.iurii.aopdemo.dao.AccountDAO
import com.iurii.aopdemo.dao.MembershipDAO
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class AopdemoApplication {

    @Bean
    fun commandLineRunner(accountDAO: AccountDAO, membershipDAO: MembershipDAO): CommandLineRunner {
        return CommandLineRunner {
            accountDAO.addAccount()

            println("\nNew call")
            accountDAO.addAccount()

            println("\nNew call")
            accountDAO.dontAddAccount()

            println("\nNew call")
            membershipDAO.doSomethingElseWithAccount()

            println("\nNew call")
            membershipDAO.addAccount()

            println("\nNew call")
            membershipDAO.addAccount()

            println("\nNew call")
            membershipDAO.addAccount()

            println("\nNew call")
            membershipDAO.doSomethingElseWithAccount()
        }
    }
}

fun main(args: Array<String>) {
    runApplication<AopdemoApplication>(*args)
}
