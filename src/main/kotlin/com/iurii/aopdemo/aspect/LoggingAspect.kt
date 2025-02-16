package com.iurii.aopdemo.aspect

import com.iurii.aopdemo.entity.Account
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.After
import org.aspectj.lang.annotation.AfterReturning
import org.aspectj.lang.annotation.AfterThrowing
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.aspectj.lang.annotation.Pointcut
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

    @Pointcut("execution(* com.iurii.aopdemo.dao.account.AccountDAO.findAccounts*(..))")
    fun forFindAccountsMethods() {
    }

    @AfterReturning(pointcut = "forFindAccountsMethods()", returning = "result")
    fun afterReturningFindAccountsAdvice(joinPoint: JoinPoint, result: List<Account>) {
        val name = joinPoint.signature.toShortString()
        println("=========> Executing @After advice on $name method")
        println("=========> Result is $result")

        for (account in result) {
            account.name = account.name.uppercase()
        }
    }

    @AfterThrowing(pointcut = "forFindAccountsMethods()", throwing = "exception")
    fun afterThrowingFindAccountsAdvice(joinPoint: JoinPoint, exception: Exception) {
        val name = joinPoint.signature.toShortString()

        println("=========> Advising on $name method which throws an exception with a message \"${exception.message}\"")
    }

    @After("forFindAccountsMethods()")
    fun afterFindAccountsMethods(joinPoint: JoinPoint) {
        val name = joinPoint.signature.toShortString()

        println("=========> Advising on $name method. It will be here whatever the outcome of the method.")
    }

    @Around("execution(* com.iurii.aopdemo.service.*.getFortune*(..))")
    fun aroundGetObject(proceedingJoinPoint: ProceedingJoinPoint): Any? {
        val name = proceedingJoinPoint.signature.toShortString()
        println("=========> Advising on $name method in Around advice")

        val begin = System.currentTimeMillis()

        // This call is necessary if you need a result
        val result = try {
            proceedingJoinPoint.proceed()
        } catch (e: Exception) {
            println(e.message)
            throw e
        }

        val end = System.currentTimeMillis()

        val duration = end - begin

        println("=======> It took $duration ms for $name to return $result")

        return result
    }
}