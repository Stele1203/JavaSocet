import java.net.*;
import java.io.*;
import java.util.*;

public class ChatServer {

    public static void main(String[] args) {
        try (ServerSocket ss = new ServerSocket(5000);
             Socket s = ss.accept();
             OutputStream os = s.getOutputStream();
             OutputStreamWriter osw = new OutputStreamWriter(os);
             PrintWriter pw = new PrintWriter(osw, true);
             FileOutputStream fos = new FileOutputStream("server.txt", true);
             InputStream is = s.getInputStream();
             InputStreamReader isr = new InputStreamReader(is);
             BufferedReader br = new BufferedReader(isr);
             Scanner skener = new Scanner(System.in)) {

            System.out.println("Čeka se klijent...");

            while (true) {
                String klijentPoruka = br.readLine();
                if (klijentPoruka.equalsIgnoreCase("exit")) {
                    break;
                }

                System.out.println("Poruka od klijenta: " + klijentPoruka);
                fos.write((klijentPoruka + System.lineSeparator()).getBytes());

                System.out.println("Unesi poruku za klijenta (ili 'exit' za izlaz):");
                String poruka = skener.nextLine();

                if (poruka.equalsIgnoreCase("exit")) {
                    pw.println(poruka);
                    break;
                }

                pw.println(poruka);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
