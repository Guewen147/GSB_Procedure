package gsb.tests;

import gsb.modele.Visiteur;
import gsb.modele.dao.VisiteurDao;

public class VisiteurDaoTest {
public static void main(String[] args) {
		
		Visiteur unVisiteur = VisiteurDao.rechercher("f21");
		System.out.println(unVisiteur.getMatricule());
		System.out.println(unVisiteur.getNom());
		System.out.println(unVisiteur.getPrenom());
		System.out.println(unVisiteur.getLogin());
		System.out.println(unVisiteur.getMdp());
		System.out.println(unVisiteur.getAdresse());
		System.out.println(unVisiteur.getUneLocalite().getCodePostal());
		System.out.println(unVisiteur.getDateEntree());
		System.out.println(unVisiteur.getCodeUnite());
		System.out.println(unVisiteur.getNomUnite());
}
}
