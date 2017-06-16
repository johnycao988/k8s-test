package com.cly.cloud.security.client.app;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;

import com.cly.security.ClientSecurityServiceManager;
import com.cly.security.SecurityAuthException;

@Order(1)
@WebFilter("/*")
public class SecurityFilter implements Filter {

	@Override
	public void destroy() {

	}
	
	
	private String geCookieValue(HttpServletRequest rs, String cookieName) {

		Cookie[] cks = rs.getCookies();

		if (cks != null)
			for (Cookie ck : cks) {

				String ckn = ck.getName();

				if (ckn.equals(cookieName))
					return ck.getValue();

			}

		return null;
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;

		HttpServletResponse res = (HttpServletResponse) response;

		Application.getLogger().debug("Request uri:" + req.getServletPath());
		
		String sid = req.getSession(true).getId();

		String uid = geCookieValue(req, sid + "#USER_ID");

		String authCode = geCookieValue(req, sid + "#AUTH_CODE");

		Application.getLogger().debug("sid:"+sid+"\r\nuid:"+uid+"\r\nauthCode:"+authCode);
		
		try {
			if (!ClientSecurityServiceManager.getClientSecurityFilterService().authenticateUser(req, res, true))
				return;
		} catch (SecurityAuthException e) {
			Application.getLogger().error("Get Client Security Service error:", e);
		}

		chain.doFilter(request, response);

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
