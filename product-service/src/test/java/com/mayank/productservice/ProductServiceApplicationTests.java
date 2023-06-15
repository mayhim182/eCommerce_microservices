package com.mayank.productservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest
@AutoConfigureMockMvc
@Testcontainers
class ProductServiceApplicationTests {

  @Container
  static MongoDBContainer mongoDBContainer= new MongoDBContainer("mongo:4.4.2");
  @DynamicPropertySource
  static void setProperties(DynamicPropertyRegistry dymDynamicPropertyRegistry){
      dymDynamicPropertyRegistry.add("spring.data.mongodb.uri",mongoDBContainer::getReplicaSetUrl);
  }
  @Autowired
  private MockMvc mockMvc;

  @Test
	void shouldCreateProduct() {
	}

}
