package fr.eni_ecole.jee.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni_ecole.jee.bean.Animateur;
import fr.eni_ecole.jee.bean.Stagiaire;
import fr.eni_ecole.jee.dal.AnimateurDAO;
import fr.eni_ecole.jee.dal.StagiaireDAO;

/**
 * Servlet implementation class ValiderAccesStagiaire
 * 
 * @author adelaune2017
 * @date 25 juil. 2017
 * @version TPWEB_suite V1.0
 */
public class ValiderAccesStagiaire extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ValiderAccesStagiaire() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = getServletContext().getNamedDispatcher("AccesStagiairePage");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd;
		Stagiaire stagiaireConnecte = null;

		// Si l'animateur est déjà connecté, on redirige vers le menu animateur
		stagiaireConnecte = (Stagiaire) request.getSession().getAttribute("stagiaireConnecte");
		if (stagiaireConnecte != null) {
			redirectionMenuStagiaire(request, response);
		} else {
			// Récupération des informations saisies dans le formulaire
			String mail = request.getParameter("identifiant");
			String motdepasse = request.getParameter("motdepasse");

			// Controle des informations :
			// si tous les champs ne sont pas renseignés, revenir sur la page du
			// formulaire
			if ((mail == null) || (mail.length() == 0) || (motdepasse == null)
					|| (motdepasse.length() == 0)) {

				String message = "Les champs Identifiant et Mot de passe sont obligatoires";
				request.setAttribute("messageErreur", message);
				rd = getServletContext().getNamedDispatcher("AccesStagiairePage");
				rd.forward(request, response);
			}

			try {
				// Valider l'identification par rapport aux informations de la base
				stagiaireConnecte = StagiaireDAO.rechercher(new Stagiaire(null,	null, motdepasse, mail));
			} catch (Exception e) {
				// Placer l'objet représentant l'exception dans le contexte de
				// requete
				request.setAttribute("erreur", e);
				// Passer la main à la page de présentation des erreurs
				rd = getServletContext().getRequestDispatcher("/afficherErreur");
				rd.forward(request, response);
			}

			// Si l'authentification est réussie...
			if (stagiaireConnecte != null) {
				// Placer le bean dans le contexte de session
				request.getSession().setAttribute("stagiaireConnecte", stagiaireConnecte);
				// Présenter la réponse
				redirectionMenuStagiaire(request, response);
			}
			// ...sinon
			else {
				// Retourner à l'écran d'identification avec un message d'erreur
				// fonctionnel
				String message = "Identifiant ou mot de passe incorrect";
				request.setAttribute("messageErreur", message);
				rd = getServletContext().getNamedDispatcher("AccesStagiairePage");
				rd.forward(request, response);
			}
		}
	}

	protected void redirectionMenuStagiaire(HttpServletRequest request,	HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/stagiaire/menu.jsp");
		rd.forward(request, response);
	}
}
