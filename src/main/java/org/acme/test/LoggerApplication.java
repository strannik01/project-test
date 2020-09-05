package org.acme.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.acme.test.docker.ConfigApp;
import org.acme.test.docker.ConfigAppException;
import org.acme.test.docker.ParentThread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerApplication {

	private static final Logger logger = LoggerFactory.getLogger(LoggerApplication.class);
	private static ExecutorService service = null;

	public static void main(String[] args) {
		if (args.length == 0) {
			logger.error("La aplicación no pudo inicializar porque no tiene ningun parametro");
			System.exit(-1);
		} else {
			if (args[0].equals("start")) {
				try {
					startApp(args);
				} catch (Exception e) {
					logger.error("No se pudo inicializar el servicio.", e);
					System.exit(-1);
				}
			}
			if (args[0].equals("stop")) {
				stopDaemon();
			}

		}
	}

	private static void startApp(String[] args) {
		//		Content content = new Content();
		try {
			ConfigApp.getInstance().init(args[1]);

			ParentThread parent = new ParentThread();
			service = Executors.newSingleThreadExecutor();
			service.execute(parent);

			// StorageContent scontent = content.selectStorageContent();
			// scontent.writeMessage(ConfigApp.getInstance().getMessage());
			logger.info("****** Fin de la aplicación ***********");
			// } catch (StorageException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }
		} catch (ConfigAppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void stopDaemon() {
		ParentThread.active = false;
		if (null != service) {
			service.shutdown();
			while (!service.isTerminated()) {
				try {
					TimeUnit.MILLISECONDS.sleep(100);
				} catch (InterruptedException e) {

				}
			}
		}
		logger.info("Application stopped");
		System.exit(-1);
	}


}
