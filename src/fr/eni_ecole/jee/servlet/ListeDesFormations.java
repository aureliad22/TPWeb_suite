package fr.eni_ecole.jee.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni_ecole.jee.bean.Formation;
import fr.eni_ecole.jee.dal.FormationDAO;

/**
 * Servlet pour la liste des formations.
 * @author Administrateur
 * @date 14 janv. 2015
 * @version J3_TPWEB v1.0
 */
 public class ListeDesFormations extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   /**
    * {@inheritDoc}
    */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		processRequest(request, response);		
	}  	

	/**
    * {@inheritDoc}
    */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}   	  	    
	
	/**
	 * Méthode qui permet d'ecrire une reponse quelque soit la methode GET ou POST.
	 * @param request requete
	 * @param response réponse
	 * @throws ServletException Exception de type Servlet.
	 * @throws IOException Exception d'entrée sortie (IO).
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		StringBuffer contenuReponse = new StringBuffer(); // Contenu de la réponse en cours de construction
		
		contenuReponse.append("<!DOCTYPE html><html><head>");
		contenuReponse.append("<meta content=\"text/html; charset=UTF-8\" http-equiv=\"content-type\"/>");
		contenuReponse.append("<link media=\"all\" rel=\"stylesheet\" href=\"");
		contenuReponse.append(request.getContextPath());
		contenuReponse.append("/theme/basique/style.css\" type=\"text/css\"/>");
		contenuReponse.append("</head>");
		contenuReponse.append("<body>");
		contenuReponse.append("<div id=\"page\">");		
				
		contenuReponse.append("<div id=\"entete\">");
		contenuReponse.append("<h1>TP Web - Formations</h1>");
		contenuReponse.append("</div>");
		
		contenuReponse.append("<div id=\"menu\">");
		contenuReponse.append("<a href=\"");
		contenuReponse.append(request.getContextPath());
		contenuReponse.append("\">Accueil</a><br />");
		contenuReponse.append("<a href=\"");
		contenuReponse.append(request.getContextPath());
		contenuReponse.append("/ListeDesFormations\">Liste des formations</a><br />");
		contenuReponse.append("<a href=\"");
		contenuReponse.append(request.getContextPath());
		contenuReponse.append("/animateur/ValiderAccesAnimateur\">Accés animateur</a><br />");
		contenuReponse.append("<a href=\"");
		contenuReponse.append(request.getContextPath());
		contenuReponse.append("/stagiaire/accesStagiaire.html\">Accés stagiaire</a><br />");
		contenuReponse.append("<br />");
		contenuReponse.append("<form method=\"get\" action=\"http://www.google.fr/search\">");
		contenuReponse.append("<input type=\"hidden\" name=\"hl\" value=\"fr\" />");
		contenuReponse.append("<input class=\"champtexte\" type=\"text\" name=\"q\" />");
		contenuReponse.append("<input type=\"submit\" value=\"Rechercher\" />");
		contenuReponse.append("</form>");
		contenuReponse.append("</div>");
		
		PrintWriter out = response.getWriter();	// Corps de la réponse HTTP
		out.print(contenuReponse);	

		contenuReponse = new StringBuffer();
		contenuReponse.append("<div id=\"contenu\">");
		out.print(contenuReponse);	
				
		try{
			
			/*
			 * Récupérer les données en base
			 */
			ArrayList<Formation> formations = FormationDAO.lister();
									
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			
			// Parcourir le result set	
			for (Formation formation : formations) {
				contenuReponse.append("<div class=\"formation\">");
				contenuReponse.append("<h2>");
				contenuReponse.append(formation.getLibelle());
				contenuReponse.append("</h2>");
				contenuReponse.append("<p> Du ");
				contenuReponse.append(df.format(formation.getDateDebut()));
				contenuReponse.append(" au ");
				contenuReponse.append(df.format(formation.getDateFin()));
				contenuReponse.append("</p>");
				contenuReponse.append("<p>");
				contenuReponse.append(formation.getDescription());
				
				contenuReponse.append("</p>");
				contenuReponse.append("</div>");
				contenuReponse.append("<br />");
			}					
			
		}catch (Exception e){
			System.err.println("Erreur : ");
			e.printStackTrace();
			
			contenuReponse = new StringBuffer();
			contenuReponse.append("<div class=\"formation\">");
			contenuReponse.append("<h2>Erreur</h2>");
			contenuReponse.append("<p>Une erreur est survenue : ");
			contenuReponse.append(e);
			contenuReponse.append("</p>");
			
			if (e.getMessage()!=null) {
				contenuReponse.append("<br />");
				contenuReponse.append("<p>");
				contenuReponse.append(e.getMessage());
				contenuReponse.append("</p>");
			}
				
			contenuReponse.append("</div>");
		}

		contenuReponse.append("</div>");
		contenuReponse.append("<div id=\"pieddepage\">TP <a href=\"http://www.eni-ecole.fr\">ENI Ecole</a></div>");
		contenuReponse.append("</div>");
		contenuReponse.append("</body>");
		contenuReponse.append("</html>");	
		
		response.setStatus(HttpServletResponse.SC_OK);
		response.setContentType("text/html");
			
		out.print(contenuReponse);
		out.flush();
		out.close();
		
	}
}