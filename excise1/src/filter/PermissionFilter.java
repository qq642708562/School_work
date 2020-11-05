package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.UserDao;

public class PermissionFilter implements Filter {
	private String notCheckUri;

	public void destroy() {

	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		notCheckUri = config.getInitParameter("notCheckUri");

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		String path = request.getServletPath();
		// System.out.println("ÇëÇóµØÖ·url-pattern:"+path);

		UserDao userDao = new UserDao();
		HttpSession session = request.getSession();
		Cookie[] cookies = request.getCookies();
		boolean isCookie = false;
		if (cookies != null) {
			for (Cookie a : cookies) {
				if (a.getName().equals("name")) {
					if (a.getValue().equals("admin")) {
						isCookie = true;
					}
				}
			}
		}
		if (isCookie != false) {
			String name = null;
			for (Cookie c : cookies) {
				if (c.getName().equals("name")) {
					name = c.getValue();
				}
			}
			if (name != null) {
				session.setAttribute("currentUser", userDao.get(name)
						.getUserName());
				session.setAttribute("chrName", userDao.get(name).getChrName());
				chain.doFilter(req, resp);
			}
		} else if (notCheckUri.indexOf(path) == -1) {
			// HttpSession session = request.getSession();
			if (session.getAttribute("currentUser") == null) {
				request.setAttribute("info", "±§Ç¸£¬ÄúÉÐÎ´µÇÂ¼");
				request.getRequestDispatcher("/error.jsp").forward(request,
						resp);
			} else {
				chain.doFilter(req, resp);
			}
		} else {
			chain.doFilter(req, resp);
		}
	}

}
