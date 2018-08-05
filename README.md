# AOP LTW
Aspect Oriented Programming (AOP) Load Time Weaving (LTW) Example

### AOP LTW with javaagent as cmd line arg
Works perfectly with javaagent as cmd line arg. 

Notice that in aop-app/pom.xml, there is only a dependency of aop-lib
& no other configuration related to AOP is required.

Steps to run with javaagent as cmd line arg.:

```sh
$ cd aop-ltw
$ mvn clean install
$ cd aop-app/target
$ java -javaagent:deploy/lib/aspectjweaver-1.9.1.jar -classpath aop-app-1.0.jar:deploy/lib/* com.aop.app.Main
14:02:45.384 [main] DEBUG com.aop.app.lib.WrapDef - before wrap
14:02:45.391 [main] DEBUG com.aop.app.Main - inside myFunc
14:02:45.391 [main] DEBUG com.aop.app.lib.WrapDef - after wrap
```