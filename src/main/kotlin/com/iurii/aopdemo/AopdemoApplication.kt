package com.iurii.aopdemo

import com.iurii.aopdemo.dao.account.AccountDAO
import com.iurii.aopdemo.dao.membership.MembershipDAO
import com.iurii.aopdemo.entity.Account
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean


@SpringBootApplication(exclude = [JmxAutoConfiguration::class])
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
            accountDAO.name

            println("\nNew call")
            accountDAO.name = "First Name"

            println("\nNew call")
            accountDAO.code

            println("\nNew call")
            accountDAO.code = "Code"

            println("\nNew call")
            accountDAO.dontAddAccount()

            println("\nNew call")
            membershipDAO.doSomethingElseWithAccount()

            println("\nNew call")
            membershipDAO.addAccount(account = account)

            println("\nNew call")
            membershipDAO.addDetails()

            println("\nNew call")
            println(accountDAO.findAccounts())
        }
    }
}

fun main(args: Array<String>) {
    runApplication<AopdemoApplication>(*args)
}
