package gsb.modele.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import gsb.modele.Visite;
import gsb.modele.Visiteur;

public class VisiteurDao {
	
	public static Visiteur rechercher(String codeVisiteur){
		Visiteur unVisiteur = null;
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select * from VISITEUR where MATRICULE ='"+codeVisiteur+"'");
		try {
			if (reqSelection.next()) {
				String unCp = reqSelection.getString(7);
				unVisiteur = new Visiteur(reqSelection.getString(1), reqSelection.getString(2), reqSelection.getString(3), reqSelection.getString(4), reqSelection.getString(5), reqSelection.getString(6), LocaliteDao.rechercher(unCp), reqSelection.getString(8),reqSelection.getInt(11), reqSelection.getString(9), reqSelection.getString(10));
				};
			}
		catch(Exception e) {
			System.out.println("erreur reqSelection.next() pour la requête - select * from VISITEUR where MATRICULE ='"+codeVisiteur+"'");
			e.printStackTrace();
			}
		ConnexionMySql.fermerConnexionBd();
		return unVisiteur;
	}
	
	public static int ajouter(Visiteur unVisiteur)
	{
		int verifAjout = 0;
		try {
			String reqInsert = "insert into VISITEUR values ('"+unVisiteur.getMatricule()+"','"+unVisiteur.getNom()+"','"+unVisiteur.getPrenom()+"','"+unVisiteur.getLogin()+"','"+unVisiteur.getMdp()+"','"+unVisiteur.getAdresse()+"','"+unVisiteur.getUneLocalite().getCodePostal()+"','"+unVisiteur.getDateEntree()+"','"+unVisiteur.getCodeUnite()+"','"+unVisiteur.getNomUnite()+"','"+unVisiteur.getPrime()+"')";
			verifAjout = ConnexionMySql.execReqMaj(reqInsert);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return verifAjout;
	}
	

	public static HashMap<String, Visiteur> retournerCollectionDesVisiteurs()
	{
		HashMap<String, Visiteur> dicVisiteur = new HashMap<String, Visiteur>();
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select * from VISITEUR");
		try {
			while (reqSelection.next()) {
				dicVisiteur.put(reqSelection.getString(1), VisiteurDao.rechercher(reqSelection.getString(1)));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("erreur retourner dicVisiteur");
		}
		ConnexionMySql.fermerConnexionBd();
		return dicVisiteur;
	}

	public static ArrayList<Visiteur> retournerDictionnaireDesVisiteur( String date1 , String date2) {
		
		ArrayList<Visiteur> ListVisiteur = new ArrayList<Visiteur>();
		ResultSet reqSelect = ConnexionSqlServer.execReqSelection("EXEC TopTrois '" +date1+  "','" +date2+ "'");
		try {
			while (reqSelect.next()) {
				Visiteur vis1 = new Visiteur (reqSelect.getString(2), reqSelect.getString(3), reqSelect.getString(4), " "," "," ",null," ",0," "," " );
				vis1.setNbVisite(reqSelect.getInt(1));
				ListVisiteur.add(vis1);
			}
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("erreur");
		}
		
		return ListVisiteur;
	}
}
