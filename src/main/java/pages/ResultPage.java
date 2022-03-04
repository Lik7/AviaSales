package pages;

import businessObjects.Ticket;
import businessObjects.TicketBlock;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import testData.Cities;
import testData.Dates;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ResultPage {
    private WebDriver driver;

    public ResultPage(WebDriver driver) {
        this.driver = driver;
    }

    private By otherPricesTitle = By.cssSelector(".calendar-matrix-dates");//блок Цены на соседние даты
    private By blockTicket = By.xpath("//*[@data-test-id=\"ticket-desktop\"]"); //блок билета
    private By priceOfTicket = By.xpath("//*[@data-test-id=\"ticket-desktop\"] //*[@data-test-id=\"price\"]"); //цена
   // private By startCityOfTicket = By.xpath("//*[@data-test-id=\"ticket-desktop\"]//*[@data-test-id=\"origin-endpoint\"] //*[@data-test-id=\"city\"]");//город вылета в билете
   // private By finishCityOfTicket = By.xpath("//*[@data-test-id=\"ticket-desktop\"]//*[@data-test-id=\"destination-endpoint\"] //*[@data-test-id=\"city\"]");//город прилета в билете
    private By startDateOfTicket = By.xpath("//*[@data-test-id=\"ticket-desktop\"]//*[@data-test-id=\"origin-endpoint\"] //*[@data-test-id=\"date\"]");//дата вылета в билете

    //создаю коллекцию билетов
    private List<Ticket> createTicketsList() {
        List<WebElement> webElementList = driver.findElements(blockTicket);
        List<Ticket> resultTicketList = new ArrayList<>();
        for (WebElement element : webElementList) {
            TicketBlock ticketBlock = new TicketBlock(element);
            Ticket ticket = ticketBlock.getTicket();
            resultTicketList.add(ticket);
        }
        return resultTicketList;
    }

    @Step("Проверка, что цена отсортирована по возрастанию")
    public void checkSortPrice() {
        waitPricesBlock();
        List<WebElement> webElementList = driver.findElements(priceOfTicket);

        List<String> expectedResult = webElementList.stream().map(data -> data.getText()).sorted().collect(Collectors.toList());
        List<String> actualResult = webElementList.stream().map(data -> data.getText()).collect(Collectors.toList());
        Assert.assertEquals(expectedResult, actualResult, "Цена отсортирована не по возростанию");
    }

    @Step("Проверка правильности города вылета")
    public void checkStartCityInTicket() {
        waitPricesBlock();
        List<String> actualDataCityThere = createTicketsList().stream().map(data -> data.getStartCityThereTicket()).collect(Collectors.toList());
        for (int i = 0; i < actualDataCityThere.size(); i++) {
            System.out.println(actualDataCityThere.get(i));
            Assert.assertEquals(Cities.MOSCOW.getCity(), actualDataCityThere.get(i), "Город вылета не " + Cities.MOSCOW.getCity());
        }
        List<String> actualDataCityBack = createTicketsList().stream().map(data -> data.getStartCityBackTicket()).collect(Collectors.toList());
        for (int i = 0; i < actualDataCityBack.size(); i++) {
            System.out.println(actualDataCityBack.get(i));
            Assert.assertEquals(Cities.ST_PETERSBURG.getCity(), actualDataCityBack.get(i), "Город вылета не " + Cities.ST_PETERSBURG.getCity());
        }
    }

    @Step("Проверка правильности города прилета")
    public void checkFinishCityInTicket() {
        waitPricesBlock();
        List<String> actualData = createTicketsList().stream().map(data -> data.getFinishCityThereTicket()).collect(Collectors.toList());
        for (int i = 0; i < actualData.size(); i++) {
            System.out.println(actualData.get(i));
            Assert.assertEquals(Cities.ST_PETERSBURG.getCity(), actualData.get(i), "Город вылета не " + Cities.ST_PETERSBURG.getCity());
        }
    }

    @Step("Проверка правильности даты вылета")
    public void checkStartDateInTicket() {
        waitPricesBlock();

        List<WebElement> webElementList = driver.findElements(startDateOfTicket);
        List<String> actualData = webElementList.stream().map(data -> data.getText()).collect(Collectors.toList());
        for (int i = 0; i < actualData.size(); i = i + 2) {
            //System.out.println(actualData.get(i));
            Assert.assertEquals(Dates.getDateDDMmmYYYYTomorrow_RUS(), actualData.get(i).substring(0, 11), "Дата вылета не " + Dates.getDateDDMmmYYYYTomorrow_RUS());
        }

        for (int i = 1; i < actualData.size(); i = i + 2) {
            //System.out.println(actualData.get(i));
            Assert.assertEquals(Dates.getDateDDMmmYYYYAfterTomorrow_RUS(), actualData.get(i).substring(0, 11), "Дата вылета не " + Dates.getDateDDMmmYYYYAfterTomorrow_RUS());
        }
    }

    private void waitPricesBlock() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 60);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(otherPricesTitle));//ожидание загрузки блока с ценами на соседние даты и соотв. загрузки всех билетов
    }
}
