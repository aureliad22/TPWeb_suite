package fr.eni_ecole.jee.util;

import java.util.ResourceBundle;

/**
 * Classe qui permet de lire les Parametres passer dans un fichier .properties.
 * @author Administrateur
 * @date 14 janv. 2015
 * @version J3_TPWEB v1.0
 */
public class Parametre {

	/**
	 * Méthode qui lit le parametre en fonction de sa clé et retourne sa valeur.
	 * @param cle
	 * @return valeur
	 */
	public static String lire(String cle){
		ResourceBundle bundle = ResourceBundle.getBundle("fr.eni_ecole.jee.util.param");
		
		return (null!=bundle) ? bundle.getString(cle) : null;
	}

}
