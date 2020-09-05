package org.acme.test.docker;

import java.text.DateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConsoleContent extends StorageContent {

	private static final Logger logger = LoggerFactory.getLogger(ConsoleContent.class);

	public ConsoleContent(int typeLog) {
		super(typeLog);
	}

	@Override
	public String writeMessage(String message) {
		message = message.trim();
		String messageFinal = DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + " - " + message;

		if (typeLogString.contains("message")) {
			messageFinal = "message : " + messageFinal;
			logger.info("{}", messageFinal);
		} else if (typeLogString.contains("warning")) {
			messageFinal = "warning : " + messageFinal;
			logger.info("{}", messageFinal);
		} else {
			messageFinal = "error : " + messageFinal;
			logger.info("{}", messageFinal);
		}

		return messageFinal;
	}

}
