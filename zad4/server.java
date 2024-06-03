import java.net.*;
import java.io.*;


public class VelikaSlovaServer {
	
	public static String convertAtoa(String s) {
        char[] a = s.toCharArray();

        for (int i = 0; i < a.length; i++) {
            if (Character.isLetter(a[i]) && Character.isLowerCase(a[i])) {
                a[i] = Character.toUpperCase(a[i]);
            }
        }

        return new String(a);
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try(ServerSocket ss = new ServerSocket(5555)){
			
			Socket s = ss.accept();
			
			InputStream is = s.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			OutputStream os = s.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			PrintWriter pw = new PrintWriter(osw,true);
			
			String text = br.readLine();
			
			String novi= convertAtoa(text);
			
			pw.println(novi);
			
			
			
			
		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
}
