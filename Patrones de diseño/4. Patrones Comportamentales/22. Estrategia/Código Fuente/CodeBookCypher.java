import java.util.*;

public class CodeBookCypher implements EncryptionStrategy {

  HashMap codeContents = new HashMap();

  private void populateCodeEntries() {
    codeContents.put("Este","Design");
    codeContents.put("mensaje","Patterns");
    codeContents.put("será","are");
    codeContents.put("cifrado","really");
    codeContents.put("basado","useful");
    codeContents.put("en","Partha");
    codeContents.put("un","Kuchana");
    codeContents.put("texto","wrote");
    codeContents.put("de","a");
    codeContents.put("libro","interesting");
    codeContents.put("y","book:");
    codeContents.put("registrado","The");
    codeContents.put("archivo","Design");
    codeContents.put("log4.txt","Patterns");
    codeContents.put("el","of");
    //.........
    //........
  }

  public String encrypt(String inputData) {

    populateCodeEntries();

    String outStr = "";

    StringTokenizer st = new StringTokenizer(inputData);
    while (st.hasMoreTokens()) {
      outStr = outStr + " " +
               codeContents.get(st.nextToken());
    }

    return new String(outStr);
  }

}
