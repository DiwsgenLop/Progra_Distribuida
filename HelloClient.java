import java.rmi.*;

public class HelloClient {
  public static void main(String[] args) {
    if (args.length < 1) {
      System.out.println("Uso: HelloClient <ip>");
      return;
    }

    try {
      String serverIP = args[0];
      HelloInterface hello = (HelloInterface) Naming.lookup("//" + serverIP + "/Hello");
      System.out.println(hello.say());

      // Llamada al método countVowels
      String phrase = "Hola, qué tal?";
      int numVowels = hello.countVowels(phrase);
      System.out.println("Número de vocales en la frase: " + numVowels);
    } catch (Exception e) {
      System.out.println("HelloClient exception: " + e);
    }
  }
}
