package org.acme.test.docker;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigApp {

	//	private static final Logger logger = LoggerFactory.getLogger(ConfigApp.class);

	private static ConfigApp instance;
	private String typeStorage;
	private String typeLog;
	private String message;
	private String pathDestino;

	private ConfigApp() {
		if (instance != null) {
			throw new IllegalStateException("Already initialized.");
		}
	}

	public static ConfigApp getInstance() {
		if (instance == null) {
			instance = new ConfigApp();
		}
		return instance;
	}

	public void init(String propertyFile) throws ConfigAppException {
		try (InputStream input = new FileInputStream(propertyFile + File.separator + "config.properties")) {
			Properties prop = new Properties();
			prop.load(input);

			this.typeStorage = prop.getProperty("data.storage");
			this.typeLog = prop.getProperty("data.typelog");
			this.message = prop.getProperty("data.message");
			this.pathDestino = prop.getProperty("data.path");

		} catch (IOException e) {
			throw new ConfigAppException("Error en configuración", e);
		}

	}

	public String getTypeStorage() {
		return typeStorage;
	}

	public void setTypeStorage(String typeStorage) {
		this.typeStorage = typeStorage;
	}

	public String getTypeLog() {
		return typeLog;
	}

	public void setTypeLog(String typeLog) {
		this.typeLog = typeLog;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPathDestino() {
		return pathDestino;
	}

	public void setPathDestino(String pathDestino) {
		this.pathDestino = pathDestino;
	}

}
