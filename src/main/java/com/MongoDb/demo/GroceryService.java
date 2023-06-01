package com.MongoDb.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GroceryService {
    private final GroceryRepository repository;

    public List<GroceryItems> getItems(){
        return repository.findAll();
    }
    public GroceryItems addItem(GroceryItems item){
        return repository.save(item);
    }

    public Optional<GroceryItems> getItemById(String id){
        return repository.findById(id);
    }
}
