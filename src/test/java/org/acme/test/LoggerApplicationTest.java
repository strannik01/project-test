package org.acme.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.text.DateFormat;
import java.util.Date;

import org.acme.test.docker.ConfigApp;
import org.acme.test.docker.ConfigAppException;
import org.acme.test.docker.ConsoleContent;
import org.acme.test.docker.FileContent;
import org.acme.test.docker.StorageContent;
import org.acme.test.docker.StorageException;
import org.acme.test.docker.TypeLog;
import org.junit.Before;
import org.junit.Test;

public class LoggerApplicationTest {

	private static String propertyFile = "src/main/resources";

	@Before
	public void setUp() {
		try {
			ConfigApp.getInstance().init(propertyFile);
		} catch (ConfigAppException e) {
			fail();
		}
	}

	@Test
	public void writeInfoMessageInFile() {
		String response = null;
		String message = "Hello World";
		StorageContent storageContent = new FileContent(TypeLog.MESSAGE);
		try {
			response = storageContent.writeMessage(message);
			assertEquals("message : " + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + " - " + message, response);
		} catch (StorageException e) {
			fail();
		}
	}

	@Test
	public void writeWarningMessageInFile() {
		String response = null;
		String message = "Hello World";
		StorageContent storageContent = new FileContent(TypeLog.WARNING);
		try {
			response = storageContent.writeMessage(message);
			assertEquals("warning : " + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + " - " + message, response);
		} catch (StorageException e) {
			fail();
		}
	}

	@Test
	public void writeErrorMessageInFile() {
		String response = null;
		String message = "Hello World";
		StorageContent storageContent = new FileContent(TypeLog.ERROR);
		try {
			response = storageContent.writeMessage(message);
			assertEquals("error : " + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + " - " + message, response);
		} catch (StorageException e) {
			fail();
		}
	}

	@Test
	public void writeInfoMessageInConsole() {
		String response = null;
		String message = "Hello World";
		StorageContent storageContent = new ConsoleContent(TypeLog.MESSAGE);
		try {
			response = storageContent.writeMessage(message);
			assertEquals("message : " + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + " - " + message, response);
		} catch (StorageException e) {
			fail();
		}
	}

	@Test
	public void writeWarningMessageInConsole() {
		String response = null;
		String message = "Hello World";
		StorageContent storageContent = new ConsoleContent(TypeLog.WARNING);
		try {
			response = storageContent.writeMessage(message);
			assertEquals("warning : " + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + " - " + message, response);
		} catch (StorageException e) {
			fail();
		}
	}

	@Test
	public void writeErrorMessageInConsole() {
		String response = null;
		String message = "Hello World";
		StorageContent storageContent = new ConsoleContent(TypeLog.ERROR);
		try {
			response = storageContent.writeMessage(message);
			assertEquals("error : " + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + " - " + message, response);
		} catch (StorageException e) {
			fail();
		}
	}

}
