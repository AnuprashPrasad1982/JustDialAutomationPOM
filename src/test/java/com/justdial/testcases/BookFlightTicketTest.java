package com.justdial.testcases;

import com.justdial.base.TestBase;
import com.justdial.pages.*;
import org.testng.Assert;
import org.testng.annotations.*;

public class BookFlightTicketTest extends TestBase {
    ItineraryPage itineraryPage;
    SearchFlightsPage searchFlightsPage;
    BookingPage bookingPage;
    ChooseSeatsPage chooseSeatsPage;
    ContactTravellerPage contactTravellerPage;
    public BookFlightTicketTest() {
        super();
    }

    @BeforeClass
    public void setUp() {
        initialization();
        bookingPage = new BookingPage();
        itineraryPage = new ItineraryPage();
        searchFlightsPage = new SearchFlightsPage();
        chooseSeatsPage = new ChooseSeatsPage();
        contactTravellerPage = new ContactTravellerPage();

    }

    @Test(priority=1)
    public void searchFlightsTest() throws Exception {
        String homePageTitle = searchFlightsPage.verifySearchFlightsPageTitle();
        Assert.assertEquals(homePageTitle, "#1 Site for Booking Flights, Hotels, Packages, Trains & Local activities.","Home page title not matched");

        boolean searchFlightText = searchFlightsPage.verifysearchFlightText();
        Assert.assertEquals(searchFlightText, true,"search flight text is displayed");

        bookingPage = searchFlightsPage.searchflights();


       }

    @Test(priority=2)
    public void bookFlightsTest() throws Exception {
       boolean bookButton = bookingPage.verifyBookLabel();
        Assert.assertEquals(bookButton, true,"Book button is displayed");
       itineraryPage = bookingPage.clickBookFlight();
    }

    @Test(priority=3)
    public void reviewYourItinerary() throws Exception
    {
        itineraryPage.switchtoitinerarypage();
       boolean reviewYourItineraryTxt = itineraryPage.verifyReviewYourItinerayLabel();
       Assert.assertEquals(reviewYourItineraryTxt, true,"Review your Itinerary is displayed");

        chooseSeatsPage = itineraryPage.reviewyouritineraryandcontinue();
    }

    @Test(priority=4)
    public void chooseSeatsMealsBaggageForTwoWays() throws Exception
    {

        boolean verifyChooseAddOnsLabel = chooseSeatsPage.verifyChooseAddOnsLabel();
        Assert.assertEquals(verifyChooseAddOnsLabel, true,"Choose add-ons");

        chooseSeatsPage.chooseSeatsMealsBaggage();

    }
    @Test(priority=5)
    public void addContactTravellerDetails() throws Exception
    {

        boolean verifyAddContactDetailsLabel = contactTravellerPage.verifyAddContactDetailsLabel();
        Assert.assertEquals(verifyAddContactDetailsLabel, true,"Add contact details");

        contactTravellerPage.addContactDetails();
        contactTravellerPage.addTravellerDetails();

    }



    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
