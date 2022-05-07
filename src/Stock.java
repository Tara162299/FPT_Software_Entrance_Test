public class Stock {
    private int ProductID;
    private int Quantity;
    private int ShopNo;

    public Stock(int ProductID, int Quantity, int ShopNo) {
        this.ProductID = ProductID;

        this.Quantity = Quantity;
        this.ShopNo = ShopNo;
    }

    public void AddStock(int amount) {
        Quantity += amount;
    }

    public void ModifyStock(int ProductId) {

    }

    public void SelectStockItem(int ProductId) {

    }
}
