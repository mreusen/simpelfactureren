package nl.reusenit.simpelfactureren.web.controller;

import javax.servlet.http.HttpSession;

import nl.reusenit.simpelfactureren.domain.Account;
import nl.reusenit.simpelfactureren.service.AccountService;
import nl.reusenit.simpelfactureren.service.AuthenticationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * @author ReusenIT
 *
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {

	private final Logger logger = LoggerFactory.getLogger(LoginController.class);

	public static final String ACCOUNT_ATTRIBUTE = "account";
	public static final String BEDRIJF_ATTRIBUTE = "bedrijf";
	public static final String REQUESTED_URL = "REQUESTED_URL";
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping(method = RequestMethod.GET)
	public void login() {
	}

	@RequestMapping(method = RequestMethod.POST)
	public String handleLogin(@RequestParam String username, @RequestParam String password, HttpSession session) 
			throws AuthenticationException {
		Account account = this.accountService.login(username, password);
		this.logger.info("Account: {} ", account);
		session.setAttribute(ACCOUNT_ATTRIBUTE, account);
		String url = (String) session.getAttribute(REQUESTED_URL);
		session.removeAttribute(REQUESTED_URL);
		if (StringUtils.hasText(url) && !url.contains("login")) {
			return "redirect:" + url;
		} else {
			return "redirect:/index.htm";
		}
	}

}
