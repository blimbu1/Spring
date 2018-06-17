package com.luv2code.springdemo.mvc;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.luv2code.springdemo.mvc.validation.CourseCode;


public class Customer {
	
	private String firstName;
	
	//adding min and Max validation rules
	@Min(value=0, message="must be greater than or equal to 0")
	@Max(value=10, message="must be lower than or equal to 10")
	@NotNull(message="is required")
	private Integer freePasses;
	
	//adding the validation rules now
	@NotNull(message="is required")
	@Size(min=1, message="is required")
	private String lastName;
	
	@Pattern(regexp="^[a-zA-Z0-9]{5}", message="only 5 chrs/digits")
	private String postalCode;
	
	
	@CourseCode(value="TOPS", message="must start with TOPS")
	private String courseCode;
	
	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getFreePasses() {
		return freePasses;
	}

	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
	}
	
	

}
