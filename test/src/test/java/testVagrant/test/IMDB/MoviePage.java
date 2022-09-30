package testVagrant.test.IMDB;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MoviePage {
	
	WebDriver driver;
	
	private String movieCountry="//li[@data-testid='title-details-origin']//div";
	private String movieDate="//li[@data-testid='title-details-releasedate']//div";
	
	public MoviePage(WebDriver webDriver) {
		driver=webDriver;
	}
	
	public String getMovieDate() {
		return driver.findElement(By.xpath(movieDate)).getText();
	}
	
	public String getMovieCountry() {
		return driver.findElement(By.xpath(movieCountry)).getText();
		
	}
	
}
