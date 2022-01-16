package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import testData.TestData;
import utils.Dates;

import java.util.List;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private By originCity = By.cssSelector("#origin"); //поле Откуда
    private By destinationCity = By.cssSelector("#destination"); //поле Куда
    private By whenField = By.cssSelector("[data-test-id=\"departure-date-field\"]"); //поле Куда

    private By thereDate = By.xpath("//*[contains(@aria-label, \"" + Dates.getDateMmmDDYYYYTomorrow() + "\")]");//дата вылета
    private By backDate = By.xpath("//*[contains(@aria-label, \"" + Dates.getDateMmmDDYYYYAfterTomorrow() + "\")]");//дата прилета

    private By passengersAndClassField = By.cssSelector("[data-test-id=\"passengers-field\"]");
    private By addRemovePassengerBtn = By.cssSelector(".additional-fields__passenger-control");

    private By findBtn = By.cssSelector("[data-test-id=\"form-submit\"]");//кнопка Найти


    @Step("Ввести город вылета")
    public void enterStartCity() {
        driver.findElement(originCity).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(originCity).sendKeys(TestData.getStartCity());
    }

    @Step("Ввести город прилета")
    public void enterFinishCity() {
        driver.findElement(destinationCity).clear();
        driver.findElement(destinationCity).sendKeys(TestData.getFinishCity());
    }

    @Step("Клик в поле Куда")
    public void whenFieldClick() {
        driver.findElement(whenField).click();
    }

    @Step("Выбор дат полета")
    public void changeDatesOfFly() {
        driver.findElement(thereDate).click();
        driver.findElement(backDate).click();
    }

    @Step("Выбор пассажиров и класса")
    public void changePassengersAndClass() {
        driver.findElement(passengersAndClassField).click();
        driver.findElement(backDate).click();
    }

    @Step("Выбор пассажиров и класса")
    public void addRemovePassenger() {
        driver.findElement(passengersAndClassField).click();
        List<WebElement> addRemoveBtn = driver.findElements(addRemovePassengerBtn);
        addRemoveBtn.get(3).click();
    }

    @Step("Нажать кнопку Найти")
    public ResultPage findBtnPress() {
        driver.findElement(By.cssSelector("[for=\"clicktripz\"]")).click();
        driver.findElement(findBtn).click();
        return new ResultPage(driver);
    }
}
