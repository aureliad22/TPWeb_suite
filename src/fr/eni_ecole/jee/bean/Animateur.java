package fr.eni_ecole.jee.bean;

import java.io.*;

/**
 * Classe en charge de gérer le bean Animateur.
 * @author Administrateur
 * @date 15 janv. 2015
 * @version J4_TPWEB v1.0
 */
public class Animateur implements Serializable {
	/**
	 * Serial UID.
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
	public Animateur(){
		super();
	}
	
	/**
	 * Constructeur animateur
	 * @param id identifiant de l'animateur
	 * @param nom nom de l'animateur
	 * @param prenom prenom de l'animateur
	 * @param motDePasse mot de passe de l'animateur
	 * @param email email de l'animateur.
	 */
	public Animateur(int id, String nom, String prenom, String motDePasse, String email){
		this();
		setId(id);
		setNom(nom);
		setPrenom(prenom);
		setMotDePasse(motDePasse);
		setEmail(email);		
	}

	/**
	 * Getter for id.
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter for id.
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Getter for nom.
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Setter for nom.
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Getter for prenom.
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * Setter for prenom.
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * Getter for motDePasse.
	 * @return the motDePasse
	 */
	public String getMotDePasse() {
		return motDePasse;
	}

	/**
	 * Setter for motDePasse.
	 * @param motDePasse the motDePasse to set
	 */
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	/**
	 * Getter for email.
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Setter for email.
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
}
