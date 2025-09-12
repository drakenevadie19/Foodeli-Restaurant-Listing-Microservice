package com.codedecode.restaurantlisting.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantDTO {

    // Characteristics showcase a restaurant
    private int id;
    private String name;
    private String address;
    private String city;
    private String restaurantDescription;
    private int owner_id;
}
