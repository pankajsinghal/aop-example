package com.aop.app.lib;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class WrapDef {
    private static final Logger logger = LoggerFactory.getLogger(WrapDef.class);

    public static boolean loaded = false;

    @Around("@annotation( wrapAnnotation ) && execution(* *(..))")
    public Object processSystemRequest(final ProceedingJoinPoint pjp, Wrap wrapAnnotation)
            throws Throwable {
        logger.debug("before wrap");
        Object o = pjp.proceed();
        logger.debug("after wrap");
        return o;
    }

    static {
        System.out.println("Loading");
        WrapDef.loaded = true;
    }
    public static void reportLoaded() {
        System.out.println("loaded : " + loaded);
    }
}
