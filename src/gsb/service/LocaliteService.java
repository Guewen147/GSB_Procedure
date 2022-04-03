package gsb.service;

import gsb.modele.Localite;
import gsb.modele.dao.LocaliteDao;

public class LocaliteService 
{
	public static Localite rechercherLocalite(String codePostal)
	{
		Localite uneLocalite = null;
		try {
			if (codePostal == null)
			{
				throw new Exception("Code postal non renseigné");
			}
			uneLocalite = LocaliteDao.rechercher(codePostal);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return uneLocalite;
	}
}
