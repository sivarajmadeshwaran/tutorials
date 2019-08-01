package siva.spring.core.annotations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class Address implements IAddress{

	private int doorNo;
	private String street;
	private String city;
	private String state;

	public Address(int doorNo, String street, String city, String state) {
		super();
		this.doorNo = (int)Math.random();
		this.street = String.valueOf(Math.random());
		this.city = "sss";
		this.state = state;
		System.out.println("Parameter Address bean initialization");

	}

	
	public Address() {
		super();
		System.out.println("Default constructor Address bean initialization");
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
