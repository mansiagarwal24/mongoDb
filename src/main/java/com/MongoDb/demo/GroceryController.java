package com.MongoDb.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class GroceryController {
    private final GroceryService service;

    @PostMapping("/addItem")
    public String addItem(@RequestBody GroceryItems groceryItems){
        service.addItem(groceryItems);
        return "Item Added!!";
    }

    @GetMapping("/get")
    public List<GroceryItems> getItems(){
        return service.getItems();
    }
    @GetMapping("/getById/{id}")
    public Optional<GroceryItems> getById(@PathVariable String id){
        return service.getItemById(id);
    }
}
