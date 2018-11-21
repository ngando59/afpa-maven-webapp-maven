package fr.ngando.person.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Utils {
	private static Logger logger = LoggerFactory.getLogger(Utils.class);
	
	public static boolean verifMail(String mail) {
		boolean result = true;
		if(!mail.contains("@")) {
			result = false;
			logger.info("adresse mail invalide, ne contient pas '@' ! ");
		} else 
		if(!(mail.endsWith(".com")||mail.endsWith(".fr"))) {
			result = false;
			logger.info("adresse mail invalide, ne se fini pas par .com ou .fr ");
		}
		return result;
	}
	
	public static boolean verifTelephone(String phone) {
		boolean result = true;
		String phoneFormat = phone.trim();
		phoneFormat = phoneFormat.replaceAll(" ", "");
		if(!(phone.startsWith("+33") || (phone.startsWith("0")))) {
			result = false;
			logger.info("telephone invalide, devrait commencer par +33 ou 0 !");
		} else 
		if(phone.startsWith("+33")) {
			phoneFormat = phoneFormat.substring(3, phoneFormat.length());
			if(phoneFormat.length() != 9) {
				result = false;
				logger.info("telephone invalide, le nombre de numéro de "+phoneFormat+" est différent de 9 !");
			}
		} else 
		if(phone.startsWith("0")) {
			if(phoneFormat.length() != 10) {
				result = false;
				logger.info("telephone invalide, le nombre de numéro de "+phoneFormat+" est différent de 10 !");
			}
		}
		if((phone.startsWith("+33"))||(phone.startsWith("0"))) {
			try {
				Integer.parseInt(phoneFormat);
			} catch (NumberFormatException e) {
				result = false;
				logger.info("telephone invalide ",e.getMessage());
			}
		}
		return result;
	}
}
