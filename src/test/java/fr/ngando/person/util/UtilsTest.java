package fr.ngando.person.util;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
	

public class UtilsTest {
	private static Logger LOGGER = LoggerFactory.getLogger(UtilsTest.class);
	
	@Before
	public void avantTest() {
		LOGGER.info("Début test ");
	}
	
	@After
	public void apresTest() {
		LOGGER.info("Fin test ");
	}
	
	@Test
	public void verif_Mail_Ko_Si_Pas_Aero() {
		boolean result = Utils.verifMail("a.com");
		assertEquals(false, result);
	}
	
	@Test
	public void verif_Mail_Ko_Si_Pas_Finir_Par_PointQuelqueChose() {
		boolean result = Utils.verifMail("prenom.nom@gmailcom");
		assertEquals(false, result);
	}
	
	@Test
	public void verif_Mail_OK_Si_Possede_Aero_Et_Finis_Par_PointQuelqueChose() {
		boolean result = Utils.verifMail("prenom.nom@gmail.fr");
		assertEquals(true, result);
	}
	
	@Test
	public void verif_Telephone_KO_SI_COMMENCE_PAS_PAR_PLUS33_OU_0() {
		boolean result = Utils.verifTelephone("1 02 03 04 0");
		assertEquals(false, result);
	}
	
	@Test
	public void verif_Telephone_KO_SI_COMMENCE_PAR_PLUS33_Et_Moins_DE_9Chiffres() {
		boolean result = Utils.verifTelephone("+33 1 02 03 04 0");
		assertEquals(false, result);
	} 
	
	@Test
	public void verif_Telephone_KO_SI_COMMENCE_PAR_PLUS33_Et_PLUS_DE_9Chiffres() {
		boolean result = Utils.verifTelephone("+33 1 02 03 04 07 89");
		assertEquals(false, result);
	} 
	
	@Test
	public void verif_Telephone_OK_SI_COMMENCE_PAR_PLUS33_9Chiffres() {
		boolean result = Utils.verifTelephone("+33 1 02 03 04 07");
		assertEquals(true, result);
	}
	
	@Test
	public void verif_Telephone_KO_SI_COMMENCE_PAR_0_Et_Moins_DE_10Chiffres() {
		boolean result = Utils.verifTelephone("01 02 03 04 0");
		assertEquals(false, result);
	} 
	
	@Test
	public void verif_Telephone_KO_SI_COMMENCE_PAR_0_Et_PLUS_DE_10Chiffres() {
		boolean result = Utils.verifTelephone("01 02 03 04 07 89");
		assertEquals(false, result);
	} 
	
	@Test
	public void verif_Telephone_OK_SI_COMMENCE_0_Et_10Chiffres() {
		boolean result = Utils.verifTelephone("01 02 03 04 07");
		assertEquals(true, result);
	}
	
	@Test
	public void verif_Telephone_KO_SI_CONTIENT_UNE_LETTRE() {
		boolean result = Utils.verifTelephone("01 a2 03 04 07");
		assertEquals(false, result);
	}
	
}
