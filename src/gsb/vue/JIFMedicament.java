package gsb.vue;

import gsb.modele.Medecin;
import gsb.modele.Medicament;
import gsb.modele.dao.MedecinDao;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JIFMedicament extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;
	protected JPanel p;  
	protected JPanel pTexte;
	protected JPanel pBoutons;
	
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
    
    public JIFMedicament() {
    	p = new JPanel();  
        pBoutons = new JPanel();
        pTexte = new JPanel(new GridLayout(9,2));
        
        JLdepotlegal = new JLabel("Depot Legal");
        JLnomCommercial = new JLabel("Nom");
        JLcomposition = new JLabel("Composition");
        JLeffets = new JLabel("Effets");
        JLcontreIndication = new JLabel("Contre Indication");
        JLprixEchantillon = new JLabel("Prix");
        JLcodeFamille = new JLabel("Code Famille");
        JLlibelleFamille = new JLabel("Libelle Famille");
        
        JTdepotlegal = new JTextField(20);
        JTdepotlegal.setMaximumSize(JTdepotlegal.getPreferredSize());
        JTnomCommercial = new JTextField(20);
        JTcomposition = new JTextField(20);
        JTeffets = new JTextField();    
        JTcontreIndication = new JTextField();
        JTprixEchantillon = new JTextField();
        JTcodeFamille = new JTextField();
        JTlibelleFamille = new JTextField();
        
        pTexte.add(JLdepotlegal);
        pTexte.add(JTdepotlegal);
        pTexte.add(JLnomCommercial);
        pTexte.add(JTnomCommercial);
        pTexte.add(JLcomposition);
        pTexte.add(JTcomposition);
        pTexte.add(JLeffets);
        pTexte.add(JTeffets);
        pTexte.add(JLcontreIndication);
        pTexte.add(JTcontreIndication);
        pTexte.add(JLprixEchantillon);
        pTexte.add(JTprixEchantillon);
        pTexte.add(JLcodeFamille);
        pTexte.add(JTcodeFamille);
        pTexte.add(JLlibelleFamille);
        pTexte.add(JTlibelleFamille);
       
        p.add(pTexte);
        p.add(pBoutons);
        Container contentPane = getContentPane();
        contentPane.add(p);
    }
    
        
        public void remplirText(Medicament unMedicament) 	
        {  
            JTdepotlegal.setText(unMedicament.getDepotLegal());        
            JTnomCommercial.setText(unMedicament.getNomCommercial());
            JTcomposition.setText(unMedicament.getComposition());
            JTeffets.setText(unMedicament.getEffets());    
            JTcontreIndication.setText(unMedicament.getContreIndication());
            JTprixEchantillon.setText(String.valueOf(unMedicament.getPrixEchantillon()));
            JTcodeFamille.setText(unMedicament.getCodeFamille());
            JTlibelleFamille.setText(unMedicament.getLibelleFamille());
           
         }
        
        public void viderText() 	
        {  // méthode qui permet de vider les zones de texte 
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
