package app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class WyszukajPolaczenie {
    int iloscPaneli=0;
    int wysokosc=5;
    int idSprawdzane=0;
	WyszukajPolaczenie(){
		JFrame WyszukajPolaczenieFrame = new JFrame("Nowa trasa");
		WyszukajPolaczenieFrame.setSize(500, 500);
		WyszukajPolaczenieFrame.setLocationRelativeTo(null);
		WyszukajPolaczenieFrame.setVisible(true);
		WyszukajPolaczenieFrame.setLayout(null);
		WyszukajPolaczenieFrame.getContentPane().setBackground(new Color(50,88,145));
		WyszukajPolaczenieFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		((JComponent) WyszukajPolaczenieFrame.getContentPane()).setBorder(new EmptyBorder(10, 10, 10, 10));
		
	//	WyszukajPolaczenieFrame.setLayout(new BorderLayout());
		
		UtilDateModel model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
		 
		frame.add(datePicker);
		
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(370,10));
	    JScrollPane scroll = new JScrollPane(panel);
	    scroll.setBounds(25, 175, 400, 250);
	    WyszukajPolaczenieFrame.add(scroll);
	    scroll.setVerticalScrollBarPolicy(
	    		   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
	    JButton button = new JButton("lol");
	    button.setBounds(10, 10, 100, 25);
	    WyszukajPolaczenieFrame.add(button);

	    
	        WyszukajPolaczenieFrame.setVisible(true);

	        JTextField wyszukajSkad = new JTextField();
	        wyszukajSkad.setBounds(120, 5, 120, 25);
	        WyszukajPolaczenieFrame.add(wyszukajSkad);
	        
	        JTextField wyszukajDokad = new JTextField();
	        wyszukajDokad.setBounds(260, 5, 120, 25);
	        WyszukajPolaczenieFrame.add(wyszukajDokad);
	        
	        wyszukajSkad.setText("Ko³obrzeg");
	        wyszukajDokad.setText("Szczecinek");
	        Map<String, JLabel> skadL = new HashMap<>();
	        Map<String, JLabel> dokadL = new HashMap<>();
	        Map<String, JLabel> godzinaOdjazduL = new HashMap<>();
	        Map<String, JLabel> godzinaPrzyjazduL = new HashMap<>();
	        Map<String, JLabel> typL = new HashMap<>();
	        Map<String, JLabel> czasL = new HashMap<>();
	        Map<String, JPanel> danePanel = new HashMap<>();
	        button.addActionListener(new ActionListener()
			{
			public void actionPerformed(ActionEvent arg0)
			{
				skadL.clear();
				dokadL.clear();
				godzinaOdjazduL.clear();
				godzinaPrzyjazduL.clear();
				typL.clear();
				czasL.clear();
				danePanel.clear();
				panel.removeAll();
				panel.setPreferredSize(new Dimension(370,10));
			     iloscPaneli=0;
			     wysokosc=5;
				 String url = "jdbc:mysql://127.0.0.1:3306/projektzespolowy" + 
						 "?useUnicode=true&characterEncoding=utf8";;
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
				Connection con2 = DriverManager.getConnection(url, user, "");
			    Statement loginST = con.createStatement();
			    loginST.execute("USE projektzespolowy");
			    ResultSet wyszukajSkadSQL = loginST.executeQuery("SELECT * FROM routes WHERE route_start = '"+wyszukajSkad.getText()+"'");
			
				   while (wyszukajSkadSQL.next()){
					   idSprawdzane=wyszukajSkadSQL.getInt("route_id");
					   Statement sprawdzeniePrzystankow = con2.createStatement();
					   sprawdzeniePrzystankow.execute("USE projektzespolowy");
					    ResultSet przystanki = sprawdzeniePrzystankow.executeQuery("SELECT * FROM routes_stops WHERE name = '"+wyszukajDokad.getText()+"'"
					    		+ " and route_id='"+idSprawdzane+"'");
						   while (przystanki.next()){
					
							    danePanel.put("panel"+iloscPaneli,new JPanel());
								danePanel.get("panel"+iloscPaneli).setBounds(5, wysokosc, panel.getPreferredSize().width, 55);
								danePanel.get("panel"+iloscPaneli).setBackground(new Color(50,88,145));
								danePanel.get("panel"+iloscPaneli).setPreferredSize(new Dimension(panel.getPreferredSize().width,150));
								danePanel.get("panel"+iloscPaneli).setLayout(null);
							
								skadL.put("skadL"+iloscPaneli,new JLabel());
								skadL.get("skadL"+iloscPaneli).setText(""+wyszukajSkadSQL.getString("route_start"));
								skadL.get("skadL"+iloscPaneli).setBounds(5, 5, 100, 25);
								skadL.get("skadL"+iloscPaneli).setForeground(Color.white);
								danePanel.get("panel"+iloscPaneli).add(skadL.get("skadL"+iloscPaneli));	
								
								dokadL.put("dokadL"+iloscPaneli,new JLabel());
								dokadL.get("dokadL"+iloscPaneli).setText(przystanki.getString("name"));
								dokadL.get("dokadL"+iloscPaneli).setBounds(5, 25, 100, 25);
								dokadL.get("dokadL"+iloscPaneli).setForeground(Color.white);
								danePanel.get("panel"+iloscPaneli).add(dokadL.get("dokadL"+iloscPaneli));
								
								godzinaOdjazduL.put("godzinaOdjazduL"+iloscPaneli,new JLabel());
								godzinaOdjazduL.get("godzinaOdjazduL"+iloscPaneli).setText(wyszukajSkadSQL.getString("time_start"));
								godzinaOdjazduL.get("godzinaOdjazduL"+iloscPaneli).setBounds(105, 5, 100, 25);
								godzinaOdjazduL.get("godzinaOdjazduL"+iloscPaneli).setForeground(Color.white);
								danePanel.get("panel"+iloscPaneli).add(godzinaOdjazduL.get("godzinaOdjazduL"+iloscPaneli));
								
								godzinaPrzyjazduL.put("godzinaPrzyjazduL"+iloscPaneli,new JLabel());
								//do zmiany
								godzinaPrzyjazduL.get("godzinaPrzyjazduL"+iloscPaneli).setText(przystanki.getString("stop_time"));
								godzinaPrzyjazduL.get("godzinaPrzyjazduL"+iloscPaneli).setBounds(105,25, 100, 25);
								godzinaPrzyjazduL.get("godzinaPrzyjazduL"+iloscPaneli).setForeground(Color.white);
								danePanel.get("panel"+iloscPaneli).add(godzinaPrzyjazduL.get("godzinaPrzyjazduL"+iloscPaneli));

								czasL.put("czasL"+iloscPaneli,new JLabel());
								czasL.get("czasL"+iloscPaneli).setText(przystanki.getString("stop_time"));
								czasL.get("czasL"+iloscPaneli).setBounds(205,15, 100, 25);
								czasL.get("czasL"+iloscPaneli).setForeground(Color.white);
								danePanel.get("panel"+iloscPaneli).add(czasL.get("czasL"+iloscPaneli));
								
								typL.put("typL"+iloscPaneli,new JLabel());
								typL.get("typL"+iloscPaneli).setText("pociag");
								typL.get("typL"+iloscPaneli).setBounds(305,15, 100, 25);
								typL.get("typL"+iloscPaneli).setForeground(Color.white);
								danePanel.get("panel"+iloscPaneli).add(typL.get("typL"+iloscPaneli));
							   
								panel.setPreferredSize(new Dimension(panel.getPreferredSize().width,panel.getPreferredSize().height+55));
								panel.add(danePanel.get("panel"+iloscPaneli));
								iloscPaneli++;
								wysokosc+=60;
							   
						   }
						    sprawdzeniePrzystankow.close();
				   }
			    
			    loginST.close();
			    
				}
				catch(Exception e){
					System.out.println(e);
				}
				
				
				
				
				panel.revalidate();
				panel.repaint();
			}});
	}
}
