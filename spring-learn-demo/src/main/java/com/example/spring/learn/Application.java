package com.example.spring.learn;

import com.example.spring.learn.common.service.WelcomeService;
import com.example.spring.learn.service.DefaultWelcomeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.util.Assert;

import java.io.*;

/**
 * 程序入口
 */
@Configuration
@ComponentScan(value = "com.example.spring.learn")
@SuppressWarnings("all")
public class Application {

	public static void main(String[] args) throws Exception {
		//	annotationTest();
		fileSystemTest();
	}

	private static void annotationTest() {

		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Application.class);
		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			System.out.println("BeanDefinition : " + beanDefinitionName);
		}

		WelcomeService welcomeService = (DefaultWelcomeService) applicationContext.getBean("defaultWelcomeService");
		System.out.println(welcomeService.sayHello("强大的spring 框架"));
	}

	private static void fileSystemTest() {
		System.out.println("welcome spring !");
		String path = "C:\\workspace\\spring-framework-5.2.0.RELEASE\\spring-learn-demo\\src\\main\\resources\\spring\\spring-config.xml";

		ApplicationContext context = new FileSystemXmlApplicationContext(path);
		WelcomeService helloService = (WelcomeService) context.getBean("helloService");
		System.out.println(helloService.sayHello("张三"));

		System.out.println("无参构造 : " + context.getBean("user1"));
		System.out.println("无参构造 : " + context.getBean("user1"));
		System.out.println("静态工厂 : " + context.getBean("user2"));
		System.out.println("静态工厂 : " + context.getBean("user2"));
		System.out.println("实力工厂 : " + context.getBean("user3"));
		System.out.println("实例工厂 : " + context.getBean("user3"));

		// FactoryBean  
		System.out.println("factoryBean : " + context.getBean("userFactoryBean"));
		System.out.println("factoryBean : " + context.getBean("&userFactoryBean"));

	}

}
