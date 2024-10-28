import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InvoiceApp {
    private JFrame Frame;
    private JTextField CustomerNameField;
    private JTextField CustomerAddressField;
    private JTextField ProductNameField;
    private JTextField ProductPriceField;
    private JTextField QuantityField;
    private JTextArea InvoiceDisplayAreaField;
    private Invoice Invoice;

    public InvoiceApp() {
        Invoice = new Invoice("Danielle's Invoice", "2900 Clifton Ave, Cinncinnati OH, 452219", "\n");

        //FRAME
        Frame = new JFrame("Invoice App");
        Frame.setSize(500, 500);
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame.setLayout(new BorderLayout());

        //PANEL
        JPanel InputPanel = new JPanel();
        InputPanel.setLayout(new GridLayout(6, 2));

        //CUSTOMER NAME
        InputPanel.add(new JLabel("Customer Name:"));
        CustomerNameField = new JTextField();
        InputPanel.add(CustomerNameField);

        //CUSTOMER ADDRESS
        InputPanel.add(new JLabel("Customer Address:"));
        CustomerAddressField = new JTextField();
        InputPanel.add(CustomerAddressField);

        //PRODUCT NAME
        InputPanel.add(new JLabel("Product Name:"));
        ProductNameField = new JTextField();
        InputPanel.add(ProductNameField);

        //PRODUCT PRICE
        InputPanel.add(new JLabel("Product Price:"));
        ProductPriceField = new JTextField();
        InputPanel.add(ProductPriceField);

        //QUANTITY
        InputPanel.add(new JLabel("Quantity:"));
        QuantityField = new JTextField();
        InputPanel.add(QuantityField);

        //LINE ITEM BUTTON
        JButton addItemButton = new JButton("Add Item");
        InputPanel.add(addItemButton);
        addItemButton.addActionListener(new AddItemListener());

        //INVOICE BUTTON
        JButton displayInvoiceButton = new JButton("Display Invoice");
        InputPanel.add(displayInvoiceButton);
        displayInvoiceButton.addActionListener(new DisplayInvoiceListener());

        Frame.add(InputPanel, BorderLayout.NORTH);

        //INVOICE DISPLAY AREA
        InvoiceDisplayAreaField = new JTextArea();
        Frame.add(new JScrollPane(InvoiceDisplayAreaField), BorderLayout.CENTER);

        Frame.setVisible(true);
    }

    private class AddItemListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String ProductName = ProductNameField.getText();
            double Price = Double.parseDouble(ProductPriceField.getText());
            int Quantity = Integer.parseInt(QuantityField.getText());

            Product Product = new Product(ProductName);
            LineItem LineItem = new LineItem (Product, Quantity, Price);
            Invoice.addLineItem(LineItem);

            ProductNameField.setText("");
            ProductPriceField.setText("");
            QuantityField.setText("");
        }
    }

    private class DisplayInvoiceListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            StringBuilder InvoiceDisplay = new StringBuilder();
            InvoiceDisplay.append("Customer:").append(Invoice.getCustomerName()).append("\n");
            InvoiceDisplay.append("Address:").append(Invoice.getAddress()).append("\n");

            for (LineItem Item : Invoice.getLineItems()) {
                InvoiceDisplay.append(Item.getProduct().getProductName()).append(" x ").append(Item.getQuantity()).append(" @ $").append(Item.UnitPrice).append(" each ").append(" = $").append(Item.getTotalAmount()).append(" \n");
            }
            InvoiceDisplay.append("\nTotal Amount Due: $").append(Invoice.getTotalAmountDue());
            InvoiceDisplayAreaField.setText(InvoiceDisplay.toString());
        }
    }

    public static void main(String[] args) {
        new InvoiceApp();
    }
}
