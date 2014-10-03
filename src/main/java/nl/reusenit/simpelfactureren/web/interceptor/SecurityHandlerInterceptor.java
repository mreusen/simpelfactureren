package nl.reusenit.simpelfactureren.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.reusenit.simpelfactureren.domain.Account;
import nl.reusenit.simpelfactureren.service.AuthenticationException;
import nl.reusenit.simpelfactureren.web.controller.LoginController;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;


/**
 * @author ReusenIT
 *
 */
public class SecurityHandlerInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object Handler)
			throws Exception {
		Account account = (Account) WebUtils.getSessionAttribute(request, LoginController.ACCOUNT_ATTRIBUTE);
		if (account == null) {
			String url = request.getRequestURL().toString();
			WebUtils.setSessionAttribute(request, LoginController.REQUESTED_URL, url);
			throw new AuthenticationException("Authentication required", "authentication.required");
		}
		return true;
	}
}
