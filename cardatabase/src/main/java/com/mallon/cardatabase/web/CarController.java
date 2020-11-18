package com.mallon.cardatabase.web;

import com.mallon.cardatabase.domain.dto.Car;
import com.mallon.cardatabase.domain.dto.Owner;
import com.mallon.cardatabase.services.CarDatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

	@Autowired
	CarDatabaseService service;
	
	@RequestMapping("/cars")
	public Iterable<Car> getCars() {
		return service.findAllCars();
	}

	@RequestMapping("/owners")
	public Iterable<Owner> getOwners(){
		return service.findAllOwners();
	}

	@RequestMapping("owner/{name}")
	public Owner getOwnerByName(@PathVariable String name){
		return service.getOwnerByName(name);
	}

}
