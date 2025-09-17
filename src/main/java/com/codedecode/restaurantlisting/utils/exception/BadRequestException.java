package com.codedecode.restaurantlisting.utils.exception;

public class BadRequestException extends RuntimeException{

    public BadRequestException(String message) {
        super("BadRequest: "+message+" :(");
    }

}
