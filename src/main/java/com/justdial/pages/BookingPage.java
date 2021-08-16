package com.justdial.pages;

import com.justdial.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BookingPage extends TestBase {

	@FindBy(xpath = "//button[text()='Book']")
	WebElement BookBtn;
	

	// Initializing the Page Objects:
	public BookingPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean verifyBookLabel(){
		return BookBtn.isDisplayed();
	}
	
	

	public ItineraryPage clickBookFlight() throws Exception
	{
		BookBtn.click();
		Thread.sleep(5000);
		return new ItineraryPage();
	}


	
	
	

}
