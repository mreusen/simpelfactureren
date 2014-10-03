package nl.reusenit.simpelfactureren.web.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import nl.reusenit.simpelfactureren.domain.Account;
import nl.reusenit.simpelfactureren.domain.support.AccountBuilder;
import nl.reusenit.simpelfactureren.service.AccountService;
import nl.reusenit.simpelfactureren.service.AuthenticationException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * @author ReusenIT
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class LoginControllerTest {

	@Autowired
	private LoginController loginController;
	@Autowired
	private AccountService accountService;
	
	@Before
	public void setup() throws AuthenticationException {
		Account account = new AccountBuilder() {
			{
				adres("Keupenstraat", "7", "b", "7091 XE", "Dinxperlo", "Nederland");
				email("Mark@ReusenIT.nl");
				credentials("mark", "secret");
				naam("Mark", "Reusen");
			}
		}.build(true);
		
		Mockito.when(this.accountService.login("mark", "secret")).thenReturn(account);
	}
	
	@After
	public void verify() throws AuthenticationException {
		Mockito.verify(this.accountService, VerificationModeFactory.times(3)).login("mark", "secret");
		Mockito.reset();
	}

	@Test
	public void testHandleLogin() throws AuthenticationException {
		
		MockHttpSession mockHttpSession = new MockHttpSession();
		mockHttpSession.setAttribute(LoginController.REQUESTED_URL, "someUrl");
		
		String view = this.loginController.handleLogin("mark", "secret", mockHttpSession);
		
		Account account = (Account) mockHttpSession.getAttribute(LoginController.ACCOUNT_ATTRIBUTE);
		
		assertNotNull(account);
		assertEquals("Mark", account.getRoepnaam());
		assertEquals("Reusen", account.getNaam());
		assertNull(mockHttpSession.getAttribute(LoginController.REQUESTED_URL));
		assertEquals("redirect:someUrl", view);
		
		// Test de verschillende view selectie keuzes
		mockHttpSession = new MockHttpSession();
		view = this.loginController.handleLogin("mark", "secret", mockHttpSession);
		assertEquals("redirect:/index.htm", view);
		
		mockHttpSession = new MockHttpSession();
		mockHttpSession.setAttribute(LoginController.REQUESTED_URL, "abclogindef");
		view = this.loginController.handleLogin("mark", "secret", mockHttpSession);
		assertEquals("redirect:/index.htm", view);
		
	}

	@Configuration
	static class LoginControllerConfiguration {
		
		@Bean
		public AccountService accountService() {
			return Mockito.mock(AccountService.class);
		}

		@Bean
		public LoginController loginController() {
			return new LoginController();
		}
	}
}
