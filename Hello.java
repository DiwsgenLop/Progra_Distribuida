import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Hello extends UnicastRemoteObject implements HelloInterface {
  private String message;

  public Hello(String msg) throws RemoteException {
    message = msg;
  }

  public String say() throws RemoteException {
    return "Server: " + message;
  }

  public int countVowels(String phrase) throws RemoteException {
    int numVowels = 0;
    String phraseLowerCase = phrase.toLowerCase();

    for (int i = 0; i < phraseLowerCase.length(); ++i) {
      char c = phraseLowerCase.charAt(i);
      switch (c) {
        case 'a':
        case 'á':
        case 'e':
        case 'é':
        case 'i':
        case 'í':
        case 'o':
        case 'ó':
        case 'u':
        case 'ú':
          numVowels++;
          break;
        default:
          // Se ignoran las demás letras
      }
    }

    return numVowels;
  }
}
