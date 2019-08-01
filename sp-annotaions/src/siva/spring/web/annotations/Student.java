package siva.spring.web.annotations;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@XmlRootElement // this is used to convert xml-object,object-xml
public class Student {

	private String name="Sivaraj";
	private String id="1";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Student(String name, String id) {
		super();
		this.name = name;
		this.id = id;
	}

	public Student() {
		super();
	}

}
