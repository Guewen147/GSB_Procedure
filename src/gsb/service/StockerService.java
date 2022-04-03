package gsb.service;

import gsb.modele.dao.StockerDao;
import gsb.modele.Visiteur;
import java.util.ArrayList;
import gsb.modele.Medicament;

public class StockerService 
{
	public static ArrayList<Medicament> retournerListeStock (String codeVisiteur)
	{
		ArrayList<Medicament> colListeStock = new ArrayList<Medicament>();
		try {
			if (codeVisiteur == null) {
				throw new Exception("Code visiteur non renseigné");
			}
			colListeStock = StockerDao.retournerListeStock(codeVisiteur);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return colListeStock;
	}
	
	public static ArrayList<Visiteur> retournerListeVisiteur (String codeMed)
	{
		ArrayList<Visiteur> colVisiteur = new ArrayList<Visiteur>();
		try {
			if (codeMed == null)
			{
				throw new Exception("Code medicament non renseigné");
			}
			colVisiteur = StockerDao.retournerListeVisiteur(codeMed);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return colVisiteur;
	}
}
