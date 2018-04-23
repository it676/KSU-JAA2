package store.ui;

import java.awt.Color;
import java.io.*;
import javax.swing.JOptionPane;
import store.classes.Customer;
import store.classes.Store;
import store.classes.TechnicalDevice;

/**
 *
 * @author IT676
 */
public class MainWindow extends javax.swing.JFrame {

    /**
     * Creates new form MainWindow
     */
    Store store;

    public MainWindow() {

        initComponents();//first 

        store = new Store("The Dreams Electronics Store");

        customSettings();

        loadStoreData("TechnicalDevices.ser", "Customers.ser");
    }

    public final void customSettings() {

        this.getContentPane().setBackground(Color.WHITE);

        this.setLocation(450, 200);
    }

    private void loadStoreData(String productsFileName, String customerFileName) {

        if (!loadData("DEVICES", productsFileName)) {
            JOptionPane.showMessageDialog(this, "Error: Can't load productsinfo.\nplease try again.", "Error", JOptionPane.ERROR_MESSAGE);

        }
        if (!loadData("CUSTOMERS", customerFileName)) {

            JOptionPane.showMessageDialog(this, "Error: Can't load customers info.\nplease try again.", "Error", JOptionPane.ERROR_MESSAGE);

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headerPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        registerLoginBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dreams Electronics Store");
        setPreferredSize(new java.awt.Dimension(540, 500));
        setResizable(false);
        setSize(new java.awt.Dimension(540, 500));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        headerPanel.setBackground(new java.awt.Color(3, 169, 244));
        headerPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Lucida Bright", 0, 10)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Dicover The Latest in New Technology");
        headerPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 190, -1));

        jLabel3.setFont(new java.awt.Font("Lucida Bright", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Welcome To The Dreams Electronics Store");
        headerPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 290, -1));

        registerLoginBtn.setFont(new java.awt.Font("Lucida Grande", 1, 11)); // NOI18N
        registerLoginBtn.setForeground(new java.awt.Color(3, 169, 244));
        registerLoginBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/store/images/account-icon.png"))); // NOI18N
        registerLoginBtn.setText("Register/Login");
        registerLoginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerLoginBtnActionPerformed(evt);
            }
        });
        headerPanel.add(registerLoginBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 140, 40));

        getContentPane().add(headerPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 70));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/store/images/main-bg.jpg"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 510, 310));

        jPanel1.setBackground(new java.awt.Color(3, 169, 244));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 570, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void registerLoginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerLoginBtnActionPerformed

        //open a new frame and pass the store object to take all the info of the store and customers from this object
        new LoginRegisterWindow(store).setVisible(true);

        this.dispose();


    }//GEN-LAST:event_registerLoginBtnActionPerformed

    //return Exception if you want what is the reason of the error 
    public boolean loadData(String type, String fileName) {

        File file = new File(fileName);

        try {

            if (!file.exists()) {
                file.createNewFile();
            }

            ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream(file));

            switch (type.toUpperCase()) {

                case "DEVICES":
                    while (true) {

                        try {

                            store.devices[store.getNumOfItems()] = (TechnicalDevice) ois.readObject();

                            System.out.println(store.devices[store.getNumOfItems()]);
                            store.setNumOfItems(1);//update counter of number of items

                        } catch (EOFException ex) {

                            break;
                        } catch (ClassNotFoundException ex) {
                            return false;
                        }

                    }
                    break;

                case "CUSTOMERS":
                    while (true) {

                        try {

                            store.customers[store.getNumOfCustomers()] = (Customer) ois.readObject();

                            store.setNumOfCustomers(1);

                        } catch (EOFException ex) {

                            break;
                        } catch (ClassNotFoundException ex) {

                            return false;
                        }

                    }
                    break;

            }

        } catch (IOException ex) {

            return ex instanceof java.io.EOFException;
        }

        return true;

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {

            //change this if you want ; since I've mac Os  I will change it to MAC OS X
            //you can chnage it to windows  if you hvae a windows  OS
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("MAC OS X".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel headerPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton registerLoginBtn;
    // End of variables declaration//GEN-END:variables
}
