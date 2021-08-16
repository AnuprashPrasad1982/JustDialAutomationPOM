package com.justdial.pages;

import com.justdial.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ContactTravellerPage extends TestBase {

    @FindBy(xpath = "//h2[contains(text(),'Add contact details')]")
    WebElement addContactDetailslabel;

    @FindBy(xpath ="//input[@placeholder='Mobile number']")
    WebElement mobileNumber;

    @FindBy(xpath ="//input[@placeholder='Email address']")
    WebElement emailAddress;

    @FindBy(xpath = "//h2[text()='Add contact details']/following::div//button[text()='Continue']")
    WebElement addContactDetailsContinueBtn;

    @FindBy(xpath = "(//input[@placeholder='First name'])[1]")
    WebElement adult1FirstName;

    @FindBy(xpath = "(//input[@placeholder='Last name'])[1]")
    WebElement adult1LastName;

    @FindBy(xpath = "(//div[@class='p-relative'])[8]/button")
    WebElement adult1Gender;

    @FindBy(xpath = " (//div[@class='p-relative'])[8]//li[text()='Male']")
    WebElement adult1GenderMale;


    @FindBy(xpath = "(//input[@placeholder='First name'])[2]")
    WebElement adult2FirstName;

    @FindBy(xpath = "(//input[@placeholder='Last name'])[2]")
    WebElement adult2LastName;

    @FindBy(xpath = "(//div[@class='p-relative'])[11]/button")
    WebElement adult2Gender;

    @FindBy(xpath = " (//div[@class='p-relative'])[11]//li[text()='Female']")
    WebElement adult2GenderFemale;

    @FindBy(xpath = "(//input[@placeholder='First name'])[3]")
    WebElement child1FirstName;

    @FindBy(xpath = "(//input[@placeholder='Last name'])[3]")
    WebElement child1LastName;

    @FindBy(xpath = "(//div[@class='p-relative'])[14]/button")
    WebElement child1Gender;

    @FindBy(xpath = " (//div[@class='p-relative'])[14]//li[text()='Male']")
    WebElement child1GenderMale;

    @FindBy(xpath = "//*[contains(text(),'Date of birth')]//following::select[1]")
    WebElement dateOfBirthDate;
    @FindBy(xpath = "//*[contains(text(),'Date of birth')]//following::select[2]")
    WebElement dateOfBirthMonth;
    @FindBy(xpath = "//*[contains(text(),'Date of birth')]//following::select[3]")
    WebElement dateOfBirthYear;

    @FindBy(xpath = "//h2[text()='Add traveller details']/following::div//button[text()='Continue to payment']")
    WebElement continueToPaymentBtn;


    // Initializing the Page Objects:
    public ContactTravellerPage() {
        PageFactory.initElements(driver, this);
    }

    public boolean verifyAddContactDetailsLabel(){
        return addContactDetailslabel.isDisplayed();
    }

    public void enterMobileNumber()
    {
        mobileNumber.sendKeys("9898989898");
    }

    public void enterEmailAddress()
    {
        emailAddress.sendKeys("test@test.com");
    }

    public void addContactDetailsContinueBtn()
    {
        addContactDetailsContinueBtn.click();
    }

    public void enterAdult1FirstName()
    {
        adult1FirstName.sendKeys("TestFN1");

    }
    public void enterAdult1LastName()
    {
        adult1LastName.sendKeys("TestLN1");

    }
    public void selectAdult1Gender()
    {
        adult1Gender.click();
        adult1GenderMale.click();

    }

    public void enterAdult2FirstName()
    {
        adult2FirstName.sendKeys("TestFN2");

    }
    public void enterAdult2LastName()
    {
        adult2LastName.sendKeys("TestLN2");

    }
    public void selectAdult2Gender()
    {
        adult2Gender.click();
        adult2GenderFemale.click();

    }


    public void enterChild1FirstName()
    {
        child1FirstName.sendKeys("TestChildFN2");

    }
    public void enterChild1LastName()
    {
        child1LastName.sendKeys("TestChildLN2");

    }
    public void selectChildGender()
    {
        child1Gender.click();
        child1GenderMale.click();

    }

    public void selectChildDOB() throws Exception
    {
        Select DOBDate = new Select(dateOfBirthDate);
        DOBDate.selectByValue("1");
        Thread.sleep(2000);


        Select DOBMonth = new Select(dateOfBirthMonth);
        DOBDate.selectByValue("Jan");
        Thread.sleep(2000);


        Select DOBYear = new Select(dateOfBirthYear);
        DOBDate.selectByValue("2018");
        Thread.sleep(2000);
    }

    public void clickContinueToPaymentBtn()
    {
        continueToPaymentBtn.click();
    }

    public void addContactDetails() throws Exception
    {
        enterMobileNumber();
        enterEmailAddress();
        addContactDetailsContinueBtn();
        Thread.sleep(2000);
    }

    public void addTravellerDetails() throws Exception{

        enterAdult1FirstName();
        enterAdult1LastName();
        selectAdult1Gender();

        enterAdult2FirstName();
        enterAdult2LastName();
        selectAdult2Gender();

        enterChild1FirstName();
        enterChild1LastName();
        selectChildGender();
        selectChildDOB();
        Thread.sleep(2000);

        clickContinueToPaymentBtn();
        Thread.sleep(2000);
    }


}
