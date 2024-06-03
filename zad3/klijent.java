import java.net.*;
import java.io.*;
import java.util.*;

public class PalindromKlijent {

    public static void main(String[] args) {
        try (Socket s = new Socket("localhost", 5006);
             OutputStream os = s.getOutputStream();
             OutputStreamWriter osw = new OutputStreamWriter(os);
             PrintWriter out = new PrintWriter(osw, true);
             InputStream is = s.getInputStream();
             InputStreamReader isr = new InputStreamReader(is);
             BufferedReader br = new BufferedReader(isr);
             Scanner skener = new Scanner(System.in)) {

            System.out.println("Unesite string:");
            String string = skener.nextLine();
            out.println(string);

            String rez = br.readLine();
            System.out.println(rez);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
