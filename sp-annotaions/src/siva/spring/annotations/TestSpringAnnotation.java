package siva.spring.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import siva.spring.core.annotations.Employee;

@RestController
public class TestSpringAnnotation {

	@Autowired
	@Lazy
	private Employee emp;

	@RequestMapping(path = "/emp", produces= MediaType.APPLICATION_XML_VALUE)
	public Employee getSpring() {
		System.out.println("Employee insance---" + emp.getName());
		// emp.getAddress().setCity("Salem");
		System.out.println(emp + "-------------");

		System.out.println("emp.Contact details " + emp.getContactDetails());
		System.out.println("emp.Dept details " + emp.getDept());
		return emp;

	}

}
