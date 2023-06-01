package com.MongoDb.demo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GroceryRepository extends MongoRepository<GroceryItems,String> {

}
