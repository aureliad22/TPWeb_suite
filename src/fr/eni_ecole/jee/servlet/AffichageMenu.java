package fr.eni_ecole.jee.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet en charge d'afficher le menu quelque soit l'utilisateur.
 * @author Administrateur
 * @date 16 janv. 2015
 * @version J5_TPWEB v1.0
 */
public class AffichageMenu extends HttpServlet {
	/**
	 * Serial UID.
	 */
	private static final long serialVersionUID = 1L;
    
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	/**
	 * Méthode qui permet d'afficher le menu quelque soit la méthode appelé GET ou POST.
	 * @param request requete
	 * @param response réponse
	 * @throws ServletException Exception de type Servlet.
	 * @throws IOException Exception d'entrée sortie (IO).
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		out.println("<div id=\"menu\">");
		out.print("<a href=\"");
		out.print(request.getContextPath());
		out.print("\">Accueil</a><br />");
		out.print("<a href=\"");
		out.print(request.getContextPath());
		out.println("/ListeDesFormations\">Liste des formations</a><br />");
		out.print("<a href=\"");
		out.print(request.getContextPath());
		out.println("/animateur\">Accés animateur</a><br />");
		out.print("<a href=\"");
		out.print(request.getContextPath());
		out.println("/stagiaire/accesStagiaire.html\">Accés stagiaire</a><br />");
		out.println("<br />");
		out.println("<form method=\"get\" action=\"http://www.google.fr/search\">");
		out.println("<input type=\"hidden\" name=\"hl\" value=\"fr\" />");
		out.println("<input class=\"champtexte\" type=\"text\" name=\"q\" />");
		out.println("<input type=\"submit\" value=\"Rechercher\" />");
		out.println("</form>");
		out.println("</div>");	
	}
}
