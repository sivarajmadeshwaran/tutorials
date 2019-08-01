package siva.spring.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import siva.spring.core.annotations.Employee;

@RestController
@CrossOrigin(origins="http://example.com",maxAge=1000)
//@Profile("prod") -- To select the particular profile 
public class EmployeeResource {

	@Autowired
	@Lazy
	private Employee emp;

	@GetMapping(path = "/emp")
	public  Employee getEmployee() {
		System.out.println("Employee insance---" + emp.getName());
		// emp.getAddress().setCity("Salem");
		System.out.println(emp + "-------------");
		System.out.println("emp.Contact details " + emp.getContactDetails());
		System.out.println("emp.Dept details " + emp.getDept());
		return emp;
	}

}
