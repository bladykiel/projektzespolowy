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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

public class Komentarze {
    int iloscPaneli=0;
    int wysokosc=5;
    Map<String, JPanel> panelKomentarze = new HashMap<>();
    Map<String, JLabel> autor = new HashMap<>();
    Map<String, JTextArea> text = new HashMap<>();
    Map<String, JButton> usun = new HashMap<>();
    Map<String, JButton> edytuj = new HashMap<>();
    Map<String, Integer> id = new HashMap<>();	
   // List<Integer> id2 = new ArrayList<Integer>();
    int IDPolaczenia2;
    JPanel panel3;
    JPanel panel;
	public Komentarze(int IDPolaczenia){
		IDPolaczenia2=IDPolaczenia;
		JFrame KomentyFrame = new JFrame("Szczegoly po³¹czenia");
		KomentyFrame.setSize(500, 450);
		KomentyFrame.setLocationRelativeTo(null);
		KomentyFrame.getContentPane().setBackground(new Color(50,88,145));
        ((JComponent) KomentyFrame.getContentPane()).setBorder(new EmptyBorder(10, 10, 10, 10));
        KomentyFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

         panel = new JPanel();
        panel.setBorder(new EtchedBorder(EtchedBorder.RAISED));
        panel.setLayout(null);
        KomentyFrame.getContentPane().add(panel);
        KomentyFrame.setVisible(true);
        
         panel3 = new JPanel();
        panel3.setLayout(null);
		panel3.setPreferredSize(new Dimension(370,10));
	    JScrollPane scroll = new JScrollPane(panel3);
	    scroll.setBounds(25, 25, 400, 250);
	    
	    scroll.setVerticalScrollBarPolicy(
	    		   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
	    panel.add(scroll);
        String url = "jdbc:mysql://127.0.0.1:3306/projektzespolowy" + 
				 "?useUnicode=true&characterEncoding=utf8";
        
        JTextArea NowyKomentarz = new JTextArea();
        NowyKomentarz.setLineWrap(true);
        NowyKomentarz.setBounds(25,300,400,50);
        NowyKomentarz.setBorder(BorderFactory.createLineBorder(Color.black));
        
        NowyKomentarz.addKeyListener(new KeyAdapter() {
	           public void keyReleased(KeyEvent e) {
	           	if(NowyKomentarz.getText().length()>140){
	           		NowyKomentarz.setText(NowyKomentarz.getText().substring(0, 140));
        		}
	           }

	           public void keyTyped(KeyEvent e) {
	               // TODO: Do something for the keyTyped event
	           }

	           public void keyPressed(KeyEvent e) {
	               // TODO: Do something for the keyPressed event
	           }
	       });
        
        
        
        JButton dodaj = new JButton("Dodaj komentarz");
        dodaj.setBounds(275,361,150,23);
        panel.add(dodaj);
        panel.add(NowyKomentarz);
        
        JLabel dodajnowy = new JLabel("Dodaj komentarz...");
        dodajnowy.setBounds(35, 279, 168, 23);
        panel.add(dodajnowy);
	/*      String user = "root";
	      String password = "njymjmbnnmbn";
	      char[] jkjasd = { 'a', 'd', 'm', 'i', 'n'};
			  password="";
			  for (int i = 0; i < jkjasd.length; i++) {
		    	  password= password+jkjasd[i];
		      }	*/
	//	 String url = "jdbc:mysql://www.db4free.net:3306/projektzespolowy";
	      String user = "projektzespolowy";
	      String password = "njymjmbnnmbn";
	      char[] jkjasd = { 'p', 'r', 'o', 'j', 'e','k','t'};
			  password="";
			  for (int i = 0; i < jkjasd.length; i++) {
		    	  password= password+jkjasd[i];
		      }	
	WczytajDane();
		
		  dodaj.addActionListener(new ActionListener()
   		{
   		public void actionPerformed(ActionEvent arg0)
   		{
   			try{
   				String password = "njymjmbnnmbn";
  		      char[] jkjasd = { 'a', 'd', 'm', 'i', 'n'};
  				  password="";
  				  for (int i = 0; i < jkjasd.length; i++) {
  			    	  password= password+jkjasd[i];
  			      }	
   			Connection con2 = DriverManager.getConnection(url, user, password); 
		    Statement loginST = con2.createStatement();
		    loginST.execute("USE projektzespolowy");
		    String updateTableSQL = " INSERT INTO comments"
    				+ " (Id_pol,Kto,Comment)"
    				+ " VALUES('"+IDPolaczenia+"',"
    				+"'"+"admin"+"','"+NowyKomentarz.getText()+"')";
		    		loginST.execute(updateTableSQL);
   			}
   			catch(Exception e){
   				System.out.println(e);
   			}
   		     iloscPaneli=0;
   		     wysokosc=5;
   		  panel3.setPreferredSize(new Dimension(370,10));
  		panel3.removeAll();
		panel3.repaint();
		panel3.revalidate();
	  	Wyzeruj();
		WczytajDane();
		NowyKomentarz.setText("");
   		}});
		}

	public void WczytajDane(){
		Wyzeruj();
		try{	
			String url = "jdbc:mysql://www.db4free.net:3306/projektzespolowy";
		//	String url = "jdbc:mysql://127.0.0.1:3306/projektzespolowy" + 
		//			 "?useUnicode=true&characterEncoding=utf8";
			  String user = "root";
		      String password = "njymjmbnnmbn";
		      char[] jkjasd = { 'a', 'd', 'm', 'i', 'n'};
				  password="";
				  for (int i = 0; i < jkjasd.length; i++) {
			    	  password= password+jkjasd[i];
			      }	
			Connection con = DriverManager.getConnection(url, user, password);
		    Statement Koment = con.createStatement();
		    Koment.execute("USE projektzespolowy");
		    ResultSet Komentarz = Koment.executeQuery("SELECT * FROM comments WHERE Id_pol = '"+IDPolaczenia2+"'");
			
		    while (Komentarz.next()){
		    System.out.print(Komentarz.getString("Comment"));
		  //  iloscPaneli++;
		    panelKomentarze.put("panelKomentarze"+iloscPaneli,new JPanel());
		    panelKomentarze.get("panelKomentarze"+iloscPaneli).setBounds(5, wysokosc, panel3.getPreferredSize().width, 55);
		    panelKomentarze.get("panelKomentarze"+iloscPaneli).setBackground(new Color(50,88,145));
		    panelKomentarze.get("panelKomentarze"+iloscPaneli).setPreferredSize(new Dimension(panel.getPreferredSize().width,150));
		    panelKomentarze.get("panelKomentarze"+iloscPaneli).setLayout(null);
		    
	        //id.add(Komentarz.getInt("Id"));
		 //   id2.put("id2"+iloscPaneli,new Integer());
	        id.put("id"+iloscPaneli,Komentarz.getInt("Id"));
	        
		    autor.put("autor"+iloscPaneli,new JLabel());
		    autor.get("autor"+iloscPaneli).setText(Komentarz.getString("Kto"));
		    autor.get("autor"+iloscPaneli).setBounds(1,25, 100, 25);
		    autor.get("autor"+iloscPaneli).setForeground(Color.white);
		    panelKomentarze.get("panelKomentarze"+iloscPaneli).add(autor.get("autor"+iloscPaneli));
		    
		    usun.put("usun"+iloscPaneli,new JButton(""+Komentarz.getInt("Id")));
		    usun.get("usun"+iloscPaneli).setBounds(325,5, 50, 20);
		    //usun.get("usun"+iloscPaneli).setForeground(Color.white);
		    panelKomentarze.get("panelKomentarze"+iloscPaneli).add(usun.get("usun"+iloscPaneli));
		    
		    edytuj.put("edytuj"+iloscPaneli,new JButton(""+Komentarz.getInt("Id")));
		    edytuj.get("edytuj"+iloscPaneli).setBounds(325,30, 50, 20);
		    panelKomentarze.get("panelKomentarze"+iloscPaneli).add(edytuj.get("edytuj"+iloscPaneli));
		  
		    edytuj.get("edytuj"+iloscPaneli).addActionListener(new ActionListener()
			{
			public void actionPerformed(ActionEvent arg0)
			{
				for(int i=0;i<iloscPaneli;i++){
					if(arg0.getSource() == edytuj.get("edytuj"+i)){
						if(text.get("text"+i).isEditable()==false){
							text.get("text"+i).setEditable(true);
							text.get("text"+i).setBackground(Color.white);
						}
						else{
						
						try{
							String password = "njymjmbnnmbn";
						      char[] jkjasd = { 'a', 'd', 'm', 'i', 'n'};
								  password="";
								  for (int k = 0; k < jkjasd.length; k++) {
							    	  password= password+jkjasd[k];
							      }	
								  
							Connection con3 = DriverManager.getConnection(url, user, password); 
						    Statement loginST = con3.createStatement();
						    loginST.execute("USE projektzespolowy");
						   String updateTableSQL = "UPDATE comments SET Comment='"+text.get("text"+i).getText()+"' WHERE Id='"+Integer.parseInt(arg0.getActionCommand())+"'";
						   loginST.execute(updateTableSQL);
						}
						catch(Exception e){
							
						} 
						text.get("text"+i).setBackground(panel.getBackground());
						text.get("text"+i).setEditable(false);
					}
					}
		
				}
	
			}});
		    
		    
		    
		    
		    usun.get("usun"+iloscPaneli).addActionListener(new ActionListener()
			{
			public void actionPerformed(ActionEvent arg0)
			{
				int pomoc = iloscPaneli;
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
				   String updateTableSQL = " DELETE FROM comments WHERE Id='"+Integer.parseInt(arg0.getActionCommand())+"'";
				   loginST.execute(updateTableSQL);
				   
				}
				catch(Exception e){
					
				} 
			     iloscPaneli=0;
	   		     wysokosc=5;
	   		  panel3.setPreferredSize(new Dimension(370,10));
	   			panel3.removeAll();
	   			panel3.repaint();
	   			panel3.revalidate();
	   		  	Wyzeruj();
	   			WczytajDane();
	
			}});
		    
		    
		    text.put("text"+iloscPaneli,new JTextArea());
		    text.get("text"+iloscPaneli).setBackground(panel.getBackground());
		    text.get("text"+iloscPaneli).setEditable(false);
		    text.get("text"+iloscPaneli).setLineWrap(true);
		    text.get("text"+iloscPaneli).setText(Komentarz.getString("Comment"));
		    text.get("text"+iloscPaneli).setBounds(55,5, 250, 45);
		    text.get("text"+iloscPaneli).setForeground(Color.black);
		    panelKomentarze.get("panelKomentarze"+iloscPaneli).add(text.get("text"+iloscPaneli));
		    
		    panel3.setPreferredSize(new Dimension(panel3.getPreferredSize().width,panel3.getPreferredSize().height+60));
			panel3.add(panelKomentarze.get("panelKomentarze"+iloscPaneli));
			iloscPaneli++;
			wysokosc+=60;
		    }
		    Koment.close();

			}
			catch(Exception e){
				System.out.println(e);
			}

	}
	public void Wyzeruj(){
		panelKomentarze.clear();
		text.clear();
		autor.clear();
		usun.clear();
		id.clear();
	}
}
