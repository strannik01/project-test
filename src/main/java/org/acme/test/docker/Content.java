package org.acme.test.docker;

public class Content {

	public StorageContent selectStorageContent() throws StorageException {
		String typeContent = ConfigApp.getInstance().getTypeStorage();
		int typeLogger = Integer.parseInt(ConfigApp.getInstance().getTypeLog());
		switch (typeContent) {
		case TypeContent.FILE:
			return new FileContent(typeLogger);
		case TypeContent.CONSOLE:
			return new ConsoleContent(typeLogger);
		case TypeContent.DATABASE:
			return new DatabaseContent(typeLogger);
		default:
			throw new StorageException("Storage not defined");
		}
	}

}
