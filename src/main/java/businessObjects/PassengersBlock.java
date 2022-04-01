package businessObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class PassengersBlock {
    private WebElement element;

    public PassengersBlock(WebElement element) {
        this.element = element;
    }

    private By passengersAdults = new By.ByXPath(".//*[@data-test-id=\"passengers-adults-field\"]");//взрослые
    private By passengersChildren = new By.ByXPath(".//*[@data-test-id=\"passengers-children-field\"]");//дети

    private By increment = new By.ByXPath(".//*[@class=\"additional-fields__passenger-control --increment\"]");//+
    private By decrement = new By.ByXPath(".//*[@class=\"additional-fields__passenger-control --decrement\"]");//-
    private By countPassengers = new By.ByXPath(".//*[@class=\"additional-fields__passenger-value\"]");//количество пассажиров

    //метод устанавливает кол-во взрослых пассажиров
    public void addAdults(int count) {
        int actualCount = Integer.parseInt(element.findElement(passengersAdults).findElement(countPassengers).getText());

        if (count != actualCount) {
            countPassengers(count, passengersAdults);
        }
    }

    //метод устанавливает кол-во детей пассажиров
    public void addChildren(int count) {
        int actualCount = Integer.parseInt(element.findElement(passengersChildren).findElement(countPassengers).getText());

        if (count != actualCount) {
            countPassengers(count, passengersChildren);
        }
    }

    private void countPassengers(int count, By locator) {
        Assert.assertFalse(count > 9, "Количество пассажиров может быть максимум 9");
        for (int i = 0; count > i; i++) {
            element.findElement(locator).findElement(increment).click();
        }
    }

}
