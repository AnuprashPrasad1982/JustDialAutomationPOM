package com.justdial.pages;

import com.justdial.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.Select;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class SearchFlightsPage extends TestBase {

	@FindBy(xpath = "//h2[text()='Search flights']")
	WebElement searchFlightText;

	@FindBy(css=".radio:nth-child(2) .radio__circle")
	WebElement roundTripRadio;

	@FindBy(xpath ="//h4[contains(text(),'From')]//following-sibling::div//input")
	WebElement searchflightFrom;

	@FindBy(xpath ="//h4[contains(text(),'To')]//following-sibling::div//input")
	WebElement searchflightTo;

	@FindBy(xpath ="//h4[contains(text(),'From')]//following-sibling::div//ul")
	WebElement searchflightFromlist;

	@FindBy(xpath ="//h4[contains(text(),'To')]//following-sibling::div//ul")
	WebElement searchflightTolist;

	@FindBy(xpath = "//h4[contains(text(),'Depart on')]//following::div[2]//button[1]/div")
	WebElement departOn;

	@FindBy(xpath = "//h4[contains(text(),'Return on')]//following::div[2]//button[2]/div")
	WebElement returnOn;

 	@FindBy(xpath = "//h4[contains(text(),'Adults')]//following::select[1]")
	WebElement selectAdults;
	@FindBy(xpath = "//h4[contains(text(),'Children')]//following::select[1]")
	WebElement selectChildren;

	@FindBy(xpath = "//button[text()='Search flights']")
	WebElement searchFlightsBtn;

	// Initializing the Page Objects:
	public SearchFlightsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifySearchFlightsPageTitle(){
		return driver.getTitle();
	}
	
	
	public boolean verifysearchFlightText(){
		return searchFlightText.isDisplayed();
	}

	public void clickRoundTrip() {roundTripRadio.click();}

	public void searchflightFrom() throws  Exception{
		searchflightFrom.click();
		searchflightFrom.sendKeys("Mumbai");
		Thread.sleep(2000);
		List<WebElement> originOptions = searchflightFromlist.findElements(By.tagName("li"));
		originOptions.get(0).click();
		Thread.sleep(2000);
	}

	public void searchflightTo() throws  Exception{
		searchflightTo.click();
		searchflightTo.sendKeys("Delhi");
		Thread.sleep(2000);
		List<WebElement> originOptions = searchflightTolist.findElements(By.tagName("li"));
		originOptions.get(0).click();
		Thread.sleep(2000);
	}

	public void departOn() throws Exception {
		departOn.click();

		SimpleDateFormat df = new SimpleDateFormat("dd/MM/YYYY");
		Date dt = new Date();
		Calendar cl = Calendar.getInstance();
		cl.setTime(dt);;
		cl.add(Calendar.DAY_OF_YEAR, 2);
		dt=cl.getTime();
		String str = df.format(dt);
		String date = str.split("/")[0];
		System.out.println("the date today + plus 2 day is " + str.split("/")[0]);

		Thread.sleep(2000);
		WebElement cal;
		cal=driver.findElement(By.xpath("//div[contains(@class,\"DayPicker-Day--today\")]"));
		String caltoday = cal.getText();
		System.out.println("the date today is"+caltoday);

		WebElement calcurrentmonth = driver.findElement(By.xpath("(//div[@class='DayPicker-Body'])[1]"));
		String caldt;
		Boolean flag=false;
		/**
		 * Select the Date
		 */
		List<WebElement> rows,cols;
		rows=calcurrentmonth.findElements(By.className("DayPicker-Week"));
		for (int i = 1; i < rows.size(); i++)
		{
			cols=rows.get(i).findElements(By.className("DayPicker-Day"));
			for (int k = 0; k < cols.size(); k++)
			{
				caldt=cols.get(k).getText();
				if (caldt.equals(date))
				{
					cols.get(k).click();
					Thread.sleep(2000);
					cols.get(k).click();
					flag = true;
					break;
				}
			}
			if(flag) break;
		}



	}

	public void returnOn() throws Exception {
		returnOn.click();

		SimpleDateFormat df = new SimpleDateFormat("dd/MM/YYYY");
		Date dt = new Date();
		Calendar cl = Calendar.getInstance();
		cl.setTime(dt);;
		cl.add(Calendar.DAY_OF_YEAR, 4);
		dt=cl.getTime();
		String str = df.format(dt);
		String date = str.split("/")[0];
		System.out.println("the date today + plus 2 day is " + str.split("/")[0]);

		Thread.sleep(2000);
		WebElement cal;
		cal=driver.findElement(By.xpath("//div[contains(@class,\"DayPicker-Day--selected\")]"));
		String caltoday = cal.getText();
		System.out.println("the selected date is:"+caltoday);

		WebElement calcurrentmonth = driver.findElement(By.xpath("(//div[@class='DayPicker-Body'])[1]"));
		String caldt;
		Boolean flag=false;
		/**
		 * Select the Date
		 */
		List<WebElement> rows,cols;
		rows=calcurrentmonth.findElements(By.className("DayPicker-Week"));
		for (int i = 1; i < rows.size(); i++)
		{
			cols=rows.get(i).findElements(By.className("DayPicker-Day"));
			for (int k = 0; k < cols.size(); k++)
			{
				caldt=cols.get(k).getText();
				if (caldt.equals(date))
				{
					cols.get(k).click();
					Thread.sleep(2000);
					flag = true;
					break;
				}
			}if(flag) break;
		}



	}

    public void selectAdults() throws  Exception {
		Select drpAdults = new Select(selectAdults);
		drpAdults.selectByValue("2");
		Thread.sleep(2000);

	}

	public void selectChildren() throws  Exception {
		Select drpAdults = new Select(selectChildren);
		drpAdults.selectByValue("1");
		Thread.sleep(2000);

	}

	public void clickonSearchFlights() throws Exception
	{
		searchFlightsBtn.click();
		Thread.sleep(2000);
	}
	public BookingPage searchflights() throws Exception
	{
		clickRoundTrip();
		searchflightFrom();
		searchflightTo();
		departOn();
		returnOn();
		selectAdults();
		selectChildren();
		clickonSearchFlights();
		return new BookingPage();
	}
	

	
	
	
	
	
	
	

}
