package gsb.vue;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import gsb.modele.Medecin;
import gsb.modele.Visiteur;
import gsb.modele.dao.MedecinDao;
import gsb.modele.dao.VisiteurDao;

public class JIFTopTrois extends JInternalFrame{
	
	private static final long serialVersionUID = 1L;

	//private ArrayList<Medecin> lesMedecins;
	private ArrayList<Visiteur> diccoVisiteur;


	protected JPanel p;
	protected JScrollPane scrollPane;
	protected JTextField JTcodeMedecin;
	protected JButton JBafficherFiche;
	protected MenuPrincipal fenetreContainer;
	protected JTable table;

	public JIFTopTrois(MenuPrincipal uneFenetreContainer) {

		fenetreContainer = uneFenetreContainer;
		// récupération des données Medecin dans la collection
		//lesMedecins = MedecinDao.retournerCollectionDesMedecins();

		//int nbLignes = lesMedecins.size();
		diccoVisiteur = VisiteurDao.retournerDictionnaireDesVisiteur("2000-01-06", "2008-12-01");
		//diccoVisiteur = new ArrayList<Visiteur>();
		//diccoVisiteur.add(new Visiteur("vis", "vin", "cent" , "", "", "", null, "", 0, "", ""));
		int nbLignes= diccoVisiteur.size();
		
		p = new JPanel(); // panneau principal de la fenêtre

		int i=0;
		String[][] data = new String[nbLignes][5] ;
		//for(Medecin unMedecin : lesMedecins){
		
		for (Visiteur uneEntree : diccoVisiteur){
			data[i][0] = String.valueOf(i+1);
			data[i][1] = uneEntree.getMatricule();
			data[i][2] = uneEntree.getNom();
			data[i][3] = uneEntree.getPrenom();
			data[i][4] = String.valueOf(uneEntree.getNbVisite());
			
			i++;
			}
		String[] columnNames = { "Rang","Matricule","Nom","Prenom","Nombre de Visite"};
		table = new JTable(data, columnNames);
		table.getSelectionModel().addListSelectionListener(table);
		
		scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(400, 200));
		p.add(scrollPane);
		
		JTcodeMedecin = new JTextField(20);
		JTcodeMedecin.setMaximumSize(JTcodeMedecin.getPreferredSize());
		JBafficherFiche = new JButton("Afficher Fiche médecin");
		
		// mise en forme de la fenêtre
		Container contentPane = getContentPane();
		contentPane.add(p);
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
   		if (source == JBafficherFiche){
   			
	}
	}
}
