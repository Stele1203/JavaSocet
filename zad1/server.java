import java.net.*;
import java.io.*;

public class EnkripcijaServer {
    
    public static String sifruj(String s) {
        char[] array = s.toCharArray();

        for (int i = 0; i < array.length; i++) {
            char c = array[i];
            if (Character.isLetter(c)) {
                if (Character.isLowerCase(c)) {
                    if (c + 3 > 'z') {
                        c = (char) (c + 3 - 26);
                    } else {
                        c = (char) (c + 3);
                    }
                } else if (Character.isUpperCase(c)) {
                    if (c + 3 > 'Z') {
                        c = (char) (c + 3 - 26);
                    } else {
                        c = (char) (c + 3);
                    }
                }
                array[i] = c;
            }
        }

        return new String(array);
    }

    public static void main(String[] args) {
        try (ServerSocket ss = new ServerSocket(5050);
             Socket s = ss.accept();
             InputStream is = s.getInputStream();
             InputStreamReader isr = new InputStreamReader(is);
             BufferedReader br = new BufferedReader(isr);
             OutputStream os = s.getOutputStream();
             OutputStreamWriter osw = new OutputStreamWriter(os);
             PrintWriter pw = new PrintWriter(osw, true)) {
            
            String rijec = br.readLine();
            String nova = sifruj(rijec);
            pw.println(nova);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
