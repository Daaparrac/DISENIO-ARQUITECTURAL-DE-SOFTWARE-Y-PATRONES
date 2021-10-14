class LoggerClient {

  public static void main(String[] args) {
	  
//Escribiendo a archivos con fiabilidad de hilos
	  
	FileLogger logger = FileLogger.getFileLogger();
    EncryptLogger eLogger = new EncryptLogger(logger);
    
    logger.log("log1.txt","Cifrado simple de un mensaje: ");
    eLogger.log("log1.txt",
				"Este mensaje será cifrado de manera simple y registrado en el archivo log1.txt");
    logger.log("log1.txt","***********************************************************************");
    EncryptionStrategy strategySubstF = new SubstitutionCypher();
    eLogger.setEncryptionStrategy(strategySubstF);

    logger.log("log2.txt","Cifrado por sustitución de caracteres de un mensaje: ");
    eLogger.log("log2.txt",
    		"Este mensaje será cifrado por sustitución y registrado en el archivo log2.txt");
    logger.log("log2.txt","***********************************************************************");
    EncryptionStrategy strategyBookF = new CodeBookCypher();
    eLogger.setEncryptionStrategy(strategyBookF);
    logger.log("log3.txt","Cifrado basado en código de libro de un mensaje: ");
    eLogger.log("log3.txt","Este mensaje será cifrado basado en un texto de un libro y registrado en el archivo log3.txt");
    logger.log("log3.txt","***********************************************************************");
    EncryptionStrategy strategyCaesarF = new CaesarCypher();
    eLogger.setEncryptionStrategy(strategyCaesarF);
    logger.log("log4.txt","Cifrado César un mensaje: ");
    eLogger.log("log4.txt","Este mensaje usará cifrado César y será registrado en el archivo log4.txt");
    logger.log("log4.txt","***********************************************************************");
 
    //Escribiendo salidas a consola
	    ConsoleLogger loggerC = ConsoleLogger.getConsoleLogger();
	    EncryptLogger eLoggerC = new EncryptLogger(loggerC);
	    System.out.println("Cifrado simple de un mensaje");
	    eLoggerC.log("consola",
	                "Este mensaje será cifrado de manera simple y registrado en el archivo log1.txt");
	    System.out.println("*************************************************************");
	    System.out.println("Cifrado por sustitución de caracteres de un mensaje: ");
	    EncryptionStrategy strategySubstC = new SubstitutionCypher();
	    eLoggerC.setEncryptionStrategy(strategySubstC);
	    eLoggerC.log("consola",
	    		"Este mensaje será cifrado por sustitución y registrado en el archivo log2.txt");
	    System.out.println("*************************************************************");
	    System.out.println("Cifrado basado en código de libro de un mensaje: ");
	    EncryptionStrategy strategyBookC = new CodeBookCypher();
	    eLoggerC.setEncryptionStrategy(strategyBookC);
	    eLoggerC.log("consola","Este mensaje será cifrado basado en un texto de un libro y registrado en el archivo log3.txt");
	    System.out.println("*************************************************************");
	    System.out.println("Cifrado César de un mensaje: ");
	    EncryptionStrategy strategyCaesarC = new CaesarCypher();
	    eLoggerC.setEncryptionStrategy(strategyCaesarC);
	    eLoggerC.log("consola","Este mensaje usará cifrado César y será registrado en el archivo log4.txt");
  }

} // End of class

