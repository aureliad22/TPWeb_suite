package fr.eni_ecole.jee.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni_ecole.jee.bean.Animateur;
import fr.eni_ecole.jee.bean.Stagiaire;
import fr.eni_ecole.jee.dal.AnimateurDAO;
import fr.eni_ecole.jee.dal.StagiaireDAO;

/**
 * Servlet implementation class ValiderAccesStagiaire
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		valider(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		valider(request, response);
	}

	/**
	 * Méthode qui permet de valider si le stagiaire est déjà connecté et de le rediriger vers le bon menu.
	 * Ou de valider si le stagiaire est présent en BD et que les informations du formulaires sont les bons.
	 * Si l'utilisateur est connecté le mettre en session et rediriger vers la bonne page.
	 * @param request requete
	 * @param response réponse
	 * @throws ServletException Exception de type Servlet.
	 * @throws IOException Exception d'entrée sortie (IO).
	 */
	protected void valider(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher;
		Stagiaire stagiaireConnecte = null;

		// Si l'animateur est déjà connecté, on redirige vers le menu animateur
		stagiaireConnecte = (Stagiaire)request.getSession().getAttribute("stagiaireConnecte");
		if (stagiaireConnecte!=null) {
			redirectionMenuStagiaire(request, response);
			return;
		}		
		
		// Récupération des informations saisies dans le formulaire
		String mail = request.getParameter("identifiant");
		String motdepasse = request.getParameter("motdepasse");

		// Controle des informations :
		// si tous les champs ne sont pas renseignés, revenir sur la page du formulaire
		if (   (mail == null) || (mail.length() == 0) 
			|| (motdepasse == null) || (motdepasse.length() == 0)) {
			
			String message = "Les champs Identifiant et Mot de passe sont obligatoires";
			request.setAttribute("messageErreur", message);
			dispatcher = getServletContext().getNamedDispatcher("AccesStagiairePage");
			dispatcher.forward(request, response);
			return;
		}
		

		try {
			// Valider l'identification par rapport aux informations de la base
			stagiaireConnecte = StagiaireDAO.rechercher(new Stagiaire(null, null, motdepasse, mail));
		} catch (Exception e) {
			// Placer l'objet représentant l'exception dans le contexte de requete
			request.setAttribute("erreur", e);
			// Passer la main à la page de présentation des erreurs
			dispatcher = getServletContext().getRequestDispatcher("/afficherErreur");
			dispatcher.forward(request, response);
			return;
		}		
			
		// Si l'authentification est réussie...
		if (stagiaireConnecte != null) {
			// Placer le bean dans le contexte de session
			request.getSession().setAttribute("stagiaireConnecte", stagiaireConnecte);
			// Présenter la réponse
			redirectionMenuStagiaire(request, response);
			return;
		}
		// ...sinon
		else {
			// Retourner à l'écran d'identification avec un message d'erreur fonctionnel			
			String message = "Identifiant ou mot de passe incorrect";
			request.setAttribute("messageErreur", message);
			dispatcher = getServletContext().getNamedDispatcher("AccesStagiairePage");
			dispatcher.forward(request, response);
			}
	}
	
	protected void redirectionMenuStagiaire(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// En fonction de la méthode de redirection utilisée (forward ou sendRedirect()),
		// l'utilisateur pourra voir ou non l'URL de la ressource : 
		
		// L'utilisation d'un forward masque la nouvelle ressource demandée (car tout 
		// se passe au sein du serveur d'application) 
		RequestDispatcher dispatcher = request.getRequestDispatcher("/stagiaire/menu.jsp");
		dispatcher.forward(request, response);
		
		// L'utilisation d'un sendRedirect expose le nom de la page à l'utilisateur (car
		// une reponse 302 est renvoyée au navigateur qui doit obligatoirement connaitre l'URL
		// de la ressource pour refaire une requête HTTP)

		//response.sendRedirect(request.getContextPath()+"/animateur/menu.jsp");
	}
}
