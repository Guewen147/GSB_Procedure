/**
 * 
 */
package gsb.tests.unit;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import gsb.modele.Visite;
import gsb.modele.Localite;
import gsb.modele.Medecin;
import gsb.modele.Visiteur;
import gsb.modele.dao.MedecinDao;
import gsb.modele.dao.VisiteDao;
import gsb.modele.dao.VisiteurDao;
import junit.framework.TestCase;

/**
 * @author acer
 *
 */
class VisiteServiceTest extends TestCase {

	@BeforeEach
	protected void setUp() throws Exception {
		super.setUp();
	}

	@AfterEach
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for {@link gsb.service.VisiteService#rechercherVisite(java.lang.String)}.
	 */
	@Test
	void testRechercherVisiteSucces() {
		Localite uneLocaliteMed = new Localite("45000","Orleans");
		Localite uneLocaliteVis = new Localite("45000","Orleans");
		Visiteur unVisiteur = new Visiteur("VISITEUR01","MAN","ANT","ANT-MAN","Avengers","Film Marvel",uneLocaliteVis,"10 NOVEMBRE",0,"101","Battaillon") ;
		Medecin unMedecin = new Medecin("MEC001","RAOUL","Medecin","24 rue du bled",uneLocaliteMed,"0617222222","100%","pied") ;
		Visite uneVisite = new Visite("v0024", "2002-03-21","Nice",unMedecin, unVisiteur);
		Visite visiteTrouvée = VisiteDao.rechercher("v0024");
		assertEquals ( uneVisite , visiteTrouvée);
	}
	
	@Test
	void testRechercherVisiteNonExistant() {
		Visite visiteTrouvée = VisiteDao.rechercher("v000021");
		assertNull(visiteTrouvée);
	}

	/**
	 * Test method for {@link gsb.service.VisiteService#ajouterVisite(gsb.modele.Visite)}.
	 */
	@Test
	void testAjouterVisiteSucces() {
		Localite uneLocaliteMed = new Localite("45000","Orleans");
		Medecin unMedecin = new Medecin("MEC001","RAOUL","Medecin","24 rue du bled",uneLocaliteMed,"0617222222","100%","pied");
		Localite uneLocaliteVis = new Localite("45000","Orleans");
		Visiteur unVisiteur = new Visiteur("VISITEUR01","MAN","ANT","ANT-MAN","Avengers","Film Marvel",uneLocaliteVis,"10 NOVEMBRE",0,"101","Battaillon");
		Visite uneVisite = new Visite("REF45","3 Mars","Commenter avec un point",unMedecin,unVisiteur);
		assertEquals(1, VisiteDao.ajouter(uneVisite));
	}
	
	@Test
	void testAjouterVisiteEchec() {
		Localite uneLocaliteMed = new Localite("45000","Orleans");
		Medecin unMedecin = new Medecin("MEC001","RAOUL","Medecin","24 rue du bled",uneLocaliteMed,"0617222222","100%","pied");
		Localite uneLocaliteVis = new Localite("45000","Orleans");
		Visiteur unVisiteur = new Visiteur("visiteur","MAN","ANT","ANT-MAN","Avengers","Film Marvel",uneLocaliteVis,"10 NOVEMBRE",0,"101","Battaillon");
		Visite uneVisite = new Visite("Ref2999°","3 Mars","Commenter avec un point",unMedecin,unVisiteur);
		assertEquals(0, VisiteDao.ajouter(uneVisite));
	}

	/**
	 * Test method for {@link gsb.service.VisiteService#modifierVisite(gsb.modele.Visite)}.
	 */
	@Test
	void testModifierVisiteSucces() {
		Localite uneLocaliteMed = new Localite("45000","Orleans");
		Medecin unMedecin = new Medecin("MEC001","RAOUL","Medecin","24 rue du bled",uneLocaliteMed,"0617222222","100%","pied");
		Localite uneLocaliteVis = new Localite("45000","Orleans");
		Visiteur unVisiteur = new Visiteur("VISITEUR01","MAN","ANT","ANT-MAN","Avengers","Film Marvel",uneLocaliteVis,"10 NOVEMBRE",0,"101","Battaillon");
		Visite uneVisite = new Visite("REF45","3 Mars","Commenter avec un point",unMedecin,unVisiteur);
		uneVisite.setCommentaire("Test nouveau commentaire");
		assertEquals(1, VisiteDao.modifier(uneVisite));
	}
	
	@Test
	void testModifierVisiteEchec() {
		Localite uneLocaliteMed = new Localite("45000","Orleans");
		Medecin unMedecin = new Medecin("MEC001","RAOUL","Medecin","24 rue du bled",uneLocaliteMed,"0617222222","100%","pied");
		Localite uneLocaliteVis = new Localite("45000","Orleans");
		Visiteur unVisiteur = new Visiteur("VISITEUR01","MAN","ANT","ANT-MAN","Avengers","Film Marvel",uneLocaliteVis,"10 NOVEMBRE",0,"101","Battaillon");
		Visite uneVisite = new Visite("REF45","3 Mars","Commenter avec un point",unMedecin,unVisiteur);
		uneVisite.setCommentaire("Test");
		assertEquals(0, VisiteDao.modifier(uneVisite));
	}

	/**
	 * Test method for {@link gsb.service.VisiteService#retournerCollectionVisites()}.
	 */
	@Test
	void testRetournerCollectionVisites() {
		HashMap<String, Visite>  tableauVis = VisiteDao.retournerCollectionVisites();
		assertEquals(tableauVis, VisiteDao.retournerCollectionVisites());
	}

}
