import Exception.Customer.CheckCustomerName;
import Exception.Product.CheckProduct;

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
        customer2.EditCustomer(2, "Martin", null, null);

        customer1.AddCustomer();

        try {
            customer1.DeleteCustomer();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Order order1 = new Order(1, 5, 5f, "15/11/2022");
        order1.CreateOrder(customer2);
        order1.CreateOrder(customer2);

        Order order2 = new Order();
        order2.EditOrder(2, 12, 4f, "16/08/2022");

    }

    static String displayOrder(int CustomerId) {

        try {
            // check if the selected order has already had a different product
            if (customer.getCustomerID() == CustomerId) {
                return ("Order ID: " + OrderId + "| Customer name: " + CustomerName + "| Customer ID: " + CustomerId + "| Product ID: " + ProductId
                        + "| Amount: " + Amount + "| Order date: " + OrderDate + "\n");
            }
            // check if the selected product has already had added to the order
            else if (order.getProductId() > 0 && order.getProductId() == this.ProductId) {
                throw new CheckProduct("The selected product has already been added to the given order");
            }
            // If the product does not have valid ID
            else if (this.ProductId <= 0 || ProductPrice <= 0) {
                throw new CheckProduct("The selected product is not valid, Cannot add to the given order");
            }
            // if the order does not have any product, and the selected product ID is not null, add the product to the order
            else if (order.getProductId() > 0 && this.ProductId > 0) {
                order.setProductId(this.ProductId);
            }
        } catch (CheckProduct e) {
            throw new RuntimeException(e);
        }
}
