package app;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

public class ZarzadzanieTrasami {
	int iloscPaneli;
	int wysokosc;
	
	ZarzadzanieTrasami(){
		JFrame ZarzadzanieTrasamiFrame = new JFrame("Nowa trasa");
		ZarzadzanieTrasamiFrame.setSize(500, 650);
		ZarzadzanieTrasamiFrame.setLocationRelativeTo(null);
		ZarzadzanieTrasamiFrame.setVisible(true);
		ZarzadzanieTrasamiFrame.getContentPane().setBackground(new Color(50,88,145));
		ZarzadzanieTrasamiFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		((JComponent) ZarzadzanieTrasamiFrame.getContentPane()).setBorder(new EmptyBorder(10, 10, 10, 10));

		
		JPanel panelInformacje = new JPanel();
		panelInformacje.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		panelInformacje.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(370,10));
	    JScrollPane scroll = new JScrollPane(panel);
	    scroll.setBounds(25, 25, 400, 400);

	    scroll.setVerticalScrollBarPolicy(
	    		   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
		
		
		
		
	    panelInformacje.add(scroll);
		
		ZarzadzanieTrasamiFrame.add(panelInformacje);
		ZarzadzanieTrasamiFrame.setVisible(true);
		
        Map<String, JLabel> skadL = new HashMap<>();
        Map<String, JLabel> dokadL = new HashMap<>();
        Map<String, JLabel> zglosilL = new HashMap<>();
        Map<String, JLabel> godzinaOdjazduL = new HashMap<>();
        Map<String, JLabel> godzinaPrzyjazduL = new HashMap<>();
        Map<String, JLabel> typL = new HashMap<>();
        Map<String, JLabel> czasL = new HashMap<>();
        Map<String, JPanel> danePanel = new HashMap<>();
        Map<String, Integer> idSzczegoly = new HashMap<>();	
		 iloscPaneli=0;
		 wysokosc=5;
		 String timee1="00:00:00";	
			String datee =null;
		 
		 
		 
        String url = "jdbc:mysql://www.db4free.net:3306/projektzespolowy";
	    String user = "projektzespolowy";
	    String password = "njymjmbnnmbn";
	    char[] jkjasd = { 'p', 'r', 'o', 'j', 'e','k','t'};
	    password="";
		for (int i = 0; i < jkjasd.length; i++) {
		    	  password= password+jkjasd[i];
		      }	
	        /*  String url = "jdbc:mysql://127.0.0.1:3306/projektzespolowy" + 
		    				 "?useUnicode=true&characterEncoding=utf8";;
		    	      String user = "root";
		    	      String password = "njymjmbnnmbn";
		    	      char[] jkjasd = { 'a', 'd', 'm', 'i', 'n'};
		    			  password="";
		    			  for (int i = 0; i < jkjasd.length; i++) {
		    		    	  password= password+jkjasd[i];
		    		      }	  */
		try{				
		Connection con = DriverManager.getConnection(url, user, password);
		Connection con2 = DriverManager.getConnection(url, user, password);
		Connection con3 = DriverManager.getConnection(url, user, password);
		Connection con4 = DriverManager.getConnection(url, user, password);
		Connection con5 = DriverManager.getConnection(url, user, password);
		Statement nieaktywowanePolaczenia = con.createStatement();
		nieaktywowanePolaczenia.execute("USE projektzespolowy");
		    ResultSet nieaktywowanePolaczeniaSQL = nieaktywowanePolaczenia.executeQuery("SELECT * FROM routes WHERE enable = 0 ");
			   while (nieaktywowanePolaczeniaSQL.next()){				  

				   idSzczegoly.put("id"+iloscPaneli,nieaktywowanePolaczeniaSQL.getInt("route_id"));
				   
				    danePanel.put("panel"+iloscPaneli,new JPanel());
					danePanel.get("panel"+iloscPaneli).setBounds(5, wysokosc, panel.getPreferredSize().width, 55);
					danePanel.get("panel"+iloscPaneli).setBackground(new Color(50,88,145));
					danePanel.get("panel"+iloscPaneli).setPreferredSize(new Dimension(panel.getPreferredSize().width,150));
					danePanel.get("panel"+iloscPaneli).setLayout(null);
					panel.setPreferredSize(new Dimension(panel.getPreferredSize().width,panel.getPreferredSize().height+60));
					panel.add(danePanel.get("panel"+iloscPaneli));
					
					dokadL.put("zglosilL"+iloscPaneli,new JLabel());
					dokadL.get("zglosilL"+iloscPaneli).setText(nieaktywowanePolaczeniaSQL.getString("owner"));
					dokadL.get("zglosilL"+iloscPaneli).setBounds(205, 12, 100, 25);
					dokadL.get("zglosilL"+iloscPaneli).setForeground(Color.white);
					danePanel.get("panel"+iloscPaneli).add(dokadL.get("zglosilL"+iloscPaneli));
					
					godzinaOdjazduL.put("godzinaOdjazduL"+iloscPaneli,new JLabel());
					godzinaOdjazduL.get("godzinaOdjazduL"+iloscPaneli).setText(nieaktywowanePolaczeniaSQL.getString("time_start"));
					godzinaOdjazduL.get("godzinaOdjazduL"+iloscPaneli).setBounds(105, 5, 100, 25);
					godzinaOdjazduL.get("godzinaOdjazduL"+iloscPaneli).setForeground(Color.white);
					danePanel.get("panel"+iloscPaneli).add(godzinaOdjazduL.get("godzinaOdjazduL"+iloscPaneli));
					
					godzinaPrzyjazduL.put("godzinaPrzyjazduL"+iloscPaneli,new JLabel());
			
					
					typL.put("typL"+iloscPaneli,new JLabel());
					typL.get("typL"+iloscPaneli).setText(nieaktywowanePolaczeniaSQL.getString("type"));
					typL.get("typL"+iloscPaneli).setBounds(305,15, 100, 25);
					typL.get("typL"+iloscPaneli).setForeground(Color.white);
					danePanel.get("panel"+iloscPaneli).add(typL.get("typL"+iloscPaneli));
				
					
					Statement przystankiNieaktywowanePolaczenia = con2.createStatement();
					przystankiNieaktywowanePolaczenia.execute("USE projektzespolowy");
					 ResultSet przystankiNieaktywowanePolaczeniaSQL = przystankiNieaktywowanePolaczenia.executeQuery("SELECT * FROM routes_stops WHERE route_id = '"+nieaktywowanePolaczeniaSQL.getInt("route_id")+"' AND nr='"+1+"'");
					  while (przystankiNieaktywowanePolaczeniaSQL.next()){	
						 
		
				
				if(przystankiNieaktywowanePolaczeniaSQL.getInt("nr")==1)
				{
				skadL.put("skadL"+iloscPaneli,new JLabel());
				skadL.get("skadL"+iloscPaneli).setText(""+przystankiNieaktywowanePolaczeniaSQL.getString("name"));
				skadL.get("skadL"+iloscPaneli).setBounds(5, 5, 100, 25);
				skadL.get("skadL"+iloscPaneli).setForeground(Color.white);
				danePanel.get("panel"+iloscPaneli).add(skadL.get("skadL"+iloscPaneli));	
				}
				
				Statement maxNr = con3.createStatement();
				maxNr.execute("USE projektzespolowy");
				ResultSet maxNrSQL = maxNr.executeQuery("SELECT MAX(nr) AS maxNumber FROM routes_stops where route_id='"+nieaktywowanePolaczeniaSQL.getInt("route_id")+"'");
				 	while (maxNrSQL.next()){
				 
				 		
				 		
				 		//------------------------------------------------------------------------------------------------------------------------------------------
						Statement dlugoscTrasy = con5.createStatement();
						dlugoscTrasy.execute("USE projektzespolowy");
						ResultSet dlugoscTrasySQL = dlugoscTrasy.executeQuery("SELECT * FROM routes_stops WHERE route_id = '"+nieaktywowanePolaczeniaSQL.getInt("route_id")+"' AND (nr BETWEEN 1 AND '"+maxNrSQL.getInt("maxNumber")+"')");
						while (dlugoscTrasySQL.next()){
							String timee2=dlugoscTrasySQL.getTime("stop_time").toString();
							SimpleDateFormat timeFormat2 = new SimpleDateFormat("HH:mm:ss");
							Date datee1 = timeFormat2.parse(timee1);
							Date datee2 = timeFormat2.parse(timee2);
							long sum2 = datee1.getTime() + datee2.getTime()+3600000 ;
							 datee = timeFormat2.format(new Date(sum2));
							timee1=datee;
						   }
						dlugoscTrasy.close();
						String time1=nieaktywowanePolaczeniaSQL.getString("time_start");
						String time2=timee1;
						SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
						timeFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
						Date date1 = timeFormat.parse(time1);
						Date date2 = timeFormat.parse(time2);
						long sum = date1.getTime() + date2.getTime();
						String date3 = timeFormat.format(new Date(sum));
						godzinaPrzyjazduL.get("godzinaPrzyjazduL"+iloscPaneli).setText(date3);
						godzinaPrzyjazduL.get("godzinaPrzyjazduL"+iloscPaneli).setBounds(105,25, 100, 25);
						godzinaPrzyjazduL.get("godzinaPrzyjazduL"+iloscPaneli).setForeground(Color.white);
						danePanel.get("panel"+iloscPaneli).add(godzinaPrzyjazduL.get("godzinaPrzyjazduL"+iloscPaneli));
						timee1="00:00:00";
	//------------------------------------------------------------------------------------------------------------------------------------------	
				 		
				 		
				 		
				 		
				 		
				 		
				 		
				 		
				 		
				 		System.out.println(maxNrSQL.getInt("maxNumber"));
				 		Statement maxName = con4.createStatement();
				 		maxName.execute("USE projektzespolowy");
						ResultSet maxNameSQL = maxName.executeQuery("SELECT name FROM routes_stops where nr='"+maxNrSQL.getInt("maxNumber")+"' AND route_id='"+nieaktywowanePolaczeniaSQL.getInt("route_id")+"'");
						while (maxNameSQL.next())
						{	
					//		System.out.println(maxNrSQL.getInt("maxNumber"));
						//	System.out.println(maxNameSQL.getString("name"));
							dokadL.put("dokadL"+iloscPaneli,new JLabel());
							dokadL.get("dokadL"+iloscPaneli).setText(maxNameSQL.getString("name"));
							dokadL.get("dokadL"+iloscPaneli).setBounds(5, 25, 100, 25);
							dokadL.get("dokadL"+iloscPaneli).setForeground(Color.white);
							danePanel.get("panel"+iloscPaneli).add(dokadL.get("dokadL"+iloscPaneli));
						}
						maxName.close();	
						
				 }
				 maxNr.close();

					  }
						iloscPaneli++;
						wysokosc+=60;
					  przystankiNieaktywowanePolaczenia.close();
			   } 
			   nieaktywowanePolaczenia.close();
			   panel.revalidate();
			   panel.repaint();
			   
			   for(int i=0;i<iloscPaneli;i++){
					int b =i;
				danePanel.get("panel"+i).addMouseListener(new MouseListener() {
					
					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						new ZarzadzajWybranaTrasa(idSzczegoly.get("id"+b));

					}
					
					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						danePanel.get("panel"+b).setBackground(new Color(50,88,145));
					}
					
					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						danePanel.get("panel"+b).setBackground(Color.red);
					}
					
					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
				});
				}
			   
			   
			   
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	
	
}
