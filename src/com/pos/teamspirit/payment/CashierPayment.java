/*
 * Created by JFormDesigner on Fri Dec 22 19:07:43 PST 2023
 */

package com.pos.teamspirit.payment;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Pawekz
 */
public class CashierPayment extends JFrame {
    public CashierPayment() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - ODETTE PISOWIFI
        modeOfPaymentTitle = new JLabel();
        cashLabel = new JLabel();

        //======== this ========
        var contentPane = getContentPane();

        //---- modeOfPaymentTitle ----
        modeOfPaymentTitle.setText("SELECT MODE OF PAYMENT");
        modeOfPaymentTitle.setFont(new Font("Ubuntu", Font.BOLD | Font.ITALIC, 20));

        //---- cashLabel ----
        cashLabel.setText("CASH");
        cashLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(338, Short.MAX_VALUE)
                    .addComponent(modeOfPaymentTitle)
                    .addGap(279, 279, 279))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(125, 125, 125)
                    .addComponent(cashLabel)
                    .addContainerGap(729, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(69, 69, 69)
                    .addComponent(modeOfPaymentTitle)
                    .addGap(74, 74, 74)
                    .addComponent(cashLabel)
                    .addContainerGap(449, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - ODETTE PISOWIFI
    private JLabel modeOfPaymentTitle;
    private JLabel cashLabel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
