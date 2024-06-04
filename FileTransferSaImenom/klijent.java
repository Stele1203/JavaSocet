import java.util.*;
import java.net.*;
import java.io.*;

public class TransferKlijent {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        try (Socket s = new Socket("localhost", 5000)) {
            OutputStream os = s.getOutputStream();
            PrintWriter pw = new PrintWriter(os, true);

            System.out.println("Unesi ime fajla sa ekstenzijom:");
            Scanner skener = new Scanner(System.in);
            String ime = skener.nextLine();

            pw.println(ime);

            InputStream is = s.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String serverResponse = br.readLine();
            if (serverResponse.equals("File not found")) {
                System.out.println("Fajl nije pronađen na serveru.");
            } else {
                try (FileOutputStream fos = new FileOutputStream("preuzeto_" + ime);
                     BufferedInputStream bis = new BufferedInputStream(is)) {

                    int b;
                    while ((b = bis.read()) != -1) {
                        fos.write(b);
                    }

                    System.out.println("Fajl uspešno preuzet kao: preuzeto_" + ime);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
