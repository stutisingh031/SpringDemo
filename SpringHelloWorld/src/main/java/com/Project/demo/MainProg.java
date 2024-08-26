package com.Project.demo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainProg {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/Project/demo/hello.xml");
		HelloImpl impl = (HelloImpl)ctx.getBean("bean1");
		System.out.println(impl.sayHello("Stuti singh"));

}
}
