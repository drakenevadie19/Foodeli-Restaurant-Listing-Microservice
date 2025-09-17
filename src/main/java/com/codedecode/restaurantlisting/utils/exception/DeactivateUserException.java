package com.codedecode.restaurantlisting.utils.exception;

public class DeactivateUserException extends RuntimeException {

    public DeactivateUserException(String reason) {
        super("Cannot deactivate user: " + reason);
    }

}
