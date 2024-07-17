package com.iurii.aopdemo.aspect

import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.aspectj.lang.reflect.MethodSignature
import org.springframework.stereotype.Component

@Aspect
@Component
class LoggingAspect {

    @Before("com.iurii.aopdemo.aspect.AopExpressions.forDAOPackage()")
    fun beforeAddAccountAdvice(joinPoint: JoinPoint) {
        println("=======> Executing @Before advice on addAccount method")

        val signature = joinPoint.signature as MethodSignature

        println("Method $signature")

        val args = joinPoint.args

        for ((index, arg) in args.withIndex()) {
            println("Argument ${index}: $arg")
        }
    }

}