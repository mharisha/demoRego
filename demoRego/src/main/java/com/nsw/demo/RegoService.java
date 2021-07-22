package com.nsw.demo;

import java.util.List;
import java.util.Map;

import com.nsw.demo.model.PerformAction;
import com.nsw.demo.model.Person;
import com.nsw.demo.model.Vehicle;

public class RegoService {
	public static final String SUCCESS = "SUCCESS";
	public static final String FAILURE = "FAILURE";
	
	public static Person addPerson(Person person, List<Person> listOfPeople) {
		person.setPersonId(listOfPeople.size());
		listOfPeople.add(person);
		return person;
	}
	
	public static Vehicle addVehicle(Vehicle vehicle, List<Vehicle> listOfVehicles) {
		vehicle.setVehicleId(listOfVehicles.size());
		listOfVehicles.add(vehicle);
		return vehicle;
	}
	
	public static String linkVehicle(PerformAction registration, Map<String,Integer> regoDB) {
		if(!regoDB.containsKey(registration.getRegistrationNo())){
			regoDB.put(registration.getRegistrationNo(), registration.getPersonId());
			return SUCCESS;
		}
		return FAILURE;
	}
	
	public static String unLinkVehicle(PerformAction deRegistration, Map<String,Integer> regoDB) {
		if(regoDB.containsKey(deRegistration.getRegistrationNo())) {
			Integer registeredPersonId = regoDB.get(deRegistration.getRegistrationNo());
			if(registeredPersonId.equals(deRegistration.getPersonId())){
				regoDB.remove(deRegistration.getRegistrationNo());
				return SUCCESS;
			}
		}		
		return FAILURE;
	}
}
