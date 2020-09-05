package org.acme.test.docker;

public class StorageException extends Exception {

	/**
	 *
	 */
	private static final long serialVersionUID = -5167058020556288915L;

	public StorageException(String message) {
		super(message);
	}

	public StorageException(String message, Throwable cause) {
		super(message, cause);
	}


}
