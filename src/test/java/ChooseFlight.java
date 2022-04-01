
import base.BaseTest;
import org.testng.annotations.Test;
import pages.ResultPage;
import testData.Cities;


public class ChooseFlight extends BaseTest {

    @Test
    public void testChooseFlight() {
        homePage.enterStartCity(Cities.MOSCOW.getCity());
        homePage.enterFinishCity(Cities.ST_PETERSBURG.getCity());
        homePage.whenFieldClick();
        homePage.changeDatesOfFly();
        homePage.addPassenger(1, 1);
        ResultPage resultPage = homePage.findBtnPress();
        resultPage.checkSortPrice();
        resultPage.checkStartCityInTicket();
        resultPage.checkFinishCityInTicket();
        resultPage.checkStartDateInTicket();
    }
}
