/**
 * 
 */
package gsb.tests.unit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gsb.modele.Localite;
import gsb.modele.Medecin;
import gsb.modele.dao.LocaliteDao;
import gsb.modele.dao.MedecinDao;

/**
 * @author acer
 *
 */
public class MedecinServiceTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	protected void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	protected void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link gsb.service.MedecinService#rechercherMedecin(java.lang.String)}.
	 */
	@Test
	public final void testRechercherMedecinSucces() {
		Localite uneLocalite = LocaliteDao.rechercher("23200");
		Medecin unMedecin = new Medecin("m001","SMITH","JEAN",
				"5 rue de la poste",uneLocalite,"05-55-12-65-45",
				"","Cardiologue");
		Medecin medecinTrouvée = MedecinDao.rechercher("MEC001");
		assertEquals(unMedecin, medecinTrouvée);
	}
	
	@Test
	public final void testRechercherMedecinInexistant() {
		
		Medecin medecinTrouvée = MedecinDao.rechercher("MED001");
		assertNull(medecinTrouvée);
	}
	
	@Test
	public final void testRetournerCollectionDesMedecins() {
		
		ArrayList<Medecin> tableauMed = MedecinDao.retournerCollectionDesMedecins();
		assertEquals(tableauMed, MedecinDao.retournerCollectionDesMedecins());
		
	}
	
	@Test
	public final void testRetournerDictionnaireDesMedecins() {
		
		HashMap<String,Medecin> dicMed = MedecinDao.retournerDictionnaireDesMedecins();
		assertEquals(dicMed, MedecinDao.retournerDictionnaireDesMedecins());
		
	}

}
