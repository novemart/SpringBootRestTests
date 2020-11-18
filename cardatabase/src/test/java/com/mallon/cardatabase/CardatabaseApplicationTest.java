package com.mallon.cardatabase;

import com.mallon.cardatabase.services.CarDatabaseService;
import com.mallon.cardatabase.web.CarController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CardatabaseApplicationTest {

	@Autowired
	private CarController carController;

	@Autowired
	private CarDatabaseService service;

	@Test
	void contextLoads() throws Exception {
		assertThat(carController).isNotNull();
		assertThat(service).isNotNull();
	}



}
