import Exception.Customer.CheckCustomerName;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Runner {
    public static void main(String[] args) throws CheckCustomerName {

        Customer customer1 = new Customer(1, "Tara", "116th Street", "202.555.1255");

        Customer customer2 = new Customer();
        customer2.EditCustomer(2, "Martin", "115th Street", "2163545620");

        customer1.AddCustomer();
        customer2.AddCustomer();

        try {
            customer1.DeleteCustomer();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Order order1 = new Order(5, 5, 5f, "15/11/2022");
        Order order2 = new Order();
        System.out.print(order2.getProductId());

    }
}
