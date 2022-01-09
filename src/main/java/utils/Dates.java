package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Dates {

    public static String getDateMmmDDYYYYTomorrow(){
        return getDateMmmDDYYYY(1);
    }
    public static String getDateMmmDDYYYYAfterTomorrow(){
        return getDateMmmDDYYYY(2);
    }

    private static String getDateMmmDDYYYY(int n) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd yyyy").withLocale(Locale.US);
        LocalDate todayDayPlusNDays = LocalDate.now().plusDays(n);
        return formatter.format(todayDayPlusNDays);
    }
}
