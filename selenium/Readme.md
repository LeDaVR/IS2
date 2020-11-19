# Selenium y Junit

## Añadimos las librerias externas de junit y selenium
![Librerias](img/3.png)


## Añadimos system.setProperty("webdriver.gecko.driver","Directorio de geckodriver")
```java

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

```


## Ejecutamos como junit
![Ejecucion](img/2.png)
