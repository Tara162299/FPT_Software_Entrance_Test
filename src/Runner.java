import Exception.Customer.CheckCustomerName;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Runner {
    public static void main(String[] args) throws CheckCustomerName {

        Customer customer = new Customer(5, "Tara", "116", "202.555.1255");
        //Customer customer1 = new Customer(5, "", "116", 15);
        // Customer customer2 = new Customer(5, null, "116", 15);
        customer.EditCustomer(5, "Martin", "116", null);

        Order order = new Order(5, 5, 5f, "30/02/2023");

    }
}
