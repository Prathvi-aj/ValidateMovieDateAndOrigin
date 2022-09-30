package testVagrant.test.IMDB;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	WebDriver driver;
	private String url="https://www.imdb.com/";
	private String searchTab="//input[@class='imdb-header-search__input searchTypeahead__input react-autosuggest__input']";
	private String searchClick="//button[@id='suggestion-search-button']";
	private String movieName="//*[@id=\"react-autowhatever-1--item-0\"]/a";
	
	public HomePage(WebDriver webDriver){
		driver=webDriver;
	}
	
	public void getURL() {
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	public void enterValueInSearchTab(String movieName) {
		driver.findElement(By.xpath(searchTab)).sendKeys(movieName);
	}
	
	public void clickOnSearch() {
	driver.findElement(By.xpath(searchClick)).click();
	
	}
	
	public void clickOnMovieName() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath(movieName)).click();
	}
	
	
	
}
