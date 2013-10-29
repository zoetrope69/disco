package pipesrus;

/**
 *
 * @author Zac Colley
 */
public class Gui extends javax.swing.JFrame {
    
    private popUp popUp = new popUp();

    /** Creates new form Gui */
    public Gui() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLabel = new javax.swing.JLabel();
        submitButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        orderScrollPane = new javax.swing.JScrollPane();
        orderList = new javax.swing.JList();
        addButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        totalCostLabel = new javax.swing.JLabel();
        itemAmountLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(-723724,true));

        titleLabel.setFont(new java.awt.Font("Serif", 2, 14));
        titleLabel.setText("Pipes 'R' Us");
        titleLabel.setToolTipText("For all your pipe needs!");

        submitButton.setText("Submit");

        resetButton.setText("Reset");

        orderList.setBackground(new java.awt.Color(-723724,true));
        orderList.setFont(new java.awt.Font("SansSerif", 0, 12));
        orderList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "<html><b><font color=\"bold\">£3.00</font> | <b><font color=\"blue\">2x :</font></b> <font color=\"red\"><i>1m</i> by <i>3in</i></font> Grade 3 Pipes <i>(Insulated, Reinforced, Chemical Resistant)</i></html>", "<html><b><font color=\"bold\">£3.00</font> | <b><font color=\"blue\">2x :</font></b> <font color=\"red\"><i>1m</i> by <i>3in</i></font> Grade 3 Pipes <i>(Insulated, Reinforced, Chemical Resistant)</i></html>", "<html><b><font color=\"bold\">£3.00</font> | <b><font color=\"blue\">2x :</font></b> <font color=\"red\"><i>1m</i> by <i>3in</i></font> Grade 3 Pipes <i>(Insulated, Reinforced, Chemical Resistant)</i></html>", "<html><b><font color=\"bold\">£3.00</font> | <b><font color=\"blue\">2x :</font></b> <font color=\"red\"><i>1m</i> by <i>3in</i></font> Grade 3 Pipes <i>(Insulated, Reinforced, Chemical Resistant)</i></html><html><b><font color=\"bold\">£3.00</font> | <b><font color=\"blue\">2x :</font></b> <font color=\"red\"><i>1m</i> by <i>3in</i></font> Grade 3 Pipes <i>(Insulated, Reinforced, Chemical Resistant)</i></html>", "<html><b><font color=\"bold\">£3.00</font> | <b><font color=\"blue\">2x :</font></b> <font color=\"red\"><i>1m</i> by <i>3in</i></font> Grade 3 Pipes <i>(Insulated, Reinforced, Chemical Resistant)</i></html>", "<html><b><font color=\"bold\">£3.00</font> | <b><font color=\"blue\">2x :</font></b> <font color=\"red\"><i>1m</i> by <i>3in</i></font> Grade 3 Pipes <i>(Insulated, Reinforced, Chemical Resistant)</i></html>", "<html><b><font color=\"bold\">£3.00</font> | <b><font color=\"blue\">2x :</font></b> <font color=\"red\"><i>1m</i> by <i>3in</i></font> Grade 3 Pipes <i>(Insulated, Reinforced, Chemical Resistant)</i></html>", "<html><b><font color=\"bold\">£3.00</font> | <b><font color=\"blue\">2x :</font></b> <font color=\"red\"><i>1m</i> by <i>3in</i></font> Grade 3 Pipes <i>(Insulated, Reinforced, Chemical Resistant)</i></html>", "<html><b><font color=\"bold\">£3.00</font> | <b><font color=\"blue\">2x :</font></b> <font color=\"red\"><i>1m</i> by <i>3in</i></font> Grade 3 Pipes <i>(Insulated, Reinforced, Chemical Resistant)</i></html>", "<html><b><font color=\"bold\">£3.00</font> | <b><font color=\"blue\">2x :</font></b> <font color=\"red\"><i>1m</i> by <i>3in</i></font> Grade 3 Pipes <i>(Insulated, Reinforced, Chemical Resistant)</i></html>", "<html><b><font color=\"bold\">£3.00</font> | <b><font color=\"blue\">2x :</font></b> <font color=\"red\"><i>1m</i> by <i>3in</i></font> Grade 3 Pipes <i>(Insulated, Reinforced, Chemical Resistant)</i></html>", "<html><b><font color=\"bold\">£3.00</font> | <b><font color=\"blue\">2x :</font></b> <font color=\"red\"><i>1m</i> by <i>3in</i></font> Grade 3 Pipes <i>(Insulated, Reinforced, Chemical Resistant)</i></html>", "<html><b><font color=\"bold\">£3.00</font> | <b><font color=\"blue\">2x :</font></b> <font color=\"red\"><i>1m</i> by <i>3in</i></font> Grade 3 Pipes <i>(Insulated, Reinforced, Chemical Resistant)</i></html>", "<html><b><font color=\"bold\">£3.00</font> | <b><font color=\"blue\">2x :</font></b> <font color=\"red\"><i>1m</i> by <i>3in</i></font> Grade 3 Pipes <i>(Insulated, Reinforced, Chemical Resistant)</i></html>", "<html><b><font color=\"bold\">£3.00</font> | <b><font color=\"blue\">2x :</font></b> <font color=\"red\"><i>1m</i> by <i>3in</i></font> Grade 3 Pipes <i>(Insulated, Reinforced, Chemical Resistant)</i></html>" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        orderList.setOpaque(false);
        orderScrollPane.setViewportView(orderList);

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        editButton.setText("Edit");

        deleteButton.setText("Delete");

        totalCostLabel.setText("Total Cost: £100.50");

        itemAmountLabel.setText("Amount of items: 30");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(titleLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 308, Short.MAX_VALUE)
                        .addComponent(addButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(editButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(deleteButton))
                    .addComponent(orderScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(totalCostLabel)
                            .addComponent(itemAmountLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 302, Short.MAX_VALUE)
                        .addComponent(submitButton)
                        .addGap(18, 18, 18)
                        .addComponent(resetButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addButton)
                            .addComponent(editButton)
                            .addComponent(deleteButton)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(titleLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(orderScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(totalCostLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(itemAmountLabel))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(submitButton)
                        .addComponent(resetButton)))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
    this.popUp.setVisible(true);
}//GEN-LAST:event_addButtonActionPerformed

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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Gui().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton editButton;
    private javax.swing.JLabel itemAmountLabel;
    private javax.swing.JList orderList;
    private javax.swing.JScrollPane orderScrollPane;
    private javax.swing.JButton resetButton;
    private javax.swing.JButton submitButton;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel totalCostLabel;
    // End of variables declaration//GEN-END:variables
}
