package com.hexaware.auto;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainProg {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/hexaware/auto/person.xml");
		Person personSunitha = (Person)ctx.getBean("personSunitha");
		personSunitha.showAllInfo();
		
		Person personJahnavi = (Person)ctx.getBean("personJahnavi");
		personJahnavi.showAllInfo();
		
		Person personSabari = (Person)ctx.getBean("personSabari");
		personSabari.showAllInfo();
	}
}
