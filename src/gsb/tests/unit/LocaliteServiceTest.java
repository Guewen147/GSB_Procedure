/**
 * 
 */
package gsb.tests.unit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gsb.modele.Localite;
import gsb.modele.dao.LocaliteDao;
import junit.framework.TestCase;

/**
 * @author acer
 *
 */
class LocaliteServiceTest extends TestCase {

	@Before
	protected void setUp() throws Exception {
		super.setUp();
	}

	@After
	protected void tearDown() throws Exception {
		super.tearDown();
		System.out.println("------------Fin des tests------------");
	}

	/**
	 * Test method for {@link gsb.service.LocaliteService#rechercherLocalite(java.lang.String)}.
	 */
	@Test
	public final void testRechercherLocaliteSucces() {
		Localite localite = new Localite("29300", "Tremeven");
		Localite localiteTrouvée = LocaliteDao.rechercher(localite.getCodePostal());
		assertEquals(localite, localiteTrouvée);
	}
	
	@Test
	public final void testRechercherLocaliteNonExistante()
	{
		Localite localite = new Localite("56690", "Landaul");
		Localite localiteNonTrouvée = LocaliteDao.rechercher(localite.getCodePostal());
		assertNull(localiteNonTrouvée);
	}

}
