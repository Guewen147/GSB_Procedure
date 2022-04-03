package gsb.service;

import java.util.ArrayList;
import java.util.HashMap;

import gsb.modele.Visite;
import gsb.modele.dao.VisiteDao;

public class VisiteService 
{
	public static Visite rechercherVisite(String reference)
	{
		Visite uneVisite = null;
		try {
			if (reference == null)
			{
				throw new Exception("Reference de la visite non renseignées");
			}
			uneVisite = VisiteDao.rechercher(reference);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return uneVisite;
	}
	
	public static int ajouterVisite(Visite uneVisite)
	{
		int resultat = 0;
		try {
			if (uneVisite == null)
			{
				throw new Exception("Visite manquante");
			}
			resultat = VisiteDao.ajouter(uneVisite);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return resultat;
	}
	
	public static int modifierVisite(Visite uneVisite)
	{
		int resultat = 0;
		try {
			if (uneVisite == null)
			{
				throw new Exception("Visite à modifier non renseignée");
			}
			resultat = VisiteDao.modifier(uneVisite);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return resultat;
	}
	
	public static HashMap<String, Visite> retournerCollectionVisites()
	{
		HashMap<String, Visite> colVisite = new HashMap<String, Visite>();
		colVisite = VisiteDao.retournerCollectionVisites();
		return colVisite;
	}
}
