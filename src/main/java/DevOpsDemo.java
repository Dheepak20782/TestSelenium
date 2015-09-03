import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
//import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;

public class DevOpsDemo {
	private WebDriver driver;
	private String baseUrl;
//	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
  
	@BeforeTest
	public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    baseUrl = "http://136.151.193.184:8761";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
	  }


	 
	@AfterTest
	public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
//	      fail(verificationErrorString);
	    }
	  }
	
	private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }
	
	/*
	private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }
	
	private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }
	*/

	@Test
	  public void testTcs() throws Exception {
	    driver.get(baseUrl + "/#/");
	    driver.findElement(By.linkText("Home")).click();
	    driver.findElement(By.linkText("login")).click();
	    driver.findElement(By.id("username")).clear();
	    driver.findElement(By.id("username")).sendKeys("user");
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys("pwd");
	    driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
	    Assert.assertTrue(isElementPresent(By.cssSelector("img[alt=\"home\"]")));
	    driver.findElement(By.linkText("logout")).click();
	  }


	
}
