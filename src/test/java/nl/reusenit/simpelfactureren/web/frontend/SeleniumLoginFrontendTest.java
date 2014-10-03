package nl.reusenit.simpelfactureren.web.frontend;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class SeleniumLoginFrontendTest {

	private WebDriver driver;
	
	@Before
	public void setup() {
//		driver = new FirefoxDriver();
		driver = new HtmlUnitDriver();
//		driver = new ChromeDriver();
	}

//	@Test
	public void startTest() {
		
		driver.get("http://localhost:8078/simpelfactureren");

		driver.findElement(By.id("login")).click();

		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("mr");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("mr");
		driver.findElement(By.id("loginButton")).click();
		driver.findElement(By.id("account")).click();

		assertEquals("mr", driver.findElement(By.id("username")).getAttribute("value"));
//		assertEquals("", driver.findElement(By.id("emailAdres")).getAttribute("value"));
	}

	@After
	public void tearDown() {
		driver.close();
	}

}

