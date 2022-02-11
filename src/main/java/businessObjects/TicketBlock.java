package businessObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TicketBlock {
    private WebElement element;

    private By priceOfTicket = new By.ByXPath(".//*[@data-test-id=\"price\"]"); //цена
    private By startCityOfTicket = new By.ByXPath(".//*[@data-test-id=\"origin-endpoint\"] //*[@data-test-id=\"city\"]");//город вылета в билете
    private By finishCityOfTicket = new By.ByXPath(".//*[@data-test-id=\"destination-endpoint\"] //*[@data-test-id=\"city\"]");//город прилета в билете
    private By startDateOfTicket = new By.ByXPath(".//*[@data-test-id=\"origin-endpoint\"] //*[@data-test-id=\"date\"]");//дата вылета в билете

    public TicketBlock(WebElement element) {
        this.element = element;
    }

    public Ticket getTicket() {
        String price = element.findElement(priceOfTicket).getText();
        String startCity = element.findElement(startCityOfTicket).getText();
        String finishCity = element.findElement(finishCityOfTicket).getText();
        String startDate = element.findElement(startDateOfTicket).getText();

        Ticket ticket = new Ticket()
                .setPrice(price)
                .setStartCity(startCity)
                .setFinishCity(finishCity)
                .setStartDate(startDate);

        return ticket;
    }
}
