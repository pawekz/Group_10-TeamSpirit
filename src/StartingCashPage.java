import javax.swing.*;
import java.awt.*;

public class StartingCashPage {

    public static void main(String[] args) {
        JFrame frame = new StartingCashFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class StartingCashFrame extends JFrame {
    private JTextField startingCashField, withdrawCashField;
    private JButton submitButton;

    public StartingCashFrame() {
        setLayout(new FlowLayout());
        setSize(300, 200);
        setTitle("Starting Cash Page");

        startingCashField = new JTextField(10);
        withdrawCashField = new JTextField(10);
        submitButton = new JButton("Submit");

        add(new JLabel("Starting Cash in Drawer:"));
        add(startingCashField);
        add(new JLabel("Withdraw Cash from Drawer:"));
        add(withdrawCashField);
        add(submitButton);
    }
}