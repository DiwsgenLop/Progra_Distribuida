import java.io.OutputStream;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface FileInterface extends Remote {
    int contarLineas(String nombrearchivo) throws RemoteException;

    int cuentavocales(String nombrearchivo) throws RemoteException;

    void escribe(OutputStream os) throws RemoteException;

    void imprimir() throws RemoteException;

    void respaldar(String nombrearchivo) throws RemoteException;

    void copiar(String nombrearchivodestino) throws RemoteException;

    void renombrar(String nombrearchivo) throws RemoteException;

    void eliminar(String nombrearchivo) throws RemoteException;
}
