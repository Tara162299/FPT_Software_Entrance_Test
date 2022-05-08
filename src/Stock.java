import Exception.Product.CheckProduct;
import Exception.Product.CheckProductID;
import Exception.Product.CheckProductPrice;
import Exception.Product.CheckProductType;
import Exception.Stock.CheckProductQuantity;
import Exception.Stock.CheckProductShop;
import Exception.Stock.CheckStock;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Stock {
    private int ProductId;
    private int Quantity;
    private int ShopNo;

    public Stock() {
    }

    public Stock(int ProductId, int Quantity, int ShopNo) {
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

        //Check the validity of the Product's Quantity
        try {
            if (Quantity < 0) {
                throw new CheckProductQuantity("The value for product quantity must be larger than 0.");
            } else {
                this.Quantity = Quantity;
            }
        } catch (CheckProductQuantity ex) {
            ex.printStackTrace();
        }

        //Check the validity of product's shop
        try {

            if (ShopNo < 0) {
                throw new CheckProductShop("The value for product shop must be larger than 0");
            } else {
                this.ShopNo = ShopNo;
            }
        } catch (CheckProductShop ex) {
            ex.printStackTrace();
        }
    }

    // Add the product to the file of products
    public void AddStock() {
        try {
            if (ProductId > 0 && Quantity >= 0 && ShopNo >= 0) {
                File file = new File("Resources/Stocks.txt");
                FileWriter fw;
                try {
                    fw = new FileWriter(file.getAbsolutePath(), true);
                    fw.write("Product ID: " + ProductId + "| Quantity: " + Quantity + "| Number of shop: " + ShopNo + "\n");

                    fw.flush();
                    fw.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else {
                throw new CheckStock("The stock information is not valid.");
            }
        } catch (CheckStock ex) {
            ex.printStackTrace();
        }
    }

    public void ModifyStock(int ProductId, int Quantity, int ShopNo) {
        //Check the validity of the updated Product's ID
        try {
            if (ProductId <= 0) {
                throw new CheckProductID("The adjusted value for product ID is not valid.");
            } else {
                this.ProductId = ProductId;
            }
        } catch (CheckProductID ex) {
            ex.printStackTrace();
        }

        //Check the validity of the updated Product's Quantity
        try {
            if (Quantity < 0) {
                throw new CheckProductQuantity("The adjusted value for product quantity must be larger or equal to 0.");
            } else {
                this.Quantity = Quantity;
            }
        } catch (CheckProductQuantity ex) {
            ex.printStackTrace();
        }

        //Check the validity of updated number of product's shop
        try {

            if (ShopNo < 0) {
                throw new CheckProductShop("The adjusted value for product shop must be larger or equal to 0");
            } else {
                this.ShopNo = ShopNo;
            }
        } catch (CheckProductShop ex) {
            ex.printStackTrace();
        }
    }

    // Add product to an existing order
    public void SelectStockItem(int ProductId) {

        try {
            // check if the selected order has already had a different product
            if (order.getProductId() > 0 && order.getProductId() != this.ProductId) {
                throw new CheckProduct("The selected order has already had a product");
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
}
