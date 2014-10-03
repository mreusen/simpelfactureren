package nl.reusenit.simpelfactureren.repository;

import java.util.List;

import nl.reusenit.simpelfactureren.domain.Account;
import nl.reusenit.simpelfactureren.domain.Klant;
import nl.reusenit.simpelfactureren.domain.KlantSearchCriteria;

/**
 * @author ReusenIT
 *
 */
public interface KlantRepository {

	Klant findById(Long id);
	
	List<Klant> findByAccount(Account account);

	Klant save(Klant klant);

	List<Klant> findByCriteria(KlantSearchCriteria criteria, Account account, int count);
}
