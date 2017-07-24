/**
 * @author adelaune2017
 * @date 24 juil. 2017
 * @version TPWEB_suite V1.0
 */
package fr.eni_ecole.jee.bean;

import java.io.Serializable;

/**
 * @author adelaune2017
 * @date 24 juil. 2017
 * @version TPWEB_suite V1.0
 */
public class Stagiaire implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Identifiant de la formation.
	 */
	private int id;
	
	/**
	 * Nom.
	 */
	private String nom;
	
	/**
	 * Prénom.
	 */
	private String prenom;
	
	/**
	 * Mot de passe.
	 */
	private String motDePasse;

	/**
	 * Email.
	 */
	private String email;
	
	/**
	 * Constructeur par défaut.
	 */
	public Stagiaire() {
		super();
	}

	/**
	 * Constructeur.
	 * @param nom
	 * @param prenom
	 * @param motDePasse
	 * @param email
	 */
	public Stagiaire(String nom, String prenom, String motDePasse, String email) {
		super();
		this.setNom(nom);
		this.setPrenom(prenom);
		this.setMotDePasse(motDePasse);
		this.setEmail(email);
	}

	/**
	 * Getter pour id.
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter pour id.
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Getter pour nom.
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Setter pour nom.
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Getter pour prenom.
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * Setter pour prenom.
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * Getter pour motDePasse.
	 * @return the motDePasse
	 */
	public String getMotDePasse() {
		return motDePasse;
	}

	/**
	 * Setter pour motDePasse.
	 * @param motDePasse the motDePasse to set
	 */
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	/**
	 * Getter pour email.
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Setter pour email.
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
