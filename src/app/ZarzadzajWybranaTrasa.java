package app;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

public class ZarzadzajWybranaTrasa {
	ZarzadzajWybranaTrasa(int idPolaczenia){
	       // System.out.println(idPolaczenia+" "+nr1Przystanku+" "+nr2Przystanku);
	       
	        JFrame frameSzczegoly = new JFrame("Szczegoly po³¹czenia");
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
	       
	        JButton opinie = new JButton("Poka¿ komentarze");
	        opinie.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent arg0) {
	        		new Komentarze(idPolaczenia);
	        	}
	        });
	        opinie.setBounds(229,28,150,25);
	        opinie.setBorder(new EmptyBorder(10, 10, 10, 10));
	        panel.add(opinie);
	        
	        
	        Map<String, JLabel> trasa = new HashMap<>();
	        Map<String, JLabel> godziny = new HashMap<>();
	        Map<String, JLabel> czas = new HashMap<>();
	        String czasStartu=null;
	        JPanel panelTrasa = new JPanel();
	        panelTrasa.setLayout(null);
	        panelTrasa.setPreferredSize(new Dimension(150,10));
	        //panelTrasa.setBounds(1, 1, 300, 250);
	        panelTrasa.setBackground(new Color(50,88,145));
	        JScrollPane scroll = new JScrollPane(panelTrasa);
	        scroll.setBounds(30, 170, 400, 200);
	        scroll.setVerticalScrollBarPolicy(
	                   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	   
	        panel.add(scroll);
	        int nr = 0;
			 String url = "jdbc:mysql://127.0.0.1:3306/projektzespolowy" + 
					 "?useUnicode=true&characterEncoding=utf8";;
		      String user = "root";
		      String password = "njymjmbnnmbn";
		      char[] jkjasd = { 'a', 'd', 'm', 'i', 'n'};
				  password="";
				  for (int i = 0; i < jkjasd.length; i++) {
			    	  password= password+jkjasd[i];
			      }	
	      /*   String url = "jdbc:mysql://www.db4free.net:3306/projektzespolowy";
	          String user = "projektzespolowy";
	          String password = "njymjmbnnmbn";
	          char[] jkjasd = { 'p', 'r', 'o', 'j', 'e','k','t'};
	              password="";
	              for (int i = 0; i < jkjasd.length; i++) {
	                  password= password+jkjasd[i];
	              }   */
				
			        
			        
			
				  
				    JPanel kursujePanel = new JPanel();
			        kursujePanel.setLayout(null);
			        kursujePanel.setBorder(BorderFactory.createTitledBorder("Kursuje w"));
			        kursujePanel.setBounds(25, 75, 410, 75);

			   
			           
			              JCheckBox pnCB = new JCheckBox("Poniedzia³ek");
			              pnCB.setBounds(5, 20, 97, 25);
			              pnCB.setFocusPainted(false);
			              pnCB.setEnabled(false);
			              kursujePanel.add(pnCB);
			             
			              JCheckBox wtCB = new JCheckBox("Wtorek");
			              wtCB.setBounds(pnCB.getLocation().x+pnCB.getWidth()+5, 20, 68, 25);
			              wtCB.setFocusPainted(false);
			              wtCB.setEnabled(false);
			              kursujePanel.add(wtCB);
			   
			              JCheckBox srCB = new JCheckBox("Œroda");
			              srCB.setBounds(wtCB.getLocation().x+wtCB.getWidth()+5, 20, 59, 25);
			              srCB.setFocusPainted(false);
			              srCB.setEnabled(false);
			              kursujePanel.add(srCB);
			           
			              JCheckBox czwCB = new JCheckBox("Czwartek");
			              czwCB.setBounds(srCB.getLocation().x+srCB.getWidth()+5, 20, 80, 25);
			              czwCB.setFocusPainted(false);
			              czwCB.setEnabled(false);
			              kursujePanel.add(czwCB);   
			             
			              JCheckBox ptCB = new JCheckBox("Pi¹tek");
			              ptCB.setBounds(czwCB.getLocation().x+czwCB.getWidth()+5, 20, 70, 25);
			              ptCB.setFocusPainted(false);
			              ptCB.setEnabled(false);
			              kursujePanel.add(ptCB);   
			             
			              JCheckBox sobCB = new JCheckBox("Sobota");
			              sobCB.setBounds(czwCB.getLocation().x, 45, 80, 25);
			              sobCB.setFocusPainted(false);
			              sobCB.setEnabled(false);
			              kursujePanel.add(sobCB);            
			             
			              JCheckBox niedzCB = new JCheckBox("Niedziela");
			              niedzCB.setBounds(ptCB.getLocation().x, 45, 78, 25);
			              niedzCB.setFocusPainted(false);
			              niedzCB.setEnabled(false);
			              kursujePanel.add(niedzCB);   
			              panel.add(kursujePanel);
			        try{               
			               Connection con = DriverManager.getConnection(url, user, "");       
			               Statement szczegolyTrasy = con.createStatement();
			               szczegolyTrasy.execute("USE projektzespolowy");
			               ResultSet info = szczegolyTrasy.executeQuery("SELECT * FROM routes WHERE route_id = '"+idPolaczenia+"'");
			               while (info.next()){
			                   if(info.getBoolean("pn")==true) pnCB.setSelected(true);
			                   if(info.getBoolean("wt")==true) wtCB.setSelected(true);
			                   if(info.getBoolean("sr")==true) srCB.setSelected(true);
			                   if(info.getBoolean("czw")==true) czwCB.setSelected(true);
			                   if(info.getBoolean("pt")==true) ptCB.setSelected(true);
			                   if(info.getBoolean("sob")==true) sobCB.setSelected(true);
			                   if(info.getBoolean("niedz")==true) niedzCB.setSelected(true);
			                   czasStartu=""+info.getTime("time_start");
			                   
			                   
			                   JButton zarzadzaj = new JButton();
			                   Boolean wyl;
			                   if(info.getBoolean("enable")==true){
			                	   zarzadzaj.setText("Zablokuj trase");
			                	   wyl=true;
			                   }
			                   else{
			                	   zarzadzaj.setText("Odblokuj trase");
			                	   wyl=false;
			                   }
			                   
			 				  zarzadzaj.addActionListener(new ActionListener() {
			 			        	public void actionPerformed(ActionEvent arg0) {
			 			        		 
											if(zarzadzaj.getText().contains("Zablokuj trase")){
												   zarzadzaj.setText("Odblokuj trase");
												 try{
									   				 Connection conn = DriverManager.getConnection(url, user, ""); 
														    Statement operacje = conn.createStatement();
														    operacje.execute("USE projektzespolowy");
														   // String operacjeSQL = "INSERT INTO operacje (kod,opis) VALUES ('"+7+"','"+"Bledne dane logowania dla uzytkownika "+login.getText()+"')";
														    String operacjeSQL = "UPDATE routes SET enable=0 WHERE route_id='"+idPolaczenia+"'";
														    operacje.execute(operacjeSQL);
														    System.out.println(idPolaczenia);
												 }
												 catch(Exception e){
													 
												 }
											   }
											   else{
												   zarzadzaj.setText("Zablokuj trase");
													 try{
										   				 Connection conn = DriverManager.getConnection(url, user, ""); 
															    Statement operacje = conn.createStatement();
															    operacje.execute("USE projektzespolowy");
															   // String operacjeSQL = "INSERT INTO operacje (kod,opis) VALUES ('"+7+"','"+"Bledne dane logowania dla uzytkownika "+login.getText()+"')";
															    String operacjeSQL = "UPDATE routes SET enable=1 WHERE route_id='"+idPolaczenia+"'";
															    operacje.execute(operacjeSQL);
															    System.out.println(idPolaczenia);
													 }
													 catch(Exception e){
														 
													 }
											   }
									
			 			        	}
			 			        });
			 				  zarzadzaj.setBounds(229,1,150,25);
			 			      panel.add(zarzadzaj);  
			                   
			                   
			              	 JLabel owner = new JLabel();
			    			 owner.setText("Trasa dodana przez: "+info.getString("owner"));
			    			 owner.setBounds(10, 10, 400, 25);
			    			 panel.add(owner);
			    			 
			              	 JLabel srodekLokomocji = new JLabel();
			              	srodekLokomocji.setText("Œrodek lokomocji: "+info.getString("type"));
			              	srodekLokomocji.setBounds(10, 45, 400, 25);
			    			 panel.add(srodekLokomocji);
			                }
			               info.close();
			                }
			                catch(Exception e){
			                    System.out.println(e);
			                }	  
				  
				  
				  try{               
	       Connection con = DriverManager.getConnection(url, user, "");       
	       Statement szczegolyTrasy = con.createStatement();
	       szczegolyTrasy.execute("USE projektzespolowy");
	       ResultSet info = szczegolyTrasy.executeQuery("SELECT * FROM routes_stops WHERE route_id = '"+idPolaczenia+"'");
	       while (info.next()){
	           System.out.println(info.getString("name"));
	         
	           trasa.put("trasa"+nr,new JLabel());
	           trasa.get("trasa"+nr).setText(info.getString("name"));
	           trasa.get("trasa"+nr).setBounds(5, nr*25+1, 100, 25);
	           trasa.get("trasa"+nr).setForeground(Color.white);
	           panelTrasa.add(trasa.get("trasa"+nr));
	 
	           godziny.put("godziny"+nr,new JLabel());
	           if(info.getInt("nr")==1){
	           godziny.get("godziny"+nr).setText(czasStartu);
	           }
	           else{
	        	   SimpleDateFormat timeFormat2 = new SimpleDateFormat("HH:mm:ss");
	        	   Date godzinaStart = timeFormat2.parse(czasStartu);
	        	   Date godzinaDodania = info.getTime("stop_time");	
					long sum3 = godzinaStart.getTime() + godzinaDodania.getTime()+3600000 ;
					godziny.get("godziny"+nr).setText(timeFormat2.format(new Date(sum3)));
				
	           }
	           godziny.get("godziny"+nr).setBounds(105, nr*25+1, 100, 25);
	           godziny.get("godziny"+nr).setForeground(Color.white);
	           panelTrasa.add(godziny.get("godziny"+nr));
	           
	       
	           czas.put("czas"+nr,new JLabel());
	           czas.get("czas"+nr).setText(info.getString("distance")+" km");
	           czas.get("czas"+nr).setBounds(210, nr*25+1, 100, 25);
	           czas.get("czas"+nr).setForeground(Color.white);
	           panelTrasa.add(czas.get("czas"+nr));
	  
	           
	           panelTrasa.setPreferredSize(new Dimension(panelTrasa.getPreferredSize().width,panelTrasa.getPreferredSize().height+25));
	           nr++;
	        }
	       info.close();
	        }
	        catch(Exception e){
	            System.out.println(e);
	        }
	       
	//route database
				  ImageIcon logo = null;
				    try {
				    	logo = new ImageIcon(getClass().getResource("/img/logom.png"));
				    	
				    } catch (Exception e) {
				        System.err.println("load error: " + e.getMessage());
				    }
					JLabel LogoL = new JLabel(logo);
					LogoL.setBounds(389, 11, 50, 50);
					panel.add(LogoL);

	    }
}
