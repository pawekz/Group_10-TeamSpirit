import javax.swing.*;
import java.awt.*;

public class StartSalePage {

    public static void main(String[] args) {
        JFrame frame = new StartSaleFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class StartSaleFrame extends JFrame {
    private JTextField itemField, quantityField;
    private JButton addItemButton, calculateTotalButton;

    public StartSaleFrame() {
        setLayout(new FlowLayout());
        setSize(300, 200);
        setTitle("Start a Sale Page");

        itemField = new JTextField(10);
        quantityField = new JTextField(10);
        addItemButton = new JButton("Add Item to Cart");
        calculateTotalButton = new JButton("Calculate Total");

        add(new JLabel("Add Item:"));
        add(itemField);
        add(new JLabel("Quantity:"));
        add(quantityField);
        add(addItemButton);
        add(calculateTotalButton);
    }
}