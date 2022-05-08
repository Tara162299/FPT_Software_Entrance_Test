import Exception.Product.CheckProduct;
import Exception.Product.CheckProductID;
import Exception.Product.CheckProductPrice;
import Exception.Product.CheckProductType;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Product {
    private int ProductId;
    private float ProductPrice;
    private String ProductType;

    private int OrderId;

    public Product(){}

    public Product(int ProductId, float ProductPrice, String ProductType) {
        //Check the validity of the Product's ID
        try {
            if (ProductId <= 0) {
                throw new CheckProductID("The value for product ID is not valid.");
            } else {
                this.ProductId = ProductId;
            }
        } catch (CheckProductID ex) {
            ex.printStackTrace();
        }

        //Check the validity of the Product's price
        try {
            if (ProductPrice <= 0) {
                throw new CheckProductPrice("The value for product price is not valid.");
            } else {
                this.ProductPrice = ProductPrice;
            }
        } catch (CheckProductPrice ex) {
            ex.printStackTrace();
        }

        //Check the validity of product's type
        try {
            if (ProductType == null || ProductType.equals("")) {
                throw new CheckProductType("The product type is not valid");
            } else {
                this.ProductType = ProductType;
            }
        } catch (CheckProductType ex) {
            ex.printStackTrace();
        }
    }

    // Add the product to the file of products
    public void AddProduct() {
        try {
            if (ProductId != 0) {
                File file = new File("Resources/Orders.txt");
                FileWriter fw;
                try {
                    fw = new FileWriter(file.getAbsolutePath(), true);
                    fw.write("Product ID: " + ProductId + "| Product price: " + ProductPrice + "| Product type: " + ProductType + "\n");

                    fw.flush();
                    fw.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else {
                throw new CheckProductID("The product ID is not valid. Please update the product ID");
            }
        }
        catch (CheckProductID ex) {
            ex.printStackTrace();
        }
    }

    public void ModifyProduct(int ProductId, float ProductPrice, String ProductType) {
        this.ProductId = ProductId;
        this.ProductPrice = ProductPrice;

        //Check the validity of the product's updated type
        try {
            if (ProductType == null || ProductType.equals("")) {
                throw new CheckProductType("The product type is not valid");
            } else {
                this.ProductType = ProductType;
            }
        } catch (CheckProductType ex) {
            ex.printStackTrace();
        }
    }

    // Add product to an existing order
    public void SelectProduct(Order order) {

        try {
            // check if the selected order has already had a different product
            if (order.getProductId() != 0 && order.getProductId() != this.ProductId) {
                throw new CheckProduct("The selected order has already had a product");
            }
            // check if the selected product has already had added to the order
            else if (order.getProductId() != 0 && order.getProductId() == this.ProductId){
                throw new CheckProduct("The selected product has already been added to the given order");
            }
            // if the order does not have any product, and the selected product ID is not null, add the product to the order
            else if (order.getProductId() == 0 && this.ProductId != 0) {
                this.OrderId = order.getOrderId();
                order.setProductId(this.ProductId);
            }
        }
        catch (CheckProduct e) {
                throw new RuntimeException(e);
            }
    }

}
