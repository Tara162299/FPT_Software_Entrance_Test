import Exception.Customer.CheckCustomerName;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Runner {
    public static void main(String[] args) throws CheckCustomerName {

        Customer customer1 = new Customer(5, "Tara", "116", "202.555.1255");
        Customer customer2 = new Customer();
        //customer2.AddCustomer();

        //customer2.EditCustomer(5, "Martin", "116", null);

        Order order1 = new Order(5, 5, 5f, "00/11/2022");
        Order order2 = new Order();
        System.out.print(order2.getProductId());

    }
}
