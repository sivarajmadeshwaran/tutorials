package siva.spring.core.annotations;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary //If we give primary to the class,if we have multiple address bean instances
public class Address1 implements IAddress{

	private int doorNo;
	private String street="Primary Test";
	private String city;
	private String state;

	public Address1(int doorNo, String street, String city, String state) {
		super();
		this.doorNo = doorNo;
		this.street = street;
		this.city = city;
		this.state = state;
	}

	
	public Address1() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getDoorNo() {
		return doorNo;
	}

	public void setDoorNo(int doorNo) {
		this.doorNo = doorNo;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
