/*
 * Created by JFormDesigner on Mon Dec 18 08:28:13 PST 2023
 */

package com.pos.teamspirit;


import loginandsignup.Login;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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


        //Call JohnJohn loginPage.java <<<<<<<<<<<<<<<<<<<<<<<<<<<<
        /*new LoginPage().setVisible(true);
        frame.dispose();*/
    }

    private void startTransactionPage(ActionEvent e) {
        // TODO add your code here

        POS_Transaction posTransaction = new POS_Transaction();
        //posTransaction.startTransaction();

    }

    private void withdrawCashCancel(ActionEvent e) {
        // TODO add your code here
       withdrawCashTextField.setText("");
    }

    private void withdrawCashConfirm(ActionEvent e) {
        // TODO add your code here

        //the logic is quite corny, it should increment the total number of sales in a transactions in order to get the
        // endingcash (endingcash = startingcash + (summation of total amount in every transaction whos cashierID is the same as the logged in cashier within the day
        //but it does demonstrate CRUD except delete functionality



        double endCashInput = Double.parseDouble(withdrawCashTextField.getText()); //should match the database amount
        int cashierID = 1; //it shouldnt be hardcoded, it should be integrate on the loginPage
        String endTimeOfTransaction = ZonedDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        DatabaseConnection con = new DatabaseConnection();
        Connection connection = con.getConnection();
        try{
            String sql = "UPDATE teamspiritpos.sales SET end_time = ?, ending_cash = ? WHERE cashier_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, endTimeOfTransaction);
            statement.setDouble(2, endCashInput);
            statement.setInt(3, cashierID);
            statement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Ending cash entered successfully");
            statement.close();
            connection.close();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
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
                .swing.border.EmptyBorder(0,0,0,0), "JFor\u006dDesi\u0067ner \u0045valu\u0061tion",javax.swing
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
			endTransactionPage(e);
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
