package com.MongoDb.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.springframework.test.util.AssertionErrors.assertEquals;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	GroceryService groceryService;
	@MockBean
	GroceryRepository groceryRepository;
	@BeforeEach
	void setUp(){
		Optional<GroceryItems> groceryItem = Optional.of(new GroceryItems("1","Coke",250,"5"));
		Mockito.when(groceryRepository.findById("1")).thenReturn(groceryItem);
	}

	@Test
	public void testGetItemById(){
		String itemName="Coke";
		Optional<GroceryItems> items = groceryService.getItemById("1");
		assertEquals("","Coke",items.get().getItemName());
	}

}
