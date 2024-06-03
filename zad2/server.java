import java.net.*;
import java.io.*;

public class KalkulatorServer {

    public static void main(String[] args) {
        try (ServerSocket ss = new ServerSocket(5000);
             Socket s = ss.accept();
             InputStream is = s.getInputStream();
             InputStreamReader isr = new InputStreamReader(is);
             BufferedReader br = new BufferedReader(isr);
             OutputStream os = s.getOutputStream();
             OutputStreamWriter osw = new OutputStreamWriter(os);
             PrintWriter out = new PrintWriter(osw, true)) {

            String op = br.readLine();
            int broj1 = Integer.parseInt(br.readLine());
            int broj2 = Integer.parseInt(br.readLine());

            int rez = 0;

            switch (op) {
                case "+":
                    rez = broj1 + broj2;
                    break;
                case "-":
                    rez = broj1 - broj2;
                    break;
                case "*":
                    rez = broj1 * broj2;
                    break;
                case "/":
                    if (broj2 != 0) {
                        rez = broj1 / broj2;
                    } else {
                        out.println("Error: Division by zero");
                        return;
                    }
                    break;
                default:
                    out.println("Error: Unknown operation");
                    return;
            }

            out.println(rez);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
