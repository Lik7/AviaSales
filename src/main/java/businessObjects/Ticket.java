package businessObjects;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ticket {
    private String price;
    private String startCityThereTicket;
    private String finishCityThereTicket;
    private String startCityBackTicket;
    private String finishCityBackTicket;
    private String startDate;

    //достаем из цены через регулярку цифры и парсим в int
    public int getPrice() {
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(price);
        String str = null;
        if (m.find()) {
            //System.out.println(m.group());
            str = m.group();
        }
        System.out.println("Цена из класса Ticket " + Integer.parseInt(str));
        return Integer.parseInt(str);
    }

    public Ticket setPrice(String price) {
        this.price = price;
        return this;
    }

    public String getStartCityThereTicket() {
        System.out.println("Метод getStartCityThereTicket класса Ticket " + startCityThereTicket);

        return startCityThereTicket;
    }

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
        System.out.println("Метод setStartCityBackTicket класса Ticket " + startCityBackTicket);
        return this;
    }

    public String getFinishCityBackTicket() {
        return finishCityBackTicket;
    }

    public Ticket setFinishCityBackTicket(String finishCityBackTicket) {
        this.finishCityBackTicket = finishCityBackTicket;
        System.out.println("Метод setFinishCityBackTicket класса Ticket " + finishCityBackTicket);
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

/*    public Ticket setStartCityThereTicket(String startCityThereTicket) {
        this.startCityThereTicket = startCityThereTicket;
        return this;
    }*/