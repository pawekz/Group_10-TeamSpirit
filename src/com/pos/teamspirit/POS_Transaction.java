package com.pos.teamspirit;

import loginandsignup.CashierPayment;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.beans.PropertyChangeEvent;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
/*
 * Created by JFormDesigner on Sat Dec 16 06:29:52 PST 2023
 */



/**
 * @author Paulo "Pawekz" Carabuena
 */
public class POS_Transaction extends JFrame{

    public void startTransaction(){
        this.setVisible(true);
    }
    public POS_Transaction() {
        initComponents();                       //butangan siya ani to call the other components
        productListPropertyChange(null);     //needed to display product table, triggered with the event
        //orderListPropertyChange(null);       //display order table
        this.POS_Transaction.setVisible(true);  //similar to frame.setVisible(true)


        customerNameTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                try {
                    if(!customerNameTextField.getText().trim().equals("")) {
                        customerTransactionID(null);
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public JTextField getCustomerNameTextField() {
        return customerNameTextField;
    }

    public JTextField getCustomerAddressTextField() {
        return customerAddressTextField;
    }


    private void customerName(ActionEvent e) {
        // TODO add your code here
        //capture customerNameTextField to be used by other method, make sure it is accessible
        customerNameTextField.getText();
    }

    private void customerAddress(ActionEvent e) {
        // TODO add your code here
        customerAddressTextField.getText();
    }
    

    private void productListPropertyChange(PropertyChangeEvent e) {
        // TODO add your code here


        if (e == null){
            System.out.println("productlist is directly called, no trigger from an event");
        }


        String query = "SELECT product_id, product_name, price FROM teamspiritpos.products";
        try (
                Connection con = DatabaseConnection.getConnection();
                PreparedStatement st = con.prepareStatement(query);
                ResultSet rs = st.executeQuery()
        ) {
            DefaultTableModel tableModel = new DefaultTableModel(new String[]{"Product ID", "Product Name", "Price"}, 0);

            while (rs.next()) {
                String productID = rs.getString("product_id");
                //System.out.println("Product ID: " + productID);     // Debug print
                String productName = rs.getString("product_name");
                //System.out.println("Product Name: " + productName); // Debug print
                String price = rs.getString("price");
                //System.out.println("Price: " + price);              // Debug print
                tableModel.addRow(new Object[]{productID, productName, price});
            }
            productListTable.setModel(tableModel);
            productListTable.revalidate();
            productListTable.repaint();

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("SQL Exception thrown!");           // Debug print
        }
    }

    private void customerSelectedProductPropertyChange(PropertyChangeEvent e) {
        // TODO add your code here
    }

    private void customerSelectedProductTablePropertyChange(PropertyChangeEvent e) {
        // TODO add your code here
    }

    private void cancelTransaction(ActionEvent e) {
        // TODO add your code here
        System.out.println("Time to exit, no more transaction");
        POS_Transaction.dispose(); //close, similar to clicking exit


    }

    private void orderListPropertyChange(PropertyChangeEvent e) {
        // TODO add your code here
    }


    private static final int PRODUCT_NAME_COLUMN = 1;
    private static final int PRODUCT_PRICE_COLUMN = 2;
    private DefaultTableModel model = new DefaultTableModel(new String[]{"Product Name", "Price", "Quantity", "Amount"}, 0);

    private void addProductToOrder(ActionEvent e) {
        int selectedRow = productListTable.getSelectedRow();
        if (selectedRow != -1) {
            Object[] rowData = new Object[4];
            rowData[0] = getProductAtRow(selectedRow); // Product Name
            rowData[1] = getPriceAtRow(selectedRow); // Price is a double
            int quantity = getQuantityFromUser();
            double amount = quantity * (double) rowData[1];
            rowData[2] = quantity;
            rowData[3] = amount;
            model.addRow(rowData);
            orderListTable.setModel(model);

            double totalAmount = calculateTotalAmount();
            totalTextField.setText(totalAmount + ""); // set total amount to the totalTextField.

            orderListTable.revalidate();
            orderListTable.repaint();
            customerSelectedProductTablePropertyChange(null);
        }
    }

    private String getProductAtRow(int row) {
        return productListTable.getValueAt(row, PRODUCT_NAME_COLUMN).toString();
    }

    private Double getPriceAtRow(int row) {
        Object value = productListTable.getValueAt(row, PRODUCT_PRICE_COLUMN);
        if (value instanceof String) {
            try {
                return Double.parseDouble((String) value);
            } catch (NumberFormatException ex) {
                // Handle parsing errors
                ex.printStackTrace();
                return 0.0;
            }
        } else if (value instanceof Double) {
            return (Double)value;
        }
        return 0.0;
    }

    private int getQuantityFromUser() {
        try {
            String input = JOptionPane.showInputDialog("Enter quantity");
            return (input != null && !input.isEmpty()) ? Integer.parseInt(input) : 1;
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "Please enter a valid number (integer).", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            return 1;
        }
    }

    private Double calculateTotalAmount() {
        Double sum = 0.0;
        for (int i = 0; i < model.getRowCount(); i++) {
            sum += (double) model.getValueAt(i, 3); // sum all 'Amount' row
        }
        DecimalFormat df = new DecimalFormat("####0.00");
        return Double.valueOf(df.format(sum));
    }

    private void minusProductToOrder(ActionEvent e) {
        int selectedRow = orderListTable.getSelectedRow();
        if (selectedRow == -1) {
            return;
        }
        int quantity = getQuantityFromUser();
        if (quantity <= 0) {
            return;
        }
        int currentQuantity = (int) orderListTable.getValueAt(selectedRow, 2);
        double price = (double) orderListTable.getValueAt(selectedRow, 1);
        if (quantity >= currentQuantity) {
            model.removeRow(selectedRow);
        } else {
            model.setValueAt(currentQuantity - quantity, selectedRow, 2);
            model.setValueAt((currentQuantity - quantity) * price, selectedRow, 3);
        }

        // it should update the total
        double totalAmount = calculateTotalAmount();
        totalTextField.setText(totalAmount + ""); // set total amount to the totalTextField.
    }

    private void confirmTransaction(ActionEvent e) {
        try {
            // Initialize your database connection first
            DatabaseConnection con = new DatabaseConnection();
            Connection connection = DatabaseConnection.getConnection();

            // Fetch starting cash
            BigDecimal startingCash = new BigDecimal(POS_StartingWithdrawCash.startingCash);

            // Fetch user inputs
            // Fetch user inputs
            String customerName = customerNameTextField.getText();
            String customerAddress = customerAddressTextField.getText();

            if (customerName == null || customerName.trim().isEmpty() || customerAddress == null || customerAddress.trim().isEmpty()) {
                // One of the fields is empty or null. Handle this case (perhaps show an error message and return)
                JOptionPane.showMessageDialog(null, "Customer Name and Address are required.");
                return;
            }

            // Calculate total amount
            Double totalAmount = calculateTotalAmount();

            // Calculate ending cash
            BigDecimal endingCash = startingCash.add(BigDecimal.valueOf(totalAmount));

            // Hardcode cashier_id to '1'
            int cashierId = 1;

            // Prepare SQL statement
            String sql = "INSERT INTO teamspiritpos.sales (cashier_id, start_time, starting_cash, total_amount, ending_cash, customer_name, customer_address) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, cashierId); // set cashier_id
            System.out.println("Cashier ID: " + cashierId);
            String startTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            statement.setString(2, startTime); // set start_time to current timestamp
            System.out.println("Starting Date: " + startTime);
            statement.setBigDecimal(3, startingCash); // set starting_cash
            System.out.println("Starting Cash: " + startingCash);
            statement.setDouble(4, totalAmount); // set total_amount
            System.out.println("Total Amount: " + totalAmount);
            statement.setBigDecimal(5, endingCash); // set ending_cash
            System.out.println("Ending Cash: " + endingCash);
            statement.setString(6, customerName); // set customer_name
            System.out.println("Customer Name: " + customerName);
            statement.setString(7, customerAddress); // set customer_address
            System.out.println("Customer Address: " + customerAddress);

            // Execute query and output result
            int rowsInserted = statement.executeUpdate();
            System.out.println(rowsInserted > 0 ? "New transaction was inserted successfully!" : "No record inserted.");

            // Close resources
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        //call CashierPayment.java in package loginandsignup
        CashierPayment cashierPayment = new CashierPayment();
        cashierPayment.setVisible(true);
    }
    private void customerTransactionID(ActionEvent e) throws SQLException {
        // TODO add your code here
        //it should fetch the autoincrement sale_id in the teamspiritpos.sales

        DatabaseConnection con = new DatabaseConnection();
        Connection connection = DatabaseConnection.getConnection();

        PreparedStatement st = connection.prepareStatement("SELECT MAX(sale_id) FROM teamspiritpos.sales");
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
            int saleId = rs.getInt(1);
            customerTransactionIDTextField.setText(String.valueOf(saleId));
            System.out.println("Transaction ID: " + saleId);
        }
        customerTransactionIDTextField.repaint();
    }



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - ODETTE PISOWIFI
        POS_Transaction = new JFrame();
        transactionInfo = new JPanel();
        customerNameTextField = new JTextField();
        customerNameLabel = new JLabel();
        customerAddressLabel = new JLabel();
        customerAddressTextField = new JTextField();
        customerTransactionIDLabel = new JLabel();
        customerTransactionIDTextField = new JTextField();
        cancelTransactionButton = new JButton();
        confirmTransactionButton = new JButton();
        productList = new JScrollPane();
        productListTable = new JTable();
        orderList = new JScrollPane();
        orderListTable = new JTable();
        addProductToOrderButton = new JButton();
        minusProductToOrderButton = new JButton();
        totalTextField = new JTextField();
        totalLabel = new JLabel();

        //======== POS_Transaction ========
        {
            POS_Transaction.setTitle("ORDER PAGE");
            var POS_TransactionContentPane = POS_Transaction.getContentPane();

            //======== transactionInfo ========
            {
                transactionInfo.setBorder(new CompoundBorder(
                    new TitledBorder("Transaction Information"),
                    new EmptyBorder(5, 5, 5, 5)));
                transactionInfo.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder(
                0, 0, 0, 0) , ""/*"JF\u006frmDes\u0069gner \u0045valua\u0074ion"*/, javax. swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder
                . BOTTOM, new java .awt .Font ("D\u0069alog" ,java .awt .Font .BOLD ,12 ), java. awt. Color.
                red) ,transactionInfo. getBorder( )) ); transactionInfo. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .
                beans .PropertyChangeEvent e) {if ("\u0062order" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} );

                //---- customerNameTextField ----
                customerNameTextField.addActionListener(e -> customerName(e));

                //---- customerNameLabel ----
                customerNameLabel.setText("Customer Name:");

                //---- customerAddressLabel ----
                customerAddressLabel.setText("Customer Address:");

                //---- customerAddressTextField ----
                customerAddressTextField.addActionListener(e -> customerAddress(e));

                //---- customerTransactionIDLabel ----
                customerTransactionIDLabel.setText("Transaction ID");

                //---- customerTransactionIDTextField ----
                customerTransactionIDTextField.setEditable(false);
                customerTransactionIDTextField.addActionListener(e -> {try {
customerTransactionID(e);} catch (SQLException ex) {
    throw new RuntimeException(ex);
}});

                GroupLayout transactionInfoLayout = new GroupLayout(transactionInfo);
                transactionInfo.setLayout(transactionInfoLayout);
                transactionInfoLayout.setHorizontalGroup(
                    transactionInfoLayout.createParallelGroup()
                        .addGroup(transactionInfoLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(transactionInfoLayout.createParallelGroup()
                                .addComponent(customerNameLabel)
                                .addComponent(customerAddressLabel))
                            .addGap(35, 35, 35)
                            .addGroup(transactionInfoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(customerNameTextField, GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                                .addComponent(customerAddressTextField))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 270, Short.MAX_VALUE)
                            .addComponent(customerTransactionIDLabel)
                            .addGap(45, 45, 45)
                            .addComponent(customerTransactionIDTextField, GroupLayout.PREFERRED_SIZE, 309, GroupLayout.PREFERRED_SIZE)
                            .addGap(15, 15, 15))
                );
                transactionInfoLayout.setVerticalGroup(
                    transactionInfoLayout.createParallelGroup()
                        .addGroup(transactionInfoLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(transactionInfoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addGroup(transactionInfoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(customerNameLabel)
                                    .addComponent(customerNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGroup(transactionInfoLayout.createParallelGroup()
                                    .addGroup(transactionInfoLayout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addComponent(customerTransactionIDLabel))
                                    .addComponent(customerTransactionIDTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(transactionInfoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(customerAddressLabel)
                                .addComponent(customerAddressTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(147, Short.MAX_VALUE))
                );
            }

            //---- cancelTransactionButton ----
            cancelTransactionButton.setText("Cancel");
            cancelTransactionButton.addActionListener(e -> cancelTransaction(e));

            //---- confirmTransactionButton ----
            confirmTransactionButton.setText("Confirm");
            confirmTransactionButton.addActionListener(e -> {
			confirmTransaction(e);

		});

            //======== productList ========
            {
                productList.addPropertyChangeListener("horizontalScrollBar", e -> {
			customerSelectedProductPropertyChange(e);

		});
                productList.addPropertyChangeListener("verticalScrollBar", e -> productListPropertyChange(e));

                //---- productListTable ----
                productListTable.addPropertyChangeListener("customerSelect", e -> customerSelectedProductTablePropertyChange(e));
                productList.setViewportView(productListTable);
            }

            //======== orderList ========
            {
                orderList.addPropertyChangeListener("verticalScrollBar", e -> orderListPropertyChange(e));
                orderList.setViewportView(orderListTable);
            }

            //---- addProductToOrderButton ----
            addProductToOrderButton.setText("+");
            addProductToOrderButton.setFont(new Font("Segoe UI", Font.BOLD, 18));
            addProductToOrderButton.setToolTipText("Select products (left) and it will appear in the order list (right)");
            addProductToOrderButton.addActionListener(e -> {
			addProductToOrder(e);
		});

            //---- minusProductToOrderButton ----
            minusProductToOrderButton.setText("-");
            minusProductToOrderButton.setFont(new Font("Segoe UI", Font.BOLD, 18));
            minusProductToOrderButton.setToolTipText("Input the number of quantity to be removed in the order list");
            minusProductToOrderButton.addActionListener(e -> minusProductToOrder(e));

            //---- totalTextField ----
            totalTextField.setEditable(false);
            totalTextField.setFont(new Font("Segoe UI", Font.BOLD, 30));

            //---- totalLabel ----
            totalLabel.setText("TOTAL:");
            totalLabel.setToolTipText("Total Amount");
            totalLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));

            GroupLayout POS_TransactionContentPaneLayout = new GroupLayout(POS_TransactionContentPane);
            POS_TransactionContentPane.setLayout(POS_TransactionContentPaneLayout);
            POS_TransactionContentPaneLayout.setHorizontalGroup(
                POS_TransactionContentPaneLayout.createParallelGroup()
                    .addGroup(POS_TransactionContentPaneLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(POS_TransactionContentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                            .addComponent(transactionInfo, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGroup(GroupLayout.Alignment.LEADING, POS_TransactionContentPaneLayout.createSequentialGroup()
                                .addComponent(productList, GroupLayout.PREFERRED_SIZE, 564, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(POS_TransactionContentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(addProductToOrderButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(minusProductToOrderButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(POS_TransactionContentPaneLayout.createParallelGroup()
                                    .addGroup(GroupLayout.Alignment.TRAILING, POS_TransactionContentPaneLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(cancelTransactionButton))
                                    .addComponent(orderList)))
                            .addGroup(POS_TransactionContentPaneLayout.createSequentialGroup()
                                .addComponent(totalLabel, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(POS_TransactionContentPaneLayout.createParallelGroup()
                                    .addComponent(confirmTransactionButton)
                                    .addComponent(totalTextField, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(30, Short.MAX_VALUE))
            );
            POS_TransactionContentPaneLayout.setVerticalGroup(
                POS_TransactionContentPaneLayout.createParallelGroup()
                    .addGroup(POS_TransactionContentPaneLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(transactionInfo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGroup(POS_TransactionContentPaneLayout.createParallelGroup()
                            .addGroup(POS_TransactionContentPaneLayout.createSequentialGroup()
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(POS_TransactionContentPaneLayout.createParallelGroup()
                                    .addComponent(productList, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
                                    .addComponent(orderList, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(POS_TransactionContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(totalLabel, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(totalTextField, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12))
                            .addGroup(POS_TransactionContentPaneLayout.createSequentialGroup()
                                .addGap(103, 103, 103)
                                .addComponent(addProductToOrderButton)
                                .addGap(18, 18, 18)
                                .addComponent(minusProductToOrderButton)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 292, Short.MAX_VALUE)))
                        .addGroup(POS_TransactionContentPaneLayout.createParallelGroup()
                            .addComponent(cancelTransactionButton)
                            .addComponent(confirmTransactionButton))
                        .addGap(37, 37, 37))
            );
            POS_Transaction.pack();
            POS_Transaction.setLocationRelativeTo(POS_Transaction.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - ODETTE PISOWIFI
    private JFrame POS_Transaction;
    private JPanel transactionInfo;
    private JTextField customerNameTextField;
    private JLabel customerNameLabel;
    private JLabel customerAddressLabel;
    private JTextField customerAddressTextField;
    private JLabel customerTransactionIDLabel;
    private JTextField customerTransactionIDTextField;
    private JButton cancelTransactionButton;
    private JButton confirmTransactionButton;
    private JScrollPane productList;
    private JTable productListTable;
    private JScrollPane orderList;
    private JTable orderListTable;
    private JButton addProductToOrderButton;
    private JButton minusProductToOrderButton;
    private JTextField totalTextField;
    private JLabel totalLabel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
