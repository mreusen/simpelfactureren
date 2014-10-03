package nl.reusenit.simpelfactureren.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Predicate;

import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import nl.reusenit.simpelfactureren.domain.Account;
import nl.reusenit.simpelfactureren.domain.Adres;
import nl.reusenit.simpelfactureren.domain.Klant;
import nl.reusenit.simpelfactureren.domain.KlantSearchCriteria;

/**
 * @author ReusenIT
 *
 */
@Repository("klantRepository")
public class JpaKlantRepository implements KlantRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Klant findById(Long id) {
		return this.entityManager.find(Klant.class, id);
	}

	@Override
	public List<Klant> findByAccount(Account account) {
		String hql = "select k from Klant k where k.account=:account";
		TypedQuery<Klant> query = this.entityManager.createQuery(hql, Klant.class);
		query.setParameter("account", account);
		return query.getResultList();
	}

	@Override
	public List<Klant> findByCriteria(KlantSearchCriteria criteria, Account account, int count) {
		Assert.notNull(criteria, "Search Criteria are required!");
		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Klant> query = builder.createQuery(Klant.class);
		Root<Klant> klant = query.from(Klant.class);
		List<Predicate> predicates = new ArrayList<Predicate>();
		
		predicates.add(builder.equal(klant.<Account> get("account"), account));
		
		if (StringUtils.hasText(criteria.getNaam())) {
			String naam = criteria.getNaam().toUpperCase();
			predicates.add(builder.like(builder.upper(klant.<String> get("naam")), "%" + naam + "%"));
		}
		if (StringUtils.hasText(criteria.getPlaats())) {
			String plaats = criteria.getPlaats().toUpperCase();
			predicates.add(builder.like(builder.upper(klant.<Adres> get ("adres").<String> get ("plaats")), 
					"%" + plaats + "%"));
		}
		if (!predicates.isEmpty()) {
			query.where(predicates.toArray(new Predicate[predicates.size()]));
		}

		query.orderBy(builder.asc(klant.get("naam")));
		return this.entityManager.createQuery(query).setMaxResults(count).getResultList();
	}

	@Override
	public Klant save(Klant klant) {
		if (klant.getAlias() == null || klant.getAlias() == "") {
			klant.setAlias(klant.getNaam() + ", " + klant.getAdres().getPlaats());
		}
		if (klant.getId() != null) {
			return this.entityManager.merge(klant);
		} else {
			this.entityManager.persist(klant);
			return klant;
		}
	}
	
}
