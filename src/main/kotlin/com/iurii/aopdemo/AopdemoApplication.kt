package com.iurii.aopdemo

import com.iurii.aopdemo.dao.AccountDAO
import com.iurii.aopdemo.dao.MembershipDAO
import com.iurii.aopdemo.entity.Account
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class AopdemoApplication {

    @Bean
    fun commandLineRunner(accountDAO: AccountDAO, membershipDAO: MembershipDAO): CommandLineRunner {
        return CommandLineRunner {
            val account = Account("name", 42)

            println("\nNew call")
            accountDAO.addAccount(account = account, vip = false)

            println("\nNew call")
            accountDAO.addInteger()

            println("\nNew call")
            accountDAO.dontAddAccount()

            println("\nNew call")
            membershipDAO.doSomethingElseWithAccount()

            println("\nNew call")
            membershipDAO.addAccount(account = account)

            println("\nNew call")
            membershipDAO.addDetails()
        }
    }
}

fun main(args: Array<String>) {
    runApplication<AopdemoApplication>(*args)
}
