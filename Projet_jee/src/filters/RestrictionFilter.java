package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RestrictionFilter implements Filter {

	private static final String ACCES_CONNEXION = "/WEB-INF/connexion.jsp";
	private static final String ACCES_INC = "/inc";
	private static final String ATT_SESSION_USER = "sessionUtilisateur";

	public RestrictionFilter() {
	}

	public void init(FilterConfig config) throws ServletException {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;

		String chemin = request.getRequestURI().substring(request.getContextPath().length());
		if (chemin.startsWith(ACCES_INC)) {
			chain.doFilter(request, response);
			return;
		}

		HttpSession session = request.getSession();

		if (session.getAttribute(ATT_SESSION_USER) == null) {
			request.getServletContext().getRequestDispatcher(ACCES_CONNEXION).forward(request, response);
		} else {
			chain.doFilter(request, response);
		}
	}

}
