package app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PanelUzytkownika {

	PanelUzytkownika(String nazwaUzytkownika){
		JFrame UzytkownikFrame = new JFrame("Uzytkownik");
		UzytkownikFrame.setLayout(null);
		UzytkownikFrame.setResizable(false);
		UzytkownikFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		UzytkownikFrame.setSize(800, 600);
		
		JLabel uzytkownikNazwaL = new JLabel("Witaj: "+nazwaUzytkownika);
		uzytkownikNazwaL.setBounds(600, 10, 100, 25);
		
		JButton wyloguj = new JButton("Wyloguj");
		wyloguj.setBounds(680, 10, 100, 25);
		UzytkownikFrame.add(uzytkownikNazwaL);
		UzytkownikFrame.add(wyloguj);
		UzytkownikFrame.setVisible(true);
		
		wyloguj.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent arg0)
		{
			//FUNKCJONALNOSC NR 3 - dodawanie trasy 
			new Logowanie();
			UzytkownikFrame.dispose();
		}});
	}
}
