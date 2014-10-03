package nl.reusenit.simpelfactureren.domain.support;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import nl.reusenit.simpelfactureren.domain.Account;
import nl.reusenit.simpelfactureren.domain.Permission;
import nl.reusenit.simpelfactureren.domain.Role;
import nl.reusenit.simpelfactureren.domain.support.EntityBuilder.EntityBuilderManager;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * @author ReusenIT
 *
 */
public class InitialDataSetup {

	private TransactionTemplate transactionTemplate;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	private Permission permissionAddFacturen = new Permission("PERM_ADD_FACTUREN");
	
	private Role roleAdmin = new Role("ROLE_ADMIN");
	private Role roleGuest = new Role("ROLE_GUEST");

	private Account markR;
	private Account gast;
	private Account pp;
	
//	private Locale locale = new Locale("nl");
	
	public InitialDataSetup(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}

	public void initialize() {
		EntityBuilderManager.setEntityManager(this.entityManager);
		
		this.transactionTemplate.execute(new TransactionCallback<Void>() {
			@Override
			public Void doInTransaction(TransactionStatus status) {
				if (dataIsAlreadyPresent()) {
					return null;
				}
//				Locale locale = Locale.getDefault();
				Locale locale = new Locale("nl", "NL");
				final String LAND = locale.getCountry();
				
				// Create Accounts
				{
					InitialDataSetup.this.markR = new AccountBuilder() {
						{
							adres("Keupenstraat", "7", "b", "7091 XE", "Dinxperlo", LAND);
							email("Mark@ReusenIT.nl");
							credentials("mr", "mr");
							naam("Mark", "Reusen");
							Calendar cal = Calendar.getInstance();
							cal.set(1969, Calendar.APRIL, 28);
							gebdatum(cal.getTime());
//							roleWithPermissions(InitialDataSetup.this.roleAdmin,
//									InitialDataSetup.this.permissionAddFacturen);
						}
					}.build();
					InitialDataSetup.this.gast = new AccountBuilder() {
						{
							adres("Gaststraat", "7", "b", "7091 XE", "Dinxperlo", LAND);
							email("gast@ReusenIT.nl");
							credentials("gast", "gast");
							naam("Some", "Body");
							Calendar cal = Calendar.getInstance();
							cal.set(1988, Calendar.JUNE, 28);
							gebdatum(cal.getTime());
							roleWithPermissions(InitialDataSetup.this.roleGuest);
						}
					}.build();
					InitialDataSetup.this.pp = new AccountBuilder() {
						{
							adres("Dorpstraat", "7", "a", "7091 XE", "Dinxperlo", LAND);
							email("pp@ReusenIT.nl");
							credentials("pp", "pp");
							naam("Pietje", "Puk");
							Calendar cal = Calendar.getInstance();
							cal.set(1977, Calendar.JUNE, 2);
							gebdatum(cal.getTime());
							roleWithPermissions(InitialDataSetup.this.roleGuest);
						}
					}.build();
				}
				
				// Create Klanten
				{
					new KlantBuilder() {
						{
							adres("Kerkstraat", "1", "a", "7091 XE", "Dinxperlo", LAND);
							klantGegevens("ABNAMRO", null, null, "ABNAMRO, Dinxperlo");
							account(InitialDataSetup.this.markR);
						}
					}.build();
					new KlantBuilder() {
						{
							adres("Dorpstraat", "3", "a", "7091 XE", "Dinxperlo", LAND);
							klantGegevens("Rabobank", null, null, "Rabobank, Dinxperlo");
							account(InitialDataSetup.this.markR);
						}
					}.build();
					new KlantBuilder() {
						{
							adres("Plein", "13", null, "7001 AG", "Aalten", LAND);
							klantGegevens("SNS bank", null, null, "SNS bank, Aalten");
							account(InitialDataSetup.this.markR);
						}
					}.build();
					new KlantBuilder() {
						{
							adres("Steeg", "13", null, "2201 AG", "Assen", LAND);
							klantGegevens("SNS bank", null, null, "SNS bank, Assen");
							account(InitialDataSetup.this.markR);
						}
					}.build();
					new KlantBuilder() {
						{
							adres("Hoofdstraat", "173", null, "3301 AG", "Rotterdam", LAND);
							klantGegevens("Rabobank", null, null, "Rabobank, Rotterdam");
							account(InitialDataSetup.this.markR);
						}
					}.build();
					new KlantBuilder() {
						{
							adres("Dam", "1", null, "1001 AG", "Amsterdam", LAND);
							klantGegevens("ABNAMRO", null, null, "ABNAMRO, Amsterdam");
							account(InitialDataSetup.this.markR);
						}
					}.build();
					new KlantBuilder() {
						{
							adres("Dorpstraat", "13", null, "7084 AG", "Breedenbroek", LAND);
							klantGegevens("Rabobank", null, null, "Rabobank, Breedenbroek");
							account(InitialDataSetup.this.gast);
						}
					}.build();
					new KlantBuilder() {
						{
							adres("Plein", "13", null, "7001 AG", "Aalten", LAND);
							klantGegevens("SNS bank", null, null, "Rabobank, Aalten");
							account(InitialDataSetup.this.gast);
						}
					}.build();
				}
				// Create Bedrijf
				{
					new BedrijfBuilder() {
						{
							adres("Keupenstraat", "7", "b", "7091 XE", "Dinxperlo", LAND);
							bedrijfGegevens("Reusen IT", "123456789", "0626500020", "info@ReusenIT.nl", true);
							financieleGegevens("ABN AMRO", "310403642", "123456", "NLABNA0310403642");
							account(InitialDataSetup.this.markR);
						}
					}.build();
					new BedrijfBuilder() {
						{
							adres("Keupenstraat", "7", "b", "7091 XE", "Dinxperlo", LAND);
							bedrijfGegevens("Beun B.V.", "123456789", "0626500020", "info@ReusenIT.nl", false);
							financieleGegevens("ABN AMRO", "310403642", "123456", "NLABNA0310403642");
							account(InitialDataSetup.this.markR);
						}
					}.build();
				}
				return null;
			}

			private boolean dataIsAlreadyPresent() {
				return InitialDataSetup.this.entityManager.createQuery("select count(a.id) from Account a", Long.class)
						.getSingleResult().longValue() > 0;
			}
		});
		// 
		EntityBuilderManager.clearEntityManager();
	}
}
