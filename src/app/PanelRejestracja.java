package app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class PanelRejestracja {
	PanelRejestracja(){
		JFrame RejestracjaFrame = new JFrame("Rejestracja");
		RejestracjaFrame.setLayout(null);
		RejestracjaFrame.setResizable(false);
		RejestracjaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		RejestracjaFrame.setSize(400, 400);
		
		JLabel loginL = new JLabel("Podaj nazwe");
		loginL.setBounds(60, 60, 100, 25);
		JTextField login = new JTextField();
		login.setBounds(60, 100, 100, 25);
		
		JLabel hasloL = new JLabel("Podaj haslo");
		hasloL.setBounds(200, 60, 100, 25);
		JPasswordField haslo = new JPasswordField();
		haslo.setBounds(200, 100, 100, 25);
		
		JButton zarejestrujB = new JButton("Zarejestruj");
		zarejestrujB.setBounds(100, 200, 100, 25);
		
		JButton wrocB = new JButton("Powrot");
		wrocB.setBounds(100, 250, 100, 25);

		
		

		
		zarejestrujB.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent arg0)
		{
		     
			 
			@SuppressWarnings("deprecation")
			String input = haslo.getText();
			 MessageDigest m=null;
			try {
				m = MessageDigest.getInstance("MD5");
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			 m.update(input.getBytes(),0,input.length());
			// System.out.println("MD51 "+new BigInteger(1,m.digest()).toString(16));

			String url = "jdbc:mysql://127.0.0.1:3306/projektzespolowy";
		      String user = "root";
		      String password = "njymjmbnnmbn";
		      char[] jkjasd = { 'a', 'd', 'm', 'i', 'n'};
				  password="";
				  for (int i = 0; i < jkjasd.length; i++) {
			    	  password= password+jkjasd[i];
			      }		
			try{				
			Connection con = DriverManager.getConnection(url, user, "");
		    Statement loginST = con.createStatement();

		    loginST.execute("USE projektzespolowy");
		    
		    ResultSet sprawdzenieLoginu = loginST.executeQuery("SELECT name FROM users WHERE name = '"+login.getText()+"'");
		    if(sprawdzenieLoginu.next()){
		    	JOptionPane.showMessageDialog(RejestracjaFrame, "Nazwa uzytkownika zajêta!.");
		    }
		    else{
	     	 String updateTableSQL = " INSERT INTO users"
	    				+ " (name, password, access)"
	    				+ " VALUES('"+login.getText()+"','"+new BigInteger(1,m.digest()).toString(16)+"',1)";
	     	loginST.execute(updateTableSQL);
	     	new Logowanie();
	     	RejestracjaFrame.dispose();
		    }
		    loginST.close();
			}
			catch(Exception e){
				System.out.println(e);
			}
			
		}});
		
		wrocB.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent arg0)
		{
			new Logowanie();
			RejestracjaFrame.dispose();
		}});
		RejestracjaFrame.add(wrocB);
		RejestracjaFrame.add(zarejestrujB);
		RejestracjaFrame.add(login);
		RejestracjaFrame.add(haslo);
		RejestracjaFrame.add(loginL);
		RejestracjaFrame.add(hasloL);
		RejestracjaFrame.setVisible(true);
	}
	
	

	
}
