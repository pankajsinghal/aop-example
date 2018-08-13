# AOP Examples

Working examples of compile time weaving(CTW) & load time weaving(LTW) in AOP 


## AOP CTW
Aspect Oriented Programming (AOP) Compile Time Weaving (CTW) Example

For compile time weaving, you need to add `aspectj-maven-plugin` into your pom.
This plugin weaves the aspects to the class with the aspect annotation while compiling the code.

Steps to run:

```sh
$ cd aop-example
$ mvn clean install
$ cd aop-ctw/target
$ java -classpath aop-ctw-1.0.jar:deploy/lib/* com.aop.ctw.Main
Loading
16:53:42.062 [main] DEBUG com.aop.lib.WrapDef - before wrap
16:53:42.064 [main] DEBUG com.aop.ctw.Main - inside runCTWAopDemo
16:53:42.064 [main] DEBUG com.aop.lib.WrapDef - after wrap
```


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


##### References:

 - [AspectJ AOP LTW not working with dynamic loading of javaagent
](https://stackoverflow.com/questions/51693552/aspectj-aop-ltw-not-working-with-dynamic-loading-of-javaagent)
- http://andrewclement.blogspot.com/2009/02/load-time-weaving-basics.html
- https://stackoverflow.com/questions/17497039/how-to-specify-path-to-aop-xml-using-aspectj-maven-plugin
- https://stackoverflow.com/questions/12423965/maven-aspectj-all-steps-to-configure-it
- https://stackoverflow.com/questions/4817670/how-can-i-add-a-javaagent-to-a-jvm-without-stopping-the-jvm
- https://blog.imaginea.com/weaving-with-aspectj/
- https://stackoverflow.com/questions/33701756/aspectj-how-to-weave-an-aspect-library-into-a-java-project
- http://www.eclipse.org/aspectj/doc/next/devguide/ltw.html
- https://www.eclipse.org/aspectj/doc/released/README-187.html
- https://www.eclipse.org/aspectj/doc/next/devguide/printable.html#ajc-ref-top
- https://stackoverflow.com/questions/51693552/aspectj-aop-ltw-not-working-with-dynamic-loading-of-javaagent


##### Note:

If you are coming via the [AspectJ AOP LTW not working with dynamic loading of javaagent
](https://stackoverflow.com/questions/51693552/aspectj-aop-ltw-not-working-with-dynamic-loading-of-javaagent) question, please note that I've corrected the code in this repo & it's working now.
