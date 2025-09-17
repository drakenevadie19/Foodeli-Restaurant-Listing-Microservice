package com.codedecode.restaurantlisting.controller;

import com.codedecode.restaurantlisting.dto.RestaurantDTO;
import com.codedecode.restaurantlisting.service.RestaurantService;
import com.codedecode.restaurantlisting.utils.Result;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.*;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RestaurantControllerTest {

    // Following is each endpoint method testing functions
    // Create testing instance of object to test
    @InjectMocks
    RestaurantController restaurantController;

    @Mock // Mock for Autowired dependency
    RestaurantService restaurantService; // no need to test for this object

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFetchAllRestaurant() {
        // Arrange - Act - Assert
        // Arrange: Mock the service behavior
        // Testing this line: List<RestaurantDTO> allRestaurants = restaurantService.findAllRestaurants();
        // Prepare data for testing
        List<RestaurantDTO> mockRestaurants = Arrays.asList(
                new RestaurantDTO(1, "Restaurant 1", "Address 1", "city 1", "Desc 1", 1),
                new RestaurantDTO(2, "Restaurant 2", "Address 2", "city 2", "Desc 2",1)
        );
        when(restaurantService.findAllRestaurants()).thenReturn(mockRestaurants);

        // Act: Call the controller method
        Result response = restaurantController.fetchAllRestaurant();

        // Assert: Verify the response and the service method in Service was called
        // Verify the response
        assertEquals(HttpStatus.OK, response.getCode());
        assertEquals(mockRestaurants, response.getData());

        // Verify that the service method was called (only once)
        verify(restaurantService, times(1)).findAllRestaurants();
    }

    @Test
    public void testSaveRestaurant() {
        // Create data test
        RestaurantDTO mockRestaurant =  new RestaurantDTO(1, "Restaurant 1", "Address 1", "city 1", "Desc 1", 1);
        when(restaurantService.addRestaurantInDB(mockRestaurant)).thenReturn(mockRestaurant);

        // Call the method
        Result response = restaurantController.saveRestaurant(mockRestaurant);

        // Verify the response
        assertEquals(HttpStatus.CREATED, response.getCode());
        assertEquals(mockRestaurant, response.getData());

        // Verify that the service was called
        verify(restaurantService, times(1)).addRestaurantInDB(mockRestaurant);
    }

    @Test
    public void testFindRestaurantById() {
        // Create data test
        Integer mockRestaurantId = 1;
        // Mock restaurant
        RestaurantDTO mockRestaurant =  new RestaurantDTO(1, "Restaurant 1", "Address 1", "city 1", "Desc 1", 1);
        // Mock service behavior
        when(restaurantService.fetchRestaurantById(mockRestaurantId)).thenReturn(mockRestaurant);

        // Call the method
        Result response = restaurantController.findRestaurantById(mockRestaurantId);

        // Verify the response
        assertEquals(HttpStatus.OK, response.getCode());
        assertEquals(mockRestaurant, response.getData());

        // Verify that the service method was called
        verify(restaurantService, times(1)).fetchRestaurantById(mockRestaurantId);
    }
}
