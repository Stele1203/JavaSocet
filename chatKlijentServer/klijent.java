import java.net.*;
import java.io.*;
import java.util.*;

public class ChatKlijent {

    public static void main(String[] args) {
        try (Socket s = new Socket("localhost", 5000);
             InputStream is = s.getInputStream();
             InputStreamReader isr = new InputStreamReader(is);
             BufferedReader br = new BufferedReader(isr);
             OutputStream os = s.getOutputStream();
             OutputStreamWriter osw = new OutputStreamWriter(os);
             PrintWriter pw = new PrintWriter(osw, true);
             FileOutputStream fos = new FileOutputStream("klijent.txt", true);
             Scanner skener = new Scanner(System.in)) {

            while (true) {
                System.out.println("Unesi poruku za server (ili 'exit' za izlaz):");
                String poruka = skener.nextLine();

                if (poruka.equalsIgnoreCase("exit")) {
                    pw.println(poruka);
                    break;
                }

                pw.println(poruka);

                String odgovor = br.readLine();
                System.out.println("Poruka od servera: " + odgovor);
                fos.write((odgovor + System.lineSeparator()).getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
