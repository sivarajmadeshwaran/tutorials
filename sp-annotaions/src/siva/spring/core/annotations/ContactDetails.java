package siva.spring.core.annotations;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class ContactDetails {

	private String mobNr;
	private String landLineNbr;
		

	public ContactDetails() {
		super();
		System.out.println("Contact Details Initialization");
	}

	public ContactDetails(String mobNr, String landLineNbr) {
		super();
		this.mobNr = mobNr;
		this.landLineNbr = landLineNbr;
	}

	public String getMobNr() {
		return mobNr;
	}

	public void setMobNr(String mobNr) {
		this.mobNr = mobNr;
	}

	public String getLandLineNbr() {
		return landLineNbr;
	}

	public void setLandLineNbr(String landLineNbr) {
		this.landLineNbr = landLineNbr;
	}

}
