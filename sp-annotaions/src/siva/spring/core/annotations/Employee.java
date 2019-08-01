package siva.spring.core.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.annotation.Lazy;

//@Component
/*
 * If the class doesn't have empty constructor it won't initiate a bean with @Component  & will
 * throw UnsatisfiedDependencyException
 */
public class Employee {

	private String id;

	private String name;

	/*
	 * @Autowired It will fetch the address object by type private IAddress
	 * address will work since we have bean name as class name of address.
	 * private IAddress address;
	 */

	@Autowired
	//@Qualifier("address")
	/*
	 * if we give diff name for address injection it will fail and throw
	 * UnsatisfiedDependencyException since we have two address beans in the
	 * application it is unable to autowire. Here we need @Qualifier to pick the
	 * correct bean
	 */
	private IAddress empAddress;
	
	public IAddress getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(IAddress empAddress) {
		this.empAddress = empAddress;
	}

	public ContactDetails getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(ContactDetails contactDetails) {
		this.contactDetails = contactDetails;
	}

	@Lookup //This will inject the prototype bean into the singleton bean.At runtime it will create context.getBean("Dept") to get the bean
	public Department getDept(){
		return null;
	}
	
	@Autowired
	@Lazy   // This will initalize contact details when it requires instead of creating instance during spring boot on load
	private ContactDetails contactDetails;

	public Employee() {
		super();
		System.out.println("siva in default constructor ----employee bean instantiation");

	}

	public Employee(String id, String name, Address address) {
		super();
		System.out.println("siva ----employee bean instantiation");
		this.id = id;
		this.name = name;
		this.empAddress = address;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



}
