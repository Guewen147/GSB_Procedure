/**
 * 
 */
package gsb.tests.unit;

import java.util.HashMap;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import gsb.modele.Localite;
import gsb.modele.Visiteur;
import gsb.modele.dao.VisiteurDao;
import junit.framework.TestCase;

/**
 * @author acer
 *
 */
class VisiteurServiceTest extends TestCase {

	@BeforeEach
	protected void setUp() throws Exception {
		super.setUp();
	}

	@AfterEach
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for {@link gsb.service.VisiteurService#rechercherVisiteur(java.lang.String)}.
	 */
	@Test
	void testRechercherVisiteurSucces() {
		Localite uneLocalite = new Localite("46000","Cahors");
		Visiteur unVisiteur = new Visiteur("a131","Villachane","Louis",
				"lvillachane","jux7g","Film Marvel",uneLocalite,"2005-12-21 00:00:00",
				0, "SW","SWISS");
		assertEquals(unVisiteur, VisiteurDao.rechercher("a131"));
	}

	/**
	 * Test method for {@link gsb.service.VisiteurService#ajouterVisiteur(gsb.modele.Visiteur)}.
	 */
	@Test
	void testAjouterVisiteurSucces() {
		Localite uneLocalite = new Localite("45000","Orleans");
		Visiteur unVisiteur = new Visiteur("VISITEUR01","MAN","ANT",
				"ANT-MAN","Avengers","Film Marvel",uneLocalite,"10 NOVEMBRE",
				0, "101","Battaillon");
		assertEquals(1, VisiteurDao.ajouter(unVisiteur));
	}
	
	void testAjouterVisiteurEchec() {
		assertEquals(0, VisiteurDao.ajouter(unVisiteur));
	}
	
	void testAjouterVisiteurExistant() {
		Localite uneLocalite = new Localite("46000","Cahors");
		Visiteur unVisiteur = new Visiteur("a131","Villachane","Louis",
				"lvillachane","jux7g","Film Marvel",uneLocalite,"2005-12-21 00:00:00",
				0, "SW","SWISS");
		assertEquals(0, VisiteurDao.ajouter(unVisiteur));
	}

	/**
	 * Test method for {@link gsb.service.VisiteurService#retournerCollectionVisiteur()}.
	 */
	@Test
	void testRetournerCollectionVisiteur() {
		HashMap<String, Visiteur> dicVisiteur = VisiteurDao.retournerCollectionDesVisiteurs();
		assertEquals(dicVisiteur, VisiteurDao.retournerCollectionDesVisiteurs());
	}

}
