package fr.eni_ecole.jee.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class FiltreAnimateur
 */
public class FiltreAnimateur implements Filter {

    /**
     * Default constructor. 
     */
    public FiltreAnimateur() {
    	super();
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		System.out.println("je passe dans le filtre animateur !!");
		HttpServletRequest requeteHttp = (HttpServletRequest) request;
		System.out.println(requeteHttp.getServletPath());

		if(requeteHttp.getSession().getAttribute("animateur") != null){
			// l'animateur est connecté, je le laisse passer:
			chain.doFilter(request, response);
		}
		else
		{
			// l'animateur n'est pas connecté, je le redirige vers la page de connexion appropriée
			HttpServletResponse responseHTTP = (HttpServletResponse)response;
			responseHTTP.sendRedirect(requeteHttp.getContextPath()+"/ValiderAccesAnimateur");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
