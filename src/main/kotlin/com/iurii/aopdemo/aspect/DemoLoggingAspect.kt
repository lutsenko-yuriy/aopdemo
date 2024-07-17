package com.iurii.aopdemo.aspect

import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.aspectj.lang.annotation.Pointcut
import org.springframework.stereotype.Component
import java.util.concurrent.atomic.AtomicInteger

@Aspect
@Component
class DemoLoggingAspect {

    val calledTimes = AtomicInteger()

    @Pointcut("execution(* com.iurii.aopdemo.dao.account.*.*(..))")
    fun forDAOPackage() { }

    @Before("forDAOPackage()")
    fun beforeAddAccountAdvice() {
        println("=======> Executing @Before advice on addAccount method")
    }

    @Before("forDAOPackage()")
    fun performAPIAnalytics() {
        println("=======> Called ${calledTimes.incrementAndGet()} times")
    }
}