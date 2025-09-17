package com.codedecode.restaurantlisting.service;

import com.codedecode.restaurantlisting.dto.RestaurantDTO;
import com.codedecode.restaurantlisting.entity.Restaurant;
import com.codedecode.restaurantlisting.mapper.RestaurantMapper;
import com.codedecode.restaurantlisting.repo.RestaurantRepo;
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

public class RestaurantServiceTest {

    @InjectMocks
    RestaurantService restaurantService;

    @Mock
    RestaurantRepo restaurantRepo;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAllRestaurants() {

        // Create Mock data for result each time fetching list of all restaurants
        List<Restaurant> mockRestaurants = Arrays.asList(
                new Restaurant(1, "Restaurant 1", "Address 1", "city 1", "Desc 1", 1),
                new Restaurant(2, "Restaurant 2", "Address 2", "city 2", "Desc 2", 1)
        );
        // Make the function that when repo call findAll function,  return list of mock restaurants above
        when(restaurantRepo.findAll()).thenReturn(mockRestaurants);

        // Call the service method
        List<RestaurantDTO> restaurantDTOList = restaurantService.findAllRestaurants();

        // Verify the result
        assertEquals(mockRestaurants.size(), restaurantDTOList.size());
        for (int i = 0;i < mockRestaurants.size(); i++) {
            // Checking each element of mockRestaurants, map each of it to DTO,
            //  and compare with each element of returned list of restaurantDTOList
            RestaurantDTO expectedDTO = RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(mockRestaurants.get(i));
            assertEquals(expectedDTO, restaurantDTOList.get(i));
        }

        // Verify that the repository method was called and only called once
        verify(restaurantRepo, times(1)).findAll();
    }

    @Test
    public void testAddRestaurantInDB() {
        RestaurantDTO mockRestaurantDTO = new RestaurantDTO(1, "Restaurant 1", "Address 1", "city 1", "Desc 1", 1);
        Restaurant mockRestaurant = RestaurantMapper.INSTANCE.mapRestaurantDTOToRestaurant(mockRestaurantDTO);

        when(restaurantRepo.save(mockRestaurant)).thenReturn(mockRestaurant);

        RestaurantDTO savedRestaurantDTO = restaurantService.addRestaurantInDB(mockRestaurantDTO);

        assertEquals(mockRestaurantDTO, savedRestaurantDTO);

        verify(restaurantRepo, times(1)).save(mockRestaurant);
    }

    @Test
    public void testFetchRestaurantById() {
        Integer mockId = 1;
        Restaurant mockRestaurant = new Restaurant(1, "Restaurant 1", "Address 1", "city 1", "Desc 1", 1);

        when(restaurantRepo.findById(mockId)).thenReturn(Optional.of(mockRestaurant));

        RestaurantDTO response = restaurantService.fetchRestaurantById(mockId);

        assertEquals(HttpStatus.OK, response);
        assertEquals(mockId, response.getId());

        verify(restaurantRepo, times(1)).findById(mockId);
    }

    @Test
    public void testFetchRestaurantById_NonExistingId() {
        Integer mockId = 1;
//        Restaurant mockRestaurant = new Restaurant(1, "Restaurant 1", "Address 1", "city 1", "Desc 1");

        when(restaurantRepo.findById(mockId)).thenReturn(Optional.empty());

        RestaurantDTO response = restaurantService.fetchRestaurantById(mockId);

        assertEquals(HttpStatus.NOT_FOUND, response);
        assertEquals(null, response);

        verify(restaurantRepo, times(1)).findById(mockId);
    }
}
