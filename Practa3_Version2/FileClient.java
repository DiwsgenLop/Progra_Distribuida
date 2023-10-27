package Practa3_Version2;

import java.io.*;
import java.rmi.*;

public class FileClient {
    public static void main(String argv[]) {
        if (argv.length != 2) {
            System.out.println("Usage: java FileClient fileName machineName");
            System.exit(0);
        }

        try {
            String name = "//" + argv[1] + "/FileServer";
            FileInterface fi = (FileInterface) Naming.lookup(name);

            // Descargar el archivo y contar líneas y vocales
            byte[] filedata = fi.downloadFile(argv[0]);
            int lineCount = fi.contarLineas(argv[0]);
            int vowelCount = fi.cuentavocales(argv[0]);

            // Imprimir el contenido del archivo
            System.out.println("Contenido del archivo:");
            fi.imprimir();

            // Escribir el contenido del archivo en un OutputStream
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            fi.escribe(outputStream);
            byte[] outputStreamData = outputStream.toByteArray();

            // Respaldar el archivo
            String backupFileName = "backup_" + argv[0];
            fi.respaldar(backupFileName);
            System.out.println("Archivo respaldado como: " + backupFileName);

            // Copiar el archivo
            String copyFileName = "copia_" + argv[0];
            fi.copiar(copyFileName);
            System.out.println("Archivo copiado como: " + copyFileName);

            // Renombrar el archivo
            String newFileName = "nuevo_nombre.txt";
            fi.renombrar(newFileName);
            System.out.println("Archivo renombrado como: " + newFileName);

            // Eliminar el archivo
            fi.eliminar(argv[0]);
            System.out.println("Archivo eliminado." + argv[0]);

            // Imprimir los valores obtenidos
            System.out.println("Número de líneas en el archivo: " + lineCount);
            System.out.println("Número de vocales en el archivo: " + vowelCount);
        } catch (Exception e) {
            System.err.println("FileClient exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
