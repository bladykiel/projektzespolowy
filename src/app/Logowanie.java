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
import javax.swing.*;


public class Logowanie {
	public Logowanie() {
	JFrame LogowanieFrame = new JFrame("Logowanie");
	LogowanieFrame.setResizable(false);
	LogowanieFrame.setLayout(null);
	LogowanieFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	LogowanieFrame.setSize(280, 320);
	//JTextField - login
	JLabel loginL = new JLabel("Nazwa uzytkownika");
	loginL.setBounds(80, 50, 200, 25);
	JLabel hasloL = new JLabel("Haslo uzytkownika");
	hasloL.setBounds(80, 125, 200, 25);
	JTextField login = new JTextField();
	login.setBounds(80, 75, 100, 25);
	JPasswordField passwordField = new JPasswordField();
	passwordField.setBounds(80, 150, 100, 25);
	//butto zaloguj
	JButton zalogujB = new JButton("zaloguj");
	zalogujB.setBounds(30, 200, 100, 50);
	
	JButton rejestracjaB = new JButton("Zarejestruj siê!");
	rejestracjaB.setBounds(160, 200, 100, 50);
	//dodanie komponentów do LogowanieFrame
	LogowanieFrame.add(rejestracjaB);
	LogowanieFrame.add(passwordField);
	LogowanieFrame.add(zalogujB);
	LogowanieFrame.add(login);
	LogowanieFrame.add(loginL);
	LogowanieFrame.add(hasloL);
	LogowanieFrame.setVisible(true);
	
	//FUNKCJONALNOSC NR 1 - LOGOWANIE
	zalogujB.addActionListener(new ActionListener()
	{

	public void actionPerformed(ActionEvent arg0)
	{
		
		@SuppressWarnings("deprecation")
		String input =passwordField.getText();
		 MessageDigest m=null;
		try {
			m = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		 m.update(input.getBytes(),0,input.length());
		 //System.out.println("MD51 "+new BigInteger(1,m.digest()).toString(16));
		//-------------
	
		 
		 
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
	    ResultSet daneLogowanie = loginST.executeQuery("SELECT * FROM users WHERE name = '"+login.getText()+"'");
			
	    if(!daneLogowanie.next()){
	    	JOptionPane.showMessageDialog(LogowanieFrame, "B³êdna nazwa u¿ytkonika lub haslo.");
	    }
	     
	   else{
	    /*	if(!daneLogowanie.getString("password").equals(new String(new BigInteger(1,m.digest()).toString(16)))){
	    		JOptionPane.showMessageDialog(LogowanieFrame, "B³êdna nazwa u¿ytkonika lub haslo.");
	    	}*/
	    	do{
		    	if(daneLogowanie.getString("password").equals(new BigInteger(1,m.digest()).toString(16)) && 
		    	daneLogowanie.getString("name").equals(login.getText()))
		    	{//----------
		    	
		    		//-------------
		    		if(daneLogowanie.getInt("access")==777){
		    			System.out.println("admin");
		    			new PanelAdmina();
		    			LogowanieFrame.dispose();
		    		}
		    		
		    		if(daneLogowanie.getInt("access")==1){//pobranieUprawnienU.getInt("nr")){
		    			System.out.println("uzytkownik");
		    		
		    			new PanelUzytkownika(login.getText());
		    			LogowanieFrame.dispose();
		    		}
				}
		    	else{
		    		JOptionPane.showMessageDialog(LogowanieFrame, "B³êdna nazwa u¿ytkonika lub haslo.");
		    	}	
	    	} while (daneLogowanie.next());
	    }
	    loginST.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	
	}});
	rejestracjaB.addActionListener(new ActionListener()
	{
	public void actionPerformed(ActionEvent arg0)
	{
		//FUNKCJONALNOSC NR 3 - dodawanie trasy 
		LogowanieFrame.dispose();
		new PanelRejestracja();

	}});

	
	
	
	
	}
	
	public static void main(String[] args) {
		new Logowanie();
	}

	

	

}
