package app;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class PanelAdmina {
	String nazwaU;
	void NazwaUzytkownika(String nazwaUzytkownika){
		nazwaU=nazwaUzytkownika;
	}
	PanelAdmina(){
		JFrame AdminFrame = new JFrame("Admin");
		AdminFrame.setLayout(null);
		AdminFrame.setResizable(false);
		AdminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		AdminFrame.setSize(800, 600);
		//dodanie guzika "dodaj Trase"
		ImageIcon dodajTraseI = null;
		    try {
		    	dodajTraseI = new ImageIcon("res/dodajTrase.png");
		    	
		    } catch (Exception e) {
		        System.err.println("load error: " + e.getMessage());
		    }
		JButton dodajTraseB = new JButton("Dodaj trasê!",dodajTraseI);
		Border border = new LineBorder( null, 1);
		dodajTraseB.setBorder(border);
		dodajTraseB.setVerticalTextPosition(SwingConstants.BOTTOM);
		dodajTraseB.setHorizontalTextPosition(SwingConstants.CENTER);
		dodajTraseB.setBounds(100, 100, 150, 170);
		
		
		
		ImageIcon edytujTraseI = null;
	    try {
	    	edytujTraseI = new ImageIcon("res/edytujTrase.png");
	    	
	    } catch (Exception e) {
	        System.err.println("load error: " + e.getMessage());
	    }
		JButton edytujTraseB = new JButton("edytuj trasê",edytujTraseI);
		edytujTraseB.setBorder(border);
		edytujTraseB.setVerticalTextPosition(SwingConstants.BOTTOM);
		edytujTraseB.setHorizontalTextPosition(SwingConstants.CENTER);
		edytujTraseB.setBounds(270, 100, 150, 170);
		
		JButton wyloguj = new JButton("Wyloguj");
		wyloguj.setBounds(680, 10, 100, 25);
		
		
		
		//dodanie komponentow do admin frame
		AdminFrame.add(wyloguj);
		AdminFrame.add(edytujTraseB);
		AdminFrame.add(dodajTraseB);
		AdminFrame.setVisible(true);
		//zmiana koloru po najechaniu i zjechaniu myszka na button dodajTraseB
		dodajTraseB.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	dodajTraseB.setBackground(Color.lightGray);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	dodajTraseB.setBackground(UIManager.getColor("control"));
		    }
		});
		//listener do klikniecia buttona dodajTraseB
		dodajTraseB.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent arg0)
		{
			//FUNKCJONALNOSC NR 3 - dodawanie trasy 
			
			DodanieTrasy();
	
		}});
		
		wyloguj.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent arg0)
		{
			//FUNKCJONALNOSC NR 3 - dodawanie trasy 
			new Logowanie();
			AdminFrame.dispose();
		}});
		
		edytujTraseB.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent arg0)
		{
			//FUNKCJONALNOSC NR 3 - dodawanie trasy 
			EdytujTrase();
		}});
		
		

	}
	//FUNKCJONALNOSC NR 3 - dodawanie trasy 
	void DodanieTrasy(){
		JFrame DodawanieTrasyFrame = new JFrame("Nowa trasa");
		DodawanieTrasyFrame.setSize(250, 250);
		DodawanieTrasyFrame.setLocationRelativeTo(null);
		DodawanieTrasyFrame.setVisible(true);
		System.out.println("Dodawanie trasy");
	}
	void EdytujTrase(){
		System.out.print("edytuj trase");
	}
}
