package com.hotwire.qa.pages;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.hotwire.qa.base.TestBase;
import com.hotwire.qa.util.TestUtil;

public class VacationPage extends TestBase {
	static TestUtil util;
	
	
	
	

	// Page Facorty or Object Repo
           @FindBy(linkText = "Vacations")
            static WebElement VacationsTab;


	@FindBy(xpath = "//button[contains(text(),'Flight')]")
	static WebElement flightOption;

	@FindBy(xpath = "//button[contains(text(),'Hotel')]")
	static WebElement hotelOption;

	@FindBy(xpath = "//button[contains(text(),'Car')]")
	static WebElement carOption;

	@FindBy(xpath = "//*[@id='farefinder-package-origin-location-input']")
	WebElement origin;
	
	

	
	
	@FindBy(xpath = "//*[@id='farefinder-package-startdate-input']")
    static WebElement departureDateTxtBox;

	@FindBy(xpath = "//*[@id='farefinder-package-destination-location-input']")
	static WebElement destination;

	@FindBy(xpath= "//*[@id='farefinder-package-enddate-input']")
	WebElement returningDateTxtBox;

	@FindBy(xpath = "//select[@id='farefinder-package-pickuptime-input']")
	WebElement departureTimingSelector;

	@FindBy(xpath = "//select[@id='farefinder-package-dropofftime-input']")
	WebElement returningTiming;

	// New Page opens up with search criteria results
	@FindBy(xpath = "//div[@id='interstitial-message']")
	WebElement processing;

	@FindBy(xpath= "//*[@id='hotelResultTitle']")
	static WebElement pageTitle;

	@FindBy(xpath = "//button[@id='farefinder-package-search-button']")
	static WebElement findADealBtn;

	
	
	
	@FindBy(xpath="//*[@class='flex-link']")
	

	List<WebElement> hotel;

	// Initialize the pageFactory
	public VacationPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions which we will perform
	public  static void vacationTab()
	{
		WebDriverWait wait = new WebDriverWait(driver, 90);
		WebElement element=	wait.until(ExpectedConditions.visibilityOf(VacationsTab));
		
		element.click();
	}

	public static void pageTitle() {
		
		String uri = driver.getCurrentUrl();
		Assert.assertTrue(uri.contains("packages"));

	}

	public void clickonflight() {
		String flight = flightOption.getAttribute("class");
		if (flight.equalsIgnoreCase("hw-btn hw-btn-check hw-btn-check-active")) {

		} else {

			hotelOption.click();
		}
	}

	public static void clickonhotel() {

		String hotel = hotelOption.getAttribute("class");

		if (hotel.equalsIgnoreCase("hw-btn hw-btn-check hw-btn-check-active")) {

		} else {

			hotelOption.click();
		}

	}

	public void clickoncar() {

		String car = carOption.getAttribute("class");
		if (car.equalsIgnoreCase("hw-btn hw-btn-check hw-btn-check-active")) {

		} else {

			carOption.click();
		}
	}

	public void Flyfrom() throws InterruptedException {
		origin.click();
		origin.sendKeys("SFO");
		origin.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		origin.sendKeys(Keys.ENTER);
		
		// WebDriverWait wait = new WebDriverWait(driver,30);
		// WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated((By.origin)));
	//WebDriverWait wait = new WebDriverWait(driver, 90);
	//WebElement element=	wait.until(ExpectedConditions.visibilityOf(origin));
	
	//element.sendKeys("sfo");
	//element.sendKeys(Keys.ENTER);
		
		
	}
	

	public void Flyto() throws InterruptedException

	{
		
		//Select Text Box then Type Then enter

		destination.click();
		destination.sendKeys("LAX");
		destination.sendKeys(Keys.ARROW_DOWN);
		destination.sendKeys(Keys.ARROW_DOWN);
		destination.sendKeys(Keys.ARROW_DOWN);
		
		destination.sendKeys(Keys.ENTER);
		

    //WebDriverWait wait = new WebDriverWait(driver, 90);
	//WebElement element=	wait.until(ExpectedConditions.visibilityOf(destination));
	//Lax, Switzerland
	
		// JavascriptExecutor js = (JavascriptExecutor) driver;
		// String script = "return
		// document.getElementById(\"farefinder-package-destination-location-input\").value;";
		// String text = (String) js.executeScript(script);
		// System.out.println(text);

		/*
		 * while (!text.equalsIgnoreCase("Lax, Switzerland")) { count++;
		 * driver.findElement(By.xpath(
		 * "//*[id='farefinder-package-destination-location-input']")).sendKeys(Keys.
		 * DOWN);
		 * 
		 * text = (String) js.executeScript(script); System.out.println(text); if (count
		 * > 9) { break; }
		 * 
		 * }
		 * 
		 * if (count > 9) { System.out.println("Element not found"); } else {
		 * System.out.println("Element  found");
		 */}

	public void departingCalenderandTime() throws InterruptedException {
		String pattern = "MM/dd/yyyy";
        DateFormat dformat = new SimpleDateFormat(pattern);

        Calendar calendar = Calendar.getInstance();
        Date today = calendar.getTime();
        System.out.println(dformat.format(today));
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        Date tomorrow = calendar.getTime();
        System.out.println(dformat.format(tomorrow));
        String DepartureDate = dformat.format(tomorrow);
        calendar.add(Calendar.DAY_OF_YEAR,21);
        Date afterhreeweek = calendar.getTime();
     
        String ReturnDate = dformat.format(afterhreeweek);


       
        departureDateTxtBox.click();
        departureDateTxtBox.clear();
        departureDateTxtBox.sendKeys(DepartureDate);
        departureDateTxtBox.sendKeys(Keys.TAB);
        
        Thread.sleep(1000);
        //Selecting departure time
      


	}

	public void returningCalender() throws InterruptedException {
		returningDateTxtBox.click();
		String pattern = "MM/dd/yyyy";
		DateFormat dateFormat = new SimpleDateFormat(pattern);

		Calendar calendar = Calendar.getInstance();
		Date today = calendar.getTime();
		calendar.add(Calendar.DAY_OF_YEAR, 21);
		Date threeWeek = calendar.getTime();
		System.out.println(dateFormat.format(threeWeek));
		String ReturnDate = dateFormat.format(threeWeek);
		returningDateTxtBox.click();
		returningDateTxtBox.clear();
		
		returningDateTxtBox.sendKeys(Keys.TAB);

		Thread.sleep(1000);
		returningDateTxtBox.click();
		returningDateTxtBox.clear();
		returningDateTxtBox.sendKeys(ReturnDate);
		returningDateTxtBox.sendKeys(Keys.TAB);
		
		Thread.sleep(2000);

	}

	public void departureTiming()
	{
		try {
            Select depTime = new Select(departureTimingSelector);
            String depTimeValue = "Evening";
            depTime.selectByVisibleText(depTimeValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}

	public void returningTiming() throws InterruptedException {
		
		try {
            Select retTime = new Select(returningTiming);
            String retTimeValue = "Morning";
            retTime.selectByVisibleText(retTimeValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
		Thread.sleep(1000);
		

	}
	

	public void clickonfindADealBtn() throws InterruptedException

	{
		Thread.sleep(1000);
		findADealBtn.click();
		
	}
	
	

	
	
	public void verifyTitle() {
	WebDriverWait wait = new WebDriverWait(driver, 90);
	WebElement element=	wait.until(ExpectedConditions.visibilityOf(pageTitle));
	}
	
	public void hotels()
	
	{
		
		
		System.out.println("Number of Hotels Retrived Successsfully :---"+hotel.size());
		if(!hotel.isEmpty())
		//{
			System.out.println("TestCase Passed Successfully");
		//}
		
		  Assert.assertTrue(!hotel.isEmpty());
	}
	
	
}
