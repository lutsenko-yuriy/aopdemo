package com.iurii.aopdemo.service

import org.springframework.stereotype.Service
import java.util.concurrent.TimeUnit

@Service
class TrafficFortuneServiceImpl : TrafficFortuneService {
    override fun getFortune(fail: Boolean): String {
        if (fail) {
            throw RuntimeException("Major accident!")
        }

        try {
            TimeUnit.SECONDS.sleep(5)
        } catch (e: InterruptedException) {
            throw RuntimeException(e)
        }

        return "Expect heavy traffic this morning"
    }
}