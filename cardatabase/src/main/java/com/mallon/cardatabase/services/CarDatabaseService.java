package com.mallon.cardatabase.services;

import com.mallon.cardatabase.domain.dao.CarRepository;
import com.mallon.cardatabase.domain.dao.OwnerRepository;
import com.mallon.cardatabase.domain.dto.Car;
import com.mallon.cardatabase.domain.dto.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarDatabaseService {
    @Autowired
    private CarRepository repository;

    @Autowired
    private OwnerRepository ownerRepository;

    public Iterable<Car> findAllCars(){
        return repository.findAll();
    }

    public Iterable<Owner> findAllOwners(){
        return ownerRepository.findAll();
    }

    public Owner getOwnerByName(String name){
        return ownerRepository.findOwnerByFirstname(name);
    }
}
