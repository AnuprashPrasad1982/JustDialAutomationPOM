package com.justdial.pages;

import com.justdial.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class ChooseSeatsPage extends TestBase {

    @FindBy(xpath = "//h2[contains(text(),'Choose add-ons')]")
    WebElement chooseAddOnsLabel;

    @FindBy(xpath = "//button[text()='Select seats']")
    WebElement selectSeatsBtn;

    //@FindBy(xpath= "((//div[@class='flex flex-column flex-nowrap l-0'])[2]/div/div)[1]")
    @FindBy(xpath = "(//div[@class='flex-inline']//div[contains(@class,'c-pointer')])[1]")
    WebElement selectSeat1;

    @FindBy(xpath = "(//div[@class='flex-inline']//div[contains(@class,'c-pointer')])[2]")
    WebElement selectSeat2;

    @FindBy(xpath = "(//div[@class='flex-inline']//div[contains(@class,'c-pointer')])[3]")
    WebElement selectSeat3;

    @FindBy(xpath = "//button[text()='Next']")
    WebElement nextButton;

    @FindBy(xpath = "//button[text()='Done']")
    WebElement doneButton;

    @FindBy(xpath = "//button[text()='View menu']")
    WebElement viewMenuBtn;

    @FindBy(xpath = "(//div[@class='flex flex-right']/*[local-name()=\"svg\"])[1]")
    WebElement addMeals;

    @FindBy(xpath = "//button[text()='View baggage options']")
    WebElement viewBaggageOptions;

    @FindBy(xpath = "(//div[@class='flex flex-right']/*[local-name()=\"svg\"])[1]")
    WebElement addBaggage;

    @FindBy(xpath = "//h2[text()='Choose add-ons']/following::div//button[text()='Continue']")
    WebElement chooseAddOnsContinueBtn;

    @FindBy(xpath = "//h2[contains(text(),'Add contact details')]//following::input[@data-testid='mobileNumber']")
    WebElement inputAddContactDetailsMobileNumber;

    @FindBy(xpath = "//h2[contains(text(),'Add contact details')]//following::input[@data-testid='email']")
    WebElement inputAddContactDetailsEmail;

    @FindBy(xpath = "(//h2[contains(text(),'Add contact details')]//following::input[@type='checkbox'])[2]")
    WebElement addContactDetailsSendMeTravelOfferChk;

    @FindBy(xpath = "//h2[text()='Add contact details']/following::div//button[text()='Continue']")
    WebElement addContactDetailsContinue;

    @FindBy(xpath = "//h2[text()='Add traveller details']")
    WebElement addTravellerDetailsLabel;


    @FindBy(xpath = "//h2[text()='Add traveller details']/following::div//button[text()='Continue to payment']")
    WebElement addTravellerDetailsContinuneToPayment;


    // Initializing the Page Objects:
    public ChooseSeatsPage() {
        PageFactory.initElements(driver, this);
    }


    public boolean verifyChooseAddOnsLabel() {
        return chooseAddOnsLabel.isDisplayed();
    }

    public void clickSeatButton() {
        selectSeatsBtn.click();
    }

    public void selectSeat() {

        selectSeat1.click();
        selectSeat2.click();
        selectSeat3.click();

    }

    public void clickNextBtn() {
        nextButton.click();
    }

    public void clickDoneButton() {
        doneButton.click();
    }

    public void clickViewMenuBtn() {
        viewMenuBtn.click();
    }

    public void clickAddMeals() {
        addMeals.click();
        addMeals.click();
        addMeals.click();
    }

    public void clickViewBaggageOptions() {
        viewBaggageOptions.click();
    }

    public void clickAddBaggage()

    {
        addBaggage.click();
        addBaggage.click();
        addBaggage.click();
    }

    public void clickChooseAddOnsContinueBtn()
    {
        chooseAddOnsContinueBtn.click();
    }

    public ContactTravellerPage chooseSeatsMealsBaggage() throws Exception
    {
        clickSeatButton();
        Thread.sleep(2000);
        selectSeat();
        clickNextBtn();
        Thread.sleep(2000);
        selectSeat();
        clickDoneButton();
        Thread.sleep(2000);
        clickViewMenuBtn();
        Thread.sleep(2000);
        clickAddMeals();
        clickNextBtn();
        Thread.sleep(2000);
        clickAddMeals();
        clickDoneButton();
        Thread.sleep(2000);
        clickViewBaggageOptions();
        Thread.sleep(2000);
        clickAddBaggage();
        clickNextBtn();
        Thread.sleep(2000);
        clickAddBaggage();
        clickDoneButton();
        Thread.sleep(2000);
        clickChooseAddOnsContinueBtn();
        Thread.sleep(2000);
        return new ContactTravellerPage();
    }

}
