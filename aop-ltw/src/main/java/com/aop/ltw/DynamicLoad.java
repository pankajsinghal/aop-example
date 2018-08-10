package com.aop.ltw;

import com.sun.tools.attach.VirtualMachine;
import org.aspectj.weaver.loadtime.Agent;

import java.lang.management.ManagementFactory;

/**
 * Refer - https://www.eclipse.org/aspectj/doc/released/README-187.html
 */
public class DynamicLoad {
    public static boolean isAspectJAgentLoaded() {
        try {
            Agent.getInstrumentation();
        } catch (NoClassDefFoundError e) {
            System.out.println(e);
            return false;
        } catch (UnsupportedOperationException e) {
            System.out.println(e);
            return dynamicallyLoadAspectJAgent();
        }
        return true;
    }

    public static boolean dynamicallyLoadAspectJAgent() {
        String nameOfRunningVM = ManagementFactory.getRuntimeMXBean().getName();
        int p = nameOfRunningVM.indexOf('@');
        String pid = nameOfRunningVM.substring(0, p);
        try {
            VirtualMachine vm = VirtualMachine.attach(pid);
            String jarFilePath = System.getProperty("AGENT_PATH");
            System.out.println("loading javaAgent " + jarFilePath);
            vm.loadAgent(jarFilePath);
            vm.detach();
            System.out.println("loaded javaAgent " + jarFilePath);
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }
}
