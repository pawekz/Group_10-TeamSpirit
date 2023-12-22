package loginandsignup;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CashierProfile extends javax.swing.JFrame {

    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cboStatus;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtUser;
    private javax.swing.JTextField txtFullName;
    private javax.swing.JPasswordField txtPass; // Added this line
    private DefaultTableModel model;

    public CashierProfile() {
        initComponents();
        model = (DefaultTableModel) jTable.getModel();
        fetchDataFromDatabase();
    }

    private void fetchDataFromDatabase() {
        try {
            // JDBC URL, username, and password of MySQL server
            String url = "jdbc:mysql://localhost:3306/teamspiritpos";
            String user = "root";
            String password = "";

            // Establish the connection
            Connection connection = DriverManager.getConnection(url, user, password);

            // The SQL query to select all records from the "cashiers" table
            String sql = "SELECT cashier_id, fullName, username, is_active FROM cashiers";

            try (PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {

                // Clear existing data in the table
                model.setRowCount(0);

                // Populate the table with data from the database
                while (resultSet.next()) {
                    String cashierID = resultSet.getString("cashier_id");
                    String username = resultSet.getString("username");
                    String fullName = resultSet.getString("fullName");
                    String status = resultSet.getString("is_active");

                    model.addRow(new Object[]{cashierID, username, fullName, status});
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception based on your application's requirements
        }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txtID = new javax.swing.JTextField();
        // Add the following line to set txtID non-editable
        txtID.setEditable(false);
        txtPass = new javax.swing.JPasswordField(); // Add this line to initialize txtPass
        cboStatus = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        btnNew = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 18));
        jLabel1.setForeground(new java.awt.Color(255, 255, 153));
        jLabel1.setText("Cashier Profile");

        jButton1.setForeground(new java.awt.Color(255, 51, 51));
        jButton1.setText("EXIT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(224, 224, 224)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel1))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "User Entry", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 0, 18))); // NOI18N

        txtID.setFont(new java.awt.Font("Calibri", 0, 14));
        cboStatus.setFont(new java.awt.Font("Calibri", 0, 14));
        cboStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"--", "Active", "Inactive"}));

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 14));
        jLabel2.setText("Username");
        jLabel4.setFont(new java.awt.Font("Calibri", 0, 14));
        jLabel4.setText("Status");

        btnSave.setFont(new java.awt.Font("Calibri", 0, 14));
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnEdit.setFont(new java.awt.Font("Calibri", 0, 14));
        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Calibri", 0, 14));
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 14));
        jLabel5.setText("Cashier ID");
        jLabel5.setVisible(false);

        txtUser.setFont(new java.awt.Font("Calibri", 0, 14));
        btnNew.setFont(new java.awt.Font("Calibri", 0, 14));
        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        jLabel6 = new javax.swing.JLabel();
        jLabel6.setFont(new java.awt.Font("Calibri", 0, 14));
        jLabel6.setText("Full Name");
        txtFullName = new javax.swing.JTextField();
        txtFullName.setFont(new java.awt.Font("Calibri", 0, 14));

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 14));
        jLabel3.setText("Password");

      javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel2Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                   .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cboStatus, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnNew)
                                .addGap(2, 2, 2)
                                .addComponent(btnSave)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEdit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDelete)))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFullName, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)) // Added this line
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFullName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE) // Added this line
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit)
                    .addComponent(btnDelete)
                    .addComponent(btnNew))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object[][]{},
            new String[]{"ID", "Username", "Full Name", "Status"}
        ) {
            boolean[] canEdit = new boolean[]{false, false, false, false};

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable);
        if (jTable.getColumnModel().getColumnCount() > 0) {
            jTable.getColumnModel().getColumn(0).setMaxWidth(50);
            jTable.getColumnModel().getColumn(1).setMaxWidth(200);
            jTable.getColumnModel().getColumn(2).setMaxWidth(200);
            jTable.getColumnModel().getColumn(3).setMaxWidth(90);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(86, 86, 86))
        );

        setSize(new java.awt.Dimension(870, 555));
        setLocationRelativeTo(null);
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

        private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {
    String cashierID = txtID.getText();
    String username = txtUser.getText();
    String fullName = txtFullName.getText();
    String password = new String(txtPass.getPassword());
    String status = cboStatus.getSelectedItem().toString();

    if (username.isEmpty() || fullName.isEmpty() || password.isEmpty() || status.equals("--")) {
        JOptionPane.showMessageDialog(this, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Check if the username already exists in the database
    if (isUsernameExists(username, cashierID)) {
        JOptionPane.showMessageDialog(this, "Username already exists. Please choose a different username.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
        String url = "jdbc:mysql://localhost:3306/teamspiritpos";
        String user = "root";
        String dbPassword = "";

        Connection connection = DriverManager.getConnection(url, user, dbPassword);

        String sql;
        if (cashierID.isEmpty()) {
            // Insert new cashier entry
            sql = "INSERT INTO cashiers (fullName, username, password, is_active) VALUES (?, ?, ?, ?)";
        } else {
            // Update existing cashier entry
            sql = "UPDATE cashiers SET fullName = ?, username = ?, password = ?, is_active = ? WHERE cashier_id = ?";
        }

        try (PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, fullName);
            statement.setString(2, username);
            statement.setString(3, password);
            statement.setString(4, status);

            // Set the cashierID parameter if it's an update
            if (!cashierID.isEmpty()) {
                statement.setString(5, cashierID);
            }

            int affectedRows = statement.executeUpdate();

            // Check if the insert/update was successful
            if (affectedRows > 0) {
                // If it's an insert, get the generated cashier ID
                if (cashierID.isEmpty()) {
                    try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                        if (generatedKeys.next()) {
                            cashierID = String.valueOf(generatedKeys.getInt(1));
                            txtID.setText(cashierID);
                        }
                    }
                }

                JOptionPane.showMessageDialog(this, "Cashier information saved successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Failed to save cashier information", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        fetchDataFromDatabase();
        clearFields();

    } catch (SQLException e) {
        e.printStackTrace();
        // Handle the exception based on your application's requirements
    }
}



    // Method to check if the username already exists in the database
private boolean isUsernameExists(String username, String currentCashierID) {
    boolean exists = false;

    try {
        // Your existing database connection code...
        
        String url = "jdbc:mysql://localhost:3306/teamspiritpos";
        String user = "root";
        String dbPassword = "";

        Connection connection = DriverManager.getConnection(url, user, dbPassword);

        String sql = "SELECT COUNT(*) FROM cashiers WHERE username = ? AND cashier_id <> ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, username);
            statement.setString(2, currentCashierID);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    exists = count > 0;
                }
            }
        }

    } catch (SQLException e) {
        e.printStackTrace();
        // Handle the exception based on your application's requirements
    }

    return exists;
}


    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {
    // Add code for editing a cashier's information here
    int selectedRowIndex = jTable.getSelectedRow();

    // Check if a row is selected
    if (selectedRowIndex != -1) {
        // Get the values from the selected row
        String cashierID = jTable.getValueAt(selectedRowIndex, 0).toString();
        String username = jTable.getValueAt(selectedRowIndex, 1).toString();
        String fullName = jTable.getValueAt(selectedRowIndex, 2).toString();
        String password = getPasswordFromDatabase(cashierID); // Fetch the password from the database
        String status = jTable.getValueAt(selectedRowIndex, 3).toString();

        // Set the values to the form for editing
        txtID.setText(cashierID);
        txtUser.setText(username);
        txtFullName.setText(fullName);
        txtPass.setText(password);
        cboStatus.setSelectedItem(status);
        // You may choose to disable or modify other components based on your requirements
    } else {
        JOptionPane.showMessageDialog(this, "Please select a row to edit", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

// Method to fetch the password from the database based on the cashierID
private String getPasswordFromDatabase(String cashierID) {
    String password = "";

    try {
        String url = "jdbc:mysql://localhost:3306/teamspiritpos";
        String user = "root";
        String dbPassword = "";

        Connection connection = DriverManager.getConnection(url, user, dbPassword);

        String sql = "SELECT password FROM cashiers WHERE cashier_id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, cashierID);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    password = resultSet.getString("password");
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
        // Handle the exception based on your application's requirements
    }

    return password;
}


        
    

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {
        // Add code for deleting a cashier's information here
        
    // Get the selected row index
    int selectedRowIndex = jTable.getSelectedRow();

    // Check if a row is selected
    if (selectedRowIndex != -1) {
        // Get the value from the selected row
        String cashierID = jTable.getValueAt(selectedRowIndex, 0).toString();

        // Delete the selected cashier entry from the database
        try {
            String url = "jdbc:mysql://localhost:3306/teamspiritpos";
            String user = "root";
            String dbPassword = "";

            Connection connection = DriverManager.getConnection(url, user, dbPassword);

            String sql = "DELETE FROM cashiers WHERE cashier_id = ?";

            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, cashierID);

                // Execute the query
                statement.executeUpdate();
            }

            // Refresh the table with updated data
            fetchDataFromDatabase();

            // Clear the input fields
            clearFields();

            JOptionPane.showMessageDialog(this, "Cashier information deleted successfully", "Success", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception based on your application's requirements
        }
    } else {
        JOptionPane.showMessageDialog(this, "Please select a row to delete", "Error", JOptionPane.ERROR_MESSAGE);
    }
}
        
    

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {
        // Add code for creating a new cashier entry here
        
        // Clear the input fields
    clearFields();
    // Enable or modify other components based on your requirements

        
    }

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {
        // Add code to handle mouse clicks on the table (e.g., for selecting a row to edit)
    }

    private void clearFields() {
        txtID.setText("");
        txtUser.setText("");
        txtFullName.setText("");
        txtPass.setText("");
        cboStatus.setSelectedIndex(0);
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CashierProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new CashierProfile().setVisible(true);
        });
    }
}
