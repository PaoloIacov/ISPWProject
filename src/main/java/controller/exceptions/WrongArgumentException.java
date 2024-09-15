package controller.exceptions;


public class WrongArgumentException extends Exception {

    // Constructor that accepts only a message
    public WrongArgumentException(String message) {
        super(message);
    }
}
