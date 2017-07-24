package fr.eni_ecole.jee.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni_ecole.jee.bean.Animateur;
import fr.eni_ecole.jee.util.AccesBase;

/**
 * DAO pour le bean animateur.
 * @author Administrateur
 * @date 15 janv. 2015
 * @version J4_TPWEB v1.0
 */
public class AnimateurDAO {

	/**
	 * Méthode qui permet de rechercher un animateur depuis la BD.
	 * @param animateur animateur recherché
	 * @return retourne l'animateur.
	 * @throws Exception Exception de type SQL.
	 */
	public static Animateur rechercher(Animateur animateur) throws Exception{
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		try{
			cnx = AccesBase.getConnection();
			rqt = cnx.prepareStatement("select id, nom, prenom from animateurs where email=? and motdepasse=?");
			rqt.setString(1, animateur.getEmail());
			rqt.setString(2, animateur.getMotDePasse());
			rs=rqt.executeQuery();
			// SI on trouve au moins 1 résultat, on prend le 1er pour mettre à 
			//jour les informations de l'animateur utilisé pour la recherche.
			if (rs.next()){
				animateur.setId(rs.getInt("id"));
				animateur.setNom(rs.getString("nom"));
				animateur.setPrenom(rs.getString("prenom"));
			}
			// ...sinon on renvoie null
			else {
				animateur = null;
			}
			
		}finally{
			if (rs!=null) rs.close();
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		return animateur;
	}
}
