import java.rmi.*;

public class HelloServer {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Uso: HelloServer <ip>");
            return;
        }

        try {
            HelloInterface hello = new Hello("Hello, world!");
            String serverIP = args[0];
            Naming.rebind("//" + serverIP + "/Hello", hello);
            System.out.println("Hello Server is ready.");
        } catch (Exception e) {
            System.out.println("Hello Server failed: " + e);
        }
    }
}
