package pipesrus;

import java.util.Date;


/**
 *
 * @author Zac Colley
 */
public class popUp extends javax.swing.JFrame {
    
    private Order order = new Order();
    private Pipe pipe = new Pipe();

    /** Creates new form popUp */
    public popUp() {
        initComponents();
    }    
    
    
    public popUp(Order o) {
        order = o;
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

        pipeQuantityLabel = new javax.swing.JLabel();
        pipeQuantitySpinner = new javax.swing.JSpinner();
        pipeReinforceCheckBox = new javax.swing.JCheckBox();
        pipeChemResCheckBox = new javax.swing.JCheckBox();
        pipeSizeDiaTextField = new javax.swing.JTextField();
        pipeInsulCheckBox = new javax.swing.JCheckBox();
        addButton = new javax.swing.JButton();
        discardButton = new javax.swing.JButton();
        pipeSizeLabel = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();
        pipeSizeDiaLabel = new javax.swing.JLabel();
        pipeColoursComboBox = new javax.swing.JComboBox();
        pipeGradeComboBox = new javax.swing.JComboBox();
        pipeGradeLabel = new javax.swing.JLabel();
        pipeSizeLengthTextField = new javax.swing.JTextField();
        pipeSizeLengthLabel = new javax.swing.JLabel();
        pipeColoursLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pipeQuantityLabel.setText("Quantity:");

        pipeQuantitySpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                pipeQuantitySpinnerStateChanged(evt);
            }
        });

        pipeReinforceCheckBox.setText("Reinforcement");
        pipeReinforceCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pipeReinforceCheckBoxActionPerformed(evt);
            }
        });

        pipeChemResCheckBox.setText("Chemical Resistance");
        pipeChemResCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pipeChemResCheckBoxActionPerformed(evt);
            }
        });

        pipeSizeDiaTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pipeSizeDiaTextField.setText("0.0");
        pipeSizeDiaTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pipeSizeDiaTextFieldActionPerformed(evt);
            }
        });
        pipeSizeDiaTextField.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                pipeSizeDiaTextFieldPropertyChange(evt);
            }
        });

        pipeInsulCheckBox.setText("Insulation");
        pipeInsulCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pipeInsulCheckBoxActionPerformed(evt);
            }
        });

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        discardButton.setText("Discard");
        discardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discardButtonActionPerformed(evt);
            }
        });

        pipeSizeLabel.setText("Size:");

        titleLabel.setFont(new java.awt.Font("Serif", 2, 14));
        titleLabel.setText("Pipes 'R' Us");
        titleLabel.setToolTipText("For all your pipe needs!");

        pipeSizeDiaLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        pipeSizeDiaLabel.setText("Diameter:");

        pipeColoursComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2" }));
        pipeColoursComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pipeColoursComboBoxActionPerformed(evt);
            }
        });

        pipeGradeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5" }));
        pipeGradeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pipeGradeComboBoxActionPerformed(evt);
            }
        });

        pipeGradeLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        pipeGradeLabel.setText("Grade:");

        pipeSizeLengthTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pipeSizeLengthTextField.setText("0.0");
        pipeSizeLengthTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pipeSizeLengthTextFieldActionPerformed(evt);
            }
        });
        pipeSizeLengthTextField.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                pipeSizeLengthTextFieldPropertyChange(evt);
            }
        });

        pipeSizeLengthLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        pipeSizeLengthLabel.setText("Length:");

        pipeColoursLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        pipeColoursLabel.setText("Colours:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(29, 29, 29)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(pipeSizeLabel)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(pipeSizeLengthLabel)
                                        .addComponent(pipeSizeDiaLabel))
                                    .addGap(29, 29, 29)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(pipeSizeLengthTextField)
                                        .addComponent(pipeSizeDiaTextField)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(pipeColoursLabel)
                                        .addComponent(pipeGradeLabel))
                                    .addGap(41, 41, 41)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(pipeGradeComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(pipeColoursComboBox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGap(20, 20, 20)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(pipeReinforceCheckBox)
                                .addComponent(pipeChemResCheckBox)
                                .addComponent(pipeInsulCheckBox)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(addButton)
                                        .addComponent(pipeQuantityLabel))
                                    .addGap(26, 26, 26)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(discardButton)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(pipeQuantitySpinner)
                                            .addGap(9, 9, 9))))))
                        .addComponent(titleLabel))
                    .addContainerGap(44, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(24, 24, 24)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(titleLabel)
                            .addGap(38, 38, 38)
                            .addComponent(pipeSizeLabel)
                            .addGap(12, 12, 12)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(pipeSizeLengthLabel)
                                .addComponent(pipeSizeLengthTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(pipeSizeDiaLabel)
                                .addComponent(pipeSizeDiaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(pipeGradeLabel)
                                .addComponent(pipeGradeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(pipeColoursLabel)
                                .addComponent(pipeColoursComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(addButton)
                                .addComponent(discardButton)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(7, 7, 7)
                            .addComponent(pipeInsulCheckBox)
                            .addGap(4, 4, 4)
                            .addComponent(pipeReinforceCheckBox)
                            .addGap(31, 31, 31)
                            .addComponent(pipeChemResCheckBox)
                            .addGap(37, 37, 37)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(pipeQuantityLabel)
                                .addComponent(pipeQuantitySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGap(25, 25, 25)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

public void printDebug(){
    System.out.println(order);
}
    
private void pipeReinforceCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pipeReinforceCheckBoxActionPerformed
    pipe.setReinforce(pipeReinforceCheckBox.isSelected());
}//GEN-LAST:event_pipeReinforceCheckBoxActionPerformed

private void pipeChemResCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pipeChemResCheckBoxActionPerformed
    pipe.setChemRes(pipeChemResCheckBox.isSelected());
}//GEN-LAST:event_pipeChemResCheckBoxActionPerformed

private void pipeSizeDiaTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pipeSizeDiaTextFieldActionPerformed
    pipe.setOutDia(Double.parseDouble((String) pipeSizeDiaTextField.getText()));
}//GEN-LAST:event_pipeSizeDiaTextFieldActionPerformed

private void pipeInsulCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pipeInsulCheckBoxActionPerformed
    pipe.setInsul(pipeInsulCheckBox.isSelected());
}//GEN-LAST:event_pipeInsulCheckBoxActionPerformed

private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
    order.setPipe(pipe);
    
    Date dateTime = new Date();
    order.setDateTime(dateTime);
    
    this.setVisible(false);
}//GEN-LAST:event_addButtonActionPerformed

private void pipeGradeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pipeGradeComboBoxActionPerformed
    pipe.setGrade(Integer.parseInt((String) pipeGradeComboBox.getSelectedItem()));
}//GEN-LAST:event_pipeGradeComboBoxActionPerformed

private void pipeSizeLengthTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pipeSizeLengthTextFieldActionPerformed
    pipe.setLength(Double.parseDouble(pipeSizeLengthTextField.getText()));
}//GEN-LAST:event_pipeSizeLengthTextFieldActionPerformed

    private void discardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discardButtonActionPerformed
        printDebug();
    }//GEN-LAST:event_discardButtonActionPerformed

    private void pipeColoursComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pipeColoursComboBoxActionPerformed
        pipe.setColours(Integer.parseInt((String) pipeColoursComboBox.getSelectedItem()));
    }//GEN-LAST:event_pipeColoursComboBoxActionPerformed

    private void pipeSizeDiaTextFieldPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_pipeSizeDiaTextFieldPropertyChange
        pipe.setOutDia(Double.parseDouble((String) pipeSizeDiaTextField.getText()));
    }//GEN-LAST:event_pipeSizeDiaTextFieldPropertyChange

    private void pipeSizeLengthTextFieldPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_pipeSizeLengthTextFieldPropertyChange
        pipe.setLength(Double.parseDouble(pipeSizeLengthTextField.getText()));
    }//GEN-LAST:event_pipeSizeLengthTextFieldPropertyChange

    private void pipeQuantitySpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_pipeQuantitySpinnerStateChanged
        order.setQuantity((Integer) pipeQuantitySpinner.getValue());
    }//GEN-LAST:event_pipeQuantitySpinnerStateChanged

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
            java.util.logging.Logger.getLogger(popUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(popUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(popUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(popUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new popUp().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton discardButton;
    private javax.swing.JCheckBox pipeChemResCheckBox;
    private javax.swing.JComboBox pipeColoursComboBox;
    private javax.swing.JLabel pipeColoursLabel;
    private javax.swing.JComboBox pipeGradeComboBox;
    private javax.swing.JLabel pipeGradeLabel;
    private javax.swing.JCheckBox pipeInsulCheckBox;
    private javax.swing.JLabel pipeQuantityLabel;
    private javax.swing.JSpinner pipeQuantitySpinner;
    private javax.swing.JCheckBox pipeReinforceCheckBox;
    private javax.swing.JLabel pipeSizeDiaLabel;
    private javax.swing.JTextField pipeSizeDiaTextField;
    private javax.swing.JLabel pipeSizeLabel;
    private javax.swing.JLabel pipeSizeLengthLabel;
    private javax.swing.JTextField pipeSizeLengthTextField;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
