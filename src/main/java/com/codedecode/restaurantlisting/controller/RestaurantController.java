package com.codedecode.restaurantlisting.controller;

import com.codedecode.restaurantlisting.dto.RestaurantDTO;
import com.codedecode.restaurantlisting.service.RestaurantService;
import com.codedecode.restaurantlisting.utils.Result;
import com.codedecode.restaurantlisting.utils.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
@CrossOrigin
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    // Get list of all restaurants
    // This method will always return a response entity and since you are interacting with the client,
    //  you will give them restaurantDTO, not restaurant Entity (list of details of restaurants)
    @GetMapping("/fetchAllRestaurants")
    public Result fetchAllRestaurant() {
        // Return list of restaurant details
        List<RestaurantDTO> allRestaurants = restaurantService.findAllRestaurants();
        return new Result(true, StatusCode.SUCCESS, "Return all restaurants successfully", allRestaurants);
    }

    @PostMapping("/addRestaurant")
    public Result saveRestaurant(@RequestBody RestaurantDTO restaurantDTO) {
        RestaurantDTO restaurantAdded = restaurantService.addRestaurantInDB(restaurantDTO);
        return new Result(true, StatusCode.SUCCESS, "Created restaurants successfully", restaurantAdded);
    }

    @GetMapping("/fetchById/{id}")
    public Result findRestaurantById(@PathVariable Integer id) {
        RestaurantDTO restaurant = restaurantService.fetchRestaurantById(id);
        if (restaurant == null) {
            return new Result(false, StatusCode.NOT_FOUND, "Restaurant not found");
        }
        return new Result(true, StatusCode.SUCCESS, "Found restaurants", restaurant);
    }

}
