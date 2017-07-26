package fr.eni_ecole.jee.servlet;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni_ecole.jee.bean.Formation;
import fr.eni_ecole.jee.bean.Stagiaire;
import fr.eni_ecole.jee.dal.StagiaireDAO;

/**
 * Servlet implementation class GererStagiaire
 */
public class GererStagiaire extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GererStagiaire() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Stagiaire stagiaireConnecte = (Stagiaire) request.getSession().getAttribute("stagiaireConnecte");
		try {
			Stagiaire stagiaireAModifier = (Stagiaire) request.getSession().getAttribute("stagiaireConnecte");
			System.out.println(stagiaireAModifier.getNom());
			request.setAttribute("stagiaireAModifier", stagiaireAModifier);
			RequestDispatcher rd = request.getRequestDispatcher("/stagiaire/gererStagiaire.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			request.setAttribute("Erreur", "La demande de modification a échoué.");
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Stagiaire stagiaireConnecte = (Stagiaire) request.getSession().getAttribute("stagiaireConnecte");

		try {
			stagiaireConnecte.setNom(request.getParameter("nomStagiaire"));
			stagiaireConnecte.setPrenom(request.getParameter("prenomStagiaire"));
			stagiaireConnecte.setEmail(request.getParameter("emailStagiaire"));
			
			if(!(stagiaireConnecte.getMotDePasse()).equals(request.getParameter("ancienMdpStagiaire")))
			{
				request.setAttribute("Erreur", "Le mot de passe est erroné.");
			}
			else
			{
				String nouveauMdp = request.getParameter("nouveauMdpStagiaire");
				if(nouveauMdp.equals(request.getParameter("confirmMdpStagiaire"))){
					stagiaireConnecte.setMotDePasse(request.getParameter("nouveauMdpStagiaire"));	
				}
				else
				{
					request.setAttribute("Erreur", "Le mot de passe ne correspond pas.");
				}
			}
			StagiaireDAO.modifierProfil(stagiaireConnecte);
			request.setAttribute("Message", "La modification s'est déroulée avec succès.");
			RequestDispatcher rd = request.getRequestDispatcher("/stagiaire/menu.jsp");
			rd.forward(request, response);
		} 
		catch (ParseException e1) {
			request.setAttribute("erreur", "veuillez vérifier vos saisies avant de valider de nouveau");
			e1.printStackTrace();
		}
		catch (Exception e) {
			request.setAttribute("erreur", "La modification a échoué.");
			e.printStackTrace();
		}
	}

}
