package com.justdial.pages;

import com.justdial.base.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.Set;

public class ItineraryPage extends TestBase {


	//Page Factory - OR:
	@FindBy(xpath = "//h2[(text()='Review your itinerary')]")
	WebElement reviewYourItinerayLabel;

	@FindBy(xpath = "//h3[text()='Standard fare']//preceding::div[2]")
	WebElement standardFareRadiobtn;

	@FindBy(xpath = "//p[contains(text(),'Total price')]/following::p[1]")
	WebElement totalPriceAmount;

	@FindBy(xpath = "//h3[contains(text(),'Protect your trip with travel insurance')]//following::div[1]//button[text()='Add']")
	WebElement travelInsuranceAddBtn;

	@FindBy(xpath = "//button[contains(text(),'Continue')]")
	WebElement continueBtn;

	@FindBy(xpath = "//button[text()='Book at this price']")
	WebElement bookAtThisPriceBtn;




	//Initializing the Page Objects:
	public ItineraryPage(){

		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean verifyReviewYourItinerayLabel(){
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOf(reviewYourItinerayLabel));

		return reviewYourItinerayLabel.isDisplayed();
	}

	public void clickStandardFareRadiobtn()
	{
		standardFareRadiobtn.click();
	}
	public String getTotalPriceAmount()
	{
		return totalPriceAmount.getText();
	}

	public void clickTravelInsuranceAddBtn()
	{
		travelInsuranceAddBtn.click();
	}
	public void clickContinueBtn()
	{
		continueBtn.click();
	}

	public String isTotalFareIncreased(String beforeIncreasedAmount, String afterIncreasedAmount)
	{
		boolean flag= false;
		int iBeforeIncAmt = Integer.parseInt(beforeIncreasedAmount) ;
		int iAfterIncAmt = Integer.parseInt(afterIncreasedAmount) ;

		String result = (iAfterIncAmt>iBeforeIncAmt)?"Total Fare Increased after Adding Travel Insurance":"Total Fare Not Increased after Adding Travel Insurance";
		return result ;
	}

	public void switchtoitinerarypage()
	{
		String mainWindowHandle = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();
		Iterator<String> iterator = allWindowHandles.iterator();
		while (iterator.hasNext()) {
			String ChildWindow = iterator.next();
			if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
				driver.switchTo().window(ChildWindow);
				}
		}
	}

	public void scrolltoelement(WebElement webElement)
	{
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", webElement);
			Thread.sleep(5000);
		}catch (Exception ex)
		{
			ex.printStackTrace();
		}

	}

	public boolean isElementPresent(WebElement element)
	{
		try
		{
			element.getTagName();
			return true;
		}catch(NoSuchElementException ex)
		{
			return false;
		}
	}
public ChooseSeatsPage reviewyouritineraryandcontinue() throws Exception
{
	/*if(isElementPresent(bookAtThisPriceBtn))
	{
		bookAtThisPriceBtn.click();
	}*/

	String TotalfarebeforeAddInsurance = getTotalPriceAmount();
	TotalfarebeforeAddInsurance = TotalfarebeforeAddInsurance.replace("₹","").replace(",","");
	System.out.println("Total fare before AddInsurance:"+TotalfarebeforeAddInsurance);

	scrolltoelement(standardFareRadiobtn);

	clickStandardFareRadiobtn();

	scrolltoelement(travelInsuranceAddBtn);
	clickTravelInsuranceAddBtn();

	scrolltoelement(totalPriceAmount);
	String TotalfareAfterAddInsurance = getTotalPriceAmount();
	TotalfareAfterAddInsurance = TotalfareAfterAddInsurance.replace("₹","").replace(",","");
	System.out.println("Total fare before AddInsurance:"+TotalfarebeforeAddInsurance);

	String result = isTotalFareIncreased(TotalfarebeforeAddInsurance,TotalfareAfterAddInsurance);
	scrolltoelement(continueBtn);
	clickContinueBtn();
	Thread.sleep(5000);
	return new ChooseSeatsPage();

}


	
}
