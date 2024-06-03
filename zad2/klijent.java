import java.util.*;
import java.net.*;
import java.io.*;

public class KalkulatorKlijent {

    public static void main(String[] args) {
        try (Socket s = new Socket("localhost", 5000);
             OutputStream os = s.getOutputStream();
             OutputStreamWriter osw = new OutputStreamWriter(os);
             PrintWriter out = new PrintWriter(osw, true);
             InputStream is = s.getInputStream();
             InputStreamReader isr = new InputStreamReader(is);
             BufferedReader br = new BufferedReader(isr);
             Scanner skener = new Scanner(System.in);
             FileWriter fr = new FileWriter("Rez.txt", true)) {

            System.out.println("Unesi znak operacija:");
            String operacija = skener.nextLine();
            System.out.println("Unesi broj 1:");
            int br1 = skener.nextInt();
            System.out.println("Unesi broj 2:");
            int br2 = skener.nextInt();

            out.println(operacija);
            out.println(br1);
            out.println(br2);

            String rez = br.readLine();
            System.out.println(rez);

            fr.write(rez + System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
