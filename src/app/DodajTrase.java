package app;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

public class DodajTrase {
	
	int liczbaStacji =0;
	int lastid=0 ;
	
	
	DodajTrase(){
		JFrame DodawanieTrasyFrame = new JFrame("Nowa trasa");
		DodawanieTrasyFrame.setSize(600, 600);
		DodawanieTrasyFrame.setLocationRelativeTo(null);
		DodawanieTrasyFrame.setVisible(true);
		DodawanieTrasyFrame.setLayout(null);
		System.out.println("Dodawanie trasy");
		DodawanieTrasyFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		

		JLabel skadL = new JLabel("Sk¹d");
		skadL.setBounds(1, 1, 100, 25);
		JLabel dokadL = new JLabel("Dokad");
		dokadL.setBounds(1, 100, 100, 25);
		
		JTextArea skadText = new JTextArea();
		skadText.setBounds(10, 50, 150, 25);
		
		JTextArea dokadText = new JTextArea();
		dokadText.setBounds(10, 150, 150, 25);
		
		JButton dodajTraseB = new JButton("Dodaj trase");
		dodajTraseB.setBounds(10, 200, 100, 100);
		
		DefaultTableModel model = new DefaultTableModel(new Object[][] {
			      },
			      new Object[] { "Nazwa stacji", "Numer" });

	      JTable table = new JTable(model);
	      for (int c = 0; c < table.getColumnCount(); c++)
	      {
	          Class<?> col_class = table.getColumnClass(c);
	          table.setDefaultEditor(col_class, null);       
	      }
	      JScrollPane scroll = new JScrollPane(table);
	      scroll.setBounds(200, 100, 200, 200);
		table.setBounds(100, 100, 200, 200);
		//JScrollPane scrollPane = new JScrollPane(table);
	//	scrollPane.setBounds(200, 100, 300, 300);
		//scrollPane.add(table);
		DodawanieTrasyFrame.add(scroll);
		
		
		
		
		JButton kolejnaStacjaB = new JButton("Dodaj stacje");
		kolejnaStacjaB.setBounds(300, 400, 200, 25);
		
		/*JTable table = new JTable(ustalmodel2());
		JScrollPane scrollPane = new JScrollPane();
		 table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		   table.setShowGrid(false);
		    scrollPane = new JScrollPane(table);
		    scrollPane.setViewportView(table);
			scrollPane.setVisible(true);
		     for (int c = 0; c < table.getColumnCount(); c++)
		     {
		         Class<?> col_class = table.getColumnClass(c);
		         table.setDefaultEditor(col_class, null);
		     }
		     

		
		     scrollPane.setBounds(100, 100, 500, 400);
		
		     DodawanieTrasyFrame.add(scrollPane);*/
		DodawanieTrasyFrame.add(kolejnaStacjaB);
	  //  DodawanieTrasyFrame.add(table);
		DodawanieTrasyFrame.add(dodajTraseB);
		DodawanieTrasyFrame.add(skadL);
		DodawanieTrasyFrame.add(dokadL);
		DodawanieTrasyFrame.add(skadText);
		DodawanieTrasyFrame.add(dokadText);
		
	
		
		dodajTraseB.addActionListener(new ActionListener()
		{
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
		/*	 String url = "jdbc:mysql://www.db4free.net:3306/projektzespolowy";
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
		    String updateTableSQL = " INSERT INTO routes"
    				+ " (A,B)"
    				+ " VALUES('"+skadText.getText()+"','"+dokadText.getText()+"')";
		    		loginST.execute(updateTableSQL);

		   ResultSet  jakieID = loginST.executeQuery("SELECT MAX(route_id) AS route_id FROM routes");

		   if(jakieID.next()){
			   lastid = jakieID.getInt("route_id");
			   System.out.print(lastid);
		   }
		   
		  for(int i=0;i<table.getModel().getRowCount();i++){
				  String updateTableSQL2 = " INSERT INTO routes_stops"
			   				+ " (route_id,name,nr)"
			   				+ " VALUES('"+lastid+"','"+table.getModel().getValueAt(i, 0)+"','"+table.getModel().getValueAt(i, 1)+"')";
					    		loginST.execute(updateTableSQL2); 
			  
		  }
		//   table.getModel().getValueAt(arg0, arg1)

		   
		   
		   
		    		
			}
			catch(Exception e){
				System.out.println(e);
			}
			
			
			DodawanieTrasyFrame.dispose();
			}});
	
		kolejnaStacjaB.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent arg0)
		{
		    String message = "Dodaj kolejny przystanek";
		    String text = JOptionPane.showInputDialog(DodawanieTrasyFrame, message);
		    if (text == null) {
		    }
		    else{
		    	liczbaStacji++;
		    	model.addRow(new Object[]{text,liczbaStacji});
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
	}
}
