package gsb.tests;

import java.util.ArrayList;

import gsb.modele.Visite;
import gsb.modele.Medicament;
import gsb.modele.dao.OffrirDao;

public class OffrirDaoTest {

	public static void main(String[] args) {
	
		ArrayList<Visite> uneCollecVis = new ArrayList<Visite>();
		uneCollecVis = OffrirDao.retournerListeOffre("APATOUX22");
		for (Visite uneVisite: uneCollecVis) {
			System.out.println(uneVisite.getReference());
	}
		 	System.out.println("_______________________________________________");
		ArrayList<Medicament> uneCollecMedica = new ArrayList<Medicament>();
		uneCollecMedica = OffrirDao.retournerListeMedicament("v0012");
		for (Medicament unMedicament: uneCollecMedica) {
			System.out.println(unMedicament.getDepotLegal());
		}
	
	}
	}

