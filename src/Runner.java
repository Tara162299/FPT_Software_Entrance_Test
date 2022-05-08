import Exception.Customer.CheckCustomerName;
import Exception.Product.CheckProduct;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

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
        order1.CreateOrder(customer1);


        Order order2 = new Order();
        order2.EditOrder(2, 12, 4f, "16/08/2022");

        ArrayList<Order> orders = new ArrayList<Order>();
        orders.add(order1);
        orders.add(order2);

        displayOrder(1, orders);
        displayOrder(2, orders);

    }

    static void displayOrder(int CustomerId, ArrayList<Order> orders) {
        boolean existOrder = false;

        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getCustomerId() == CustomerId) {
                System.out.println("The order(s) from customer with the ID: " + CustomerId + " are: ");
                System.out.println("Order ID: " + orders.get(i).getOrderId() + "| Customer name: " + orders.get(i).getCustomerName() + "| Customer ID: " + orders.get(i).getCustomerId() + "| Product ID: "
                        + orders.get(i).getProductId() + "| Amount: " + orders.get(i).getOrderAmount() + "| Order date: " + orders.get(i).getOrderDate() + "\n");

                existOrder = true;
            }
        }

        if (existOrder == false) {
            System.out.println("There is no such order from customer with the ID: " + CustomerId);
        }
    }
}
