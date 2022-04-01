package testData;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


public class Dates {

    //дата вылета завтра
    public static String getDateDDMmmYYYYTomorrow_RUS(){
        return getDateMmmDDYYYY_RUS(1);
    }

    //дата вылета обрантно послезавтра
    public static String getDateDDMmmYYYYAfterTomorrow_RUS(){
        return getDateMmmDDYYYY_RUS(2);
    }

    public static String getDateDDMmmYYYYTomorrow_EN(){
        return getDateMmmDDYYYY_EN(1);
    }

    //дата вылета обрантно послезавтра
    public static String getDateDDMmmYYYYAfterTomorrow_EN(){
        return getDateMmmDDYYYY_EN(2);
    }

    private static String getDateMmmDDYYYY_RUS(int n) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMM yyyy");
        LocalDate todayDayPlusNDays = LocalDate.now().plusDays(n);
        return formatter.format(todayDayPlusNDays);
    }

    private static String getDateMmmDDYYYY_EN(int n) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd yyyy").withLocale(Locale.US);
        LocalDate todayDayPlusNDays = LocalDate.now().plusDays(n);
        return formatter.format(todayDayPlusNDays);
    }
}
