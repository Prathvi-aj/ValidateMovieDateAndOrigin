package testVagrant.test.WIKI;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WikiHomePage {

	WebDriver driver;
	private String url="https://en.wikipedia.org/wiki/Wiki";
	private String searchTab="//input[@class='vector-search-box-input']";
	private String searchClick="//input[@class='searchButton']";
	
	public WikiHomePage(WebDriver webDriver){
		driver=webDriver;
	}
	
	public void getURL() {
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	
	public void getNavigateURL() {
		driver.navigate().to(url);
	}
	
	public void enterValueInSearchTab(String movieName) {
		driver.findElement(By.xpath(searchTab)).sendKeys(movieName);
	}
	
	public void clickOnSearch() {
	driver.findElement(By.xpath(searchClick)).click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
	
	}
	
	
	
}
