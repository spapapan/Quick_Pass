/*
 * 
 *  Listen to global keywords without the need of focus
 * 
 */


package utils;

 
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger; 
import org.jnativehook.GlobalScreen; 
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class GlobalKeyListener implements NativeKeyListener {
	
	private LinkedList<String> list;
	
	public GlobalKeyListener()
	{
		list = new LinkedList<String>();
		list.add("A");
		list.add("A");
		list.add("A");
		Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
		logger.setLevel(Level.OFF); 
		logger.setUseParentHandlers(false);
	}
    public void nativeKeyPressed(NativeKeyEvent e) {
        list.add(NativeKeyEvent.getKeyText(e.getKeyCode()));
        list.removeFirst();
        if (list.get(0).equals("Ctrl") && list.get(1).equals("C") && list.get(2).equals("Shift"))
        { 
             new Get_Pass();
        }  
    }
 
    public void nativeKeyReleased(NativeKeyEvent e) {
       
    }

    public void nativeKeyTyped(NativeKeyEvent e) {
       
    }

     
}
