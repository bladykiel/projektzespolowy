package app;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
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
import javax.swing.border.EtchedBorder;


public class Logowanie {
	public Logowanie(){
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Point punkcik = new Point(screenSize.width/2-140,50);
		new Logowanie(punkcik);
	}
	public Logowanie(Point punkt) {
	JFrame LogowanieFrame = new JFrame("Logowanie");
	LogowanieFrame.setResizable(false);
	LogowanieFrame.setLayout(null);
	LogowanieFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	LogowanieFrame.setSize(280, 500);
	LogowanieFrame.getContentPane().setBackground(new Color(50,88,145));
	LogowanieFrame.setLocation(punkt);
	
	ImageIcon logo = null;
    try {
    	logo = new ImageIcon(getClass().getResource("/img/logo.png"));
    	
    } catch (Exception e) {
        System.err.println("load error: " + e.getMessage());
    }
	JLabel LogoL = new JLabel(logo);
	LogoL.setBounds(LogowanieFrame.getWidth()/2-50, 10, 100, 100);
	
	Font myFont = new Font("Serif", Font.BOLD | Font.BOLD, 16);
	JLabel zalogujInfo = new JLabel("Zaloguj siê");
	zalogujInfo.setBounds(25, 5, 100, 25);
	zalogujInfo.setFont(myFont);
	
	JPanel panel = new JPanel();
	panel.setBounds(10, 140, LogowanieFrame.getWidth()-25,200);
	panel.setBackground(new Color(220,220,220));
	panel.setLayout(null);
	panel.setBorder(new EtchedBorder(EtchedBorder.RAISED));
	
	//panel.setBorder(setBorder(new BevelBorder(BevelBorder.LOWERED)););
	
	myFont = new Font("Serif", Font.BOLD | Font.BOLD, 10);
	//JTextField - login
	JLabel loginL = new JLabel("Nazwa uzytkownika");
	loginL.setBounds(15, 40, 200, 25);
	loginL.setFont(myFont);
	JLabel hasloL = new JLabel("Haslo uzytkownika");
	hasloL.setBounds(15, 95, 200, 25);
	hasloL.setFont(myFont);
	JTextField login = new JTextField();
	login.setBounds(15, 60, panel.getWidth()-30, 25);
	login.setBorder(new RoundedCornerBorder());
	
	JPasswordField passwordField = new JPasswordField();
	passwordField.setBounds(15, 115, panel.getWidth()-30, 25);
	passwordField.setBorder(new RoundedCornerBorder());
	//butto zaloguj
	JButton zalogujB = new JButton("zaloguj");
	zalogujB.setBounds(15, 160, 100, 25);
	zalogujB.setBorder(new RoundedCornerBorder());
	zalogujB.setBackground(new Color(50,88,145));
	zalogujB.setForeground(new Color(220,220,220));
	zalogujB.setFocusPainted(false);
	JButton rejestracjaB = new JButton("Zarejestruj siê!");
	rejestracjaB.setBounds(125, 370, 120, 25);
	rejestracjaB.setBorder(new RoundedCornerBorder());
	rejestracjaB.setForeground(new Color(50,88,145));
	rejestracjaB.setBackground(new Color(220,220,220));
	rejestracjaB.setFocusPainted(false);
	JLabel brakKonta = new JLabel("Nie masz konta?");
	brakKonta.setBounds(15,370,200,25);
	brakKonta.setForeground(new Color(220,220,220));
	//dodanie komponentów do LogowanieFrame
	LogowanieFrame.add(brakKonta);
	LogowanieFrame.add(panel);
	LogowanieFrame.add(LogoL);
	LogowanieFrame.add(rejestracjaB);
	panel.add(passwordField);
	panel.add(zalogujB);
	panel.add(login);
	panel.add(loginL);
	panel.add(hasloL);
	panel.add(zalogujInfo);
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

		 
	/*	 String url = "jdbc:mysql://127.0.0.1:3306/projektzespolowy";
	      String user = "root";
	      String password = "njymjmbnnmbn";
	      char[] jkjasd = { 'a', 'd', 'm', 'i', 'n'};
			  password="";
			  for (int i = 0; i < jkjasd.length; i++) {
		    	  password= password+jkjasd[i];
		      }	*/	
		 String url = "jdbc:mysql://www.db4free.net:3306/projektzespolowy";
	      String user = "projektzespolowy";
	      String password = "njymjmbnnmbn";
	      char[] jkjasd = { 'p', 'r', 'o', 'j', 'e','k','t'};
			  password="";
			  for (int i = 0; i < jkjasd.length; i++) {
		    	  password= password+jkjasd[i];
		      }	
		try{				
		Connection con = DriverManager.getConnection(url, user, password);
		 
		 
	    Statement loginST = con.createStatement();
	  
	    loginST.execute("USE projektzespolowy");
	    ResultSet daneLogowanie = loginST.executeQuery("SELECT * FROM users WHERE name = '"+login.getText()+"'");
			
	    if(!daneLogowanie.next()){
	    	JOptionPane.showMessageDialog(LogowanieFrame, "B³êdna nazwa u¿ytkonika lub haslo.");
	    }
	   else{
	    	do{
		    	if(daneLogowanie.getString("password").equals(new BigInteger(1,m.digest()).toString(16)) && 
		    	daneLogowanie.getString("name").equals(login.getText()))
		    	{
		    		if(daneLogowanie.getInt("access")==777){ //jesli w bazie uzytkownik ma 777 acces zaladuj admina
		    			if(daneLogowanie.getBoolean("banned")==false){
		    			System.out.println("admin");
		    			new PanelAdmina(login.getText(),LogowanieFrame.getLocation());
		    			LogowanieFrame.dispose();
		    			}
		    			else{
		    				JOptionPane.showMessageDialog(LogowanieFrame, "Twoje konto jest zbanowane...");
		    			}
		    		}	
		    		if(daneLogowanie.getInt("access")==1){//pobranieUprawnienU.getInt("nr")){
		    			if(daneLogowanie.getBoolean("banned")==false){
		    		
		    			new PanelUzytkownika(login.getText());
		    			LogowanieFrame.dispose();
		    			}
		    			else{
		    				JOptionPane.showMessageDialog(LogowanieFrame, "Twoje konto jest zbanowane...");
		    			}
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
		new PanelRejestracja(LogowanieFrame.getLocation());
	}});
	
	//Dodanie wykonanie "zaloguj" po kliknieciu enter w passwordField i login
	passwordField.addActionListener(new ActionListener()
	{
	public void actionPerformed(ActionEvent arg0)
	{
		zalogujB.doClick();
	}});
	
	login.addActionListener(new ActionListener()
	{
	public void actionPerformed(ActionEvent arg0)
	{
		zalogujB.doClick();
	}});
	
	login.setText("admin");
	passwordField.setText("admin");
	}
	public static void main(String[] args) {
		new Logowanie();
	}	
}
