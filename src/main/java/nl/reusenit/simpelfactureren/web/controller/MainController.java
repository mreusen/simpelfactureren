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
import org.springframework.web.servlet.ModelAndView;


/**
 * @author ReusenIT
 *
 */
@Controller
public class MainController {

	@RequestMapping(value = "/index.htm")
	public ModelAndView main() {
		ModelAndView mov = new ModelAndView();
		mov.setViewName("index");
		return mov;
	}

}
