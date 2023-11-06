package Practa3_Version2;

import java.io.*;
import java.rmi.*;

public class FileClient {
    public static void main(String argv[]) {
        if (argv.length != 2) {
            System.out.println("Usage: java FileClient <operation> <parameter>");
            System.exit(0);
        }

        try {
            String name = "//" + argv[1] + "/FileServer";
            FileInterface fi = (FileInterface) Naming.lookup(name);

            String operation = argv[0];
            String parameter = argv[1];

            switch (operation) {
                case "contarLineas":
                    int lineCount = fi.contarLineas(parameter);
                    System.out.println("Número de líneas: " + lineCount);
                    break;
                case "cuentavocales":
                    int vowelCount = fi.cuentavocales(parameter);
                    System.out.println("Número de vocales: " + vowelCount);
                    break;
                case "escribe":
                    OutputStream os = new FileOutputStream("salida.txt");
                    fi.escribe(os);
                    os.close();
                    System.out.println("Contenido del archivo escrito en salida.txt");
                    break;
                case "imprimir":
                    fi.imprimir();
                    break;
                case "respaldar":
                    fi.respaldar(parameter);
                    System.out.println("Archivo respaldado.");
                    break;
                case "copiar":
                    fi.copiar(parameter);
                    System.out.println("Archivo copiado a " + parameter);
                    break;
                case "renombrar":
                    fi.renombrar(parameter);
                    System.out.println("Archivo renombrado a " + parameter);
                    break;
                case "eliminar":
                    fi.eliminar(parameter);
                    System.out.println("Archivo eliminado.");
                    break;
                default:
                    System.out.println("Operación no válida.");
            }
        } catch (Exception e) {
            System.err.println("FileServer exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
