package com.codedecode.restaurantlisting.utils.exception;

public class ObjectAlreadyExistedException extends RuntimeException{

    public ObjectAlreadyExistedException(String objName, String id) {
        super(objName + " " + id + " is already existed!");
    }

}
