package com.mallon.cardatabase.services;

import com.mallon.cardatabase.domain.dto.Car;
import com.mallon.cardatabase.domain.dao.CarRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
@SpringBootTest
public class CarDatabaseServiceTest {

    @InjectMocks
    CarDatabaseService service;

    @Mock
    CarRepository carRepo;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAllCarsTest(){
        ArrayList<Car> list = new ArrayList<>();
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        list.add(car1);
        list.add(car2);
        list.add(car3);

        //tell the repository to return the fake list
        when(carRepo.findAll()).thenReturn(list);


        //test
        Iterable<Car> carList = service.findAllCars();

        assertEquals(3, ((ArrayList) carList).size());
        verify(carRepo, times(1)).findAll();
    }
}
