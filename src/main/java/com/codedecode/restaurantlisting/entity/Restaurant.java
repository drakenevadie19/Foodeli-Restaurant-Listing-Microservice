package com.codedecode.restaurantlisting.entity;

//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {

    // Characteristics show case a restaurant
    @Id
    // Auto generate ID by hibernate for restaurant, no need to input.
    // When running application, there will be 2 table generated, one for the restaurant and one for the Hibernate sequence for maintaining ID
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    // The rest fields are inputted by managers
    private String name;
    private String address;
    private String city;
    private String restaurantDescription;

    private int owner_id;
}
