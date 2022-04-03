package gsb.vue;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gsb.modele.Medicament;
import gsb.service.MedicamentService;


public class JIFMedicamentAdd extends JInternalFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	
	protected JPanel p;
	protected JPanel pSaisie;
	protected JPanel pBouton;
	
	protected JLabel JLdepotlegal;
	protected JLabel JLnomCommercial;
	protected JLabel JLcomposition;
	protected JLabel JLeffets;
	protected JLabel JLcontreIndication;
    protected JLabel JLprixEchantillon;
    protected JLabel JLcodeFamille;
    protected JLabel JLlibelleFamille;
   
    protected JTextField JTdepotlegal;
	protected JTextField JTnomCommercial;
	protected JTextField JTcomposition;
	protected JTextField JTeffets;
	protected JTextField JTcontreIndication;
    protected JTextField JTprixEchantillon;
    protected JTextField JTcodeFamille;
    protected JTextField JTlibelleFamille;
    
    protected JButton JBajouterMedicament;
    protected MenuPrincipal fenetreContainer;
    
    public JIFMedicamentAdd(MenuPrincipal uneFenetreContainer)
    {
    	fenetreContainer = uneFenetreContainer;
    	
    	 JLdepotlegal = new JLabel("Depot Legal");
         JLnomCommercial = new JLabel("Nom");
         JLcomposition = new JLabel("Composition");
         JLeffets = new JLabel("Effets");
         JLcontreIndication = new JLabel("Contre Indication");
         JLprixEchantillon = new JLabel("Prix");
         JLcodeFamille = new JLabel("Code Famille");
         JLlibelleFamille = new JLabel("Libelle Famille");
         
        p = new JPanel();
 		pSaisie = new JPanel(new GridLayout(8,2));
 		pBouton = new JPanel(new GridLayout(1, 1));
 		
 		JTdepotlegal = new JTextField(20);
 		JTdepotlegal.setMaximumSize(JTdepotlegal.getPreferredSize());
        JTnomCommercial = new JTextField(20);
        JTnomCommercial.setMaximumSize(JTnomCommercial.getPreferredSize());
        JTcomposition = new JTextField(20);
        JTcomposition.setMaximumSize(JTcomposition.getPreferredSize());
        JTeffets = new JTextField(20);  
        JTeffets.setMaximumSize(JTeffets.getPreferredSize());
        JTcontreIndication = new JTextField(20);
        JTcontreIndication.setMaximumSize(JTcontreIndication.getPreferredSize());
        JTprixEchantillon = new JTextField(20);
        JTprixEchantillon.setMaximumSize(JTprixEchantillon.getPreferredSize());
        JTcodeFamille = new JTextField(20);
        JTcodeFamille.setMaximumSize(JTcodeFamille.getPreferredSize());
        JTlibelleFamille = new JTextField(20);
        JTlibelleFamille.setMaximumSize(JTlibelleFamille.getPreferredSize());
        JBajouterMedicament = new JButton("Ajouter Medicament");
		JBajouterMedicament.addActionListener(this);
		
		pSaisie.add(JLdepotlegal);
		pSaisie.add(JTdepotlegal);
		pSaisie.add(JLnomCommercial);
		pSaisie.add(JTnomCommercial);
		pSaisie.add(JLcomposition);
		pSaisie.add(JTcomposition);
		pSaisie.add(JLeffets);
		pSaisie.add(JTeffets);
		pSaisie.add(JLcontreIndication);
		pSaisie.add(JTcontreIndication);
		pSaisie.add(JLprixEchantillon);
		pSaisie.add(JTprixEchantillon);
		pSaisie.add(JLcodeFamille);
		pSaisie.add(JTcodeFamille);
		pSaisie.add(JLlibelleFamille);
		pSaisie.add(JTlibelleFamille);
		
		pBouton.add(JBajouterMedicament);
		p.add(pSaisie);
		p.add(pBouton);
		
		Container contentPane = getContentPane();
		contentPane.add(p);
		
    }
    
		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			Object source = arg0.getSource();
			if (source == JBajouterMedicament)
			{
				Medicament unMedicament = new Medicament(JTdepotlegal.getText(), JTnomCommercial.getText(), JTcomposition.getText(), JTeffets.getText(), JTcontreIndication.getText(), Float.valueOf(JTprixEchantillon.getText()), JTcodeFamille.getText(), JTlibelleFamille.getText());
				MedicamentService.ajouterMedicament(unMedicament);
				this.viderText();
			}
		}
		
		public void viderText()
		{
				JTdepotlegal.setText("");
				JTnomCommercial.setText("");
				JTcomposition.setText("");
				JTeffets.setText("");
				JTcontreIndication.setText("");
				JTprixEchantillon.setText("");
				JTcodeFamille.setText("");
				JTlibelleFamille.setText("");
		}
    
}
