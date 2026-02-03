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
    private String coverImagePath;
    private short status;

    public RestaurantDTO(
            int id,
            String name,
            String address,
            String city,
            String restaurantDescription,
            String coverImagePath,
            int owner_id,
            short status
    ) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.city = city;
        this.restaurantDescription = restaurantDescription;
        this.coverImagePath = coverImagePath;
        this.owner_id = owner_id;
        this.status = status;
    }
}
