package siva.spring.annotations;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import siva.spring.web.annotations.Student;

@RestController
public class StudentResource {

	@Autowired
	private Student student;

	List<Student> stuList = Arrays.asList(new Student("Sivaraj", "1"), new Student("Raj", "2"),
			new Student("prabha", "3"));

	/**
	 * RequestMapping with producing xml for student
	 * 
	 * @return
	 */
	@RequestMapping(path = "/student", produces = MediaType.APPLICATION_XML_VALUE)
	public Student getStudentDetails() {
		System.out.println("Student insance---" + student);
		return stuList.get(2);
	}

	/**
	 * RequestMapping with Headers & Json value mapping
	 * 
	 * @return
	 */
	@RequestMapping(path = "/student", headers = "key=siva", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Student> getStudentJson() {
		System.out.println("Student insance---" + student);
		return stuList;
	}

	/**
	 * RequestMapping along with PathVariable
	 * 
	 * @return
	 */
	@RequestMapping(path = "/student/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Student getStudentById(@PathVariable(name = "id") String id) {
		return stuList.stream().filter(s -> s.getId().equals(id)).findAny().get();

	}

	/**
	 * RequestMapping along with multiple PathVariable
	 * 
	 * @return
	 */
	@RequestMapping(path = "/student/{id}/name/{nm}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Student getStudentById(@PathVariable("id") String id, @PathVariable("nm") String name) {
		return stuList.stream().filter(s -> s.getId().equals(id)).filter(s -> s.getName().equals(name)).findAny().get();

	}

	/**
	 * RequestMapping along with RequestParam
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(path = "/stu", produces = MediaType.APPLICATION_JSON_VALUE)
	public Student studentByQueryPm(@RequestParam(defaultValue = "1", name = "id", required = true) String id) {
		return stuList.stream().filter(s -> s.getId().equals(id)).findAny().get();

	}

	/**
	 * @GetMapping for multiple url's mapping to same controller method
	 * 
	 * @return
	 */
	@GetMapping(path = { "/stu1", "/stu2" }, produces = MediaType.APPLICATION_JSON_VALUE)
	public Student stuForMultiplePaths() {
		// return stuList.stream().findFirst().get();
		try {
			return stuList.stream().findFirst().get();
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Sivaraj Facing  Error in server side");
		}
	}

	/**
	 * @ExceptionHandler- This us used to caught the exception and process
	 *                    something
	 * @ResponseStatus - This is used to give the http status of the response
	 * @return
	 */
	@ExceptionHandler(NoSuchElementException.class)
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void onException(NoSuchElementException e) {
		System.out.println("Exception Occured in Siva-----------");

	}

}
