package com.aop.ltw;

import com.aop.lib.Wrap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AOPDemo {
    private static final Logger logger = LoggerFactory.getLogger(AOPDemo.class);
    @Wrap
    public void runAopDemo(){
        logger.debug("inside runAopDemo");
    }
}
