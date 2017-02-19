package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader; 
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter; 
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke; 
import utils.Random_Number_Gen;

public class Remove_Password_UI extends JDialog implements ActionListener{

	private Random_Number_Gen Pass; 
	private static final long serialVersionUID = 1L;
	private JTextField username; 
	private final String path = "info.txt";

	public Remove_Password_UI(JFrame parent, String title) {
		super(parent, title); 
		
        Pass = new Random_Number_Gen();
         
		Point p = new Point(900, 300);
		setLocation(p.x, p.y);
		
		JPanel panel = new JPanel(){
		    @Override
		    public Dimension getPreferredSize() {
		        return new Dimension(250, 60);
		    };
		};
		
		panel.setLayout(null);
 
		JLabel user_label = new JLabel("Username:");  
		JButton button = new JButton("Remove");
		
	    username = new JTextField(); 
	    
	    username.setBounds(20,25,130,20);  
	    
	    button.setBounds(160,25, 80, 20);
		
	    user_label.setLocation(20,5); 
	    user_label.setSize(100,20); 
  
 
		
		panel.add(user_label); 
		panel.add(username); 
		panel.add(button);
		 
		button.addActionListener(this);
		getContentPane().add(panel, BorderLayout.PAGE_END);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		pack();
		setVisible(true);
	}
 
	public JRootPane createRootPane() {
		JRootPane rootPane = new JRootPane();
		KeyStroke stroke = KeyStroke.getKeyStroke("ESCAPE");
		Action action = new AbstractAction() {
			
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		};
		InputMap inputMap = rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		inputMap.put(stroke, "ESCAPE");
		rootPane.getActionMap().put("ESCAPE", action);
		return rootPane;
	}
  
	public void actionPerformed(ActionEvent e) { 
		removeLineFromFile(username.getText());
		username.setText("");
	}
	
 
	 
	public void removeLineFromFile(String lineToRemove) {

	    try {

	      File inFile = new File(path);

	      if (!inFile.isFile()) {
	        System.out.println("Parameter is not an existing file");
	        return;
	      }
 
	      File tempFile = new File(inFile.getAbsolutePath() + ".tmp");

	      BufferedReader br = new BufferedReader(new FileReader(path));
	      PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

	      String line = null;
 
	      while ((line = br.readLine()) != null) {

	        if (!line.trim().contains(lineToRemove)) {

	          pw.println(line);
	          pw.flush();
	        }
	      }
	      pw.close();
	      br.close();

	      //Delete the original file
	      if (!inFile.delete()) {
	        System.out.println("Could not delete file");
	        return;
	      }
 
	      if (!tempFile.renameTo(inFile))
	        System.out.println("Could not rename file");

	    }
	    catch (FileNotFoundException ex) {
	      ex.printStackTrace();
	    }
	    catch (IOException ex) {
	      ex.printStackTrace();
	    }
	  }
 
}