package fr.eni_ecole.jee.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet de déconnexion
 * @author Administrateur
 * @date 15 janv. 2015
 * @version J4_TPWEB v1.0
 */
public class Deconnecter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Deconnecter() {
        super();
    }

    /**
     * {@inheritDoc}
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		deconnecter(request, response);
	}

	/**
	 * {@inheritDoc}
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		deconnecter(request, response);
	}
	
	/**
	 * Méthode qui permet d'ecrire une reponse quelque soit la methode
	 * GET ou POST et de se deconnecter.
	 * @param request requete
	 * @param response réponse
	 * @throws ServletException exception SQL Servlet
	 * @throws IOException exception de type IO.
	 */
	protected void deconnecter(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		session.invalidate();
		response.sendRedirect(request.getContextPath()+"/");
	}
}
