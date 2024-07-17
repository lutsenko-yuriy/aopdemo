package com.iurii.aopdemo.aspect

import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.springframework.stereotype.Component

@Aspect
@Component
class DemoLoggingAspect {

    @Before("execution(* add*(..))")
    fun beforeAddAccountAdvice() {
        println("=======> Executing @Before advice on addAccount method")
    }
}