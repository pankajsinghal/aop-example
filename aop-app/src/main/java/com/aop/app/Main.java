package com.aop.app;

import com.aop.app.lib.Wrap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    @Wrap
    public void myFunc(){
        logger.debug("inside myFunc");
    }

    public static void main(String[] args) {
        new Main().myFunc();
    }

}
