package Practa3_Version2;

import java.io.OutputStream;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface FileInterface extends Remote {
    public byte[] downloadFile(String fileName) throws RemoteException;

    public int contarLineas(String nombreArchivo);

    public int cuentavocales(String nombreArchivo);

    public void escribe(OutputStream os) throws RemoteException;

    public void imprimir();

    public void respaldar(String nombreArchivoDestino) throws RemoteException;

    public void copiar(String nombreArchivoDestino) throws RemoteException;

    public void renombrar(String nombreArchivo) throws RemoteException;

    public void eliminar(String nombreArchivo) throws RemoteException;
}
