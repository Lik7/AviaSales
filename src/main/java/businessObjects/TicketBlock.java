package businessObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TicketBlock {
    private WebElement element;

    private By priceOfTicket = new By.ByXPath(".//*[@data-test-id=\"price\"]"); //цена
    private By startCityOfTicket = new By.ByXPath(".//*[@data-test-id=\"origin-endpoint\"] //*[@data-test-id=\"city\"]");//город вылета в билете
    private By finishCityOfTicket = new By.ByXPath(".//*[@data-test-id=\"destination-endpoint\"] //*[@data-test-id=\"city\"]");//город прилета в билете
    private By startDateOfTicket = new By.ByXPath(".//*[@data-test-id=\"origin-endpoint\"] //*[@data-test-id=\"date\"]");//дата вылета в билете

    public TicketBlock(WebElement element) {
        this.element = element;
    }

    //получаем один билет
    public Ticket getTicket() {
        String price = element.findElement(priceOfTicket).getText();
        List <WebElement> startCity = element.findElements(startCityOfTicket);//города вылета в билете
        List<WebElement> finishCity = element.findElements(finishCityOfTicket);
        String startDate = element.findElement(startDateOfTicket).getText();

        Ticket ticket = new Ticket()
                .setPrice(price)
                .setStartCityThereTicket(startCity.get(0).getText())
                .setStartCityBackTicket(startCity.get(1).getText())
                .setFinishCityThereTicket(finishCity.get(0).getText())
                .setFinishCityBackTicket(finishCity.get(1).getText())
                .setStartDate(startDate);

        return ticket;
    }
}
