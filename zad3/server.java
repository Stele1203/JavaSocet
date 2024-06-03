import java.util.*;
import java.io.*;
import java.net.*;

public class PalindromServer {

    public static boolean isPalindrome(String str) {
        str = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        try (ServerSocket ss = new ServerSocket(5006);
             Socket s = ss.accept();
             InputStream is = s.getInputStream();
             InputStreamReader isr = new InputStreamReader(is);
             BufferedReader br = new BufferedReader(isr);
             OutputStream os = s.getOutputStream();
             OutputStreamWriter osw = new OutputStreamWriter(os);
             PrintWriter out = new PrintWriter(osw, true)) {

            String palindrom = br.readLine();
            String rez;

            if (isPalindrome(palindrom)) {
                rez = "Da";
            } else {
                rez = "NE";
            }

            out.println(rez);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
