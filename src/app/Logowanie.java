package app;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

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
	
	passwordField.addKeyListener(new KeyAdapter() {
        public void keyReleased(KeyEvent e) {
        	if(passwordField.getText().length()>25){
        		passwordField.setText(passwordField.getText().substring(0, 25));
 		}
        }

        public void keyTyped(KeyEvent e) {
            // TODO: Do something for the keyTyped event
        }

        public void keyPressed(KeyEvent e) {
            // TODO: Do something for the keyPressed event
        }
    });
	
	login.addKeyListener(new KeyAdapter() {
        public void keyReleased(KeyEvent e) {
        	if(login.getText().length()>25){
        		login.setText(login.getText().substring(0, 25));
 		}
        }

        public void keyTyped(KeyEvent e) {
            // TODO: Do something for the keyTyped event
        }

        public void keyPressed(KeyEvent e) {
            // TODO: Do something for the keyPressed event
        }
    });
	
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

		 
		 String url = "jdbc:mysql://127.0.0.1:3306/projektzespolowy" + 
				 "?useUnicode=true&characterEncoding=utf8";
	      String user = "root";
	      String password = "njymjmbnnmbn";
	      char[] jkjasd = { 'a', 'd', 'm', 'i', 'n'};
			  password="";
			  for (int i = 0; i < jkjasd.length; i++) {
		    	  password= password+jkjasd[i];
		      }	
		/* String url = "jdbc:mysql://www.db4free.net:3306/projektzespolowy";
	      String user = "projektzespolowy";
	      String password = "njymjmbnnmbn";
	      char[] jkjasd = { 'p', 'r', 'o', 'j', 'e','k','t'};
			  password="";
			  for (int i = 0; i < jkjasd.length; i++) {
		    	  password= password+jkjasd[i];
		      }	*/
		try{				
		Connection con = DriverManager.getConnection(url, user, "");
		 
		 
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
		    			//--------------------
		    			
		    			Connection con2 = DriverManager.getConnection(url, user, "");
		    			 
		    			 
		    		    Statement loginST2 = con.createStatement();
		    		  JPasswordField noweHaslo = new JPasswordField();
		    		  JPasswordField noweHaslo2 = new JPasswordField();
		    		    loginST2.execute("USE projektzespolowy");
		    		    ResultSet daneLogowanie2 = loginST2.executeQuery("SELECT zmianahasla FROM users WHERE name = '"+login.getText()+"'");
		    				while(daneLogowanie2.next()){
		    					
		    					Date today=new Date();
		    					
		    					 Date myDate=new Date(today.getYear(),today.getMonth()-1,today.getDay());
		    					 
		    					if(daneLogowanie2.getDate("zmianaHasla").before(myDate)){
		    						System.out.print("stare haslo");
		    						 JPanel myPanel = new JPanel();
			    				      myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.PAGE_AXIS));
			    				      myPanel.add(new JLabel("Podaj nowe has³o:"));
			    				      myPanel.add(noweHaslo);
			    				      myPanel.add(Box.createVerticalStrut(5));
			    				      myPanel.add(new JLabel("Powtorz nowe haslo:"));
			    				      myPanel.add(noweHaslo2);
		    						
			    				      int result = JOptionPane.showConfirmDialog(LogowanieFrame, myPanel, 
			    				               "Dodanie przystanku", JOptionPane.OK_CANCEL_OPTION);
			    				    while (result == JOptionPane.OK_OPTION) {
			    				    	//---------------------------------------------------------------------------------------------------------------------------
			    				 
			    					if(noweHaslo.getText().equals(noweHaslo2.getText())){
			    						int count=0;
			    						int uppercase=0;
			    						char ch;
			    						int liczbaZnakow;
			    						liczbaZnakow=noweHaslo.getText().length();
			    						if(liczbaZnakow<=20 && liczbaZnakow>=7){
			    							for (int i = 0, len = noweHaslo.getText().length(); i < len; i++) {
			    							    if (Character.isDigit(noweHaslo.getText().charAt(i))) {
			    							        count++;
			    							    }
			    							}
			    							System.out.print(count);
			    							if(count>=1){
			    								 for(int i=0;i<noweHaslo.getText().length();i++)
			    							        {
			    							            ch = noweHaslo.getText().charAt(i);
			    							            int asciivalue = (int)ch;
			    							            if(asciivalue >=65 && asciivalue <=90){
			    							                uppercase++;
			    							            }
			    							        }
			    								 if(uppercase>=1){
			    									 
			    									 String input2 = noweHaslo.getText();
			    									 MessageDigest m2=null;
			    									try {
			    										m2 = MessageDigest.getInstance("MD5");
			    									} catch (NoSuchAlgorithmException e) {
			    										e.printStackTrace();
			    									}
			    									 m2.update(input2.getBytes(),0,input2.length());
			    									// System.out.println("MD51 "+new BigInteger(1,m.digest()).toString(16));

			    									String url2 = "jdbc:mysql://127.0.0.1:3306/projektzespolowy";
			    								      String user2 = "root";
			    								      String password2 = "njymjmbnnmbn";
			    								      char[] jkjasd2 = { 'a', 'd', 'm', 'i', 'n'};
			    										  password2="";
			    										  for (int i = 0; i < jkjasd2.length; i++) {
			    									    	  password2= password2+jkjasd2[i];
			    									      }		
			    									/* String url = "jdbc:mysql://www.db4free.net:3306/projektzespolowy";
			    								      String user = "projektzespolowy";
			    								      String password = "njymjmbnnmbn";
			    								      char[] jkjasd = { 'p', 'r', 'o', 'j', 'e','k','t'};
			    										  password="";
			    										  for (int i = 0; i < jkjasd.length; i++) {
			    									    	  password= password+jkjasd[i];
			    									      }	*/
			    									try{				
			    									Connection con3 = DriverManager.getConnection(url2, user2, "");
			    								    Statement loginST3 = con.createStatement();

			    								    loginST3.execute("USE projektzespolowy");
			    								    
			    								    		
			    								    //-------------------
			    									
			    					    			SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");					
			    								    Connection con4 = DriverManager.getConnection(url2, user2, "");
						    						Statement loginST4 = con.createStatement();		
			    							     	 String updateTableSQL = "UPDATE users SET password='"+new BigInteger(1,m2.digest()).toString(16)+"',zmianahasla='"+ft.format(today)+"' WHERE name='"+login.getText()+"'	";
			    							     	loginST4.execute(updateTableSQL);
			    							     	//new PanelAdmina(login.getText(),LogowanieFrame.getLocation());
			    		    		    			//LogowanieFrame.dispose();
			    							     
			    							     	JOptionPane.showMessageDialog(LogowanieFrame, "Zmiana hasla pomyslna! Mozesz sie zalogowac nowym haslem!.");
			    								
			    							     	Connection conn = DriverManager.getConnection(url, user, ""); 
			    								    Statement operacje = conn.createStatement();
			    								    operacje.execute("USE projektzespolowy");
			    								    String operacjeSQL = "INSERT INTO operacje (kod,opis) VALUES ('"+1+"','"+"Pomyslna zmiana hasla dla "+login.getText()+"')";
			    								    operacje.execute(operacjeSQL);
			    											
			    							     	result=1;
			    							     	//------------------------
			    								  
			    								    	
			    								    	
			    								    
			    								    loginST3.close();
			    									}
			    									catch(Exception e){
			    										System.out.println(e);
			    									}
			    							
			    										
			    										
			    									 
			    									 
			    									 
			    								 }
			    								 else{
			    									 JOptionPane.showMessageDialog(LogowanieFrame, "Haslo musi posiadac minimum 1 wielka litere.");
			    									 Connection conn = DriverManager.getConnection(url, user, ""); 
				    								    Statement operacje = conn.createStatement();
				    								    operacje.execute("USE projektzespolowy");
				    								    String operacjeSQL = "INSERT INTO operacje (kod,opis) VALUES ('"+2+"','"+"Niepomyslna zmiana hasla dla "+login.getText()+"')";
				    								    operacje.execute(operacjeSQL);
			    								 break;
			    								 }
			    							}
			    							else{
			    								JOptionPane.showMessageDialog(LogowanieFrame, "Haslo musi posiadac minimum 1 cyfry.");
			    								 Connection conn = DriverManager.getConnection(url, user, ""); 
			    								    Statement operacje = conn.createStatement();
			    								    operacje.execute("USE projektzespolowy");
			    								    String operacjeSQL = "INSERT INTO operacje (kod,opis) VALUES ('"+3+"','"+"Niepomyslna zmiana hasla dla "+login.getText()+"')";
			    								    operacje.execute(operacjeSQL);
			    						break;
			    							}
			    						}
			    						else{
			    							JOptionPane.showMessageDialog(LogowanieFrame, "Haslo musi skladac sie z min. 8 znakow i max. z 25 znakow.");
			    							 Connection conn = DriverManager.getConnection(url, user, ""); 
		    								    Statement operacje = conn.createStatement();
		    								    operacje.execute("USE projektzespolowy");
		    								    String operacjeSQL = "INSERT INTO operacje (kod,opis) VALUES ('"+4+"','"+"Niepomyslna zmiana hasla dla "+login.getText()+"')";
		    								    operacje.execute(operacjeSQL);
			    						break;
			    						}
			    						
			    						}
			    						else
			    						{
			    							JOptionPane.showMessageDialog(LogowanieFrame, "Wpisano rozne hasla!");
			    							 Connection conn = DriverManager.getConnection(url, user, ""); 
		    								    Statement operacje = conn.createStatement();
		    								    operacje.execute("USE projektzespolowy");
		    								    String operacjeSQL = "INSERT INTO operacje (kod,opis) VALUES ('"+5+"','"+"Niepomyslna zmiana hasla dla "+login.getText()+"')";
		    								    operacje.execute(operacjeSQL);
			    						break;
			    						}
			    					
			    				    	
			    				    	
			    				    	
			    				    	
			    				    	
			    				    //-------------------------------------------------------------------------------------------------------------------------	
			    				    	
			    				    }
		    						
		    				}
		    					else{
		    						new PanelAdmina(login.getText(),LogowanieFrame.getLocation());
		    		    			LogowanieFrame.dispose();
		    		    			 Connection conn = DriverManager.getConnection(url, user, ""); 
 								    Statement operacje = conn.createStatement();
 								    operacje.execute("USE projektzespolowy");
 								    String operacjeSQL = "INSERT INTO operacje (kod,opis) VALUES ('"+1+"','"+"Pomyslnie zalogowano "+login.getText()+"')";
 								    operacje.execute(operacjeSQL);
		    					}
		    				}
		    				loginST2.close();
		    			
		    			
		    			
		    			
		    			
		    			
		    			
		    			
		    			//-------------------
		    			
		    			}
		    			else{
		    				JOptionPane.showMessageDialog(LogowanieFrame, "Twoje konto jest zbanowane...");
		    				 Connection conn = DriverManager.getConnection(url, user, ""); 
							    Statement operacje = conn.createStatement();
							    operacje.execute("USE projektzespolowy");
							    String operacjeSQL = "INSERT INTO operacje (kod,opis) VALUES ('"+6+"','"+"Proba zalogowania sie na konto zbanowane "+login.getText()+"')";
							    operacje.execute(operacjeSQL);
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
   				 Connection conn = DriverManager.getConnection(url, user, ""); 
					    Statement operacje = conn.createStatement();
					    operacje.execute("USE projektzespolowy");
					    String operacjeSQL = "INSERT INTO operacje (kod,opis) VALUES ('"+7+"','"+"Bledne dane logowania dla uzytkownika "+login.getText()+"')";
					    operacje.execute(operacjeSQL);
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
	passwordField.setText("asdasd123Q");
	}
	public static void main(String[] args) {
		new Logowanie();
	}	
}
