/*
 *   Retrieve the password given the username. 
 *   If the username doesn't exist a new 
 *   password is created and saved.
 *   Also the new password is placed in 
 *   the clipboard.
 *   
 */


package utils;

import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap; 

public class Get_Pass {

	private final String path = "info.txt";
	private HashMap<String,String> passlist;
	private Random_Number_Gen Random_Pass;
	
	public Get_Pass() 
	{
		passlist = new HashMap<String,String>();
		get_Pass();
		GET();
	}
	
	public void GET()
	{
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		String clip = get_clipboard_text(); 
		clip = clip.replace(" ","");
		
		if (!passlist.containsKey(clip)) 
		{
			generate_pass(clip);
		}
		 
		String password = passlist.get(clip); 
		StringSelection selection = new StringSelection(password);
		 
        clipboard.setContents(selection, selection);
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	private void import_pass(String line)
	{
		if (!line.equals(""))
		{
			String[] parts = line.split("\\ ");
			passlist.put(parts[0], parts[1]);
		}
	}
	
	private void generate_pass(String username)
	{
		Random_Pass = new Random_Number_Gen();
		new Add_Password(username,Random_Pass.get());
		get_Pass();
		GET();
	}    
	
	private String get_clipboard_text()
	{
		String clip = null;
	    try {
		    clip = (String) Toolkit.getDefaultToolkit()
		          .getSystemClipboard().getData(DataFlavor.stringFlavor);
	    } catch (HeadlessException e) {
		    // TODO Auto-generated catch block  
		    e.printStackTrace();
	    } catch (UnsupportedFlavorException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
	    } catch (IOException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
	    } 
	    return clip;
	}

} 
