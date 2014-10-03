package nl.reusenit.simpelfactureren.web.controller;

import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import nl.reusenit.simpelfactureren.domain.Account;
import nl.reusenit.simpelfactureren.service.AccountService;
import nl.reusenit.simpelfactureren.validation.AccountValidator;
import nl.reusenit.simpelfactureren.web.method.support.SessionAttribute;

/**
 * @author ReusenIT
 *
 */
@Controller
//@RequestMapping("/account/account/{accountId}")
@RequestMapping("/account/account")
@SessionAttributes(types=Account.class)
public class AccountController {

	@Autowired
	private AccountService accountService;

//	@Autowired
//	private InvoiceService invoiceService;

//	@Autowired
//	private CustomerService customerService;

	@ModelAttribute("countries")
	public Map<String, String> countries(Locale currentLocale) {
		Map<String, String> countries = new TreeMap<String, String>();
		for (Locale locale : Locale.getAvailableLocales()) {
			countries.put(locale.getCountry(), locale.getDisplayCountry(currentLocale));
		}
		return countries;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setDisallowedFields("id");
		binder.setValidator(new AccountValidator());
	}

	@RequestMapping(method = RequestMethod.GET)
	public String index(Model model,
			@SessionAttribute(value = LoginController.ACCOUNT_ATTRIBUTE, exposeAsModelAttribute = true) Account account) {
//		model.addAttribute("invoices", this.invoiceService.findByAccount(account));
//		model.addAttribute("customers", this.customerService.findByAccount(account));
		return "account/account";
	}

	@RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
	public String update(@Valid @ModelAttribute Account account, BindingResult result, HttpSession session) {
		if (result.hasErrors()) {
			return "account/account";
		}
		this.accountService.save(account);
		return "redirect:/account/account";
	}
}
