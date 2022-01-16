
import base.BaseTest;
import org.testng.annotations.Test;
import pages.ResultPage;


public class ChooseFlight extends BaseTest {
    @Test

    public void testChooseFlight() {
        homePage.enterStartCity();
        homePage.enterFinishCity();
        homePage.whenFieldClick();
        homePage.changeDatesOfFly();
        homePage.addRemovePassenger();
        ResultPage resultPage = homePage.findBtnPress();
        resultPage.checkSortPrice();
        resultPage.checkStartCityInTicket();
        resultPage.checkFinishCityInTicket();
        resultPage.checkStartDateInTicket();
    }
}
