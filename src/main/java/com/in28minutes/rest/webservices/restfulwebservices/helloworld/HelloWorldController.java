package com.in28minutes.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin(origins="http://localhost:4200")
@RestController
public class HelloWorldController {

	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		return "Hello World";
	}

	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World - Changed");
	}

	@GetMapping(path = "/hello-world/path-variable/{name}/{email}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name, @PathVariable String email) {
		return new HelloWorldBean(String.format("Hello World, %s - %s", name, email));
	}
}
