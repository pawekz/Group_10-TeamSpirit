/*
 * Created by JFormDesigner on Mon Dec 18 08:28:13 PST 2023
 */

package com.pos.teamspirit;


import loginandsignup.Login;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.sql.*;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Paulo "Pawekz" Carabuena
 */
public class POS_StartingWithdrawCash  {

    private void startingCashConfirm(ActionEvent e) {
        // TODO add your code here


        double startingCash = Double.parseDouble(startingCashTextField.getText());
        int cashierID = 1;
        String startTimeOfTransaction = ZonedDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));


        DatabaseConnection con = new DatabaseConnection();
        Connection connection = con.getConnection();

        try{
            String query = "INSERT INTO teamspiritpos.sales (cashier_id, start_time, starting_cash) VALUES (?,?,?)";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setInt(1, cashierID); //it shouldn't be hardcoded, it should be fetch from the login page
            pst.setString(2, startTimeOfTransaction);
            pst.setDouble(3, startingCash);
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Starting cash entered successfully");
            pst.close();
            connection.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }


    }
    public POS_StartingWithdrawCash() {
        initComponents();
    }

    private void startingCashCancel(ActionEvent e) {
        startingCashTextField.setText("");

    }

    private void startTransactionPage(ActionEvent e) {
        // TODO add your code here

        POS_Transaction posTransaction = new POS_Transaction();

    }

    private void withdrawCashCancel(ActionEvent e) {
        // TODO add your code here
       withdrawCashTextField.setText("");
    }

    private void withdrawCashConfirm(ActionEvent e) {
        // Obtain cashierID from some source. This could be an input, a config file, a GUI component, etc.
        //
        int cashierID = 1; //Placeholder.

        BigDecimal withdrawCash = new BigDecimal(withdrawCashTextField.getText());

        Connection db = DatabaseConnection.getConnection();
        checkCash(db, cashierID, withdrawCash);
    }

    private void checkCash(Connection db, int cashierID, BigDecimal withdrawCash) {
        try{
            BigDecimal endingCashDB = getEndingCash(db, cashierID);
            if (withdrawCash.compareTo(endingCashDB) == 0) {
                JOptionPane.showMessageDialog(null,"The input cash matches with the calculated ending cash.");
                /*System.out.println("The input cash matches with the calculated ending cash.");*/
            } else {
                JOptionPane.showMessageDialog(null,"The input cash does not match with the calculated ending cash.\nPlease recheck your cash register and recount the money" );
                /*System.out.println("The input cash does not match with the calculated ending cash.");*/
                System.out.println("Ending Cash: " + endingCashDB);
            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    private BigDecimal getEndingCash(Connection db, int cashierID) throws SQLException {
        BigDecimal endingCashDB = null;
        String query1 = "SELECT ending_cash as endingCash FROM teamspiritpos.sales WHERE cashier_id = ? ORDER BY sale_id DESC LIMIT 1";
        try (PreparedStatement pstmt = db.prepareStatement(query1)) {
            pstmt.setInt(1, cashierID);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()){
                    endingCashDB = rs.getBigDecimal("endingCash");
                } else {
                    throw new RuntimeException("No sales found for cashier " + cashierID);
                }
            }
        }
        return endingCashDB;
    }

    private void endTransactionPage(ActionEvent e) {
        // TODO add your code here

        //it should call "LoginAndSignUp.java" in 'src/loginandsignup'
        Login login = new Login();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                login.setVisible(true);
            }
        });
        //add dispose function where it should close the POS_StartingWithdrawCash.java
        //it should close
        pos_starting_withdraw_cash.dispose();
    }
        private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - ODETTE PISOWIFI
        pos_starting_withdraw_cash = new JFrame();
        startingCashPanel = new JPanel();
        startingCashLabel = new JLabel();
        startingCashTextField = new JTextField();
        startingCashConfirmButton = new JButton();
        startingCashCancelButton = new JButton();
        withdrawCashPanel = new JPanel();
        withdrawCashLabel = new JLabel();
        withdrawCashTextField = new JTextField();
        withdrawCashConfirmButton = new JButton();
        withdrawCashCancelButton = new JButton();
        startTransactionPageButton = new JButton();
        endTransactionPageButton = new JButton();

        //======== pos_starting_withdraw_cash ========
        {
            pos_starting_withdraw_cash.setTitle("STARTING CASH | WITHDRAW CASH");
            var pos_starting_withdraw_cashContentPane = pos_starting_withdraw_cash.getContentPane();

            //======== startingCashPanel ========
            {
                startingCashPanel.setBorder(new TitledBorder("Starting Cash"));
                startingCashPanel.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax
                .swing.border.EmptyBorder(0,0,0,0),"" /*"JFor\u006dDesi\u0067ner \u0045valu\u0061tion"*/,javax.swing
                .border.TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM,new java.awt.
                Font("Dia\u006cog",java.awt.Font.BOLD,12),java.awt.Color.red
                ),startingCashPanel. getBorder()));startingCashPanel. addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override
                public void propertyChange(java.beans.PropertyChangeEvent e){if("bord\u0065r".equals(e.getPropertyName(
                )))throw new RuntimeException();}});

                //---- startingCashLabel ----
                startingCashLabel.setText("Amount");

                //---- startingCashConfirmButton ----
                startingCashConfirmButton.setText("Confirm");
                startingCashConfirmButton.addActionListener(e -> {
			startingCashConfirm(e);
		});

                //---- startingCashCancelButton ----
                startingCashCancelButton.setText("Clear");
                startingCashCancelButton.addActionListener(e -> startingCashCancel(e));

                GroupLayout startingCashPanelLayout = new GroupLayout(startingCashPanel);
                startingCashPanel.setLayout(startingCashPanelLayout);
                startingCashPanelLayout.setHorizontalGroup(
                    startingCashPanelLayout.createParallelGroup()
                        .addGroup(startingCashPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(startingCashLabel)
                            .addGap(50, 50, 50)
                            .addGroup(startingCashPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addGroup(startingCashPanelLayout.createSequentialGroup()
                                    .addComponent(startingCashConfirmButton)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(startingCashCancelButton))
                                .addComponent(startingCashTextField, GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE))
                            .addContainerGap(39, Short.MAX_VALUE))
                );
                startingCashPanelLayout.setVerticalGroup(
                    startingCashPanelLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, startingCashPanelLayout.createSequentialGroup()
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(startingCashPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(startingCashTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(startingCashLabel))
                            .addGap(18, 18, 18)
                            .addGroup(startingCashPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(startingCashConfirmButton)
                                .addComponent(startingCashCancelButton))
                            .addGap(14, 14, 14))
                );
            }

            //======== withdrawCashPanel ========
            {
                withdrawCashPanel.setBorder(new TitledBorder("Withdraw Cash"));

                //---- withdrawCashLabel ----
                withdrawCashLabel.setText("Amount");

                //---- withdrawCashConfirmButton ----
                withdrawCashConfirmButton.setText("Confirm");
                withdrawCashConfirmButton.addActionListener(e -> {
			withdrawCashConfirm(e);
		});

                //---- withdrawCashCancelButton ----
                withdrawCashCancelButton.setText("Clear");
                withdrawCashCancelButton.addActionListener(e -> withdrawCashCancel(e));

                GroupLayout withdrawCashPanelLayout = new GroupLayout(withdrawCashPanel);
                withdrawCashPanel.setLayout(withdrawCashPanelLayout);
                withdrawCashPanelLayout.setHorizontalGroup(
                    withdrawCashPanelLayout.createParallelGroup()
                        .addGroup(withdrawCashPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(withdrawCashLabel)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                            .addGroup(withdrawCashPanelLayout.createParallelGroup()
                                .addGroup(withdrawCashPanelLayout.createSequentialGroup()
                                    .addComponent(withdrawCashConfirmButton)
                                    .addGap(92, 92, 92)
                                    .addComponent(withdrawCashCancelButton))
                                .addComponent(withdrawCashTextField, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE))
                            .addGap(39, 39, 39))
                );
                withdrawCashPanelLayout.setVerticalGroup(
                    withdrawCashPanelLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, withdrawCashPanelLayout.createSequentialGroup()
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(withdrawCashPanelLayout.createParallelGroup()
                                .addComponent(withdrawCashLabel, GroupLayout.Alignment.TRAILING)
                                .addComponent(withdrawCashTextField, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(withdrawCashPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(withdrawCashCancelButton)
                                .addComponent(withdrawCashConfirmButton))
                            .addContainerGap())
                );
            }

            //---- startTransactionPageButton ----
            startTransactionPageButton.setText("START TRANSACTION");
            startTransactionPageButton.addActionListener(e -> {
			startTransactionPage(e);

		});

            //---- endTransactionPageButton ----
            endTransactionPageButton.setText("END TRANSACTION");
            endTransactionPageButton.addActionListener(e -> {
			endTransactionPage(e); //
		});

            GroupLayout pos_starting_withdraw_cashContentPaneLayout = new GroupLayout(pos_starting_withdraw_cashContentPane);
            pos_starting_withdraw_cashContentPane.setLayout(pos_starting_withdraw_cashContentPaneLayout);
            pos_starting_withdraw_cashContentPaneLayout.setHorizontalGroup(
                pos_starting_withdraw_cashContentPaneLayout.createParallelGroup()
                    .addGroup(pos_starting_withdraw_cashContentPaneLayout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addGroup(pos_starting_withdraw_cashContentPaneLayout.createParallelGroup()
                            .addComponent(startingCashPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(withdrawCashPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(102, 102, 102))
                    .addGroup(GroupLayout.Alignment.TRAILING, pos_starting_withdraw_cashContentPaneLayout.createSequentialGroup()
                        .addContainerGap(240, Short.MAX_VALUE)
                        .addGroup(pos_starting_withdraw_cashContentPaneLayout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, pos_starting_withdraw_cashContentPaneLayout.createSequentialGroup()
                                .addComponent(startTransactionPageButton)
                                .addGap(229, 229, 229))
                            .addGroup(GroupLayout.Alignment.TRAILING, pos_starting_withdraw_cashContentPaneLayout.createSequentialGroup()
                                .addComponent(endTransactionPageButton, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
                                .addGap(228, 228, 228))))
            );
            pos_starting_withdraw_cashContentPaneLayout.setVerticalGroup(
                pos_starting_withdraw_cashContentPaneLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, pos_starting_withdraw_cashContentPaneLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(startingCashPanel, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(startTransactionPageButton)
                        .addGap(28, 28, 28)
                        .addComponent(withdrawCashPanel, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(endTransactionPageButton)
                        .addContainerGap(58, Short.MAX_VALUE))
            );
            pos_starting_withdraw_cash.pack();
            pos_starting_withdraw_cash.setLocationRelativeTo(pos_starting_withdraw_cash.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - ODETTE PISOWIFI
    private JFrame pos_starting_withdraw_cash;
    private JPanel startingCashPanel;
    private JLabel startingCashLabel;
    private JTextField startingCashTextField;
    private JButton startingCashConfirmButton;
    private JButton startingCashCancelButton;
    private JPanel withdrawCashPanel;
    private JLabel withdrawCashLabel;
    private JTextField withdrawCashTextField;
    private JButton withdrawCashConfirmButton;
    private JButton withdrawCashCancelButton;
    private JButton startTransactionPageButton;
    private JButton endTransactionPageButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                POS_StartingWithdrawCash startingWithdrawCash = new POS_StartingWithdrawCash();
                startingWithdrawCash.pos_starting_withdraw_cash.setVisible(true);
            }
        });
    }
}
