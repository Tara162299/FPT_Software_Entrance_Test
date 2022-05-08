import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import Exception.Customer.CheckCustomerName;
import Exception.Order.CheckOrderAmount;
import Exception.Order.CheckOrderDate;
import Exception.Order.CheckOrderID;
import Exception.Product.CheckProduct;
import Exception.Product.CheckProductID;

public class Order {
    private int OrderId;
    private int ProductId;
    private float Amount;
    //private LocalDate OrderDate;
    private String OrderDate;
    private int CustomerId;
    private String CustomerName;

    public int getOrderId() {
        return OrderId;
    }

    public int getProductId() {
        return ProductId;
    }

    public void setProductId(int ProductId) {
        this.ProductId = ProductId;
    }

    public Order() {
    }

    public Order(int OrderId, int ProductId, float Amount, String OrderDate) {
        //Check the validity of Order's ID
        try {
            if (OrderId <= 0) {
                throw new CheckOrderID("The order ID is not valid. Please enter a valid ID");
            } else {
                this.OrderId = OrderId;
            }
        } catch (CheckOrderID ex) {
            ex.printStackTrace();
        }

        //Check the validity of Product's ID
        try {
            if (ProductId <= 0) {
                throw new CheckProductID("The product ID for the order is not valid. Please enter a valid ID");
            } else {
                this.ProductId = ProductId;
            }
        } catch (CheckProductID ex) {
            ex.printStackTrace();
        }

        //Check validity of Order's amount
        try {
            if (Amount <= 0) {
                throw new CheckOrderAmount("The order amount must be a positive number");
            } else if (Amount > (int) Amount) {
                throw new CheckOrderAmount("The order amount must be a round integer");
            } else {
                this.Amount = Amount;
            }
        } catch (CheckOrderAmount e) {
            throw new RuntimeException(e);
        }

        // Check validity of Order's date
        try {
            // Special cases of dates that are invalid.
            if (OrderDate.startsWith("30")) {
                throw new CheckOrderDate("The order date is not valid");
            }

            if (OrderDate.startsWith("00") || OrderDate.startsWith("00", 3)) {
                throw new CheckOrderDate("The order date is not valid");
            }

            if (OrderDate == "" || OrderDate == null) {
                throw new CheckOrderDate("The order date can not be empty");
            }

            Date TodayDate = new Date();
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(OrderDate);

            Pattern OrderDatePattern = Pattern.compile("^(0[1-9]|1\\d|2\\d|3[0-1]|[1-9])/(0[1-9]|1[0-2]|[1-9])/(\\d{4})$");
            // Check if the date input have the format of "dd/MM/yyyy"
            if (!(OrderDatePattern.matcher(OrderDate).matches())) {
                throw new CheckOrderDate("The order date is not valid");

                // Check if the date input is less than current date
            } else if (date.compareTo(TodayDate) < 0) {
                throw new CheckOrderDate("The order date can not be less than the current date");
            } else {
                this.OrderDate = OrderDate;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void CreateOrder(Customer customer) {
        boolean checkOrderValid = false;
        this.CustomerId = customer.getCustomerID();
        this.CustomerName = customer.getCustomerName();

        File file = new File("Resources/Orders.txt");
        FileWriter fw;

        if (OrderId != 0 && ProductId != 0) {
            checkOrderValid = true;
        }

        if (checkOrderValid = true) {
            try {

                fw = new FileWriter(file.getAbsolutePath(), true);
                fw.write("Order ID: " + OrderId + "| Customer name: " + CustomerName + "| Customer ID: " + CustomerId + "| Product ID: " + ProductId
                        + "| Amount: " + Amount + "| Order date: " + OrderDate + "\n");

                fw.flush();
                fw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void EditOrder(int OrderId, int ProductId, float Amount, String OrderDate) {
        //Check the validity of the adjusted Order's ID
        try {
            if (OrderId <= 0) {
                throw new CheckOrderID("The adjusted value for order ID is not valid.");
            } else {
                this.OrderId = OrderId;
            }
        } catch (CheckOrderID ex) {
            ex.printStackTrace();
        }

        //Check the validity of the adjusted Product's ID
        try {
            if (ProductId <= 0) {
                throw new CheckProductID("The adjusted value for product ID for the order is not valid.");
            } else {
                this.ProductId = ProductId;
            }
        } catch (CheckProductID ex) {
            ex.printStackTrace();
        }

        //Check validity of the updated Order's amount
        try {
            if (Amount < 0) {
                throw new CheckOrderAmount("The adjusted value for order amount must be a positive number");
            } else if (Amount > (int) Amount) {
                throw new CheckOrderAmount("The adjusted value for order amount must be a round integer");
            } else {
                this.Amount = Amount;
            }
        } catch (
                CheckOrderAmount e) {
            throw new RuntimeException(e);
        }

        // Check validity of the updated Order's date
        try {
            Date TodayDate = new Date();
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(OrderDate);

            Pattern OrderDatePattern = Pattern.compile("^(0[1-9]|1\\d|2\\d|3[0-1]|[1-9])/(0[1-9]|1[0-2]|[1-9])/(\\d{4})$");

            // Special cases of dates that are invalid.
            if (OrderDate.startsWith("30")) {
                throw new CheckOrderDate("The adjusted order date is not valid");
            }

            if (OrderDate.startsWith("00") || OrderDate.startsWith("00", 3)) {
                throw new CheckOrderDate("The adjusted order date is not valid");
            }

            // Check if the date input have the format of "dd/MM/yyyy"
            if (!(OrderDatePattern.matcher(OrderDate).matches())) {
                throw new CheckOrderDate("The adjusted order date is not valid");

                // Check if the date input is less than current date
            } else if (date.compareTo(TodayDate) < 0) {
                throw new CheckOrderDate("The adjusted order date can not be less than the current date");
            } else {
                this.OrderDate = OrderDate;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
