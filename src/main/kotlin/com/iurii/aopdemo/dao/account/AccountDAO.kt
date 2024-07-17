package com.iurii.aopdemo.dao.account

import com.iurii.aopdemo.entity.Account

interface AccountDAO {
    fun addAccount(account: Account, vip: Boolean)
    fun dontAddAccount()
    fun addInteger(): Int
}