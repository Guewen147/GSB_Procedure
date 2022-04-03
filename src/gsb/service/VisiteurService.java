package gsb.service;

import java.util.ArrayList;
import java.util.HashMap;

import gsb.modele.Visite;
import gsb.modele.Visiteur;
import gsb.modele.dao.VisiteDao;
import gsb.modele.dao.VisiteurDao;

public class VisiteurService 
{
	public static Visiteur rechercherVisiteur(String codeVisiteur)
	{
		Visiteur unVisiteur = null;
		try {
			if (codeVisiteur == null)
			{
				throw new Exception("Code visiteur non renseigné");
			}
			unVisiteur = VisiteurDao.rechercher(codeVisiteur);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return unVisiteur;
	}
	
	public static int ajouterVisiteur(Visiteur unVisiteur)
	{
		int succesAjout = 0;
		try {
			if (unVisiteur == null)
			{
				throw new Exception("Aucun Visiteur renseigné");
			}
			succesAjout = VisiteurDao.ajouter(unVisiteur);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return succesAjout;
	}
	
	public static HashMap<String, Visiteur> retournerCollectionVisiteur()
	{
		HashMap<String, Visiteur> dicVisiteur = new HashMap<String, Visiteur>();
		dicVisiteur = VisiteurDao.retournerCollectionDesVisiteurs();
		return dicVisiteur;
	}
}
