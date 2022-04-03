package gsb.tests;

import gsb.modele.Medicament;
import gsb.modele.dao.MedicamentDao;


public class MedicamentDaoTest {
	
	public static void main(String[] args) {
		
		Medicament unMedicament = MedicamentDao.rechercher("3MYC7");
		System.out.println(unMedicament.getDepotLegal());
		System.out.println(unMedicament.getNomCommercial());
		System.out.println(unMedicament.getComposition());
		System.out.println(unMedicament.getEffets());
		System.out.println(unMedicament.getContreIndication());
		System.out.println(unMedicament.getPrixEchantillon());
		System.out.println(unMedicament.getCodeFamille());
		System.out.println(unMedicament.getLibelleFamille());
	
	    Medicament unMedicament1= new Medicament("TOPL01", "Toplexil","citrate de sodium, arôme composé caramel" , "Reduit l irritation de la gorge", "interdit pour les Femmes enceinte", 3.24 , "SIR", "SIROP");
	    System.out.println(MedicamentDao.ajouter(unMedicament1));
	    
	}
}
