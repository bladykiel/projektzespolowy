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

public class PanelRejestracja {
	PanelRejestracja(Point punkt){
		JFrame RejestracjaFrame = new JFrame("Rejestracja");
		//RejestracjaFrame.setLayout(null);
		RejestracjaFrame.setResizable(false);
		RejestracjaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		RejestracjaFrame.setSize(400, 400);
		RejestracjaFrame.setLocation(punkt);
		RejestracjaFrame.getContentPane().setBackground(new Color(50,88,145));
		((JComponent) RejestracjaFrame.getContentPane()).setBorder(new EmptyBorder(10, 10, 10, 10));
		
		JPanel panelRejestracja = new JPanel();
		panelRejestracja.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		panelRejestracja.setLayout(null);
		
		
		
		
		JLabel loginL = new JLabel("Podaj nazwe");
		loginL.setFont(new Font("Tahoma", Font.PLAIN, 9));
		loginL.setBounds(65, 39, 100, 25);
		JTextField login = new JTextField();
		login.setBounds(41, 60, 100, 25);
		login.setBorder(new RoundedCornerBorder());
		
		JLabel hasloL = new JLabel("Podaj haslo");
		hasloL.setFont(new Font("Tahoma", Font.PLAIN, 9));
		hasloL.setBounds(65, 96, 100, 25);
		JPasswordField haslo = new JPasswordField();
		haslo.setBounds(41, 117, 100, 25);
		haslo.setBorder(new RoundedCornerBorder());
		
		JLabel hasloL2 = new JLabel("Powtorz haslo");
		hasloL2.setFont(new Font("Tahoma", Font.PLAIN, 9));
		hasloL2.setBounds(65, 153, 100, 25);
		JPasswordField haslo2 = new JPasswordField();
		haslo2.setBounds(41, 176, 100, 25);
		haslo2.setBorder(new RoundedCornerBorder());
		
		JButton zarejestrujB = new JButton("Zarejestruj");
		zarejestrujB.setBounds(41, 237, 100, 25);
		zarejestrujB.setBorder(new RoundedCornerBorder());
		zarejestrujB.setFocusPainted(false);
		zarejestrujB.setBackground(new Color(50,88,145));
		zarejestrujB.setForeground(new Color(220,220,220));
		
		JButton wrocB = new JButton("Powrot");
		wrocB.setBounds(151, 237, 100, 25);
		wrocB.setBorder(new RoundedCornerBorder());
		wrocB.setFocusPainted(false);
		wrocB.setBackground(new Color(50,88,145));
		wrocB.setForeground(new Color(220,220,220));
		zarejestrujB.addActionListener(new ActionListener()
		{
		@SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent arg0)
		{
	if(haslo.getText().equals(haslo2.getText())){
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
		    
		    ResultSet sprawdzenieLoginu = loginST.executeQuery("SELECT name FROM users WHERE name = '"+login.getText()+"'");
		    if(sprawdzenieLoginu.next()){
		    	JOptionPane.showMessageDialog(RejestracjaFrame, "Nazwa uzytkownika zajêta!.");
		    }
		    else{
	     	 String updateTableSQL = " INSERT INTO users"
	    				+ " (name, password, access)"
	    				+ " VALUES('"+login.getText()+"','"+new BigInteger(1,m.digest()).toString(16)+"',1)";
	     	loginST.execute(updateTableSQL);
	     	new Logowanie(RejestracjaFrame.getLocation());
	     	RejestracjaFrame.dispose();
		    }
		    loginST.close();
			}
			catch(Exception e){
				System.out.println(e);
			}
	}
	else
	{
		JOptionPane.showMessageDialog(RejestracjaFrame, "Wpisano rozne hasla!.");
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
