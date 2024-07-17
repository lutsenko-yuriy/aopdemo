package com.iurii.aopdemo.dao.account

import com.iurii.aopdemo.entity.Account
import org.springframework.stereotype.Repository

@Repository
class AccountDAOImpl : AccountDAO {

    override var code: String = ""
        get() {
            println(javaClass.name + " get code $field")
            return field
        }
        set(value) {
            println(javaClass.name + " replace code $field with $value")
            field = value
        }

    override var name: String = ""
        get() {
            println(javaClass.name + " get name $field")
            return field
        }
        set(value) {
            println(javaClass.name + " replace name $field with $value")
            field = value
        }

    override fun addAccount(account: Account, vip: Boolean) {
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