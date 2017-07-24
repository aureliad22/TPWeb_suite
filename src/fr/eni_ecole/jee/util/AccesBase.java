package fr.eni_ecole.jee.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

/**
 * @author adelaune2017
 * @date 24 juil. 2017
 * @version TPWEB_suite V1.0
 */
public class AccesBase {
	/**
	 * Méthode qui permet de récupérer une connexion à la BdD.
	 * @return Connection
	 * @throws SQLException Exception de type SQL.
	 */
	public static Connection getConnectionUsingParam() throws SQLException{
		
		String uri = Parametre.lire("dbUrl");
		String user = Parametre.lire("dbUser");
		String password = Parametre.lire("dbPassword");
		
		DriverManager.registerDriver(new SQLServerDriver());
		Connection connexion =  DriverManager.getConnection(uri, user, password);
		
		return connexion;		
	}
	 /**
	  * 
	  * Méthode en charge de récupérer une connexion à la BdD
	  * @return Connection
	  * @throws SQLException Exception de type SQL.
	  */
	public static Connection getConnection() throws Exception {
		InitialContext jndi = null;
		DataSource ds = null;
		Connection cnx = null;
		try {
			// ----> Obtenir une référence sur le contexte initial JNDI
			jndi = new InitialContext();
			// ----> Rechercher la source de données
			ds = (DataSource) jndi.lookup("java:comp/env/jdbc/dsTPWeb");
			// ----> Obtenir une connexion
			cnx = ds.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
			throw new Exception("L'accès à la base est impossible pour le moment");
		}

		return cnx;
	}
}
