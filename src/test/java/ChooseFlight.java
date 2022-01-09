
import base.BaseTest;
import org.assertj.core.api.Assertions;
import org.testng.Assert;
import org.testng.AssertJUnit;
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
        resultPage.priceList();

        Assertions.assertThat(resultPage.priceList()).isSorted();
    }
}
