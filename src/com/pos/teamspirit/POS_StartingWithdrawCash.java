package com.pos.teamspirit;

import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;
import javax.swing.border.*;
/*
 * Created by JFormDesigner on Sat Dec 16 06:18:09 PST 2023
 */



/**
 * @author Pawekz
 */
public class POS_StartingWithdrawCash  {

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - ODETTE PISOWIFI
        pos_starting_withdraw_cash = new JFrame();
        panel1 = new JPanel();
        startingCashLabel = new JLabel();
        startingCashTextFIeld = new JTextField();
        startingCashConfirmButton = new JButton();
        startingCashCancelButton = new JButton();
        panel2 = new JPanel();
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

            //======== panel1 ========
            {
                panel1.setBorder(new TitledBorder("Starting Cash"));
                panel1.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax
                . swing. border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn" , javax. swing
                .border . TitledBorder. CENTER ,javax . swing. border .TitledBorder . BOTTOM, new java. awt .
                Font ( "Dia\u006cog", java .awt . Font. BOLD ,12 ) ,java . awt. Color .red
                ) ,panel1. getBorder () ) ); panel1. addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override
                public void propertyChange (java . beans. PropertyChangeEvent e) { if( "\u0062ord\u0065r" .equals ( e. getPropertyName (
                ) ) )throw new RuntimeException( ) ;} } );

                //---- startingCashLabel ----
                startingCashLabel.setText("Amount");

                //---- startingCashConfirmButton ----
                startingCashConfirmButton.setText("Confirm");

                //---- startingCashCancelButton ----
                startingCashCancelButton.setText("Cancel");

                GroupLayout panel1Layout = new GroupLayout(panel1);
                panel1.setLayout(panel1Layout);
                panel1Layout.setHorizontalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(startingCashLabel)
                            .addGap(50, 50, 50)
                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addComponent(startingCashConfirmButton)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(startingCashCancelButton))
                                .addComponent(startingCashTextFIeld, GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE))
                            .addContainerGap(39, Short.MAX_VALUE))
                );
                panel1Layout.setVerticalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                            .addContainerGap(11, Short.MAX_VALUE)
                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(startingCashTextFIeld, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(startingCashLabel))
                            .addGap(18, 18, 18)
                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(startingCashConfirmButton)
                                .addComponent(startingCashCancelButton))
                            .addGap(14, 14, 14))
                );
            }

            //======== panel2 ========
            {
                panel2.setBorder(new TitledBorder("Withdraw Cash"));

                //---- withdrawCashLabel ----
                withdrawCashLabel.setText("Amount");

                //---- withdrawCashConfirmButton ----
                withdrawCashConfirmButton.setText("Confirm");

                //---- withdrawCashCancelButton ----
                withdrawCashCancelButton.setText("Cancel");

                GroupLayout panel2Layout = new GroupLayout(panel2);
                panel2.setLayout(panel2Layout);
                panel2Layout.setHorizontalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(panel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(withdrawCashLabel)
                            .addGap(35, 35, 35)
                            .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(withdrawCashTextField)
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addComponent(withdrawCashConfirmButton)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                                    .addComponent(withdrawCashCancelButton)))
                            .addContainerGap(54, Short.MAX_VALUE))
                );
                panel2Layout.setVerticalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(withdrawCashLabel)
                                .addComponent(withdrawCashTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(withdrawCashConfirmButton)
                                .addComponent(withdrawCashCancelButton))
                            .addContainerGap())
                );
            }

            //---- startTransactionPageButton ----
            startTransactionPageButton.setText("START TRANSACTION");

            //---- endTransactionPageButton ----
            endTransactionPageButton.setText("END TRANSACTION");

            GroupLayout pos_starting_withdraw_cashContentPaneLayout = new GroupLayout(pos_starting_withdraw_cashContentPane);
            pos_starting_withdraw_cashContentPane.setLayout(pos_starting_withdraw_cashContentPaneLayout);
            pos_starting_withdraw_cashContentPaneLayout.setHorizontalGroup(
                pos_starting_withdraw_cashContentPaneLayout.createParallelGroup()
                    .addGroup(pos_starting_withdraw_cashContentPaneLayout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addGroup(pos_starting_withdraw_cashContentPaneLayout.createParallelGroup()
                            .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(startTransactionPageButton)
                        .addGap(28, 28, 28)
                        .addComponent(panel2, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(endTransactionPageButton)
                        .addContainerGap(52, Short.MAX_VALUE))
            );
            pos_starting_withdraw_cash.pack();
            pos_starting_withdraw_cash.setLocationRelativeTo(pos_starting_withdraw_cash.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - ODETTE PISOWIFI
    private JFrame pos_starting_withdraw_cash;
    private JPanel panel1;
    private JLabel startingCashLabel;
    private JTextField startingCashTextFIeld;
    private JButton startingCashConfirmButton;
    private JButton startingCashCancelButton;
    private JPanel panel2;
    private JLabel withdrawCashLabel;
    private JTextField withdrawCashTextField;
    private JButton withdrawCashConfirmButton;
    private JButton withdrawCashCancelButton;
    private JButton startTransactionPageButton;
    private JButton endTransactionPageButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
