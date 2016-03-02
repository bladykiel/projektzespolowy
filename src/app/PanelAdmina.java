package app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

public class PanelAdmina {
	String nazwaU;
	void NazwaUzytkownika(String nazwaUzytkownika){
		nazwaU=nazwaUzytkownika;
	}
	PanelAdmina(String nazwaUzytkownika,Point punkt){
		JFrame AdminFrame = new JFrame("Admin");
		Color kolorTla = new Color(50,88,145);
		//AdminFrame.setLayout(null);
		//AdminFrame.setResizable(false);
		AdminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		AdminFrame.setSize(350, 500);
		AdminFrame.getContentPane().setBackground(kolorTla);
		((JComponent) AdminFrame.getContentPane()).setBorder(new EmptyBorder(5, 10, 10, 10)); //dodanie obramowania dla frame
		AdminFrame.setLocation(punkt); //Ustawienie Frame'a w miejscu poprzedniego
		//dodanie guzików, labelów, obrazków itd itd
		ImageIcon dodajTraseI = null;
		    try {
		    	dodajTraseI = new ImageIcon(getClass().getResource("/img/dodajTrase.png"));
		    	
		    } catch (Exception e) {
		        System.err.println("load error: " + e.getMessage());
		    }
		JButton dodajTraseB = new JButton("Dodaj trasê!",dodajTraseI);
		Border border = new LineBorder( null, 1);
		dodajTraseB.setBorder(border);
		dodajTraseB.setVerticalTextPosition(SwingConstants.BOTTOM);
		dodajTraseB.setHorizontalTextPosition(SwingConstants.CENTER);
		dodajTraseB.setBounds(100, 100, 150, 170);
		dodajTraseB.setBackground(null);
		dodajTraseB.setBorder(null);			
		
		JLabel uzytkownikNazwaL = new JLabel("Witaj: "+nazwaUzytkownika);
		uzytkownikNazwaL.setForeground(Color.white);
		ImageIcon edytujTraseI = null;
	    try {
	    	edytujTraseI = new ImageIcon(getClass().getResource("/img/edytujTrase.png"));
	    	
	    } catch (Exception e) {
	        System.err.println("load error: " + e.getMessage());
	    }
		JButton edytujTraseB = new JButton("edytuj trasê",edytujTraseI);
		edytujTraseB.setBorder(border);
		edytujTraseB.setVerticalTextPosition(SwingConstants.BOTTOM);
		edytujTraseB.setHorizontalTextPosition(SwingConstants.CENTER);
		edytujTraseB.setBounds(270, 100, 150, 170);
		edytujTraseB.setBackground(null);
		edytujTraseB.setBorder(null);				
		ImageIcon wyszukajTraseI = null;
	    try {
	    	wyszukajTraseI = new ImageIcon(getClass().getResource("/img/wyszukajTrase.png"));
	    	
	    } catch (Exception e) {
	        System.err.println("load error: " + e.getMessage());
	    }
		JButton wyszukajTraseB = new JButton("Wyszukaj trasê",wyszukajTraseI);
		wyszukajTraseB.setBorder(border);
		wyszukajTraseB.setVerticalTextPosition(SwingConstants.BOTTOM);
		wyszukajTraseB.setHorizontalTextPosition(SwingConstants.CENTER);
		wyszukajTraseB.setBounds(440, 100, 150, 170);
		wyszukajTraseB.setBackground(null);
		wyszukajTraseB.setBorder(null);		
		
		ImageIcon usersI = null;
	    try {
	    	usersI = new ImageIcon(getClass().getResource("/img/users.png"));
	    	
	    } catch (Exception e) {
	        System.err.println("load error: " + e.getMessage());
	    }
		JButton usersB = new JButton("Zarz¹dzaj u¿ytkownikami",usersI);
		usersB.setBorder(border);
		usersB.setVerticalTextPosition(SwingConstants.BOTTOM);
		usersB.setHorizontalTextPosition(SwingConstants.CENTER);
		usersB.setBounds(440, 100, 150, 170);
		usersB.setBackground(null);
		usersB.setBorder(null);
		JButton wyloguj = new JButton("Wyloguj");
		wyloguj.setBounds(680, 10, 100, 25);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 140, AdminFrame.getWidth()-35,185);
		panel.setBackground(new Color(220,220,220));
	//	panel.setLayout(null);
		panel.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		
	 	JMenuBar menuBar = new JMenuBar();
		JMenu trasaMenu = new JMenu("Trasa");
		trasaMenu.setMnemonic(KeyEvent.VK_F);
		menuBar.add(trasaMenu);
		JMenuItem wylogujMenu = new JMenuItem("Wyloguj");
		wylogujMenu.setSize(50,25);
		JMenuItem dodajTraseMenu = new JMenuItem("Dodaj trasê", KeyEvent.VK_N);
		trasaMenu.add(dodajTraseMenu);
		menuBar.add(wylogujMenu);
	// Dodanie rzeczy do panelu
		panel.add(dodajTraseB);
		panel.add(edytujTraseB);
		panel.add(wyszukajTraseB);
		panel.add(usersB);
	//dodanie komponentow do admin frame
		AdminFrame.add(uzytkownikNazwaL,BorderLayout.NORTH);
		AdminFrame.add(panel,BorderLayout.CENTER);
		AdminFrame.setJMenuBar(menuBar);
		AdminFrame.setVisible(true);
	//zmiana koloru po najechaniu i zjechaniu myszka na button dodajTraseB
		dodajTraseB.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	dodajTraseB.setBackground(kolorTla);
		    	dodajTraseB.setForeground(Color.WHITE);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	dodajTraseB.setBackground(null);
		    	dodajTraseB.setForeground(Color.black);
		    }
		});
		wyszukajTraseB.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	wyszukajTraseB.setBackground(kolorTla);
		    	wyszukajTraseB.setForeground(Color.WHITE);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	wyszukajTraseB.setBackground(null);
		    	wyszukajTraseB.setForeground(Color.black);
		    }
		});
		usersB.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	usersB.setBackground(kolorTla);
		    	usersB.setForeground(Color.WHITE);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	usersB.setBackground(null);
		    	usersB.setForeground(Color.black);
		    }
		});
		edytujTraseB.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	edytujTraseB.setBackground(kolorTla);
		    	edytujTraseB.setForeground(Color.WHITE);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	edytujTraseB.setBackground(null);
		    	edytujTraseB.setForeground(Color.black);
		    }
		});
	//listeney do klikniecia buttona
		dodajTraseMenu.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent arg0)
		{
		
			DodanieTrasy(AdminFrame);
		}});
		
		dodajTraseB.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent arg0)
		{
			DodanieTrasy(AdminFrame);
		}});
		
		wylogujMenu.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent arg0)
		{
			new Logowanie();
			AdminFrame.dispose();
		}});
		
		edytujTraseB.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent arg0)
		{
			EdytujTrase();
		}});
	}
//FUNKCJONALNOSC NR 3 - dodawanie trasy 
	void DodanieTrasy(JFrame AdminFrame){
		new DodajTrase();		
	}
//Koniec funkcjonalnosci nr 3
//-------------------------------------------------------------
//FUNKCJONALNOSC NR 4 - edycja trasy
	void EdytujTrase(){
		System.out.print("edytuj trase");
	}
//Koniec funkcjonalnosci nr 4	
}
