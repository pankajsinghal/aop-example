package com.aop.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        boolean dynamicLoad = Boolean.getBoolean("dynamicLoad");
        if(dynamicLoad){
            Main.isAdviceClassLoaded();
            if(!DynamicLoad.isAspectJAgentLoaded()) {
                logger.error("AspectJ Not Loaded. Existing.");
                System.exit(0);
            }
            Main.isAdviceClassLoaded();
        }

        new AOPDemo().runAopDemo();
    }

    private static void isAdviceClassLoaded() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        java.lang.reflect.Method m = ClassLoader.class.getDeclaredMethod("findLoadedClass", String.class);
        m.setAccessible(true);
        ClassLoader cl = ClassLoader.getSystemClassLoader();
        Object test1 = m.invoke(cl, "com.aop.app.lib.WrapDef");
        boolean loaded = test1 != null;
        System.out.println("com.aop.app.lib.WrapDef Loaded : " + loaded);
    }

}
