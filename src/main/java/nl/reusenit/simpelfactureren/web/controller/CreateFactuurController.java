package nl.reusenit.simpelfactureren.web.controller;

import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import nl.reusenit.simpelfactureren.domain.Account;
import nl.reusenit.simpelfactureren.domain.Klant;
import nl.reusenit.simpelfactureren.service.BedrijfService;
import nl.reusenit.simpelfactureren.service.KlantService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

/**
 * @author ReusenIT
 *
 */
@Controller
public class CreateFactuurController {

//	@Autowired
//	private FactuurService factuurService;
	
	@Autowired
	private BedrijfService bedrijfService;

	@Autowired
	private KlantService klantService;

	private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy");


	public FactuurForm initializeForm() {
		FactuurForm factuurForm = new FactuurForm();
		factuurForm.setFactuurDatum(simpleDateFormat.format(new Date()));
		return factuurForm;
	}

	public Map<Long, String> initializeSelectableKlanten(Account account) {
		Map<Long, String> selectableKlanten = new HashMap<Long, String>();
		for (Klant klant : klantService.findByAccount(account)) {
			selectableKlanten.put(klant.getId(), klant.getAlias());
		}
		return selectableKlanten;
	}

	public Map<Currency, String> initializeSelectableCurrency() {
		Map<Currency, String> selectableCurrency = new HashMap<Currency, String>();
		selectableCurrency.put(Currency.getInstance("EUR"), "Euro");
		selectableCurrency.put(Currency.getInstance("USD"), "Dollar");
		return selectableCurrency;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
}
