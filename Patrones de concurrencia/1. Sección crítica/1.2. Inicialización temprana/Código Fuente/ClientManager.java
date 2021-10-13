
public class ClientManager {

	public static void main(String[] args) {
		for (int i = 1; i <= 100; i++) {
			FileProcess proceso1 = new FileProcess("Thread 1 is wrtting");
			proceso1.start();
			FileProcess proceso2 = new FileProcess("Thread 2 is writting");
			proceso2.start();
		}
	}
}

class FileProcess extends Thread {
	private String msgLog;

	public FileProcess(String msg) {
		this.msgLog = msg;

	}

	@Override
	public void run() {
		// Cuanto se demora obteniendo el registrador
		long t1 = System.nanoTime();
		Logger fileLogger = FileLogger.getFileLogger();
		long t2 = System.nanoTime();
		long timeExc = t2 - t1;
		System.out.println("Obteniendo registrador " + this.msgLog + " :" + timeExc);
		// Cuanto se demora registrando los mensajes
		long t3 = System.nanoTime();
		for (int i = 1; i <= 100; i++) {
			fileLogger.log(msgLog);
		}
		long t4 = System.nanoTime();
		long timeExc2 = t4 - t3;
		System.out.println("Registrando mensajes: " + this.msgLog + " :" + timeExc2);
		// Creación de archivos para realizar los datos estadisticos
		FileUtil futil = new FileUtil();
		futil.writeToFile("log" + this.msgLog + ".csv", this.msgLog + "," + timeExc + "," + timeExc2, true, true);

	}

}
