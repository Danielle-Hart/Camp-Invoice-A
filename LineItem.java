public class LineItem {
    private Product Product;
    private int Quantity;
    double UnitPrice;

    public LineItem(Product Product, int Quantity, double UnitPrice) {
        this.Product = Product;
        this.Quantity = Quantity;
        this.UnitPrice = UnitPrice;
    }

    public double getTotalAmount(){
        return UnitPrice * Quantity;
    }

    public Product getProduct(){
        return Product;
    }

    public int getQuantity(){
            return Quantity;
    }
}
