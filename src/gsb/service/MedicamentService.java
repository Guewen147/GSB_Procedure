package gsb.service;

import java.util.HashMap;

import gsb.modele.Medicament;
import gsb.modele.dao.MedicamentDao;

public class MedicamentService 
{
	public static Medicament rechercherMedicament(String codeMedicament)
	{
		Medicament unMedicament = null;
		try{
			if (codeMedicament == null)
			{
				throw new Exception("Code Medicament non renseigné");
			}
			unMedicament = MedicamentDao.rechercher(codeMedicament);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return unMedicament;
	}
	
	public static int ajouterMedicament(Medicament unMedicament)
	{
		int resultat = 0;
		try {
			if (unMedicament == null)
			{
				throw new Exception("Medicament à ajouter non renseigné");
			}
			resultat = MedicamentDao.ajouter(unMedicament);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return resultat;
	}
	
	public static HashMap<String, Medicament> retournerListeMedicament()
	{
		HashMap<String, Medicament> dicMedicament = new HashMap<String, Medicament>();
		dicMedicament = MedicamentDao.retournerMedicament();
		return dicMedicament;
	}
	
	public static HashMap<String, Medicament> rechercherListeMedicamentFam(String codeFam)
	{
		HashMap<String, Medicament> dicMedic = new HashMap<String, Medicament>();
		try
		{
			if (codeFam == null)
			{
				throw new Exception("Code famille non reseigné");
			}
			dicMedic = MedicamentDao.retournerMedicamentParFamille(codeFam);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return dicMedic;
	}
}
