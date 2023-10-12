import java.rmi.*;

public class HelloClient {
  public static void main(String[] args) {
    if (args.length < 2) {
      System.out.println("Uso: HelloClient <ip> <frase>");
      return;
    }

    String serverIP = args[0];
    String phrase = args[1];

    try {
      HelloInterface hello = (HelloInterface) Naming.lookup("//" + serverIP + "/Hello");
      System.out.println(hello.say());

      int numVowels = hello.countVowels(phrase);
      System.out.println("Número de vocales en la frase: " + numVowels);
    } catch (Exception e) {
      System.out.println("HelloClient exception: " + e);
    }
  }
}
