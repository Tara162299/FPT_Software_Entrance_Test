import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        float num1 = 500000000000000000000000000000000.5f;
        String OrderDate = "20/05/2022";

        SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
        Date date = new Date();
        //System.out.println(formatter.format(date));
        //System.out.println(date);

        //LocalDate localDate = LocalDate.parse("2019-15-20");
        //String date = localDate.format(DateTimeFormatter.ofPattern("MMM dd, yyyy"));
        //String date1 = localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        //System.out.println(date1);

        Date TodayDate = new Date();
        System.out.println(TodayDate);
        try {
            Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(OrderDate);
            System.out.println(date1);
            if (date1.compareTo(TodayDate) < 0) {
                System.out.print(true);
            }
            else {
                System.out.print(false);
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }
}
