import java.io.*;
import java.util.*;


public class EncryptLogger {
  private EncryptionStrategy currEncryptionStrategy;
  private Logger logger;

  public EncryptLogger(Logger inp_logger) {
    logger = inp_logger;

    // set the default encryption strategy
    setEncryptionStrategy(new SimpleEncryption());
  }

  public void log(String fileName, String msg) {
    /*Added functionality*/
    msg = encrypt(msg);

    /*
    	Now forward the encrypted text to the FileLogger 
    	for storage
    */
    logger.log(fileName, msg);
  }
  public String encrypt(String msg) {
    /*
     	Apply encryption using the current encryption strategy
     */
    return currEncryptionStrategy.encrypt(msg);
  }

  public void setEncryptionStrategy(
    EncryptionStrategy strategy) {
    currEncryptionStrategy = strategy;
  }

}
