import javax.swing.*;
import javax.swing.border.*;
/*
 * Created by JFormDesigner on Sat Dec 16 06:29:52 PST 2023
 */



/**
 * @author Pawekz
 */
public class POS_Transaction {
    public POS_Transaction() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - ODETTE PISOWIFI
        POS_Transaction = new JFrame();
        menuBar2 = new JMenuBar();
        menu2 = new JMenu();
        transactionInfo = new JPanel();
        customerNameTextField = new JTextField();
        customerNameLabel = new JLabel();
        customerAddressLabel = new JLabel();
        customerAddressTextField = new JTextField();
        customerTransactionLabel = new JLabel();
        customerTransactionTextField = new JTextField();
        selectOrderPanel = new JPanel();
        selectOrderScrollPane = new JScrollPane();
        orderTable = new JTable();
        productSelectionPanel = new JPanel();
        productSelectionScrollPane = new JScrollPane();
        productSelectionTable = new JTable();

        //======== POS_Transaction ========
        {
            POS_Transaction.setTitle("ORDER PAGE");
            var POS_TransactionContentPane = POS_Transaction.getContentPane();

            //======== menuBar2 ========
            {

                //======== menu2 ========
                {
                    menu2.setText("FILE");
                }
                menuBar2.add(menu2);
            }
            POS_Transaction.setJMenuBar(menuBar2);

            //======== transactionInfo ========
            {
                transactionInfo.setBorder(new CompoundBorder(
                    new TitledBorder("Transaction Information"),
                    new EmptyBorder(5, 5, 5, 5)));
                transactionInfo.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder
                ( 0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax. swing. border. TitledBorder. CENTER, javax. swing. border
                . TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ), java. awt
                . Color. red) ,transactionInfo. getBorder( )) ); transactionInfo. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void
                propertyChange (java .beans .PropertyChangeEvent e) {if ("bord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException( )
                ; }} );

                //---- customerNameLabel ----
                customerNameLabel.setText("Customer Name:");

                //---- customerAddressLabel ----
                customerAddressLabel.setText("Customer Address:");

                //---- customerTransactionLabel ----
                customerTransactionLabel.setText("Transaction Date");

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
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                            .addComponent(customerTransactionLabel)
                            .addGap(45, 45, 45)
                            .addComponent(customerTransactionTextField, GroupLayout.PREFERRED_SIZE, 309, GroupLayout.PREFERRED_SIZE)
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
                                        .addComponent(customerTransactionLabel))
                                    .addComponent(customerTransactionTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(transactionInfoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(customerAddressLabel)
                                .addComponent(customerAddressTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(36, Short.MAX_VALUE))
                );
            }

            //======== selectOrderPanel ========
            {
                selectOrderPanel.setBorder(new TitledBorder("Order"));

                //======== selectOrderScrollPane ========
                {
                    selectOrderScrollPane.setViewportView(orderTable);
                }

                GroupLayout selectOrderPanelLayout = new GroupLayout(selectOrderPanel);
                selectOrderPanel.setLayout(selectOrderPanelLayout);
                selectOrderPanelLayout.setHorizontalGroup(
                    selectOrderPanelLayout.createParallelGroup()
                        .addGroup(selectOrderPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(selectOrderScrollPane, GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
                            .addContainerGap())
                );
                selectOrderPanelLayout.setVerticalGroup(
                    selectOrderPanelLayout.createParallelGroup()
                        .addGroup(selectOrderPanelLayout.createSequentialGroup()
                            .addComponent(selectOrderScrollPane, GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
                            .addContainerGap())
                );
            }

            //======== productSelectionPanel ========
            {
                productSelectionPanel.setBorder(new TitledBorder("Product"));

                //======== productSelectionScrollPane ========
                {
                    productSelectionScrollPane.setViewportView(productSelectionTable);
                }

                GroupLayout productSelectionPanelLayout = new GroupLayout(productSelectionPanel);
                productSelectionPanel.setLayout(productSelectionPanelLayout);
                productSelectionPanelLayout.setHorizontalGroup(
                    productSelectionPanelLayout.createParallelGroup()
                        .addGroup(productSelectionPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(productSelectionScrollPane, GroupLayout.PREFERRED_SIZE, 437, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
                productSelectionPanelLayout.setVerticalGroup(
                    productSelectionPanelLayout.createParallelGroup()
                        .addGroup(productSelectionPanelLayout.createSequentialGroup()
                            .addComponent(productSelectionScrollPane, GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
                            .addContainerGap())
                );
            }

            GroupLayout POS_TransactionContentPaneLayout = new GroupLayout(POS_TransactionContentPane);
            POS_TransactionContentPane.setLayout(POS_TransactionContentPaneLayout);
            POS_TransactionContentPaneLayout.setHorizontalGroup(
                POS_TransactionContentPaneLayout.createParallelGroup()
                    .addGroup(POS_TransactionContentPaneLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(POS_TransactionContentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(transactionInfo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGroup(POS_TransactionContentPaneLayout.createSequentialGroup()
                                .addComponent(selectOrderPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(productSelectionPanel, GroupLayout.PREFERRED_SIZE, 458, GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(15, Short.MAX_VALUE))
            );
            POS_TransactionContentPaneLayout.setVerticalGroup(
                POS_TransactionContentPaneLayout.createParallelGroup()
                    .addGroup(POS_TransactionContentPaneLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(transactionInfo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(POS_TransactionContentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(selectOrderPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(productSelectionPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            POS_Transaction.pack();
            POS_Transaction.setLocationRelativeTo(POS_Transaction.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - ODETTE PISOWIFI
    private JFrame POS_Transaction;
    private JMenuBar menuBar2;
    private JMenu menu2;
    private JPanel transactionInfo;
    private JTextField customerNameTextField;
    private JLabel customerNameLabel;
    private JLabel customerAddressLabel;
    private JTextField customerAddressTextField;
    private JLabel customerTransactionLabel;
    private JTextField customerTransactionTextField;
    private JPanel selectOrderPanel;
    private JScrollPane selectOrderScrollPane;
    private JTable orderTable;
    private JPanel productSelectionPanel;
    private JScrollPane productSelectionScrollPane;
    private JTable productSelectionTable;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
