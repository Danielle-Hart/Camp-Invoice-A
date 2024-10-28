import java.util.ArrayList;

public class Invoice {
    private String CustomerName;
    private String Address;
    private String Title;
    private ArrayList<LineItem> LineItems;

    public Invoice(String CustomerName, String Address, String Title) {
        this.CustomerName = CustomerName;
        this.Address = Address;
        this.Title = Title;
        this.LineItems = new ArrayList<>();
    }

    public void addLineItem(LineItem Item) {
        LineItems.add(Item);
    }

    public double getTotalAmountDue(){
        double TotalAmount = 0;
        for (LineItem Item: LineItems){
            TotalAmount += Item.getTotalAmount();
        }
        return TotalAmount;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public String getAddress() {
        return Address;
    }

    public ArrayList<LineItem> getLineItems(){
        return LineItems;
    }
}