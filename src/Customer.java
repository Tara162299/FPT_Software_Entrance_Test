import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Pattern;

import Exception.Customer.CheckCustomerID;
import Exception.Customer.CheckCustomerName;

public class Customer {
    private int CustomerID;
    private String CustomerName;
    private String Address;
    private String Phone;

    public String getCustomerName() {
        return CustomerName;
    }

    public int getCustomerID() {
        return CustomerID;
    }


    public Customer() {
    }

    public Customer(int CustomerID, String CustomerName, String Address, String Phone) {
        this.CustomerID = CustomerID;

        //Check format of Customer's name
        try {
            if (CustomerName == null || CustomerName.equals("")) {
                throw new CheckCustomerName("The customer name is not valid");
            } else {
                this.CustomerName = CustomerName;
            }
        } catch (CheckCustomerName ex) {
            ex.printStackTrace();
        }

        this.Address = Address;

        //Check format of Customer's phone number
        try {
            //Pattern for phone's format for 0978325511
            Pattern PhonePattern = Pattern.compile("^(\\d{3}[- .]?){2}\\d{4}$");

            if (!(PhonePattern.matcher(Phone).matches())) {
                throw new CheckCustomerName("The customer phone number is not valid");
            } else {
                this.Phone = Phone;
            }
        } catch (CheckCustomerName ex) {
            ex.printStackTrace();
        }
    }

    //Add existing customer to the file of Customers
    public void AddCustomer() {
        // Before adding, check if the customer has at least the name and ID
        if (CustomerID != 0 && (CustomerName != "" || CustomerName != null)) {
            File file = new File("Resources/Customers.txt");
            FileWriter fw;
            try {
                fw = new FileWriter(file.getAbsolutePath(), true);
                fw.write("Customer: " + CustomerName + "| ID: " + CustomerID + "| Address:  " + Address + "| Phone: " + Phone + "\n");

                fw.flush();
                fw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        else if (CustomerID == 0){
            try {
                throw new CheckCustomerID("The customer ID is not valid");
            } catch (CheckCustomerID e) {
                throw new RuntimeException(e);
            }
        }

        else if (CustomerName != "" || CustomerName != null) {
            try {
                throw new CheckCustomerName("The customer name is not valid");
            } catch (CheckCustomerName e) {
                throw new RuntimeException(e);
            }
        }
    }

    // Edit info from an existing Customer, including all attributes
    public void EditCustomer(int CustomerID, String CustomerName, String Address, String Phone) {
        this.CustomerID = CustomerID;

        //Check format of Customer's name
        try {
            if (CustomerName == null || CustomerName.equals("")) {
                throw new CheckCustomerName("The customer name is not valid");
            } else {
                this.CustomerName = CustomerName;
            }
        } catch (CheckCustomerName ex) {
            ex.printStackTrace();
        }

        this.Address = Address;

        //Check format of Customer's phone number
        try {
            //Pattern for phone's format for 0978325511, 202.555.1255
            Pattern PhonePattern = Pattern.compile("^(\\d{3}[- .]?){2}\\d{4}$");

            if (Phone == null) {
                this.Phone = null;
            } else if (!(PhonePattern.matcher(Phone).matches())) {
                throw new CheckCustomerName("The customer phone number is not valid");
            } else {
                this.Phone = Phone;
            }
        } catch (CheckCustomerName ex) {
            ex.printStackTrace();
        }
    }

    //Remove this customer from
    public void DeleteCustomer() {
    }
}
