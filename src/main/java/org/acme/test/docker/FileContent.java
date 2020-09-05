package org.acme.test.docker;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.DateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileContent extends StorageContent {

	private static final Logger logger = LoggerFactory.getLogger(FileContent.class);

	public FileContent(int typeLog) {
		super(typeLog);
	}

	@Override
	public String writeMessage(String message) throws StorageException {
		message = message.trim();
		String messageFinal = super.typeLogString + ": "
				+ DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + " - " + message;
		try {
			File file = new File("v1.0.0/fileTest.txt");
			if (!file.exists()) {
				file.createNewFile();
				logger.info("Archivo creado type: {}", super.typeLogString);
			}

			try (FileOutputStream fos = new FileOutputStream(file)) {
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
				bw.write(messageFinal);
				bw.newLine();

				bw.close();
			}

			logger.info("Se escribió en archivo type: {}", super.typeLogString);
		} catch (IOException e) {
			throw new StorageException("No se pudo escribir archivo", e);
		}
		return messageFinal;
	}

}
