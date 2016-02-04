package com.gumtree.user.model;

@SuppressWarnings("serial")
public class AddressBookException extends Exception {

	public AddressBookException() {
		super();
	}

	public AddressBookException(String message, Throwable cause, 
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public AddressBookException(String message, Throwable cause) {
		super(message, cause);
	}

	public AddressBookException(String message) {
		super(message);
	}

	public AddressBookException(Throwable cause) {
		super(cause);
	}
}
