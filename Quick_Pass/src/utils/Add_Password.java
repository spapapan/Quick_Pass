/*
 * 
 *  Save username - password combination to 
 *  local storage so it can be accessed in 
 *  the future. 
 *   
 * 
 */


package utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter; 
  
public class Add_Password {
	 
	private String password;
	private String username;
	private final String path = "info.txt";

	public Add_Password(String user, String pass) {
		this.password = pass;
		this.username = user; 
		Encrypt_Password();
		Save_Password();
	} 
	 
	private void Save_Password()
	{
		 PrintWriter pw = null;

		  try {
		     File file = new File(path);
		     FileWriter fw = new FileWriter(file, true);
		     pw = new PrintWriter(fw);
		     pw.println(username + " " + password);
		  } catch (IOException e) {
		     e.printStackTrace();
		  } finally {
		     if (pw != null) {
		        pw.close();
		     }
		  }
	}
	
	private void Encrypt_Password()
	{
		password = Encryption.Encrypt(password);
	}
 
}
