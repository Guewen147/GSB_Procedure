package gsb.tests;

import gsb.modele.Localite;
import gsb.modele.dao.LocaliteDao;

public class LocaliteDaoTest {

	public static void main(String[] args) {
				
				Localite uneLocalite = LocaliteDao.rechercher("45000");
				System.out.println(uneLocalite.getCodePostal());
				System.out.println(uneLocalite.getVille());
		}
		
}


