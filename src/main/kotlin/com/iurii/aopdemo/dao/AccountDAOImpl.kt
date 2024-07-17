package com.iurii.aopdemo.dao

import com.iurii.aopdemo.entity.Account
import org.springframework.stereotype.Repository

@Repository
class AccountDAOImpl : AccountDAO {
    override fun addAccount(account: Account) {
        println(javaClass.name + " add account to db")
    }

    override fun dontAddAccount() {
        println(javaClass.name + " dont add account to db")
    }

    override fun addInteger(): Int {
        println(javaClass.name + " add 42 from db")
        return 42
    }
}