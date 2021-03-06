package pages;

import businessObjects.PassengersBlock;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import testData.Dates;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private By originCity = By.cssSelector("#origin"); //поле Откуда
    private By destinationCity = By.cssSelector("#destination"); //поле Куда
    private By whenField = By.cssSelector("[data-test-id=\"departure-date-field\"]"); //поле Когда

    private By thereDate = By.xpath("//*[contains(@aria-label, \"" + Dates.getDateDDMmmYYYYTomorrow_EN() + "\")]");//дата вылета
    private By backDate = By.xpath("//*[contains(@aria-label, \"" + Dates.getDateDDMmmYYYYAfterTomorrow_EN() + "\")]");//дата прилета

    private By passengersBlock = By.xpath("//*[@class=\"additional-fields__inner-wrap\"]");//блок пассажиры
    private By passengersAndClassField = By.cssSelector("[data-test-id=\"passengers-field\"]");//пассажиры

    private By findBtn = By.cssSelector("[data-test-id=\"form-submit\"]");//кнопка Найти


    @Step("Ввести город вылета")
    public void enterStartCity(String startCity) {
        driver.findElement(originCity).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));//очищает поле от предзаполненного значения
        driver.findElement(originCity).sendKeys(startCity);
    }

    @Step("Ввести город прилета")
    public void enterFinishCity(String finishCity) {
        driver.findElement(destinationCity).clear();
        driver.findElement(destinationCity).sendKeys(finishCity);
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
    public void addPassenger(int countAdults, int countChildren) {
        driver.findElement(passengersAndClassField).click();

        PassengersBlock passengers = new PassengersBlock(driver.findElement(passengersBlock));
        passengers.addAdults(countAdults);
        passengers.addChildren(countChildren);
    }

    @Step("Нажать кнопку Найти")
    public ResultPage findBtnPress() {
        driver.findElement(By.cssSelector("[for=\"clicktripz\"]")).click();
        driver.findElement(findBtn).click();
        return new ResultPage(driver);
    }
}
