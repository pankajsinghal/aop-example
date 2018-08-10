# AOP Examples

## AOP LTW
Aspect Oriented Programming (AOP) Load Time Weaving (LTW) Example

### AOP LTW example with `javaagent` as cmd line arg

Notice that in aop-app/pom.xml, there is only a dependency of aop-lib
& no other configuration related to AOP is required.

Steps to run with `javaagent` as cmd line arg.:

```sh
$ cd aop-example
$ mvn clean install
$ cd aop-ltw/target
$ java -javaagent:deploy/lib/aspectjweaver-1.9.1.jar   -classpath aop-ltw-1.0.jar:deploy/lib/* com.aop.ltw.Main
Loading
16:21:34.453 [main] DEBUG com.aop.lib.WrapDef - before wrap
16:21:34.459 [main] DEBUG com.aop.ltw.AOPDemo - inside runAopDemo
16:21:34.459 [main] DEBUG com.aop.lib.WrapDef - after wrap
```

### AOP LTW example with Dynamic loading of `javaagent`

Refer - https://www.eclipse.org/aspectj/doc/released/README-187.html

Steps to run with dynamic loading of `javaagent`:

```sh
$ cd aop-example
$ mvn clean install
$ cd aop-ltw/target
$ java -DdynamicLoad=true -DAGENT_PATH=deploy/lib/aspectjweaver-1.9.1.jar  -classpath aop-ltw-1.0.jar:deploy/lib/* com.aop.ltw.Main
WrapDef Loaded : false
java.lang.UnsupportedOperationException: AspectJ weaving agent was neither started via '-javaagent' (preMain) nor attached via 'VirtualMachine.loadAgent' (agentMain)
loading javaAgent deploy/lib/aspectjweaver-1.9.1.jar
loaded javaAgent deploy/lib/aspectjweaver-1.9.1.jar
WrapDef Loaded : false
Loading
16:20:27.904 [main] DEBUG com.aop.lib.WrapDef - before wrap
16:20:27.912 [main] DEBUG com.aop.ltw.AOPDemo - inside runAopDemo
16:20:27.912 [main] DEBUG com.aop.lib.WrapDef - after wrap
```


#####References:
 - [AspectJ AOP LTW not working with dynamic loading of javaagent
](https://stackoverflow.com/questions/51693552/aspectj-aop-ltw-not-working-with-dynamic-loading-of-javaagent)
