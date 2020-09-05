package org.acme.test.docker;

public abstract class StorageContent {

	protected String typeLogString;

	public StorageContent(int typeLog) {
		loadTypeLogger(typeLog);
	}

	private void loadTypeLogger(int typeLog) {
		switch (typeLog) {
		case TypeLog.MESSAGE:
			typeLogString = "message ";
			break;
		case TypeLog.WARNING:
			typeLogString = "warning ";
			break;
		case TypeLog.ERROR:
			typeLogString = "error ";
			break;
		default:
			break;
		}
	}

	public abstract String writeMessage(String message) throws StorageException;
}
