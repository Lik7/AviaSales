import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.Locale;

public class TestMetod {
    public static void main(String[] args) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd yyyy").withLocale(Locale.US);
        //DateTimeFormatter formatter2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.valueOf("MMM dd yyyy"));
        LocalDate todayDayPlusNDays = LocalDate.now().plusDays(1);

        System.out.println(formatter.format(todayDayPlusNDays));


    }


}

