package com.baris.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

	
	@GetMapping(value="person/param",params="version=1")
	public PersonV1 personV1() {
		return new PersonV1("Bob Charlie");
	}
	

	@GetMapping(value="person/param",params="version=2")
	public PersonV2 personV2() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}

	@GetMapping("v3/person")
	public PersonV2 personV3() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}
	
	

	@GetMapping(value="person/header",headers="X-API-VERSION=1")
	public PersonV1 header1() {
		return new PersonV1("Bob Charlie");
	}
	

	@GetMapping(value="person/header",headers="X-API-VERSION=2")
	public PersonV2 header2() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}

}
