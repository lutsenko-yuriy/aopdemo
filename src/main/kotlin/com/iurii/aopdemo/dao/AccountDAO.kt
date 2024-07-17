package com.iurii.aopdemo.dao

import com.iurii.aopdemo.entity.Account

interface AccountDAO {
    fun addAccount(account: Account)
    fun dontAddAccount()
    fun addInteger(): Int
}