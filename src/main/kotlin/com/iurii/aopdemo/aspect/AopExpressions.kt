package com.iurii.aopdemo.aspect

import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Pointcut
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component

@Aspect
@Component
@Order(2)
class AopExpressions {
    @Pointcut("execution(* com.iurii.aopdemo.dao.account.*.*(..))")
    fun forDAOPackage() { }

    @Pointcut("execution(* com.iurii.aopdemo.dao.account.*.get*(..))")
    fun forGettersInPackage() { }

    @Pointcut("execution(* com.iurii.aopdemo.dao.account.*.set*(..))")
    fun forSettersInPackage() { }

    @Pointcut("forDAOPackage() && !(forGettersInPackage() || forSettersInPackage())")
    fun forDaoPackageWithoutGettersAndSetters() { }
}