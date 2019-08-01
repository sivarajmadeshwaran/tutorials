package siva.spring.annotations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;

import siva.spring.core.annotations.Employee;

@SpringBootApplication
@ComponentScan(basePackages = "siva.spring")
public class SpringAnnotationApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeResource.class, args);
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
