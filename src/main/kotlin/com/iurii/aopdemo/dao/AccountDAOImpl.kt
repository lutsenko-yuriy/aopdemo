package com.iurii.aopdemo.dao

import org.springframework.stereotype.Repository

@Repository
class AccountDAOImpl : AccountDAO {
    override fun addAccount() {
        println(javaClass.name + " add account to db")
    }
}