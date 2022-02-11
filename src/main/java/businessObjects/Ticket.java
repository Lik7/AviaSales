package businessObjects;

public class Ticket {
private String price;
private String startCity;
private String finishCity;
private String startDate;

    public String getPrice() {
        System.out.println("Цена из класса Ticket " + price);
        return price;
    }

    public Ticket setPrice(String price) {
        this.price = price;
        return this;
    }

    public String getStartCity() {
        System.out.println("Город вылета из класса Ticket " + startCity);

        return startCity;
    }

    public Ticket setStartCity(String startCity) {
        this.startCity = startCity;
        return this;
    }

    public String getFinishCity() {
        return finishCity;
    }

    public Ticket setFinishCity(String finishCity) {
        this.finishCity = finishCity;
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
