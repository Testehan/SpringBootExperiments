package com.testehan.SpringBootExperiments.docs.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.Ordered;
import org.springframework.dao.PessimisticLockingFailureException;

/*
    Note that the aspect implements the Ordered interface so that we can set the precedence of the
    aspect higher than the transaction advice (we want a fresh transaction each time we retry). The
    maxRetries and order properties are both configured by Spring. The main action happens in the
    doConcurrentOperation around advice. Notice that, for the moment, we apply the retry logic to each
    businessService(). We try to proceed, and if we fail with a PessimisticLockingFailureException, we
    try again, unless we have exhausted all of our retry attempts.
*/

@Aspect
public class ConcurrentOperationExecutor implements Ordered {
    private static final int DEFAULT_MAX_RETRIES = 2;
    private int maxRetries = DEFAULT_MAX_RETRIES;
    private int order = 1;

    public void setMaxRetries(int maxRetries) {
        this.maxRetries = maxRetries;
    }
    public int getOrder() {
        return this.order;
    }
    public void setOrder(int order) {
        this.order = order;
    }
    @Around("com.xyz.myapp.CommonPointcuts.businessService()")
    public Object doConcurrentOperation(ProceedingJoinPoint pjp) throws Throwable {
        int numAttempts = 0;
        PessimisticLockingFailureException lockFailureException;
        do {
            numAttempts++;
            try {
                return pjp.proceed();
            }
            catch(PessimisticLockingFailureException ex) {
                lockFailureException = ex;
            }
        } while(numAttempts <= this.maxRetries);
        throw lockFailureException;
    }
}
