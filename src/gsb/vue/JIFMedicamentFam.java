package gsb.vue;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionListener;

import gsb.modele.Medicament;
import gsb.modele.dao.MedicamentDao;
import gsb.service.MedicamentService;

public class JIFMedicamentFam extends JInternalFrame  implements ActionListener {

		private static final long serialVersionUID = 1L;
		
		private HashMap<String, Medicament> dicMedicament;
		
		protected JPanel p;
		protected JPanel pButton;
		protected JScrollPane scrollPane;
		protected JPanel pSaisie;
		protected JTextField JTCodeFam;
		protected JButton JBrechercher;
		protected JButton JBfermer;
		protected MenuPrincipal fenetreContainer;
		protected JTable table;
		protected JLabel JLFam;
		
		
		public JIFMedicamentFam(MenuPrincipal uneFenetreContainer, String ohana) {
		
			fenetreContainer = uneFenetreContainer;
			
			p = new JPanel();
			pSaisie = new JPanel(new GridLayout(1, 3));
			JLFam = new JLabel("Famille");
			JLFam.setSize(new Dimension(5, 5));
			JTCodeFam = new JTextField(15);
			JBrechercher = new JButton("Rechercher");
			JBrechercher.addActionListener(this);
			pSaisie.add(JLFam);
			pSaisie.add(JTCodeFam);
			pSaisie.add(JBrechercher);
			p.add(pSaisie);
			
			dicMedicament = MedicamentService.rechercherListeMedicamentFam(ohana);
			int nbLignes = dicMedicament.size();
			int i=0;
			String [][] data = new String[nbLignes][5];
			
			for(Map.Entry<String, Medicament> unMedicament : dicMedicament.entrySet())
			{
				data[i][0] = unMedicament.getValue().getDepotLegal();
				data[i][1] = unMedicament.getValue().getNomCommercial();
				data[i][2] = unMedicament.getValue().getComposition();
				data[i][3] = unMedicament.getValue().getEffets();
				data[i][4] = unMedicament.getValue().getContreIndication();
				i++;
			}
			String[] columnNames = {"Depot Legal", "Nom", "Composition", "Effets", "Contre Indication"}; 
			
			table = new JTable(data, columnNames);
			
			scrollPane = new JScrollPane(table);
			scrollPane.setPreferredSize(new Dimension(400, 200));
			p.add(scrollPane);
			
			pButton = new JPanel(new GridLayout(1, 1));
			JBfermer = new JButton("Fermer");
			JBfermer.addActionListener(this);
			pButton.add(JBfermer);
			
			p.add(pButton);
			
			Container contentPane = getContentPane();
			contentPane.add(p);
		}
		
		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			Object source = arg0.getSource();
			if (source == JBrechercher)
			{
				fenetreContainer.ouvrirFenetre(new JIFMedicamentFam(fenetreContainer, JTCodeFam.getText()));
			}
			
			if (source == JBfermer)
			{
				this.dispose();
			}
		}
}
