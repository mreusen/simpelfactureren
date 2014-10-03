package nl.reusenit.simpelfactureren.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Repository;

import nl.reusenit.simpelfactureren.domain.Account;

/**
 * @author ReusenIT
 *
 */
@Repository("accountRepository")
public class JpaAccountRepository implements AccountRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Account findByUsername(String username) {
		String hql = "select c from Account c where c.username=:username";
		TypedQuery<Account> query = this.entityManager.createQuery(hql, Account.class).setParameter("username", username);
		List<Account> accounts = query.getResultList();

		return accounts.size() == 1 ? accounts.get(0) : null;
	}

	@Override
	public Account findById(Long id) {
		return this.entityManager.find(Account.class, id);
	}

	@Override
	public Account save(Account account) {
		if (account.getId() != null) {
			this.entityManager.merge(account);
			this.entityManager.flush();
			return account;
		} else {
			account.setPassword(DigestUtils.sha256Hex(account.getPassword() + "{" + account.getUsername() + "}"));
			this.entityManager.persist(account);
			return account;
		}
	}

}
