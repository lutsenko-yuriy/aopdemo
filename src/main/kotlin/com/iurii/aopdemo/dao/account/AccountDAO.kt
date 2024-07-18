package com.iurii.aopdemo.dao.account

import com.iurii.aopdemo.entity.Account

interface AccountDAO {
    var name: String
    var code: String
    fun addAccount(account: Account, vip: Boolean)
    fun dontAddAccount()
    fun addInteger(): Int
    fun findAccounts(): List<Account>
}