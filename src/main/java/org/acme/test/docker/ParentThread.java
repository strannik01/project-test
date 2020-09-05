package org.acme.test.docker;

public class ParentThread implements Runnable {

	public static volatile boolean active = true;

	@Override
	public void run() {
		while (active) {
			initProcess();
		}
	}

	private void initProcess() {
		Content content = new Content();
		try {
			StorageContent scontent = content.selectStorageContent();
			scontent.writeMessage(ConfigApp.getInstance().getMessage());
		} catch (StorageException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
