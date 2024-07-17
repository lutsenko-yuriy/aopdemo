package com.iurii.aopdemo.dao.membership

import com.iurii.aopdemo.entity.Account

interface MembershipDAO {
    fun addAccount(account: Account)
    fun doSomethingElseWithAccount()
    fun addDetails()
}