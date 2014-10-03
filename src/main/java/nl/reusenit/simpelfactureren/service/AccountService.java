package nl.reusenit.simpelfactureren.service;

import nl.reusenit.simpelfactureren.domain.Account;

/**
 * @author ReusenIT
 *
 */
public interface AccountService {

	Account save(Account account);
	
	Account login(String username, String password) throws AuthenticationException;
	
	Account getAccount(String username);

}
