package gsb.tests;

import java.util.ArrayList;

import gsb.modele.Medicament;
import gsb.modele.Visiteur;
import gsb.modele.dao.StockerDao;

public class StockerDaoTest {
	
	public static void main(String[] arg) {
	
	ArrayList<Medicament> uneCollecMedicament = new ArrayList<Medicament>();
	uneCollecMedicament = StockerDao.retournerListeStock("e49");
	for (Medicament unMedicament : uneCollecMedicament) {
		System.out.println(unMedicament.getNomCommercial());
	}
	System.out.println("_______________________________________________");
	
	ArrayList<Visiteur> uneCollecVisiteur = new ArrayList<Visiteur>();
	uneCollecVisiteur = StockerDao.retournerListeVisiteur("APATOUX22");
	for (Visiteur unVisiteur : uneCollecVisiteur) {
		System.out.println(unVisiteur.getNom());
	}
}
}
