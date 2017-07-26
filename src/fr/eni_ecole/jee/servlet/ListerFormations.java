package fr.eni_ecole.jee.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni_ecole.jee.bean.Formation;
import fr.eni_ecole.jee.dal.FormationDAO;

/**
 * Servlet implementation class ListerFormations
 */
public class ListerFormations extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructeur par défaut.
	 */
	public ListerFormations(){
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Méthode en charge de traiter la requête et de fournir une réponse.
	 * @param request
	 * @param response
	 */
	private void processRequest(HttpServletRequest request, HttpServletResponse response) {
		RequestDispatcher rd = null;
		rd = getServletContext().getRequestDispatcher("/formations.jsp");
		List<Formation> listeFormations = null;
		try {
			listeFormations = FormationDAO.lister();
			request.setAttribute("formations", listeFormations);
			rd.forward(request, response);			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
