package com.nsw.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nsw.demo.model.PerformAction;
import com.nsw.demo.model.Person;
import com.nsw.demo.model.Vehicle;

@RestController
public class RegoController {
	
	List<Person> personsList = new ArrayList<Person>();
	List<Vehicle> vehicleList = new ArrayList<Vehicle>();
	Map<String,Integer> regoDB = new HashMap<String,Integer>();
	
	@PostMapping("/persons")
	public Person createPerson(@RequestBody Person person) {
		return RegoService.addPerson(person, personsList);
	}
	
	@PostMapping("/vehicles")
	public Vehicle createVehicle(@RequestBody Vehicle vehicle) {
		return RegoService.addVehicle(vehicle, vehicleList);
	}
	
	@PatchMapping("/vehicles")
	public String linkVehicle(@RequestBody PerformAction link) {
		return RegoService.linkVehicle(link, regoDB);
	}
	
	@DeleteMapping("/vehicles")
	public String unLinkVehicle(@RequestBody PerformAction link) {
		return RegoService.unLinkVehicle(link, regoDB);
	}
	
}
