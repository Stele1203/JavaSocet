import java.net.*;
import java.io.*;

public class TransferServer {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try (ServerSocket ss = new ServerSocket(5000)) {
            System.out.println("Server is listening on port 5000...");
            Socket s = ss.accept();
            System.out.println("Client connected.");

            InputStream is = s.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String imeFajla = br.readLine();

            File file = new File(imeFajla);
            OutputStream os = s.getOutputStream();
            PrintWriter pw = new PrintWriter(os, true);

            if (file.exists() && !file.isDirectory()) {
                pw.println("File found");

                try (FileInputStream fis = new FileInputStream(file);
                     BufferedOutputStream bos = new BufferedOutputStream(os)) {

                    int b;
                    while ((b = fis.read()) != -1) {
                        bos.write(b);
                    }

                    System.out.println("Fajl uspešno prebačen");
                    bos.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                pw.println("File not found");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
