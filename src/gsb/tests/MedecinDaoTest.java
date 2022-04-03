/*
 * Créé le 3 mars 2015
 *
 * TODO Pour changer le modèle de ce fichier généré, allez à :
 * Fenêtre - Préférences - Java - Style de code - Modèles de code
 */
package gsb.tests;

import gsb.modele.Medecin;
import gsb.modele.dao.MedecinDao;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Isabelle
 * 3 mars 2015
 * TODO Pour changer le modèle de ce commentaire de type généré, allez à :
 * Fenêtre - Préférences - Java - Style de code - Modèles de code
 */
public class MedecinDaoTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Medecin unMedecin = MedecinDao.rechercher("m001");
		System.out.println(unMedecin.getCodeMed());
		System.out.println(unMedecin.getNom());
		System.out.println(unMedecin.getPrenom());
		System.out.println(unMedecin.getAdresse());
		System.out.println(unMedecin.getLaLocalite().getCodePostal());
		System.out.println(unMedecin.getTelephone());
		System.out.println(unMedecin.getPotentiel());
		System.out.println(unMedecin.getSpecialite());
		
		System.out.println("______________________________________");
		HashMap<String,Medecin> unDicco = new HashMap<String,Medecin>();
		unDicco =	MedecinDao.retournerDictionnaireDesMedecins();
		if (unDicco.containsKey("m002")){
			System.out.println(unDicco.get("m002").getNom());
		}
		System.out.println("______________________________________");
		ArrayList<Medecin> uneCollec = new ArrayList<Medecin>();
		uneCollec = MedecinDao.retournerCollectionDesMedecins();
		for (Medecin leMedecin: uneCollec) {
			System.out.println(leMedecin.getNom());
		}
		
		
   
	}

}
