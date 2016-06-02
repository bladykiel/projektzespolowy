package app;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

public class ZarzadzajUzytkownikami {

    Map<String, JLabel> nazwaU = new HashMap<>();
    Map<String, JButton> banB = new HashMap<>();
    Map<String, JButton> nazwaB = new HashMap<>();
    JPanel panelTrasa = new JPanel();
    JTextField wyszukajU = new JTextField();
	ZarzadzajUzytkownikami(){
		JFrame frameSzczegoly = new JFrame("Zarzadzaj u¿ytkownik");
	       frameSzczegoly.setSize(500, 450);
	       frameSzczegoly.setLocationRelativeTo(null);
	       frameSzczegoly.getContentPane().setBackground(new Color(50,88,145));
	       ((JComponent) frameSzczegoly.getContentPane()).setBorder(new EmptyBorder(10, 10, 10, 10));
	       frameSzczegoly.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	      
	       JPanel panel = new JPanel();
	       panel.setBorder(new EtchedBorder(EtchedBorder.RAISED));
	       panel.setLayout(null);
	       frameSzczegoly.getContentPane().add(panel);
	       frameSzczegoly.setVisible(true);
	       

	       wyszukajU.setBounds(1, 1, 1150, 30);
	       panel.add(wyszukajU);
	       
	       
	       wyszukajU.addKeyListener(new KeyAdapter() {
	           public void keyReleased(KeyEvent e) {
	           	odswiezWyszukiwanie();
	           }

	           public void keyTyped(KeyEvent e) {
	               // TODO: Do something for the keyTyped event
	           }

	           public void keyPressed(KeyEvent e) {
	               // TODO: Do something for the keyPressed event
	           }
	       });

	       panelTrasa.setLayout(null);
	       panelTrasa.setPreferredSize(new Dimension(150,10));
	       panelTrasa.setBackground(new Color(50,88,145));
	       JScrollPane scroll = new JScrollPane(panelTrasa);
	       scroll.setBounds(30, 170, 400, 200);
	       scroll.setVerticalScrollBarPolicy(
	                  JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	  
	       panel.add(scroll);
	       
	       odswiezWyszukiwanie();
	     /*  int nr= 0;
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
                      Statement szczegolyUsers = con.createStatement();
                      szczegolyUsers.execute("USE projektzespolowy");
                      ResultSet info = szczegolyUsers.executeQuery("SELECT * FROM users");
                      while (info.next()){
                    	 
                    	 nazwaU.put("nazwaU"+nr,new JLabel());
                    	 nazwaU.get("nazwaU"+nr).setText(info.getString("name"));
                    	 nazwaU.get("nazwaU"+nr).setBounds(5, nr*25+1, 100, 25);
                    	 nazwaU.get("nazwaU"+nr).setForeground(Color.white);
                          panelTrasa.add(nazwaU.get("nazwaU"+nr)); 
                    	 
                          banB.put("banB"+nr, new JButton()); 
                          if(info.getInt("banned")==1){
                        	 banB.get("banB"+nr).setText("Odbanuj");
                          }
                          else{
                        	 banB.get("banB"+nr).setText("Zbanuj"); 
                          }
                          banB.get("banB"+nr).setBounds(105, nr*25+1, 100, 25);
                          panelTrasa.add(banB.get("banB"+nr));
                          nr++;
                    	 
                    	 
                      }
                      info.close();
                  }
                  catch(Exception e){
                      System.out.println(e);
                  }  */
	             
	}
	public void odswiezWyszukiwanie(){
		int nr= 0;
		panelTrasa.removeAll();
		nazwaU.clear();
		banB.clear();
		 
	       String url = "jdbc:mysql://www.db4free.net:3306/projektzespolowy";
	         String user = "projektzespolowy";
	         String password = "njymjmbnnmbn";
	         char[] jkjasd = { 'p', 'r', 'o', 'j', 'e','k','t'};
	             password="";
	             for (int i = 0; i < jkjasd.length; i++) {
	                 password= password+jkjasd[i];
	             }
	             
	            /* String url = "jdbc:mysql://127.0.0.1:3306/projektzespolowy" + 
	    				 "?useUnicode=true&characterEncoding=utf8";;
	    	      String user = "root";
	    	      String password = "njymjmbnnmbn";
	    	      char[] jkjasd = { 'a', 'd', 'm', 'i', 'n'};
	    			  password="";
	    			  for (int i = 0; i < jkjasd.length; i++) {
	    		    	  password= password+jkjasd[i];
	    		      }	   */ 
	             
	             
	             
	             try{               
                   Connection con = DriverManager.getConnection(url, user, password);       
                   Statement szczegolyUsers = con.createStatement();
                   szczegolyUsers.execute("USE projektzespolowy");
                   ResultSet info = szczegolyUsers.executeQuery("SELECT * FROM users");
                   while (info.next()){
                 	 if(info.getString("name").contains(wyszukajU.getText())){
                 		 System.out.println(info.getString("name"));
                 	 nazwaU.put("nazwaU"+nr,new JLabel());
                 	 nazwaU.get("nazwaU"+nr).setText(info.getString("name"));
                 	 nazwaU.get("nazwaU"+nr).setBounds(5, nr*25+1, 100, 25);
                 	 nazwaU.get("nazwaU"+nr).setForeground(Color.white);
                       panelTrasa.add(nazwaU.get("nazwaU"+nr)); 
                 	 
                       banB.put("banB"+nr, new JButton()); 
                       if(info.getInt("banned")==1){
                     	 banB.get("banB"+nr).setText("Odbanuj");
                       }
                       else{
                     	 banB.get("banB"+nr).setText("Zbanuj"); 
                       }
                       banB.get("banB"+nr).setBounds(105, nr*25+1, 100, 25);
                       panelTrasa.add(banB.get("banB"+nr));
                       int nrr = nr;
                       banB.get("banB"+nr).addActionListener(new ActionListener()
              			{
                    	 
              			public void actionPerformed(ActionEvent arg0)
              			{
              			 if(banB.get("banB"+nrr).getText()=="Zbanuj"){
              				banB.get("banB"+nrr).setText("Odbanuj");
              				System.out.print(nazwaU.get("nazwaU"+nrr).getText());
              			  try{   
              				String password = "njymjmbnnmbn";
              		      char[] jkjasd = { 'a', 'd', 'm', 'i', 'n'};
              				  password="";
              				  for (int i = 0; i < jkjasd.length; i++) {
              			    	  password= password+jkjasd[i];
              			      }	
              				Connection con3 = DriverManager.getConnection(url, user, password); 
						    Statement loginST = con3.createStatement();
						    loginST.execute("USE projektzespolowy");
						   String updateTableSQL = "UPDATE users SET banned='1' WHERE name='"+nazwaU.get("nazwaU"+nrr).getText()+"'";
						   loginST.execute(updateTableSQL);
              			  }
              			  catch(Exception e){
              				  
              			  }
              			 }
              			 else{
              				banB.get("banB"+nrr).setText("Zbanuj");
              			  try{   
              				String password = "njymjmbnnmbn";
              		      char[] jkjasd = { 'a', 'd', 'm', 'i', 'n'};
              				  password="";
              				  for (int i = 0; i < jkjasd.length; i++) {
              			    	  password= password+jkjasd[i];
              			      }	
                				Connection con3 = DriverManager.getConnection(url, user, password); 
  						    Statement loginST = con3.createStatement();
  						    loginST.execute("USE projektzespolowy");
  						   String updateTableSQL = "UPDATE users SET banned='0' WHERE name='"+nazwaU.get("nazwaU"+nrr).getText()+"'";
  						   loginST.execute(updateTableSQL);
                			  }
                			  catch(Exception e){
                				  
                			  }
              			 }
              			}});
                       
                       
                       
                       nr++;
                   
                 	 }
                   }
                   info.close();
                   panelTrasa.repaint();
               }
               catch(Exception e){
                   System.out.println(e);
               }  
	}
}