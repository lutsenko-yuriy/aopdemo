package com.iurii.aopdemo.aspect

import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component
import java.util.concurrent.atomic.AtomicInteger

@Aspect
@Component
@Order(3)
class ApiAnalyticsAspect {

    val calledTimes = AtomicInteger()

    @Before("com.iurii.aopdemo.aspect.AopExpressions.forDaoPackageWithoutGettersAndSetters()")
    fun performAPIAnalytics() {
        println("=======> Called ${calledTimes.incrementAndGet()} times")
    }
}