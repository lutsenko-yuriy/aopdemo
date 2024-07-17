package com.iurii.aopdemo.aspect

import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component

@Aspect
@Component
@Order(1)
class CloudLoggingAspect {

    @Before("com.iurii.aopdemo.aspect.AopExpressions.forDAOPackage()")
    fun logToCloudAsync() {
        println("=======> log stuff to cloud async")
    }

}