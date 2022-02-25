
import base.BaseTest;
import org.testng.annotations.Test;
import pages.ResultPage;
import testData.Cities;


public class ChooseFlight extends BaseTest {

    @Test
    public void testChooseFlight() {
        //homePage.enterStartCity(TestData.getStartCity());
        homePage.enterStartCity(Cities.MOSCOW.getCity());
        //homePage.enterFinishCity(TestData.getFinishCity());
        homePage.enterFinishCity(Cities.ST_PETERSBURG.getCity());
        homePage.whenFieldClick();
        homePage.changeDatesOfFly();
        homePage.addRemovePassenger();
        ResultPage resultPage = homePage.findBtnPress();
       // resultPage.checkSortPrice();
        resultPage.checkStartCityInTicket();
        //resultPage.checkFinishCityInTicket();
        //resultPage.checkStartDateInTicket();
    }
}
