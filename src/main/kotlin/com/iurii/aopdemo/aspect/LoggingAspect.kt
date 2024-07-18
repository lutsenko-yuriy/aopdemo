package com.iurii.aopdemo.aspect

import com.iurii.aopdemo.entity.Account
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.AfterReturning
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

    @AfterReturning(pointcut = "execution(* com.iurii.aopdemo.dao.account.AccountDAO.findAccounts(..))", returning = "result")
    fun afterReturningFindAccountsAdvice(joinPoint: JoinPoint, result: List<Account>) {
        val name = joinPoint.signature.toShortString()
        println("=========> Executing @After advice on $name method")
        println("=========> Result is $result")
    }

}