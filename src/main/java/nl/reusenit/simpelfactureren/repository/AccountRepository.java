package nl.reusenit.simpelfactureren.repository;

import nl.reusenit.simpelfactureren.domain.Account;

/**
 * @author ReusenIT
 *
 */
public interface AccountRepository {

	Account findByUsername(String username);
	
	Account findById(Long id);
	
	Account save(Account account);

}
