/*
 *  User interface to add new password
 */


package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import utils.Add_Password;
import utils.Random_Number_Gen;
 

public class AddPassword_UI extends JDialog implements ActionListener{

	private Random_Number_Gen Pass;
	private String passgen;
	private static final long serialVersionUID = 1L;
	private JTextField username;
	private JTextField password;

	public AddPassword_UI(JFrame parent, String title) {
		super(parent, title); 
		
        Pass = new Random_Number_Gen();
         
		Point p = new Point(900, 300);
		setLocation(p.x, p.y);
		
		JPanel panel = new JPanel(){
		    @Override
		    public Dimension getPreferredSize() {
		        return new Dimension(450, 60);
		    };
		};
		
		panel.setLayout(null);
 
		JLabel user_label = new JLabel("Username"); 
		JLabel pass_label = new JLabel("Password"); 
		JButton button = new JButton("Add");
		
	    username = new JTextField();
	    password = new JTextField(); 
	    
	    username.setBounds(20,25,100,20); 
	    password.setBounds(140,25,180,20); 
	    
	    button.setBounds(340,25, 100, 20);
		
	    user_label.setLocation(20,5);
	    pass_label.setLocation(140,5);
	    user_label.setSize(100,20);
	    pass_label.setSize(100,20); 
 
		password.setText(Pass.get()); 
 
		
		panel.add(user_label);
		panel.add(pass_label);
		panel.add(username);
		panel.add(password);
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
		new Add_Password(username.getText(),password.getText());
		Pass = new Random_Number_Gen();
	    password.setText(Pass.get()); 
		username.setText("");
	}
	 
 
}
