package com.iurii.aopdemo.dao

import org.springframework.stereotype.Repository

@Repository
class MembershipDAOImpl : MembershipDAO {
    override fun addAccount() {
        println(javaClass.name + " add account to db")
    }

    override fun doSomethingElseWithAccount() {
        println(javaClass.name + " do something else with account")
    }
}