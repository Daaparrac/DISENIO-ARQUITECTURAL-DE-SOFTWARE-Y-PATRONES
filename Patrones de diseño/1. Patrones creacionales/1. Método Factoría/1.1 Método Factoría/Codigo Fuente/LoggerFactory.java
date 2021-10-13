import java.util.*;
import java.io.*;

public class LoggerFactory {
 
  public Logger getLogger() {
      return new FileLogger();
  }
}

