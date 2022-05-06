import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.regex.Pattern;

import Exception.Order.CheckOrderAmount;
import Exception.Order.CheckOrderDate;

public class Order {
    private int OrderID;
    private int ProductId;
    private float Amount;
    //private LocalDate OrderDate;
    private String OrderDate;
    ;

    public Order() {

    }

    public Order(int OrderID, int ProductId, float Amount, String OrderDate) {
        this.OrderID = OrderID;
        this.ProductId = ProductId;

        //Check validity of Order's amount
        try {
            if (Amount < 0) {
                throw new CheckOrderAmount("The order amount must be a positive number");
            } else if (Amount > (int) Amount) {
                throw new CheckOrderAmount("The order amount must be a round integer");
            } else {
                this.Amount = Amount;
            }
        } catch (
                CheckOrderAmount e) {
            throw new RuntimeException(e);
        }

        // Check validity of Order's date
        try {
            Date TodayDate= new Date();
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(OrderDate);

            Pattern OrderDatePattern = Pattern.compile("^(0[1-9]|1[0-9]|2[0-9]|3[0-1]|[1-9])/(0[1-9]|1[0-2]|[1-9])/([0-9]{4})$");

            if (OrderDate.substring(0, 2) == "30") {
                throw new CheckOrderDate("The order date is not valid");
            }

            if (OrderDate.substring(0, 2) == "00" || OrderDate.substring(3, 5) == "00") {
                throw new CheckOrderDate("The order date is not valid");
            }


            // Check if the date input have the format of "dd/MM/yyyy"
            if (!(OrderDatePattern.matcher(OrderDate).matches())) {
                throw new CheckOrderDate("The order date is not valid");

                // Check if the date input is less than current date"
            } else if (date.compareTo(TodayDate) < 0) {
                throw new CheckOrderDate("The order date can not be less than the current date");
            } else {
                this.OrderDate = OrderDate;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void CreateOrder() {

    }

    public void EditOrder(int OrderId) {

    }

}
