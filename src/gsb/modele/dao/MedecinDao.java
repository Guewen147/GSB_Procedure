/*
 * Créé le 22 févr. 2015
 *
 * TODO Pour changer le modèle de ce fichier généré, allez à :
 * Fenêtre - Préférences - Java - Style de code - Modèles de code
 */
package gsb.modele.dao;

import gsb.modele.Localite;
import gsb.modele.Medecin;
import gsb.modele.Visiteur;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;



/**
 * @author Isabelle
 * 22 févr. 2015
 * TODO Pour changer le modèle de ce commentaire de type généré, allez à :
 * Fenêtre - Préférences - Java - Style de code - Modèles de code
 */
public class MedecinDao {
	
	public static Medecin rechercher(String codeMedecin){
		Medecin unMedecin=null;
		Localite uneLocalite= null;
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select * from MEDECIN where CODEMED ='"+codeMedecin+"'");
		try {
			if (reqSelection.next()) {
				uneLocalite = LocaliteDao.rechercher(reqSelection.getString(5));
				unMedecin = new Medecin(reqSelection.getString(1), reqSelection.getString(2), reqSelection.getString(3), reqSelection.getString(4), uneLocalite, reqSelection.getString(6), reqSelection.getString(7), reqSelection.getString(8) );	
			};
			}
		catch(Exception e) {
			System.out.println("erreur reqSelection.next() pour la requête - select * from MEDECIN where CODEMED ='"+codeMedecin+"'");
			e.printStackTrace();
			}
		ConnexionMySql.fermerConnexionBd();
		return unMedecin;
	}
	
	public static ArrayList<Medecin> retournerCollectionDesMedecins(){
		ArrayList<Medecin> collectionDesMedecins = new ArrayList<Medecin>();
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select * from MEDECIN");
		try{
		while (reqSelection.next()) {
			String codeMedecin = reqSelection.getString(1);
		    collectionDesMedecins.add(MedecinDao.rechercher(codeMedecin));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erreur retournerCollectionDesMedecins()");
		}
		return collectionDesMedecins;
	}
	
	public static HashMap<String,Medecin> retournerDictionnaireDesMedecins(){
		HashMap<String, Medecin> diccoDesMedecins = new HashMap<String, Medecin>();
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select CODEMED from MEDECIN");
		try{
		while (reqSelection.next()) {
			String codeMedecin = reqSelection.getString(1);
		    diccoDesMedecins.put(codeMedecin, MedecinDao.rechercher(codeMedecin));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erreur retournerDiccoDesMedecins()");
		}
		return diccoDesMedecins;
	}
	
	

	public static ArrayList<Medecin> retournerDictionnaireMedecin12( String date1) {

        ArrayList<Medecin> ListeMedecin = new ArrayList<Medecin>();
        ResultSet reqSelect = ConnexionSqlServer.execReqSelection("EXEC VisitePrioritaire12 '" +date1+  "'");
        try {
            while (reqSelect.next()) {
                Medecin med1 = new Medecin (reqSelect.getString(1), reqSelect.getString(2), reqSelect.getString(3),"",null,"","","");
                med1.setDateMax(reqSelect.getString(4));
                ListeMedecin.add(med1);
            }
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("erreur retourner dicoMedecin");
        }

        return ListeMedecin;
    }

    public static ArrayList<Medecin> retournerDictionnaireMedecin6( String date1) {

        ArrayList<Medecin> ListeMedecin = new ArrayList<Medecin>();
        ResultSet reqSelect = ConnexionSqlServer.execReqSelection("EXEC VisitePrioritaire6 '" +date1+  "'");
        try {
            while (reqSelect.next()) {
                Medecin med1 = new Medecin (reqSelect.getString(1), reqSelect.getString(2), reqSelect.getString(3),"",null,"","","");
                med1.setDateMax(reqSelect.getString(4));
                ListeMedecin.add(med1);
            }
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("erreur retourner dicoMedecin");
        }

        return ListeMedecin;
    }

}
