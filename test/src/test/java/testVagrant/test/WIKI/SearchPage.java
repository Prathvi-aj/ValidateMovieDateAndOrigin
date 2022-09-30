package testVagrant.test.WIKI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {

	

	WebDriver driver;
	
	private String movieCountry="//*[@id=\"mw-content-text\"]/div[1]/table[1]/tbody/tr[14]/td";
	private String movieDate="//*[@id=\"mw-content-text\"]/div[1]/table[1]/tbody/tr[12]/td/div/ul/li";
	
	public SearchPage(WebDriver webDriver) {
		driver=webDriver;
	}
	
	public String getMovieDate() {
		return driver.findElement(By.xpath(movieDate)).getText();
	}
	
	public String getMovieCountry() {
		return driver.findElement(By.xpath(movieCountry)).getText();
		
	}
	
}
