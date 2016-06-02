package app;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Font;
import javax.swing.Icon;

public class PanelRejestracja {
	int liczbaZnakowspecjalnych;
	int liczbaZnakow;
	PanelRejestracja(Point punkt){
		JFrame RejestracjaFrame = new JFrame("Rejestracja");
		//RejestracjaFrame.setLayout(null);
		RejestracjaFrame.setResizable(false);
		RejestracjaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		RejestracjaFrame.setSize(280, 400);
		RejestracjaFrame.setLocation(punkt);
		RejestracjaFrame.getContentPane().setBackground(new Color(50,88,145));
		((JComponent) RejestracjaFrame.getContentPane()).setBorder(new EmptyBorder(10, 10, 10, 10));
		
		JPanel panelRejestracja = new JPanel();
		panelRejestracja.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		panelRejestracja.setLayout(null);
		
		
		
		
		JLabel loginL = new JLabel("Podaj nazwe");
		loginL.setFont(new Font("Tahoma", Font.PLAIN, 9));
		loginL.setBounds(43, 58, 100, 25);
		JTextField login = new JTextField();
		login.setBounds(20, 84, 100, 25);
		login.setBorder(new RoundedCornerBorder());
		
		JLabel hasloL = new JLabel("Podaj haslo");
		hasloL.setFont(new Font("Tahoma", Font.PLAIN, 9));
		hasloL.setBounds(43, 120, 100, 25);
		JPasswordField haslo = new JPasswordField();
		haslo.setBounds(20, 156, 100, 25);
		haslo.setBorder(new RoundedCornerBorder());
		
		JLabel hasloL2 = new JLabel("Powtorz haslo");
		hasloL2.setFont(new Font("Tahoma", Font.PLAIN, 9));
		hasloL2.setBounds(164, 120, 100, 25);
		JPasswordField haslo2 = new JPasswordField();
		haslo2.setBounds(139, 156, 100, 25);
		haslo2.setBorder(new RoundedCornerBorder());
		
		JButton zarejestrujB = new JButton("Zarejestruj");
		zarejestrujB.setBounds(20, 237, 100, 25);
		zarejestrujB.setBorder(new RoundedCornerBorder());
		zarejestrujB.setFocusPainted(false);
		zarejestrujB.setBackground(new Color(50,88,145));
		zarejestrujB.setForeground(new Color(220,220,220));
		
		JButton wrocB = new JButton("Powrot");
		wrocB.setBounds(139, 237, 100, 25);
		wrocB.setBorder(new RoundedCornerBorder());
		wrocB.setFocusPainted(false);
		wrocB.setBackground(new Color(50,88,145));
		wrocB.setForeground(new Color(220,220,220));
		zarejestrujB.addActionListener(new ActionListener()
		{
		@SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent arg0)
		{
			String url = "jdbc:mysql://127.0.0.1:3306/projektzespolowy";
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
	if(haslo.getText().equals(haslo2.getText())){
		int count=0;
		int uppercase=0;
		char ch;
		liczbaZnakow=haslo.getText().length();
		if(liczbaZnakow<=20 && liczbaZnakow>=7){
			for (int i = 0, len = haslo.getText().length(); i < len; i++) {
			    if (Character.isDigit(haslo.getText().charAt(i))) {
			        count++;
			    }
			}
			System.out.print(count);
			if(count>=1){
				 for(int i=0;i<haslo.getText().length();i++)
			        {
			            ch = haslo.getText().charAt(i);
			            int asciivalue = (int)ch;
			            if(asciivalue >=65 && asciivalue <=90){
			                uppercase++;
			            }
			        }
				 if(uppercase>=1){
					 
					 String input = haslo.getText();
					 MessageDigest m=null;
					try {
						m = MessageDigest.getInstance("MD5");
					} catch (NoSuchAlgorithmException e) {
						e.printStackTrace();
					}
					 m.update(input.getBytes(),0,input.length());
					// System.out.println("MD51 "+new BigInteger(1,m.digest()).toString(16));

					
					try{				
					Connection con = DriverManager.getConnection(url, user, "");
				    Statement loginST = con.createStatement();

				    loginST.execute("USE projektzespolowy");
				    
				    ResultSet sprawdzenieLoginu = loginST.executeQuery("SELECT name FROM users WHERE name = '"+login.getText()+"'");
				    if(sprawdzenieLoginu.next()){
				    	JOptionPane.showMessageDialog(RejestracjaFrame, "Nazwa uzytkownika zajêta!.");
				    }
				    else{
				    	if(login.getText().length()>=6 && login.getText().length()<=25){
				    		int znaki=0;
				    		
				    		for (int i = 0, len = login.getText().length(); i < len; i++) {
							    if (Character.isDigit(login.getText().charAt(i))) {
							        znaki++;
							    }
							    if (Character.isUpperCase(login.getText().charAt(i))) znaki++;
							    if (Character.isLowerCase(login.getText().charAt(i))) znaki++;

							}
				    		if(znaki==login.getText().length()){
				    			
				    //-------------------
				    			Date today=new Date();
				    			SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
			     	 String updateTableSQL = " INSERT INTO users"
			    				+ " (name, password, access, zmianahasla)"
			    				+ " VALUES('"+login.getText()+"','"+new BigInteger(1,m.digest()).toString(16)+"',1,'"+ft.format(today)+"')";
			     	loginST.execute(updateTableSQL);
			     	new Logowanie(RejestracjaFrame.getLocation());
			     	RejestracjaFrame.dispose();
	   				 Connection conn = DriverManager.getConnection(url, user, ""); 
					    Statement operacje = conn.createStatement();
					    operacje.execute("USE projektzespolowy");
					    String operacjeSQL = "INSERT INTO operacje (kod,opis) VALUES ('"+8+"','"+"Pomyslna rejestracja uzytkownika "+login.getText()+"')";
					    operacje.execute(operacjeSQL);
			     	//------------------------
				    	}
				    		else{
				    			JOptionPane.showMessageDialog(RejestracjaFrame, "Nazwa uzytkownika nie moze zawierac znakow specjalnych (np. ?,! itp).");
				   				 Connection conn = DriverManager.getConnection(url, user, ""); 
								    Statement operacje = conn.createStatement();
								    operacje.execute("USE projektzespolowy");
								    String operacjeSQL = "INSERT INTO operacje (kod,opis) VALUES ('"+9+"','"+"Bledne nazwa uzytkownika "+login.getText()+"')";
								    operacje.execute(operacjeSQL);
				    		}
				    	}
				    	else{
				    		JOptionPane.showMessageDialog(RejestracjaFrame, "Nazwa uzytkownika musi skladac sie z min. 6 znakow i max. z 25 znakow.");
			   				 Connection conn = DriverManager.getConnection(url, user, ""); 
							    Statement operacje = conn.createStatement();
							    operacje.execute("USE projektzespolowy");
							    String operacjeSQL = "INSERT INTO operacje (kod,opis) VALUES ('"+10+"','"+"Bledne dlugosc loginu "+login.getText()+"')";
							    operacje.execute(operacjeSQL);
				    	}
				    }
				    loginST.close();
					}
					catch(Exception e){
						System.out.println(e);
					}
			
						
						
					 
					 
					 
				 }
				 else{
					 JOptionPane.showMessageDialog(RejestracjaFrame, "Haslo musi posiadac minimum 1 wielka litere.");
					 try{
					 Connection conn = DriverManager.getConnection(url, user, ""); 
					    Statement operacje = conn.createStatement();
					    operacje.execute("USE projektzespolowy");
					    String operacjeSQL = "INSERT INTO operacje (kod,opis) VALUES ('"+11+"','"+"Bledne haslo przy rejestracji "+login.getText()+"')";
					 
					 
					    operacje.execute(operacjeSQL);
					 }
					 catch(Exception e){
						 
					 }
				 }
			}
			else{
				JOptionPane.showMessageDialog(RejestracjaFrame, "Haslo musi posiadac minimum 1 cyfry.");
				 try{
					 Connection conn = DriverManager.getConnection(url, user, ""); 
					    Statement operacje = conn.createStatement();
					    operacje.execute("USE projektzespolowy");
					    String operacjeSQL = "INSERT INTO operacje (kod,opis) VALUES ('"+12+"','"+"Bledne haslo przy rejestracji "+login.getText()+"')";
					 
					 
					    operacje.execute(operacjeSQL);
					 }
					 catch(Exception e){
						 
					 }
				
			}
		}
		else{
			JOptionPane.showMessageDialog(RejestracjaFrame, "Haslo musi skladac sie z min. 8 znakow i max. z 25 znakow.");
			 try{
				 Connection conn = DriverManager.getConnection(url, user, ""); 
				    Statement operacje = conn.createStatement();
				    operacje.execute("USE projektzespolowy");
				    String operacjeSQL = "INSERT INTO operacje (kod,opis) VALUES ('"+13+"','"+"Bledne haslo przy rejestracji "+login.getText()+"')";
				 
				 
				    operacje.execute(operacjeSQL);
				 }
				 catch(Exception e){
					 
				 }
		}
		
		}
		else
		{
			JOptionPane.showMessageDialog(RejestracjaFrame, "Wpisano rozne hasla!");
			 try{
				 Connection conn = DriverManager.getConnection(url, user, ""); 
				    Statement operacje = conn.createStatement();
				    operacje.execute("USE projektzespolowy");
				    String operacjeSQL = "INSERT INTO operacje (kod,opis) VALUES ('"+14+"','"+"Bledne haslo przy rejestracji "+login.getText()+"')";
				 
				 
				    operacje.execute(operacjeSQL);
				 }
				 catch(Exception e){
					 
				 }
		}
		}});
		
		wrocB.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent arg0)
		{
			
			new Logowanie();
			RejestracjaFrame.dispose();
		}});
		
		
		panelRejestracja.add(wrocB);
		panelRejestracja.add(zarejestrujB);
		panelRejestracja.add(login);
		panelRejestracja.add(haslo);
		panelRejestracja.add(loginL);
		panelRejestracja.add(hasloL);
		panelRejestracja.add(hasloL2);
		panelRejestracja.add(haslo2);

		RejestracjaFrame.getContentPane().add(panelRejestracja);
		RejestracjaFrame.setVisible(true);
	}
}
