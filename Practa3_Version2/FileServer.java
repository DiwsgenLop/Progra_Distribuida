package Practa3_Version2;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class FileServer {
    public static void main(String argv[]) {
        try {
            // Crea una instancia de la clase IOArchivo y expón sus métodos a través de RMI
            FileInterface ioArchivo = new IOArchivo("nombre_del_archivo.txt");
            // O tambien se puede poner
            // FileInterface ioArchivo = new IOArchivo(argv[0]); // argv[0] es el nombre del
            // archivo que se le da desde la linea de comandos

            // Crea el registro RMI y rebind el objeto remoto
            LocateRegistry.createRegistry(1099);
            Naming.rebind("//localhost/FileServer", ioArchivo);

            System.out.println("FileServer esperando conexiones...");
        } catch (Exception e) {
            System.out.println("FileServer: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
