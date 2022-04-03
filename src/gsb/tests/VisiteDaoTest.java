package gsb.tests;

import gsb.modele.Medecin;

import gsb.modele.Visite;
import gsb.modele.Visiteur;
import gsb.modele.dao.MedecinDao;
import gsb.modele.dao.VisiteDao;
import gsb.modele.dao.VisiteurDao;

public class VisiteDaoTest {

public static void main(String[] args) {
		
		Visite uneVisite = VisiteDao.rechercher("v0011");
		System.out.println(uneVisite.getReference());
		System.out.println(uneVisite.getDate());
		System.out.println(uneVisite.getCommentaire());
		System.out.println(uneVisite.getUnMedecin().getCodeMed());
		System.out.println(uneVisite.getUnVisiteur().getMatricule());
		
		Medecin unMedecin = MedecinDao.rechercher("m012");
		Visiteur unVisiteur = VisiteurDao.rechercher("f21");
		
		Visite uneVisite1= new Visite("v0024", "2002-03-21","Nice",unMedecin, unVisiteur);
		System.out.println(VisiteDao.ajouter(uneVisite1));
		
		uneVisite1.setCommentaire("pas de prise de poids");
		VisiteDao.modifier(uneVisite1);
		System.out.println(VisiteDao.modifier(uneVisite1));
}
}
