package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.Dates;

import java.util.List;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        //ageFactory.initElements((driver), this);
    }

    /*  @FindBy (css = "#origin")
      private By startCity;//поле Откуда

      @FindBy (css = "#destination")
      private By finishCity;//поле Откуда
  */
    private By startCity = By.cssSelector("#origin"); //поле Откуда
    private By finishCity = By.cssSelector("#destination"); //поле Куда
    private By whenField = By.cssSelector("[data-test-id=\"departure-date-field\"]"); //поле Куда

    private By thereDate = By.xpath("//*[contains(@aria-label, \"" + Dates.getDateMmmDDYYYYTomorrow() + "\")]");
    private By backDate = By.xpath("//*[contains(@aria-label, \"" + Dates.getDateMmmDDYYYYAfterTomorrow() + "\")]");

    private By passengersAndClassField = By.cssSelector("[data-test-id=\"passengers-field\"]");
    private By addRemovePassengerBtn = By.cssSelector(".additional-fields__passenger-control");

    private By findBtn = By.cssSelector("[data-test-id=\"form-submit\"]");


    @Step("Ввести город вылета")
    public void enterStartCity() {
        driver.findElement(startCity).clear();
        driver.findElement(startCity).sendKeys("Москва");
    }

    @Step("Ввести город прилета")
    public void enterFinishCity() {
        driver.findElement(finishCity).clear();
        driver.findElement(finishCity).sendKeys("Санкт-Петербург");
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
    public ResultPage findBtnPress(){
        driver.findElement(findBtn).click();
        return new ResultPage(driver);
    }

}
/*
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(screwdriver));*/