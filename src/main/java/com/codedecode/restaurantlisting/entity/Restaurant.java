package com.codedecode.restaurantlisting.entity;

//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="restaurantdb")
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

    @Column(name = "cover_image_path")
    private String coverImagePath;

    @Column(name = "owner_id", nullable = false)
    private int owner_id;

    /**
     * 1 = ACTIVE
     * 2 = INACTIVE
     * 0 = SUSPENDED
     */
    @Column(nullable = false)
    private short status;

    @Column(name = "created_at", updatable = false, insertable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", insertable = false)
    private LocalDateTime updatedAt;

    public void setOwnerId(int ownerId) {
    }
}
