package gsb.service;

import java.util.ArrayList;
import gsb.modele.Visite;
import gsb.modele.Medicament;
import gsb.modele.dao.OffrirDao;

public class OffrirService 
{
	public static ArrayList<Visite> retournerListeOffre(String codeMedicament)
	{
		ArrayList<Visite> colListeOffre = new ArrayList<Visite>();
		try {
			if (codeMedicament == null) 
			{
				throw new Exception("Code medicament non renseigné");
			}
			colListeOffre = OffrirDao.retournerListeOffre(codeMedicament);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return colListeOffre;
	}
	
	public static ArrayList<Medicament> retournerListeMedicament(String codeVisite)
	{
		ArrayList<Medicament> colMedicament = new ArrayList<Medicament>();
		try {
			if (codeVisite == null)
			{
				throw new Exception("Code visite non renseigné");
			}
			colMedicament = OffrirDao.retournerListeMedicament(codeVisite);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return colMedicament;
	}
}
