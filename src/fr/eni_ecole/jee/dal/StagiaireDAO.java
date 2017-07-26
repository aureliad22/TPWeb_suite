/**
 * @author adelaune2017
 * @date 24 juil. 2017
 * @version TPWEB_suite V1.0
 */
package fr.eni_ecole.jee.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni_ecole.jee.bean.Stagiaire;
import fr.eni_ecole.jee.util.AccesBase;
import fr.eni_ecole.tools.ManipDate;

/**
 * @author adelaune2017
 * @date 24 juil. 2017
 * @version TPWEB_suite V1.0
 */
public class StagiaireDAO {
	
	private static final String RQ_BYID = "SELECT * FROM stagiaires WHERE id=?";
	public static final String RQ_UPDATE = "UPDATE stagiaires SET nom =?, prenom=?, email=?, motdepasse=? WHERE id= ?";
	
	/**
	 * Méthode qui permet de rechercher un stagiaire depuis la BD.
	 * @param id identifiant du stagiaire recherché
	 * @return retourne le stagiaire.
	 * @throws Exception Exception de type SQL.
	 */
	public static Stagiaire rechercher(int id) throws Exception{
		PreparedStatement cmd = null;
		Stagiaire stagiaire = null;
		try(Connection cnx = AccesBase.getConnection()){
			cmd = cnx.prepareStatement(RQ_BYID);
			cmd.setInt(1, id);
			ResultSet rs = cmd.executeQuery();
			
			if(rs.next()){
				stagiaire = stagiaireBuilder(rs);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new Exception("Problème d'affichage du stagiaire à partir de la base TPJavaEE_GestionFormations!");
		}
		return stagiaire;
	}
	
	/**
	 * Méthode en charge de 
	 * @param rs
	 * @return
	 * @throws SQLException 
	 */
	private static Stagiaire stagiaireBuilder(ResultSet rs) throws SQLException {
		Stagiaire stagiaire = new Stagiaire();
		stagiaire.setNom(rs.getString("nom"));
		stagiaire.setPrenom(rs.getString("prenom"));
		stagiaire.setEmail(rs.getString("email"));
		stagiaire.setMotDePasse(rs.getString("motDePasse"));
		return stagiaire;
	}

	public static Stagiaire modifierProfil(Stagiaire stagiaireCourant) throws Exception {
		Stagiaire stagiaire = null;
		
		try(Connection cnx = AccesBase.getConnection()){
			PreparedStatement stm = cnx.prepareStatement(RQ_UPDATE);
			stm.setString(1, stagiaireCourant.getNom());
			stm.setString(2, stagiaireCourant.getPrenom());
			stm.setString(3, stagiaireCourant.getEmail());
			stm.setString(4, stagiaireCourant.getMotDePasse());
			stm.setInt(5, stagiaireCourant.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return stagiaire;		
	}
	
	/**
	 * Méthode qui permet de rechercher un animateur depuis la BD.
	 * @param animateur animateur recherché
	 * @return retourne l'animateur.
	 * @throws Exception 
	 */
	public static Stagiaire rechercher(Stagiaire stagiaire) throws Exception{
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		try{
			cnx = AccesBase.getConnection();
			rqt = cnx.prepareStatement("select id, nom, prenom from stagiaires where email=? and motdepasse=?");
			rqt.setString(1, stagiaire.getEmail());
			rqt.setString(2, stagiaire.getMotDePasse());
			rs=rqt.executeQuery();
			// SI on trouve au moins 1 résultat, on prend le 1er pour mettre à 
			//jour les informations de l'animateur utilisé pour la recherche.
			if (rs.next()){
				stagiaire.setId(rs.getInt("id"));
				stagiaire.setNom(rs.getString("nom"));
				stagiaire.setPrenom(rs.getString("prenom"));
			}
			// ...sinon on renvoie null
			else {
				stagiaire = null;
			}
			
		}finally{
			if (rs!=null) rs.close();
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		return stagiaire;
	}
}
