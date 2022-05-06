import java.util.regex.Pattern;

import Exception.Customer.CheckCustomerName;

public class Customer {
    private int CustomerID;
    private String CustomerName;
    private String Address;
    private String Phone;

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

    public Customer() {
    }

    //Add existing customer to the database
    public void AddCustomer(Customer customer) {
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
