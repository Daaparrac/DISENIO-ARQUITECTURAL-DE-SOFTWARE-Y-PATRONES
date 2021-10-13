import java.util.*;

public class CompositeDemo {
  public static final String SEPARATOR = ", ";

  public static void main(String[] args) {
    FileSystemPart mainFolder =
      new Directory("Principal2021");
    FileSystemPart subFolder1 = new Directory("Abril");

    FileSystemPart subFolder2 = new Directory("Mayo");


    FileSystemPart folder1File1 =
      new File("DatosAbril1.txt",10000);
    FileSystemPart folder1File2 =
      new File("DatosAbril2.txt",20000);
    FileSystemPart folder2File1 =
      new File("DatosMayo1.txt",30000);
    FileSystemPart folder2File2 =
      new File("DatosMayo2.txt",30000);

    try {
      mainFolder.addComponent(subFolder1);
      mainFolder.addComponent(subFolder2);
      subFolder1.addComponent(folder1File1);
      subFolder1.addComponent(folder1File2);
      subFolder2.addComponent(folder2File1);
      subFolder2.addComponent(folder2File2);
    } catch (CompositeException ex) {
      //
    }

    //Client refers to both composite &
    //individual components in a uniform manner
    System.out.println(" El tamaño del directorio principal es: " +
                       mainFolder.getComponentSize() + " KB");
    System.out.println(" El tamaño de la subcarpeta 1 es: " +
                       subFolder1.getComponentSize() + " KB");
    System.out.println(" El tamaño del archivo DatosAbril1.txt es: " +
                       folder1File1.getComponentSize() + " KB");
    System.out.println(" El tamaño del archivo DatosMayo2.txt es: " +
            folder2File2.getComponentSize() + " KB");
  }
}
