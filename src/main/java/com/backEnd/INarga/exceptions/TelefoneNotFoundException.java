package com.backEnd.INarga.exceptions;

public class TelefoneNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -1906328335252901322L;

	public TelefoneNotFoundException(String message) {
        super(message);
    }
}
