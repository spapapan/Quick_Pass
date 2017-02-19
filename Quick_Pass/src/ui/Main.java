package ui;
 
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException; 
import javax.swing.JFrame; 
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException; 
import utils.GlobalKeyListener;

public class Main{
		
	public static void main(String[] args) 
	{
		new Main();
	}
 
	public Main(){

		
	    if(!SystemTray.isSupported()){
	        System.out.println("System tray is not supported !!! ");
	        return ;
	    }
	    
	    Catch_Hotkeys();
	    Create_DB();

	    SystemTray systemTray = SystemTray.getSystemTray();

	    Image image = Toolkit.getDefaultToolkit().getImage("images/icon.png");

	    PopupMenu trayPopupMenu = new PopupMenu();

	    //1nd menuitem of popupmenu
	    MenuItem action = new MenuItem("Add Password");
	    action.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	new AddPassword_UI(new JFrame(), "Create new password"); 
	        }
	    });     
	    trayPopupMenu.add(action);
	    
	    //2nd menuitem of popupmenu
	    MenuItem export = new MenuItem("Export Passwords");
	    export.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) { 
	            new Export_Passwords();
	        }
	    });
	    trayPopupMenu.add(export);

	    //3nd menuitem of popupmenu
	    MenuItem close = new MenuItem("Exit");
	    close.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            System.exit(0);             
	        }
	    });
	    trayPopupMenu.add(close);

	    //setting tray icon
	    TrayIcon trayIcon = new TrayIcon(image, "Quick Pass", trayPopupMenu); 
	    trayIcon.setImageAutoSize(true);

	    try{
	        systemTray.add(trayIcon);
	    }catch(AWTException awtException){
	        awtException.printStackTrace();
	    }
	     

	}  
	
	private void Create_DB()
	{ 
		try 
		{
		  File file = new File("info.txt");
		  file.createNewFile();
	    } 
		catch (IOException e) 
		{
		   e.printStackTrace();
	    }
	}
	
	private void Catch_Hotkeys()
	{  
	       try {
	            GlobalScreen.registerNativeHook();
	        }
	        catch (NativeHookException ex) {
	            System.err.println("There was a problem registering the native hook.");
	            System.err.println(ex.getMessage());

	            System.exit(1);
	        }

	        GlobalScreen.addNativeKeyListener(new GlobalKeyListener());  
	}
 
}