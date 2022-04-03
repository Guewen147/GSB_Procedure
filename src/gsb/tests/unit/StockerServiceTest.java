/**
 * 
 */
package gsb.tests.unit;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gsb.modele.Medicament;
import gsb.modele.Visite;
import gsb.modele.Visiteur;
import gsb.modele.dao.OffrirDao;
import gsb.modele.dao.StockerDao;
import junit.framework.TestCase;

/**
 * @author acer
 *
 */
public class StockerServiceTest extends TestCase {

	@Before
	protected void setUp() throws Exception {
		super.setUp();
	}

	@After
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for {@link gsb.service.StockerService#retournerListeStock(java.lang.String)}.
	 */
	@Test
	public void testRetournerListeStock() {
		ArrayList<Medicament>  listeStock = StockerDao.retournerListeStock("e49");
		assertEquals(listeStock, StockerDao.retournerListeStock("e49"));
	}

	/**
	 * Test method for {@link gsb.service.StockerService#retournerListeVisiteur(java.lang.String)}.
	 */
	@Test
	public void testRetournerListeVisiteur() {
		ArrayList<Visiteur>  listeVisiteur = StockerDao.retournerListeVisiteur("APATOUX22");
		assertEquals(listeVisiteur, StockerDao.retournerListeVisiteur("APATOUX22"));
	}

}
