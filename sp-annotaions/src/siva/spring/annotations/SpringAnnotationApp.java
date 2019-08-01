package siva.spring.annotations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import siva.spring.core.annotations.Employee;

@SpringBootApplication
@ComponentScan(basePackages = "siva.spring")
@Import(Employee.class) //This is to import the bean class instead of component scan
public class SpringAnnotationApp {

	public static void main(String[] args) {
		SpringApplication.run(SpringAnnotationApp.class, args);
	}

	//@Bean
	/*
	 * this is to register the employee instance to the spring context so
	 * whenever autowire is called for this employee it will get this bean and
	 * return
	 */
//	@DependsOn("address1")
	public Employee empl() {
		return new Employee("1", "sivaraj", null);
	}

}
