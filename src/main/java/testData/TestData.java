package testData;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class TestData {

    private static String startCity = "Москва";//заданный город вылета
    private static String finishCity = "Санкт-Петербург";//заданный город прилета

    public static String getStartCity() {
        return startCity;
    }

    public static String getFinishCity() {
        return finishCity;
    }

    //дата вылета завтра
    public static String getDateDDMmmYYYYTomorrow(){
        return getDateMmmDDYYYY(1);
    }

    //дата вылета обрантно послезавтра
    public static String getDateDDMmmYYYYAfterTomorrow(){
        return getDateMmmDDYYYY(2);
    }

    private static String getDateMmmDDYYYY(int n) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
        LocalDate todayDayPlusNDays = LocalDate.now().plusDays(n);
        return formatter.format(todayDayPlusNDays);
    }
}
