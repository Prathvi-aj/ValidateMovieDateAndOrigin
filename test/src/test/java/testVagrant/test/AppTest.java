package testVagrant.test;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import testVagrant.test.IMDB.*;
import testVagrant.test.WIKI.*;

public class AppTest {
	WebDriver driver;
	
	@BeforeTest
	public void loadDriver() {
	
		 System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");
		  
		  driver = new ChromeDriver();
	}
	
 
	@Test
	public void validateMovieDateandcountry() {
		 String movieName="K.G.F: Chapter 1";//Pushpa: The Rise,Andhadhun,K.G.F: Chapter 1
		 String date1="";
		 String country1="";
		 String date2="";
		 String country2="";
		
		 
		  HomePage homePage=new HomePage(driver);
		  MoviePage moviePage=new MoviePage(driver);
		  WikiHomePage wikiHomePage=new WikiHomePage(driver);
		  SearchPage searchPage=new SearchPage(driver);
		  
		  homePage.getURL();
		  homePage.enterValueInSearchTab(movieName);
		  homePage.clickOnMovieName();
		  date1= moviePage.getMovieDate();
		  country1=moviePage.getMovieCountry();
		 
		  wikiHomePage.getNavigateURL();
		  wikiHomePage.enterValueInSearchTab(movieName);
		  wikiHomePage.clickOnSearch();
		  date2=searchPage.getMovieDate();
		  country2=searchPage.getMovieCountry();
		  
		  if(date1.contains("("))
			  date1=date1.substring(0,date1.indexOf("(")-1);
		  if(date2.contains("("))
			  date2=date2.substring(0,date2.indexOf("(")-1);
		 // String string = "January 2, 2010";
		  DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
		  DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("d MMMM yyyy", Locale.ENGLISH);
			 
		  LocalDate imdbDate = LocalDate.parse(date1, formatter1);
		  LocalDate wikiDate = LocalDate.parse(date2, formatter2);
			 
		 Assert.assertEquals(imdbDate+"", wikiDate+"","Both Dates Are Same");
		 Assert.assertEquals(country1, country2,"Both Countries Are Same");
		 
		 
		 
	  }
	
	@AfterTest
	public void closeDriver() {
		driver.quit();
	}
}
