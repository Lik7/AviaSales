package businessObjects;

public class Ticket {
    private String price;
    private String startCityThereTicket;
    private String finishCityThereTicket;
    private String startCityBackTicket;
    private String finishCityBackTicket;
    private String startDate;

    public String getPrice() {
        System.out.println("Цена из класса Ticket " + price);

        return price;
    }

    public Ticket setPrice(String price) {
        this.price = price;
        return this;
    }

    public String getStartCityThereTicket() {
        System.out.println("Город вылета из класса Ticket " + startCityThereTicket);

        return startCityThereTicket;
    }

/*    public Ticket setStartCityThereTicket(String startCityThereTicket) {
        this.startCityThereTicket = startCityThereTicket;
        return this;
    }*/

    public Ticket setStartCityThereTicket(String startCityThereTicket) {
        this.startCityThereTicket = startCityThereTicket;
        System.out.println("Метод setStartCityThereTicket класса Ticket " + startCityThereTicket);
        return this;
    }

    public String getFinishCityThereTicket() {
        return finishCityThereTicket;
    }

    public Ticket setFinishCityThereTicket(String finishCityThereTicket) {
        this.finishCityThereTicket = finishCityThereTicket;
        System.out.println("Метод setFinishCityThereTicket класса Ticket " + finishCityThereTicket);
        return this;
    }

    public String getStartCityBackTicket() {
        return startCityBackTicket;
    }

    public Ticket setStartCityBackTicket(String startCityBackTicket) {
        this.startCityBackTicket = startCityBackTicket;
        return this;
    }

    public String getFinishCityBackTicket() {
        return finishCityBackTicket;
    }

    public Ticket setFinishCityBackTicket(String finishCityBackTicket) {
        this.finishCityBackTicket = finishCityBackTicket;
        return this;
    }

    public String getStartDate() {
        return startDate;
    }

    public Ticket setStartDate(String startDate) {
        this.startDate = startDate;
        return this;
    }
}
