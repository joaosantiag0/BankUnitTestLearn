package br.com.jsantiago.exceptions;

public class AccountException extends Exception {
    public AccountException() {
    }

    public AccountException(String message) {
        super(message);
    }
}
