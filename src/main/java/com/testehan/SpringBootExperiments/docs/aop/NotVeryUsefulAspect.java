package com.testehan.SpringBootExperiments.docs.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component          // this is still needed so that spring finds out about this Aspect class
@Aspect
public class NotVeryUsefulAspect {

    @Before("execution(* UserDao.dataAccessOperation(..))")
    public void beforeDataAccessOperation() {
        System.out.println("Before running User dataAccessOperation");
    }

    @Before("beforeUserDaoAccessOperation()")   // this was defined in a @Pointcut below
    public void beforeDataAccessOperation2() {
        System.out.println("Before 2 running User dataAccessOperation");

    }

    @Before("execution(* com.testehan.SpringBootExperiments.docs.aop.UserDao.*(..))")
    public void beforeAnyMethodCallDataAccessOperation() {
        System.out.println("Before running any method from UserDao");
    }

    @Before("within(com.testehan.SpringBootExperiments.docs.aop.UserDao)")
    public void beforeAllMethodsFromUserDao(JoinPoint joinPoint) {
        System.out.println("Before all from UserDao");

        // JoinPoint gives us information about the method that triggers the call of this aspect
        System.out.println(joinPoint);
        UserDao userDao = (UserDao) joinPoint.getTarget();

        System.out.println(userDao);
    }


    @After("execution(* UserDao.dataAccessOperation(..))")
    public void afterDataAccessOperation() {
        System.out.println("After running User dataAccessOperation");
    }

    @Around("execution(* UserDao.dataAccessOperation(..))")
    public void aroundDataAccessOperation(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("Around running User dataAccessOperation");
        pjp.proceed();
        System.out.println("Around running User dataAccessOperation");
        pjp.proceed();
        System.out.println("Around running User dataAccessOperation");
        pjp.proceed();
    }

    @After("args(name)")
    public void afterGetName(String name) {
        System.out.println("Method was called with " + name + " parameter");
    }

// Dan: not working for some reason...did not spend more time trying to understand why..
//    @AfterThrowing(
//            pointcut="com.testehan.SpringBootExperiments.docs.aop.UserDao.dataAccessOperation()",
//            throwing="ex")
//    public void doRecoveryActions(DataAccessException ex) {
//        // ...
//    }

    @Pointcut("execution(* UserDao.dataAccessOperation(..))")
    public void beforeUserDaoAccessOperation(){}


}
