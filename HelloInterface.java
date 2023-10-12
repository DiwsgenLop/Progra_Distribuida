import java.rmi.Remote;
import java.rmi.RemoteException;

public interface HelloInterface extends Remote {
    public String say() throws RemoteException;

    public int countVowels(String phrase) throws RemoteException;
}
