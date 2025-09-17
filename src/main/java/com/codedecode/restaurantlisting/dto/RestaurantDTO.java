package com.codedecode.restaurantlisting.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@AllArgsConstructor
@NoArgsConstructor
public class RestaurantDTO {

    // Characteristics showcase a restaurant
    private int id;
    private String name;
    private String address;
    private String city;
    private String restaurantDescription;
    private int owner_id;

    public RestaurantDTO(int id, String name, String address, String city, String restaurantDescription, int owner_id) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.city = city;
        this.restaurantDescription = restaurantDescription;
        this.owner_id = owner_id;
    }
}
