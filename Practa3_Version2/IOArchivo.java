package Practa3_Version2;

import java.io.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class IOArchivo extends UnicastRemoteObject implements FileInterface {
    private String nombreArchivo;

    // Constructor con parametro para representar el nombre del archivo en el que
    // operar
    public IOArchivo(String nombreArchivo) throws RemoteException {
        this.nombreArchivo = nombreArchivo;
    }

    // Metodo para descargar el archivo
    public byte[] downloadFile(String fileName) {
        try {
            File file = new File(fileName);
            byte buffer[] = new byte[(int) file.length()];
            BufferedInputStream input = new BufferedInputStream(new FileInputStream(fileName));
            input.read(buffer, 0, buffer.length);
            input.close();
            return (buffer);
        } catch (Exception e) {
            System.out.println("FileImpl: " + e.getMessage());
            e.printStackTrace();
            return (null);
        }
    }

    // Metodo para contarlineas del archivo dado el nombre del archivo String
    public int contarLineas(String nombreArchivo) {
        int contador = 0;
        try {
            FileReader fr = new FileReader(nombreArchivo);
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();
            while (linea != null) {
                contador++;
                linea = br.readLine();
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            System.out.println("Error al leer el archivo");
        }
        return contador;
    }

    // Metodo para contarlas vocales del archivo dado el nombre del archivo String
    public int cuentavocales(String nombreArchivo) {
        int contador = 0;
        try {
            FileReader fr = new FileReader(nombreArchivo);
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();
            while (linea != null) {
                for (int i = 0; i < linea.length(); i++) {
                    if (linea.charAt(i) == 'a' || linea.charAt(i) == 'e' || linea.charAt(i) == 'i'
                            || linea.charAt(i) == 'o' || linea.charAt(i) == 'u') {
                        contador++;
                    }
                }
                linea = br.readLine();
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            System.out.println("Error al leer el archivo");
        }
        return contador;
    }

    // Metodo que escriba el contedio del archivo a OS
    public void escribe(OutputStream os) throws RemoteException {
        try (InputStream is = new FileInputStream(nombreArchivo)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = is.read(buffer)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo en el OutputStream: " + e.getMessage());
            throw new RemoteException("Error al escribir el archivo en el OutputStream: " + e.getMessage());
        }
    }

    // Metodo para imprimir el contenido del archivo en pantalla
    public void imprimir() {
        try {
            FileReader fr = new FileReader(nombreArchivo);
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();
            while (linea != null) {
                System.out.println(linea);
                linea = br.readLine();
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            System.out.println("Error al leer el archivo");
        }
    }

    // Metodo para respaldar el archivo
    public void respaldar(String nombreArchivoDestino) throws RemoteException {
        try (InputStream is = new FileInputStream(nombreArchivo);
                OutputStream os = new FileOutputStream(nombreArchivoDestino)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = is.read(buffer)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            System.err.println("Error al respaldar el archivo: " + e.getMessage());
            throw new RemoteException("Error al respaldar el archivo: " + e.getMessage());
        }
    }

    // Metodo para copiar el contenido del archivo fuente a un archivo destino
    // 'nombrearchivodestino'
    public void copiar(String nombreArchivoDestino) throws RemoteException {
        try (InputStream is = new FileInputStream(nombreArchivo);
                OutputStream os = new FileOutputStream(nombreArchivoDestino)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = is.read(buffer)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            System.err.println("Error al copiar el archivo: " + e.getMessage());
            throw new RemoteException("Error al copiar el archivo: " + e.getMessage());
        }
    }

    // Metodo para renombrar el archivo
    public void renombrar(String nombreArchivo) throws RemoteException {
        File archivo = new File(nombreArchivo);
        File archivo2 = new File(this.nombreArchivo);
        if (archivo2.renameTo(archivo)) {
            System.out.println("Archivo renombrado");
        } else {
            System.out.println("Error al renombrar el archivo");
        }
    }

    // Metodo para eliminar el archivo
    public void eliminar(String nombreArchivo) throws RemoteException {
        File archivo = new File(nombreArchivo);
        if (archivo.delete()) {
            System.out.println("Archivo eliminado");
        } else {
            System.out.println("Error al eliminar el archivo");
        }
    }
}
