/*
 *  Exports the decrypted usernames - passwords to a given location
 */

package ui;
 
import java.io.BufferedReader; 
import java.io.File;
import java.io.FileNotFoundException; 
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException; 
import java.io.PrintWriter; 
import java.util.HashMap; 
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import utils.Encryption; 

  public class Export_Passwords extends JFrame {
			
	 private final String path = "info.txt";
	 private HashMap<String,String> passlist;
	  
	 public Export_Passwords()
	 {
		 passlist = new HashMap<String,String>();
		 get_Pass();
		 getSaveLocation(); 
	 }
 
	 private void getSaveLocation() 
	 {
		JFileChooser chooser = new JFileChooser();
			    
		chooser.setSelectedFile(new File("passwords.txt"));
		int result = chooser.showSaveDialog(this);

		if (result == chooser.APPROVE_OPTION) 
		{  
		     writeOutput(chooser.getSelectedFile());
		}  
	  }
		  
	  public void writeOutput(File saveLocation)
	  { 
		  String location = saveLocation.getAbsolutePath(); 
		  File filepass = new File(location);
		  try 
		  {
			filepass.createNewFile();
		  } 
		  catch (IOException e1) 
		  { 
			e1.printStackTrace();
		  }
		  
			 PrintWriter pw = null;

			  try {
			     File file = new File(location);
			     FileWriter fw = new FileWriter(file, true);
			     pw = new PrintWriter(fw);
			     populate_pass(pw); 
			  } catch (IOException e) {
			     e.printStackTrace();
			  } finally {
			     if (pw != null) {
			        pw.close();
			     }
			  }
	    }
		 
		private void populate_pass(PrintWriter writer)
		{
			 for (String key : passlist.keySet())
			 {
				 writer.println(key + " " + passlist.get(key));
			 }
		}
		
		private void get_Pass()
		{
			try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			    String line;
			    try {
					while ((line = br.readLine()) != null) {
					   import_pass(line);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		private void import_pass(String line)
		{
			if (!line.equals(""))
			{
				String[] parts = line.split("\\ "); 
				String pass = Encryption.Decrypt(parts[1]);
				passlist.put(parts[0], pass);
			}
		}
}