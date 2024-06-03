import java.net.*;
import java.io.*;
import java.util.*;


public class VelikaSlovaKlijent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try(Socket s = new Socket("localhost",5555)){
			OutputStream os = s.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			PrintWriter pw = new PrintWriter(osw,true);
			
			InputStream is = s.getInputStream();
			InputStreamReader isr= new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			Scanner skener = new Scanner(System.in);
			
			System.out.println("Unesi string: ");
			String string= skener.nextLine();
			
			pw.println(string);
			
			String novi = br.readLine();
			
			System.out.println("Resenje je "+novi);
			
		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
