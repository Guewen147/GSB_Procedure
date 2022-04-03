/**
 * 
 */
package gsb.tests.unit;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import gsb.modele.Medecin;
import gsb.modele.Medicament;
import gsb.modele.Visite;
import gsb.modele.dao.OffrirDao;
import gsb.modele.dao.VisiteDao;
import junit.framework.TestCase;

/**
 * @author acer
 *
 */
class OffrirServiceTest extends TestCase {

	@BeforeEach
	protected void setUp() throws Exception {
		super.setUp();
	}

	@AfterEach
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for {@link gsb.service.OffrirService#retournerListeOffre(java.lang.String)}.
	 */
	@Test
	void testRetournerListeOffre() {
		ArrayList<Visite>  listeOffre = OffrirDao.retournerListeOffre("APATOUX22");
		assertEquals(listeOffre, OffrirDao.retournerListeOffre("APATOUX22"));
	}

	/**
	 * Test method for {@link gsb.service.OffrirService#retournerListeMedicament(java.lang.String)}.
	 */
	@Test
	void testRetournerListeMedicament() {
		ArrayList<Medicament>  listeMedic = OffrirDao.retournerListeMedicament("v0012");
		assertEquals(listeMedic, OffrirDao.retournerListeMedicament("v0012"));
	}

}
