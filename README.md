# AOP LTW
Aspect Oriented Programming (AOP) Load Time Weaving (LTW) Example

### AOP LTW example with `javaagent` as cmd line arg

Notice that in aop-app/pom.xml, there is only a dependency of aop-lib
& no other configuration related to AOP is required.

Steps to run with `javaagent` as cmd line arg.:

```sh
$ cd aop-ltw
$ mvn clean install
$ cd aop-app/target
$ java -javaagent:deploy/lib/aspectjweaver-1.9.1.jar -classpath aop-app-1.0.jar:deploy/lib/* com.aop.app.Main
14:02:45.384 [main] DEBUG com.aop.app.lib.WrapDef - before wrap
14:02:45.391 [main] DEBUG com.aop.app.Main - inside myFunc
14:02:45.391 [main] DEBUG com.aop.app.lib.WrapDef - after wrap
```

### AOP LTW example with Dynamic loading of `javaagent`

Refer - https://www.eclipse.org/aspectj/doc/released/README-187.html

Steps to run with dynamic loading of `javaagent`:

```sh
$ cd aop-ltw
$ mvn clean install
$ cd aop-app/target
$ java -DdynamicLoad=true -DAGENT_PATH=deploy/lib/aspectjweaver-1.9.1.jar  -classpath aop-app-1.0.jar:deploy/lib/* com.aop.app.Main
com.aop.app.lib.WrapDef Loaded : false
java.lang.UnsupportedOperationException: AspectJ weaving agent was neither started via '-javaagent' (preMain) nor attached via 'VirtualMachine.loadAgent' (agentMain)
loading javaAgent deploy/lib/aspectjweaver-1.9.1.jar
loaded javaAgent deploy/lib/aspectjweaver-1.9.1.jar
com.aop.app.lib.WrapDef Loaded : false
Loading
15:55:02.099 [main] DEBUG com.aop.app.lib.WrapDef - before wrap
15:55:02.111 [main] DEBUG com.aop.app.AOPDemo - inside runAopDemo
15:55:02.111 [main] DEBUG com.aop.app.lib.WrapDef - after wrap
```


#####References:
 - [AspectJ AOP LTW not working with dynamic loading of javaagent
](https://stackoverflow.com/questions/51693552/aspectj-aop-ltw-not-working-with-dynamic-loading-of-javaagent)
