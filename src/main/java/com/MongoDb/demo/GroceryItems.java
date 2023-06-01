package com.MongoDb.demo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("grocery")
public class GroceryItems {
    @Id
    private String id;
    private String itemName;
    private int price;
    private String quantity;
}
