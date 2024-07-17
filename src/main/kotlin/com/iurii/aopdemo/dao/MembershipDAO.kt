package com.iurii.aopdemo.dao

import com.iurii.aopdemo.entity.Account

interface MembershipDAO {
    fun addAccount(account: Account)
    fun doSomethingElseWithAccount()
    fun addDetails()
}