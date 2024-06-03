import java.net.*;
import java.io.*;
import java.util.Scanner;

public class EnkripcijaKlijent {
    public static void main(String[] args) {
        try (Socket s = new Socket("localhost", 5050);
             OutputStream os = s.getOutputStream();
             OutputStreamWriter osw = new OutputStreamWriter(os);
             PrintWriter out = new PrintWriter(osw, true);
             InputStream is = s.getInputStream();
             InputStreamReader isr = new InputStreamReader(is);
             BufferedReader br = new BufferedReader(isr);
             Scanner unos = new Scanner(System.in)) {

            System.out.println("Unesi tekst: ");
            String tekst = unos.nextLine();

            out.println(tekst);

            String resenje = br.readLine();
            System.out.println("Šifra je: " + resenje);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
