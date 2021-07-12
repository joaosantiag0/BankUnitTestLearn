package br.com.jsantiago.exceptions;

public class UserInputErrorException extends Exception {

    public UserInputErrorException() {
    }

    public UserInputErrorException(String message) {
        super(message);
    }
}
