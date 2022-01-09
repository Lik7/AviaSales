package pages;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.assertj.core.api.Assertions.*;


import java.util.List;

public class ResultPage {
    private WebDriver driver;

    public ResultPage(WebDriver driver) {
        this.driver = driver;
    }

    //private By otherPricesTitle = By.cssSelector(".prediction-advice");//блок Цены на соседние даты
    private By otherPricesTitle = By.cssSelector("[role=\"presentation\"]");//блок Цены на соседние даты
    private By priceOfTicket = By.xpath("//*[@data-test-id=\"ticket-desktop\"] //*[@data-test-id=\"price\"]"); //цена
    //private By priceOfTicket = By.cssSelector("data-test-id=\"price\""); //цена


    public boolean checkAscendingPrice(List<WebElement> list) {
           return false;
    }

    public List priceList() {
        waitPricesBlock();
        List<WebElement> priceList;

        return priceList = driver.findElements(priceOfTicket);
    }

    private void waitPricesBlock() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 40);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(otherPricesTitle));
    }
}
// [data-test-id="ticket-desktop"] блок с билетом, кроме рекламы
//List<WebElement> addRemoveBtn = driver.findElements(addRemovePassengerBtn);
