package app;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class DodajTrase {
	Date time = new Date( );
	int liczbaStacji =0;
	int lastid=0 ;
    long lacznyCzas=0;
    int lacznyDystans=0;
    long zerowyTime=60000*60L*23L;	
    SimpleDateFormat ft = new SimpleDateFormat ("HH:mm:ss");
	DodajTrase(String nazwaUzytkownika){
		JFrame DodawanieTrasyFrame = new JFrame("Nowa trasa");
		DodawanieTrasyFrame.setSize(500, 500);
		DodawanieTrasyFrame.setLocationRelativeTo(null);
		DodawanieTrasyFrame.setVisible(true);
	//	DodawanieTrasyFrame.setLayout(null);
	
		DodawanieTrasyFrame.getContentPane().setBackground(new Color(50,88,145));
		DodawanieTrasyFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		((JComponent) DodawanieTrasyFrame.getContentPane()).setBorder(new EmptyBorder(10, 10, 10, 10));
		Font myFont = new Font("Serif", Font.BOLD | Font.BOLD, 12);
		JLabel cenaL = new JLabel("Cena:");
		cenaL.setBounds(135, 45, 100, 25);
		cenaL.setFont(myFont);
		
		JTextField cenaText = new JTextField();
		cenaText.setBounds(170, 45, 80, 25);
		cenaText.setBackground(new Color(50,88,145));
		cenaText.setForeground(Color.white);
		cenaText.setHorizontalAlignment(SwingConstants.RIGHT);
		cenaText.setBorder(new RoundedCornerBorder());
		
		JLabel pln = new JLabel("PLN");
		pln.setFont(myFont);
		pln.setBounds(255, 45, 50, 25);
		
		JSpinner czasRozpoczeciaMin = new JSpinner();
		czasRozpoczeciaMin.setBounds(380, 55, 45, 35);
		czasRozpoczeciaMin.setFont(new Font("Serif", Font.BOLD | Font.BOLD, 25));
		
		SpinnerDateModel modelGodz = new SpinnerDateModel();
		modelGodz.setCalendarField(Calendar.HOUR);

		
		
		JSpinner czasRozpoczeciaGodz = new JSpinner();
		czasRozpoczeciaGodz.setBounds(330, 55, 45, 35);
		czasRozpoczeciaGodz.setFont(new Font("Serif", Font.BOLD | Font.BOLD, 25));
		czasRozpoczeciaGodz.setModel(modelGodz);
		czasRozpoczeciaGodz.setEditor(new JSpinner.DateEditor(czasRozpoczeciaGodz, "HH"));	
		
		JLabel godzinaInfo = new JLabel("Podaj godzinê");
		godzinaInfo.setBounds(342, 30, 97, 25);
		SpinnerDateModel modelMins = new SpinnerDateModel();
		modelMins.setCalendarField(Calendar.MINUTE);
		czasRozpoczeciaMin.setModel(modelMins);
		czasRozpoczeciaMin.setEditor(new JSpinner.DateEditor(czasRozpoczeciaMin, "mm"));


	
		
		
		JButton dodajTraseB = new JButton("Dodaj trase");
		dodajTraseB.setBounds(30, 310, 100, 25);
		dodajTraseB.setBorder(new RoundedCornerBorder());
		dodajTraseB.setBackground(new Color(50,88,145));
		dodajTraseB.setForeground(Color.white);
		dodajTraseB.setFocusPainted(false);
		
		
		
		
		DefaultTableModel model = new DefaultTableModel(new Object[][] {
			      },
			      new Object[] { "Numer stacji","Nazwa stacji", "Czas przejazdu","Odleg³oœæ" });

	      JTable table = new JTable(model){
	    	
	    		public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
	    			Component comp = super.prepareRenderer(renderer, row, column);
	    			comp.setBackground(row % 2 == 0 ? Color.white : Color.LIGHT_GRAY);
	    			return comp;
	    		}
	      };
	      table.setShowGrid(false);
	      for (int c = 0; c < table.getColumnCount(); c++)
	      {
	          Class<?> col_class = table.getColumnClass(c);
	          table.setDefaultEditor(col_class, null);       
	      }
	      
	      JTableHeader header = table.getTableHeader();
	      header.setBackground(new Color(50,88,145));
	      header.setForeground(Color.white);
	   
	      JScrollPane scroll = new JScrollPane(table);
	      scroll.setBounds(30, 100, 400, 200);
	      scroll.getViewport().setBackground(Color.WHITE);
	      //scroll.setBackground(new Color(50,88,145));
	      table.setBounds(100, 100, 400, 200);
	    
		
		

	    time.setTime(zerowyTime);
	 //   System.out.println("zerowy" +ft.format(time));
		JLabel czasKoniec = new JLabel();
		czasKoniec.setText(ft.format(time));
		czasKoniec.setBounds(200, 450, 100, 150);
		
	    JButton kolejnaStacjaB = new JButton("Dodaj stacje");
		kolejnaStacjaB.setBounds(310, 310, 120, 25);
		kolejnaStacjaB.setBorder(new RoundedCornerBorder());
		kolejnaStacjaB.setBackground(new Color(50,88,145));
		kolejnaStacjaB.setForeground(Color.white);
		kolejnaStacjaB.setFocusPainted(false);
		
		JPanel panelInformacje = new JPanel();
		panelInformacje.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		panelInformacje.setLayout(null);
		
		panelInformacje.add(cenaText);
		panelInformacje.add(cenaL);
		panelInformacje.add(pln);
		panelInformacje.add(DodawanieTrasyFrame.getContentPane().add(scroll));
		panelInformacje.add(kolejnaStacjaB);
		panelInformacje.add(czasRozpoczeciaGodz);
		panelInformacje.add(czasRozpoczeciaMin);
		panelInformacje.add(godzinaInfo);
		panelInformacje.add(dodajTraseB);
		JLabel lacznyCzasPrzejazdu = new JLabel("");
		lacznyCzasPrzejazdu.setBounds(100, 450, 100, 25);
		lacznyCzasPrzejazdu.setText("00:00:00");
		
	JPanel kursujePanel = new JPanel();
	kursujePanel.setLayout(null);
	kursujePanel.setBorder(BorderFactory.createTitledBorder("Kursuje w"));
	kursujePanel.setBounds(25, 350, 410, 75);

	panelInformacje.add(kursujePanel);
		
	      JCheckBox pnCB = new JCheckBox("Poniedzia³ek");
	      pnCB.setBounds(5, 20, 97, 25);
	      pnCB.setFocusPainted(false);
	      kursujePanel.add(pnCB);
	  
	      
	      JCheckBox wtCB = new JCheckBox("Wtorek");
	      wtCB.setBounds(pnCB.getLocation().x+pnCB.getWidth()+5, 20, 68, 25);
	      wtCB.setFocusPainted(false);
	      kursujePanel.add(wtCB);
	
	      JCheckBox srCB = new JCheckBox("Œroda");
	      srCB.setBounds(wtCB.getLocation().x+wtCB.getWidth()+5, 20, 59, 25);
	      srCB.setFocusPainted(false);
	      kursujePanel.add(srCB);
	      
	      JCheckBox czwCB = new JCheckBox("Czwartek");
	      czwCB.setBounds(srCB.getLocation().x+srCB.getWidth()+5, 20, 80, 25);
	      czwCB.setFocusPainted(false);
	      kursujePanel.add(czwCB);	
	      
	      JCheckBox ptCB = new JCheckBox("Pi¹tek");
	      ptCB.setBounds(czwCB.getLocation().x+czwCB.getWidth()+5, 20, 70, 25);
	      ptCB.setFocusPainted(false);
	      kursujePanel.add(ptCB);	
	      
	      JCheckBox sobCB = new JCheckBox("Sobota");
	      sobCB.setBounds(czwCB.getLocation().x, 45, 80, 25);
	      sobCB.setFocusPainted(false);
	      kursujePanel.add(sobCB);		     
	      
	      JCheckBox niedzCB = new JCheckBox("Niedziela");
	      niedzCB.setBounds(ptCB.getLocation().x, 45, 78, 25);
	      niedzCB.setFocusPainted(false);
	      kursujePanel.add(niedzCB);	
	      
		/*
		DodawanieTrasyFrame.add(czasKoniec);

		DodawanieTrasyFrame.add(lacznyCzasPrzejazdu);	

		
		 ;*/
		DodawanieTrasyFrame.getContentPane().add(panelInformacje);
		JComboBox typTransportuCombo = new JComboBox();
		typTransportuCombo.setModel(new DefaultComboBoxModel(new String[] {"Poci¹g", "Samolot", "Autobus", "Bus"}));
		typTransportuCombo.setBounds(170, 319, 93, 20);
		panelInformacje.add(typTransportuCombo);
		
		JLabel typSrodkaL = new JLabel("Typ \u015Arodka Lokomocji");
		typSrodkaL.setFont(new Font("Tahoma", Font.PLAIN, 9));
		typSrodkaL.setBounds(169, 304, 103, 14);
		panelInformacje.add(typSrodkaL);

		dodajTraseB.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent arg0)
		{
		/*	 String url = "jdbc:mysql://127.0.0.1:3306/projektzespolowy" + 
					 "?useUnicode=true&characterEncoding=utf8";
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
				JSpinner.DateEditor de = new JSpinner.DateEditor(czasRozpoczeciaGodz, "HH");
				JSpinner.DateEditor de2 = new JSpinner.DateEditor(czasRozpoczeciaMin, "mm");

				czasRozpoczeciaGodz.setEditor(de);
				czasRozpoczeciaMin.setEditor(de2);		
			
				String CzasPoczatek = ""+de.getFormat().format(czasRozpoczeciaGodz.getValue())
						+":"+de2.getFormat().format(czasRozpoczeciaMin.getValue());
				CzasPoczatek+=":00";
			
		
				
				
			
		
				
		
			Connection con = DriverManager.getConnection(url, user, password); 
		    Statement loginST = con.createStatement();
		    loginST.execute("USE projektzespolowy");
		   // loginST.execute("SET NAMES 'UTF-8'");
		    String updateTableSQL = " INSERT INTO routes"
    				+ " (price,time_start,duration,distance,pn,wt,sr,czw,pt,sob,niedz,type,owner)"
    				+ " VALUES('"+cenaText.getText()+"',"
    				+"'"+CzasPoczatek+"','"+ft.format(zerowyTime + lacznyCzas*1000L*60L)+"','"+lacznyDystans+"',"
    				+ "'"+booleanToInt(pnCB.isSelected())+"','"+booleanToInt(wtCB.isSelected())+"','"+booleanToInt(srCB.isSelected())+"',"
    				+ "'"+booleanToInt(czwCB.isSelected())+"','"+booleanToInt(ptCB.isSelected())+"','"+booleanToInt(sobCB.isSelected())+"','"+booleanToInt(niedzCB.isSelected())+"',"
    						+ "'"+typTransportuCombo.getSelectedItem().toString()+"', '"+nazwaUzytkownika+"')";
		    		loginST.execute(updateTableSQL);

		   ResultSet  jakieID = loginST.executeQuery("SELECT MAX(route_id) AS route_id FROM routes");

		   if(jakieID.next()){
			   lastid = jakieID.getInt("route_id");
			 //  System.out.print(lastid);
		   }
		
		  for(int i=0;i<table.getModel().getRowCount();i++){
				  String updateTableSQL2 = " INSERT INTO routes_stops"
			   				+ " (route_id,name,distance,stop_time,nr)"
			   				+ " VALUES('"+lastid+"','"+table.getModel().getValueAt(i, 1)+"',"
			   	+ "'"+Integer.parseInt(table.getModel().getValueAt(i, 3).toString())+"','"+table.getModel().getValueAt(i, 2)+"'"
			   			+ ",'"+table.getModel().getValueAt(i, 0)+"')";
				 
				  loginST.execute(updateTableSQL2); 
			  
		  }
		//   table.getModel().getValueAt(arg0, arg1)

		   
		   
		   
		    		
			}
			catch(Exception e){
				System.out.println(e);
			}
			
			
			DodawanieTrasyFrame.dispose();
			}});
		
		JTextField nazwaPrzystanku = new JTextField();
	      JTextField odleglosc = new JTextField();
			JTextField czasPrzejazdu = new JTextField();
	      JPanel myPanel = new JPanel();
	      myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.PAGE_AXIS));
	      myPanel.add(new JLabel("Podaj nazwe przystanku:"));
	      myPanel.add(nazwaPrzystanku);
	      myPanel.add(Box.createVerticalStrut(5));
	      myPanel.add(new JLabel("Podaj czas przejazdu od poprzedniej stacji: [min]"));
	      myPanel.add(czasPrzejazdu);
	      myPanel.add(Box.createVerticalStrut(5));
	      myPanel.add(new JLabel("Podaj odleg³oœæ od poprzedniej stacji: [km]"));
	      myPanel.add(odleglosc);
		
	   




		kolejnaStacjaB.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent arg0)
		{
		   // String message = "Dodaj kolejny przystanek";
		    //String text = JOptionPane.showInputDialog(DodawanieTrasyFrame, message,inputFields);

			int result = JOptionPane.showConfirmDialog(DodawanieTrasyFrame, myPanel, 
		               "Dodanie przystanku", JOptionPane.OK_CANCEL_OPTION);
		    while (result == JOptionPane.OK_OPTION) {
		    	try{
				double odlegloscLiczba = Double.parseDouble(odleglosc.getText()); 
		    	long czasLiczba = Long.parseLong(czasPrzejazdu.getText()); 
		    	lacznyDystans+=odlegloscLiczba;
		    	time.setTime(zerowyTime + czasLiczba*1000L*60L);
		    	lacznyCzas+=czasLiczba;
		    //	System.out.println(ft.format(time));
		    	liczbaStacji++;
		    	if(liczbaStacji==1){
		    		model.addRow(new Object[]{liczbaStacji,nazwaPrzystanku.getText(),"00:00:00",0});
		    	}
		    	else{
		    	model.addRow(new Object[]{liczbaStacji,nazwaPrzystanku.getText(),ft.format(time),odleglosc.getText()});
		    	}
		    	nazwaPrzystanku.setText("");
		    	odleglosc.setText("");
		    	czasPrzejazdu.setText("");
		    	
		    	lacznyCzasPrzejazdu.setText(ft.format(zerowyTime + lacznyCzas*1000L*60L));
		    //	System.out.print(ft.format(time));
		    	czasKoniec.setText(""+new SimpleDateFormat("mm").format(czasRozpoczeciaGodz.getModel().getValue())+""+new SimpleDateFormat("HH").format(czasRozpoczeciaGodz.getModel().getValue()));
		    	break;
		    	}
		    	catch(Exception e){
		    		JOptionPane.showMessageDialog(DodawanieTrasyFrame, "Poda³eœ b³êdn¹ liczbê, spróbuj jeszcze raz.");
		    		result = JOptionPane.showConfirmDialog(DodawanieTrasyFrame, myPanel, 
				               "Dodanie przystanku", JOptionPane.OK_CANCEL_OPTION);
		    	}
		    	}
	
		}});
		

		DodawanieTrasyFrame.addWindowListener(new WindowListener() {
		        public void windowClosing(WindowEvent e) {
		        	UIManager.put("OptionPane.yesButtonText", "Tak");
		        	UIManager.put("OptionPane.noButtonText", "Nie");
		        	
		            if (JOptionPane.showConfirmDialog(DodawanieTrasyFrame, "Anulowaæ dodawanie trasy?", "Anulowaæ?", JOptionPane.YES_NO_OPTION, 0, new ImageIcon("")) != 0) {
		            	
		            }
		            else{
		            
		            DodawanieTrasyFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		            }
		           //ghgh
		        }
		        public void windowOpened(WindowEvent e) {}
		        public void windowClosed(WindowEvent e) {}
		        public void windowIconified(WindowEvent e) {}     
		        public void windowDeiconified(WindowEvent e) {}
		        public void windowActivated(WindowEvent e) {}	       
		        public void windowDeactivated(WindowEvent e) {}

		    });
		
		
		  ImageIcon logo = null;
		    try {
		    	logo = new ImageIcon(getClass().getResource("/img/logom.png"));
		    	
		    } catch (Exception e) {
		        System.err.println("load error: " + e.getMessage());
		    }
			JLabel LogoL = new JLabel(logo);
			LogoL.setBounds(46, 30, 50, 50);
			panelInformacje.add(LogoL);
		
			
			cenaText.addKeyListener(new KeyAdapter() {
		        public void keyReleased(KeyEvent e) {
		        	char ch;
		        	int liczbaKropek=0;
		        	cenaText.setText(cenaText.getText().replace(',', '.'));	
		        	
		        	
					 for(int i=0;i<cenaText.getText().length();i++)
				        {
				            ch = cenaText.getText().charAt(i);
				            int asciivalue = (int)ch;
				           
				            if(asciivalue == 46){
				            	liczbaKropek++;
				            	if(cenaText.getText().indexOf(".")+3<cenaText.getText().length()){
					        		cenaText.setText(cenaText.getText().substring(0, (cenaText.getText().indexOf(".")+3)));
					        		}
				            	//System.out.println(liczbaKropek);
				            }
				            if(liczbaKropek==1 && cenaText.getText().length()==1){
				            	cenaText.setText("0.");
				            	break;
				            }
				            if(liczbaKropek>1){
				            	cenaText.setText("");
				            	break;
				            }
						    if (Character.isUpperCase(cenaText.getText().charAt(i))) cenaText.setText("");
						    if (Character.isLowerCase(cenaText.getText().charAt(i))) cenaText.setText("");
				            
				        }
		        
		      
		        	/*if(login.getText().length()>25){
		        		login.setText(login.getText().substring(0, 25));
		 		}*/
		        }

		        public void keyTyped(KeyEvent e) {
		            // TODO: Do something for the keyTyped event
		        }

		        public void keyPressed(KeyEvent e) {
		            // TODO: Do something for the keyPressed event
		        }
		    });	
	}
	
	 public static int booleanToInt(boolean value) {
			return value ? 1 : 0;
		    }
	 
	 
}
