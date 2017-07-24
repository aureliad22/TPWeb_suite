package fr.eni_ecole.jee.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * Classe en charge de gérer le bean formation.
 * @author Administrateur
 * @date 14 janv. 2015
 * @version J3_TPWEB v1.0
 */
public class Formation implements Serializable {

	/**
	 * Serial UID.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Identifiant de la formation.
	 */
	private int id;
	/**
	 * Libelle de la formation.
	 */
	private String libelle;
	/**
	 * Date de début de la formation.
	 */
	private Date dateDebut;
	/**
	 * Date de fin de la formation.
	 */
	private Date dateFin;
	/**
	 * Description de la formation.
	 */
	private String description;
	
	/**
	 * Constructeur par défaut pour la formation.
	 */
	public Formation(){
		super();
	}
	/**
	 * Constructeur formation.
	 * @param id identifiant
	 * @param libelle libelle de la formation
	 * @param dateDebut date de debut de la formation
	 * @param dateFin date de fin de la formation
	 * @param description description de la formation.
	 */
	public Formation(int id, String libelle, Date dateDebut, Date dateFin, String description){
		super();
		setId(id);
		setLibelle(libelle);
		setDateDebut(dateDebut);
		setDateFin(dateFin);
		setDescription(description);
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
	 * Getter for libelle.
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}
	/**
	 * Setter for libelle.
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	/**
	 * Getter for dateDebut.
	 * @return the dateDebut
	 */
	public Date getDateDebut() {
		return dateDebut;
	}
	/**
	 * Setter for dateDebut.
	 * @param dateDebut the dateDebut to set
	 */
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	/**
	 * Getter for dateFin.
	 * @return the dateFin
	 */
	public Date getDateFin() {
		return dateFin;
	}
	/**
	 * Setter for dateFin.
	 * @param dateFin the dateFin to set
	 */
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	/**
	 * Getter for description.
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * Setter for description.
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * Getter for serialversionuid.
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
