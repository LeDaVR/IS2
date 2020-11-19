

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class demo{
	static String result ;
	
	void percentCalculator(WebDriver driver,String value1,String value2) {
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	      driver.navigate().to("http://www.calculator.net/");
	      driver.manage().window().maximize();

	      driver.findElement(By.xpath("//*[@id=\"contentout\"]/table/tbody/tr/td[3]/div[2]/a")).click();

	      driver.findElement(By.xpath("//*[@id=\"content\"]/table[2]/tbody/tr/td/div[3]/a")).click();

	      driver.findElement(By.id("cpar1")).sendKeys(value1);

	      driver.findElement(By.id("cpar2")).sendKeys(value2);

	      driver.findElement(By.xpath(".//*[@id = 'content']/table/tbody/tr[2]/td/input[2]")).click();
	      
	}
   
   @Test
   public void testPositive() {
	   System.setProperty("webdriver.gecko.driver","C:\\Users\\Leo\\Downloads\\geckodriver-v0.28.0-win64\\geckodriver.exe");
	      WebDriver driver = new FirefoxDriver();
	      percentCalculator(driver,"10","50");
	      result =
	 	         driver.findElement(By.xpath(".//*[@id = 'content']/p[2]/font/b")).getText();
	      driver.close();
		assertEquals(result, "5" );
   }
   
   @Test
   public void testNegative() {
	   System.setProperty("webdriver.gecko.driver","C:\\Users\\Leo\\Downloads\\geckodriver-v0.28.0-win64\\geckodriver.exe");
	      WebDriver driver = new FirefoxDriver();
	      percentCalculator(driver,"-10","50");
	      result =
	 	         driver.findElement(By.xpath(".//*[@id = 'content']/p[2]/font/b")).getText();
	      driver.close();
		assertEquals(result, "-5" );
   }
   
   @Test
   public void testString() {
	   System.setProperty("webdriver.gecko.driver","C:\\Users\\Leo\\Downloads\\geckodriver-v0.28.0-win64\\geckodriver.exe");
	      WebDriver driver = new FirefoxDriver();
	      percentCalculator(driver,"-10","palabra");
	      result =
	 	         driver.findElement(By.xpath("/html/body/div[3]/div[1]/p[2]")).getText();
	      driver.close();
		assertEquals(result,"Please provide two numeric values in any fields below.");
   }
   
}