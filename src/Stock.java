import Exception.Product.CheckProductID;
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
    public void SelectStockItem(int Quantity) {

        try {
            // check if the stock for the product is currently empty
            if (this.Quantity <= 0 ) {
                throw new CheckStock("The stock for the product is empty. Please restock");
            }
            // check if the wanted quantity for the product is valid
            else if (Quantity <= 0) {
                throw new CheckStock("The wanted quantity for the product is invalid");
            }
            else if (Quantity > this.Quantity) {
                throw new CheckStock("The wanted quantity for the product is larger than the stock.");
            }
            else {
                this.Quantity -= Quantity;
            }

        } catch (CheckStock e) {
            throw new RuntimeException(e);
        }
    }
}
