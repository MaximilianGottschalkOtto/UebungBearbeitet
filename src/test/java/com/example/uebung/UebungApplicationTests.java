package com.example.uebung;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UebungApplicationTests {

	@Autowired
	private CostumerApplication application;

	@Test
	void shouldBeNotNull() {
		Assertions.assertNotNull(application);
	}

}
