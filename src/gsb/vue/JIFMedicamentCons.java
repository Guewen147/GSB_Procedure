package gsb.vue;

import java.awt.Container;
import java.awt.Dimension;
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
import gsb.service.MedicamentService;

public class JIFMedicamentCons extends JInternalFrame  implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private HashMap<String, Medicament> dicMedicament;
	
	protected JPanel p;
	protected JScrollPane scrollPane;
	protected JPanel pSaisie;
	protected JTextField JTdepotLegalMedic;
	protected JButton JBafficherFiche;
	protected MenuPrincipal fenetreContainer;
	protected JTable table;
	
	public JIFMedicamentCons(MenuPrincipal uneFenetreContainer) {
	
		fenetreContainer = uneFenetreContainer;
		dicMedicament = MedicamentService.retournerListeMedicament();
		int nbLignes = dicMedicament.size();
		
		p = new JPanel();
		
		int i=0;
		String [][] data = new String[nbLignes][3];
		
		for(Map.Entry<String, Medicament> unMedicament : dicMedicament.entrySet())
		{
			data[i][0] = unMedicament.getValue().getDepotLegal();
			data[i][1] = unMedicament.getValue().getNomCommercial();
			data[i][2] = unMedicament.getValue().getLibelleFamille();
			i++;
		}
		String[] columnNames = {"Depot Legal", "Nom", "Famille"};
		table = new JTable(data, columnNames);
		table.getSelectionModel().addListSelectionListener(table);
		
		scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(400, 200));
		p.add(scrollPane);
		
		pSaisie = new JPanel();
		JTdepotLegalMedic = new JTextField(20);
		JTdepotLegalMedic.setMaximumSize(JTdepotLegalMedic.getPreferredSize());
		JBafficherFiche = new JButton("Afficher Fiche Medicament");
		JBafficherFiche.addActionListener(this);
		pSaisie.add(JTdepotLegalMedic);
		pSaisie.add(JBafficherFiche);
		p.add(pSaisie);
		
		Container contentPane = getContentPane();
		contentPane.add(p);
	}
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		Object source = arg0.getSource();
		if (source == JBafficherFiche)
		{
			if (dicMedicament.containsKey(JTdepotLegalMedic.getText())){
				Medicament unMedicament = dicMedicament.get(JTdepotLegalMedic.getText());
				fenetreContainer.ouvrirFenetre(new JIFMedicamentFiche(unMedicament));
			}
		}
		if (source == table)
		{
			JTdepotLegalMedic.setText((String)table.getValueAt(table.getSelectedRow(), table.getSelectedColumn()));
		}
	}
}

