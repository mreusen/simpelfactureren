package nl.reusenit.simpelfactureren.service;

import java.util.List;

import nl.reusenit.simpelfactureren.domain.Account;
import nl.reusenit.simpelfactureren.domain.Klant;
import nl.reusenit.simpelfactureren.domain.KlantSearchCriteria;

/**
 * @author ReusenIT
 *
 */
public interface KlantService {

	Klant save(Klant klant);
	
	Klant findById(long id);

	List<Klant> findByAccount(Account account);

	List<Klant> findByCriteria(KlantSearchCriteria criteria, Account account);

}
