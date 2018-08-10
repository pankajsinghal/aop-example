package com.aop.ctw;

import com.aop.lib.Wrap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    @Wrap
    public void runCTWAopDemo(){
        logger.debug("inside runCTWAopDemo");
    }

    public static void main(String[] args){

        new Main().runCTWAopDemo();

    }


}
