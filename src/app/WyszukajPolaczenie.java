package app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Period;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import com.toedter.calendar.JCalendar;
import javax.swing.JCheckBox;

public class WyszukajPolaczenie {
    int iloscPaneli=0;
    int wysokosc=5;
    int idSprawdzane=0;
	WyszukajPolaczenie(){
		JFrame WyszukajPolaczenieFrame = new JFrame("Nowa trasa");
		WyszukajPolaczenieFrame.setSize(500, 650);
		WyszukajPolaczenieFrame.setLocationRelativeTo(null);
		WyszukajPolaczenieFrame.setVisible(true);
	//	WyszukajPolaczenieFrame.setLayout(null);
		WyszukajPolaczenieFrame.getContentPane().setBackground(new Color(50,88,145));
		WyszukajPolaczenieFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		((JComponent) WyszukajPolaczenieFrame.getContentPane()).setBorder(new EmptyBorder(10, 10, 10, 10));
		
	//	WyszukajPolaczenieFrame.setLayout(new BorderLayout());
		
	/*	UtilDateModel model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);*/
		 
		//frame.add(datePicker);
		
		JPanel panelInformacje = new JPanel();
		panelInformacje.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		panelInformacje.setLayout(null);
		
		
		
		
		JCalendar kalendarz = new JCalendar();
		kalendarz.setBounds(222, 11, 200, 170);

		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(370,10));
	    JScrollPane scroll = new JScrollPane(panel);
	    scroll.setBounds(25, 250, 400, 250);

	    scroll.setVerticalScrollBarPolicy(
	    		   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
	    JButton button = new JButton("Wyszukaj");
	    button.setFocusPainted(false);
	    button.setBorder(new RoundedCornerBorder());
	    button.setBounds(322, 196, 100, 25);
	    button.setBackground(new Color(50,88,145));
	    button.setForeground(new Color(220,220,220));

	        JTextField wyszukajSkad = new JTextField();
	        wyszukajSkad.setBounds(49, 36, 120, 25);
	        wyszukajSkad.setBorder(new RoundedCornerBorder());
	        wyszukajSkad.setBackground(new Color(50,88,145));
		    wyszukajSkad.setForeground(new Color(220,220,220));
	        
	        JTextField wyszukajDokad = new JTextField();
	        wyszukajDokad.setBounds(49, 92, 120, 25);
	        wyszukajDokad.setBorder(new RoundedCornerBorder());
	        wyszukajDokad.setBackground(new Color(50,88,145));
	        wyszukajDokad.setForeground(new Color(220,220,220));
	        
	        Font myFont = new Font("Serif", Font.BOLD | Font.BOLD, 10);
	        JLabel skadInfoL = new JLabel("Przystanek pocz¹tkowy");
	        skadInfoL.setBounds(wyszukajSkad.getX()+15, wyszukajSkad.getY()-20, 100, 25);
	        skadInfoL.setFont(myFont);
	        
	        
	        JLabel dokadInfoL = new JLabel("Przystanek koñcowy");
	        dokadInfoL.setBounds(wyszukajDokad.getX()+15, wyszukajDokad.getY()-20, 100, 25);
	        dokadInfoL.setFont(myFont);
	        
	        
	        
	        
			JSpinner czasRozpoczeciaMin = new JSpinner();
			czasRozpoczeciaMin.setBounds(119, 130, 45, 35);
			czasRozpoczeciaMin.setFont(new Font("Serif", Font.BOLD | Font.BOLD, 25));
			
			SpinnerDateModel modelGodz = new SpinnerDateModel();
			modelGodz.setCalendarField(Calendar.HOUR);

			
			
			JSpinner czasRozpoczeciaGodz = new JSpinner();
			czasRozpoczeciaGodz.setBounds(64, 130, 45, 35);
			czasRozpoczeciaGodz.setFont(new Font("Serif", Font.BOLD | Font.BOLD, 25));
			czasRozpoczeciaGodz.setModel(modelGodz);
			czasRozpoczeciaGodz.setEditor(new JSpinner.DateEditor(czasRozpoczeciaGodz, "HH"));	
			
			JLabel godzinaInfo = new JLabel("Podaj godzinê");
			godzinaInfo.setBounds(330, 30, 200, 25);
			SpinnerDateModel modelMins = new SpinnerDateModel();
			modelMins.setCalendarField(Calendar.MINUTE);
			czasRozpoczeciaMin.setModel(modelMins);
			czasRozpoczeciaMin.setEditor(new JSpinner.DateEditor(czasRozpoczeciaMin, "mm"));

	        
	        
	        
	        
	        
	        
	        
	        
	        
	        wyszukajSkad.setText("Ko³obrzeg");
	        wyszukajDokad.setText("Szczecinek");
	        Map<String, JLabel> skadL = new HashMap<>();
	        Map<String, JLabel> dokadL = new HashMap<>();
	        Map<String, JLabel> godzinaOdjazduL = new HashMap<>();
	        Map<String, JLabel> godzinaPrzyjazduL = new HashMap<>();
	        Map<String, JLabel> typL = new HashMap<>();
	        Map<String, JLabel> czasL = new HashMap<>();
	        Map<String, JPanel> danePanel = new HashMap<>();
	        Map<String, Integer> idSzczegoly = new HashMap<>();	   
	        Map<String, Integer> nr1Szczegoly = new HashMap<>();	
	        Map<String, Integer> nr2Szczegoly = new HashMap<>();	
	        panelInformacje.add(czasRozpoczeciaGodz);
	        panelInformacje.add(czasRozpoczeciaMin);
	        panelInformacje.add(kalendarz);
	        panelInformacje.add(scroll);
	        panelInformacje.add(button);
	        panelInformacje.add(wyszukajSkad);
	        panelInformacje.add(wyszukajDokad);
	        panelInformacje.add(skadInfoL);
	        panelInformacje.add(dokadInfoL);
		/*	WyszukajPolaczenieFrame.add(kalendarz);
		    WyszukajPolaczenieFrame.add(scroll);
		    WyszukajPolaczenieFrame.add(button);*/
	        WyszukajPolaczenieFrame.getContentPane().add(panelInformacje);
	        
	        JLabel infoSkadL1 = new JLabel("Sk\u0105d\r\n");
	        infoSkadL1.setFont(new Font("Tahoma", Font.PLAIN, 9));
	        infoSkadL1.setBounds(62, 225, 32, 14);
	        panelInformacje.add(infoSkadL1);
	        
	        JLabel infoGodzPrzyjazdL = new JLabel("Godzina przyjazdu");
	        infoGodzPrzyjazdL.setFont(new Font("Tahoma", Font.PLAIN, 9));
	        infoGodzPrzyjazdL.setBounds(124, 225, 104, 14);
	        panelInformacje.add(infoGodzPrzyjazdL);
	        
	        JLabel infoDokadL = new JLabel("Dok\u0105d");
	        infoDokadL.setFont(new Font("Tahoma", Font.PLAIN, 9));
	        infoDokadL.setBounds(60, 234, 46, 14);
	        panelInformacje.add(infoDokadL);
	        
	        JLabel infoGodzOdjL = new JLabel("Godzina odjazdu");
	        infoGodzOdjL.setFont(new Font("Tahoma", Font.PLAIN, 9));
	        infoGodzOdjL.setBounds(126, 234, 86, 14);
	        panelInformacje.add(infoGodzOdjL);
	        
	        JLabel infoCzasJazdyL = new JLabel("Czas jazdy");
	        infoCzasJazdyL.setFont(new Font("Tahoma", Font.PLAIN, 9));
	        infoCzasJazdyL.setBounds(235, 234, 46, 14);
	        panelInformacje.add(infoCzasJazdyL);
	        
	        JLabel infoTypPojazduL = new JLabel("Typ pojazdu");
	        infoTypPojazduL.setFont(new Font("Tahoma", Font.PLAIN, 9));
	        infoTypPojazduL.setBounds(331, 234, 65, 14);
	        panelInformacje.add(infoTypPojazduL);
	        
	        JPanel srodekLokomocjiPanel = new JPanel();
	        srodekLokomocjiPanel.setBounds(22, 518, 287, 56);
	        panelInformacje.add(srodekLokomocjiPanel);
		    srodekLokomocjiPanel.setBorder(BorderFactory.createTitledBorder("Œrodek lokomocji"));

	        JCheckBox pociagCB = new JCheckBox("Poci\u0105g");
	        pociagCB.setSelected(true);
	        pociagCB.setBounds(27, 197, 57, 23);
	        srodekLokomocjiPanel.add(pociagCB);
	        
	        JCheckBox autobusCB = new JCheckBox("Autobus");
	        autobusCB.setSelected(true);
	        autobusCB.setBounds(86, 197, 65, 23);
	        srodekLokomocjiPanel.add(autobusCB);
	       
	        JCheckBox busCB = new JCheckBox("Bus");
	        busCB.setSelected(true);
	        busCB.setBounds(153, 197, 45, 23);
	        srodekLokomocjiPanel.add(busCB);
	        
	        JCheckBox samolotCB = new JCheckBox("Samolot");
	        samolotCB.setSelected(true);
	        samolotCB.setBounds(200, 197, 65, 23);
	        srodekLokomocjiPanel.add(samolotCB);
		    WyszukajPolaczenieFrame.setVisible(true);

	
	        
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
			     
				    SimpleDateFormat format = new SimpleDateFormat("EEEE");
	
				   int pn=0;
				   int wt=0;
				   int sr=0;
				   int czw=0;
				   int pt=0;
				   int sob=0;
				   int niedz=0;
					if(format.format(kalendarz.getDate()).equals("poniedzia³ek")){
				    	pn=1;
				    }
					else if(format.format(kalendarz.getDate()).equals("wtorek")){
						wt=1;
					}
					else if(format.format(kalendarz.getDate()).equals("œroda")){
						sr=1;
					}
					else if(format.format(kalendarz.getDate()).equals("czwartek")){
						czw=1;
					}
					else if(format.format(kalendarz.getDate()).equals("pi¹tek")){
						pt=1;
					}
					else if(format.format(kalendarz.getDate()).equals("sobota")){
						sob=1;
					}
					else if(format.format(kalendarz.getDate()).equals("niedziela")){
						niedz=1;
					}
			     
					String samolot = null;
					String bus = null;
					String pociag = null;
					String autobus = null;
					if(samolotCB.isSelected()){
						samolot = "Samolot";
					}
					if(busCB.isSelected()){
						bus = "Bus";
					}
					if(pociagCB.isSelected()){
						pociag = "Poci¹g";
					}		     
					if(autobusCB.isSelected()){
						autobus = "Autobus";
					}	
					int nrPaczatkowy=0;
					int nrKoncowy=0;
					String datee =null;
					String timee1="00:00:00";
				    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
				   
				//    String czas = czasRozpoczeciaGodz.get.toString()+":"+czasRozpoczeciaMin.getValue().toString()+":"+"00";
		
				      DateFormat dateFormat = new SimpleDateFormat("mm");
			           Date datep1 = (Date) czasRozpoczeciaMin.getValue();
			            String timep1=dateFormat.format(datep1);
			          
			        
			            DateFormat dateFormat2 = new SimpleDateFormat("HH");
				           Date datep2 = (Date) czasRozpoczeciaGodz.getValue();
				            String timep2=dateFormat2.format(datep2);
				       String godzinaStartowania=null;
			     
			     String godzina = timep2+":"+timep1+":00";
			 
			     
			  /*   DateFormat dateFormat3 = new SimpleDateFormat("hh:mm:ss");
			    Date datep3 = dateFormat3.format(godzina);*/
			     
			/*	 String url = "jdbc:mysql://127.0.0.1:3306/projektzespolowy" + 
						 "?useUnicode=true&characterEncoding=utf8";;
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
				Connection con2 = DriverManager.getConnection(url, user, password);
				Connection con3 = DriverManager.getConnection(url, user, password);
				Connection con4 = DriverManager.getConnection(url, user, password);
				

					  
		
				
			    Statement poczatekTrasy = con3.createStatement();

			    poczatekTrasy.execute("USE projektzespolowy");

			    ResultSet poczatekTrasySQL = poczatekTrasy.executeQuery("SELECT * FROM routes_stops WHERE name = '"+wyszukajSkad.getText()+"'");
			   while (poczatekTrasySQL.next()){
			    idSzczegoly.put("id"+iloscPaneli,poczatekTrasySQL.getInt("route_id"));
			    
				    Statement loginST = con.createStatement();
				    loginST.execute("USE projektzespolowy");
			    ResultSet wyszukajSkadSQL = loginST.executeQuery("SELECT * FROM routes WHERE route_id = '"+poczatekTrasySQL.getInt("route_id")+"'"
			    		+ "AND pn>='"+pn+"' AND wt>='"+wt+"'AND sr>='"+sr+"' AND czw>='"+czw+"'AND pt>='"+pt+"'AND sob>='"+sob+"'AND niedz>='"+niedz+"'AND time_start>='"+godzina+"' AND (type='"+pociag+"' OR type='"+autobus+"' OR type='"+bus+"'OR type='"+samolot+"')");
			
			

		
				   while (wyszukajSkadSQL.next()){
					   
					   godzinaStartowania = wyszukajSkadSQL.getString("time_start").toString();
					   idSprawdzane=poczatekTrasySQL.getInt("route_id");
					   Statement sprawdzeniePrzystankow = con2.createStatement();
					   sprawdzeniePrzystankow.execute("USE projektzespolowy");
					    ResultSet przystanki = sprawdzeniePrzystankow.executeQuery("SELECT * FROM routes_stops WHERE name = '"+wyszukajDokad.getText()+"'"
					    		+ " and route_id='"+idSprawdzane+"'");
						   while (przystanki.next()){
							    nr2Szczegoly.put("nr"+iloscPaneli,przystanki.getInt("nr"));
							    danePanel.put("panel"+iloscPaneli,new JPanel());
								danePanel.get("panel"+iloscPaneli).setBounds(5, wysokosc, panel.getPreferredSize().width, 55);
								danePanel.get("panel"+iloscPaneli).setBackground(new Color(50,88,145));
								danePanel.get("panel"+iloscPaneli).setPreferredSize(new Dimension(panel.getPreferredSize().width,150));
								danePanel.get("panel"+iloscPaneli).setLayout(null);
							
								skadL.put("skadL"+iloscPaneli,new JLabel());
								skadL.get("skadL"+iloscPaneli).setText(""+poczatekTrasySQL.getString("name"));
								skadL.get("skadL"+iloscPaneli).setBounds(5, 5, 100, 25);
								skadL.get("skadL"+iloscPaneli).setForeground(Color.white);
								danePanel.get("panel"+iloscPaneli).add(skadL.get("skadL"+iloscPaneli));	
								
								dokadL.put("dokadL"+iloscPaneli,new JLabel());
								dokadL.get("dokadL"+iloscPaneli).setText(przystanki.getString("name"));
								dokadL.get("dokadL"+iloscPaneli).setBounds(5, 25, 100, 25);
								dokadL.get("dokadL"+iloscPaneli).setForeground(Color.white);
								danePanel.get("panel"+iloscPaneli).add(dokadL.get("dokadL"+iloscPaneli));
								
								godzinaOdjazduL.put("godzinaOdjazduL"+iloscPaneli,new JLabel());
								if(poczatekTrasySQL.getInt("nr")==1){
								godzinaOdjazduL.get("godzinaOdjazduL"+iloscPaneli).setText(wyszukajSkadSQL.getString("time_start"));
								godzinaStartowania=wyszukajSkadSQL.getString("time_start").toString();
								nr1Szczegoly.put("nr"+iloscPaneli,1);
								
								}
								else {
									
									
									
									Statement dodaniePoczatkowej = con4.createStatement();
									dodaniePoczatkowej.execute("USE projektzespolowy");
									ResultSet dodaniePoczatkowejSQL = dodaniePoczatkowej.executeQuery("SELECT * FROM routes_stops WHERE route_id = '"+poczatekTrasySQL.getInt("route_id")+"' AND (nr BETWEEN '"+1+"' AND '"+poczatekTrasySQL.getInt("nr")+"')");
									while (dodaniePoczatkowejSQL.next()){

										
										nr1Szczegoly.put("nr"+iloscPaneli,poczatekTrasySQL.getInt("nr"));
										// godzinaStartowania = wyszukajSkadSQL.getString("time_start").toString();
									
										String godzinaDoDodania = dodaniePoczatkowejSQL.getString("stop_time").toString();
										SimpleDateFormat timeFormat2 = new SimpleDateFormat("HH:mm:ss");
										Date godzinaStart = timeFormat2.parse(godzinaStartowania);
										Date godzinaDodania = timeFormat2.parse(godzinaDoDodania);	
										long sum3 = godzinaStart.getTime() + godzinaDodania.getTime()+3600000 ;
										String godzinaOdPrzystanku = timeFormat2.format(new Date(sum3));
										
										godzinaStartowania=godzinaOdPrzystanku;
									
										godzinaOdjazduL.get("godzinaOdjazduL"+iloscPaneli).setText(godzinaStartowania);
									}
									dodaniePoczatkowej.close();
									
									
									
									
								}
								
								
								
								godzinaOdjazduL.get("godzinaOdjazduL"+iloscPaneli).setBounds(105, 5, 100, 25);
								godzinaOdjazduL.get("godzinaOdjazduL"+iloscPaneli).setForeground(Color.white);
								danePanel.get("panel"+iloscPaneli).add(godzinaOdjazduL.get("godzinaOdjazduL"+iloscPaneli));
								
								godzinaPrzyjazduL.put("godzinaPrzyjazduL"+iloscPaneli,new JLabel());

								
								int nrPoczatkowy=1;
								nrPoczatkowy+=poczatekTrasySQL.getInt("nr");
								Statement dlugoscTrasy = con3.createStatement();
								dlugoscTrasy.execute("USE projektzespolowy");
								ResultSet dlugoscTrasySQL = dlugoscTrasy.executeQuery("SELECT * FROM routes_stops WHERE route_id = '"+poczatekTrasySQL.getInt("route_id")+"' AND (nr BETWEEN '"+nrPoczatkowy+"' AND '"+przystanki.getInt("nr")+"')");
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
								
								
								
								
								
								
								String time1=godzinaStartowania;
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

							
								//kolejny sql

								czasL.put("czasL"+iloscPaneli,new JLabel());
								czasL.get("czasL"+iloscPaneli).setText(datee);
								czasL.get("czasL"+iloscPaneli).setBounds(205,15, 100, 25);
								czasL.get("czasL"+iloscPaneli).setForeground(Color.white);
								danePanel.get("panel"+iloscPaneli).add(czasL.get("czasL"+iloscPaneli));
								
								//zamknac sql
								
								  
								
								typL.put("typL"+iloscPaneli,new JLabel());
								typL.get("typL"+iloscPaneli).setText(wyszukajSkadSQL.getString("type"));
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
			   poczatekTrasySQL.close();

				}
				  
				
				catch(Exception e){
					System.out.println(e);
				}
				
				
				
				
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
						new SzczegolyTrasy(idSzczegoly.get("id"+b),nr1Szczegoly.get("nr"+b),nr2Szczegoly.get("nr"+b));

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
				
			}});


	        
}
	
}
