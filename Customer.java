public class Customer {
    private String Name;
    private String Address;

    public Customer(String Name, String Address) {
        this.Name = Name;
        this.Address = Address;
    }

    public String getName() {
        return Name;
    }

    public String getAddress() {
        return Address;
    }
}
