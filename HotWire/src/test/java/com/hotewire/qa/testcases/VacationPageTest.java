package com.hotewire.qa.testcases;

import  org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import com.hotwire.qa.base.TestBase;


import com.hotwire.qa.pages.VacationPage;
import com.hotwire.qa.util.TestUtil;

public class VacationPageTest extends TestBase {
	
   
	static VacationPage vacationpage;
	TestUtil testUtil;
	
	
	
	
	VacationPageTest(){
		super();
	}

	

	@BeforeMethod
	public void setUp() {
		initialization();
		vacationpage = new VacationPage();
		testUtil = new TestUtil();
		
		
	}
	
	
	@Test
	public void hotwire() throws InterruptedException 
	{    
		
		VacationPage.vacationTab();
		vacationpage.clickonflight();
		VacationPage.clickonhotel();
		vacationpage.clickoncar();
		vacationpage.Flyfrom();
		
		vacationpage.Flyto();
		
		vacationpage.departingCalenderandTime();
		
		vacationpage.departureTiming();
		vacationpage.returningCalender();
		vacationpage.returningTiming();
		
		vacationpage.clickonfindADealBtn();
		vacationpage.verifyTitle();
		//vacationpage.waitresultprocessing();
		vacationpage.hotels();
		
		
		
		
	}

	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	

}
