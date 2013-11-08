package pipesrus;

import java.util.*;
import javax.swing.*;

/**
 *
 * @author Zac Colley
 */
public class Gui extends javax.swing.JFrame {

    private ArrayList<Order> orders = new ArrayList();
    private DefaultListModel orderListItems = new DefaultListModel();
    
    private Order order = new Order();
    private Pipe pipe = new Pipe();

    /** Creates new form Gui */
    public Gui(ArrayList<Order> o) {
        
        initComponents();
        
        addOrder.setBounds(0, 0, 400, 400);
        
        orders = o;
        
        updateItemList();
        this.orderList.setModel(orderListItems);
        
        orderListItems.addElement("No orders");
    }
    
    public ArrayList<Order> getOrders(){
        return orders;
    }
    
    public void addOrder(Order o){
        orders.add(o);
    }
    
    public void updateItemList(){
        orderListItems.removeAllElements();        
        
        int pipeAmount = 0;
        
        for(Order o: orders){
            orderListItems.addElement(style("b", "£" + o.getCost() * o.getQuantity()) + " " + o);
            pipeAmount += order.getQuantity();
        }
        
        itemAmountLabel.setText("\nOrder amount: " + orders.size() + " ("+ pipeAmount +" pipes)");
        
        totalCost(orders);
    }
     public void totalCost(ArrayList<Order> orders){
        double totalCost = 0.0;
        
        for(Order o: orders){
            totalCost += o.getCost() * o.getQuantity();
        }
        
        totalCostLabel.setText("Total: £" + totalCost + "\n");
    }
    
    
    public String style(String type, String input){
        String output = "<html>";
        if("colour".equals(type)){            
            output += "<html><font color='red'>" + input + "</font>";
        }
        else if("b".equals(type)){            
            output += "<b>" + input + "</b>";
        }
        else if("i".equals(type)){            
            output += "<i>" + input + "</i>";
        }
        else if("u".equals(type)){            
            output += "<u>" + input + "</u>";
        }
        return output;
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addOrder = new javax.swing.JDialog();
        pipeSizeLengthTextField = new javax.swing.JTextField();
        pipeGradeLabel = new javax.swing.JLabel();
        pipeGradeComboBox = new javax.swing.JComboBox();
        pipeColoursComboBox = new javax.swing.JComboBox();
        pipeSizeDiaLabel = new javax.swing.JLabel();
        pipeSizeLengthLabel = new javax.swing.JLabel();
        pipeColoursLabel = new javax.swing.JLabel();
        pipeSizeDiaTextField = new javax.swing.JTextField();
        pipeChemResCheckBox = new javax.swing.JCheckBox();
        pipeQuantityLabel = new javax.swing.JLabel();
        pipeReinforceCheckBox = new javax.swing.JCheckBox();
        pipeQuantitySpinner = new javax.swing.JSpinner();
        submitOrderButton = new javax.swing.JButton();
        discardOrderButton = new javax.swing.JButton();
        pipeSizeLabel = new javax.swing.JLabel();
        titleLabel1 = new javax.swing.JLabel();
        pipeInsulCheckBox = new javax.swing.JCheckBox();
        Colours = new javax.swing.JDialog();
        colorChooser = new javax.swing.JColorChooser();
        titleLabel = new javax.swing.JLabel();
        submitOrdersButton = new javax.swing.JButton();
        resetOrdersButton = new javax.swing.JButton();
        orderScrollPane = new javax.swing.JScrollPane();
        orderList = new javax.swing.JList();
        addOrderButton = new javax.swing.JButton();
        editOrderButton = new javax.swing.JButton();
        deleteOrderButton = new javax.swing.JButton();
        totalCostLabel = new javax.swing.JLabel();
        itemAmountLabel = new javax.swing.JLabel();

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

        pipeGradeLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        pipeGradeLabel.setText("Grade:");

        pipeGradeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5" }));
        pipeGradeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pipeGradeComboBoxActionPerformed(evt);
            }
        });

        pipeColoursComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2" }));
        pipeColoursComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pipeColoursComboBoxActionPerformed(evt);
            }
        });

        pipeSizeDiaLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        pipeSizeDiaLabel.setText("Diameter:");

        pipeSizeLengthLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        pipeSizeLengthLabel.setText("Length:");

        pipeColoursLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        pipeColoursLabel.setText("Colours:");

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

        pipeChemResCheckBox.setText("Chemical Resistance");
        pipeChemResCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pipeChemResCheckBoxActionPerformed(evt);
            }
        });

        pipeQuantityLabel.setText("Quantity:");

        pipeReinforceCheckBox.setText("Reinforcement");
        pipeReinforceCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pipeReinforceCheckBoxActionPerformed(evt);
            }
        });

        pipeQuantitySpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                pipeQuantitySpinnerStateChanged(evt);
            }
        });

        submitOrderButton.setText("Submit");
        submitOrderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitOrderButtonActionPerformed(evt);
            }
        });

        discardOrderButton.setText("Discard");
        discardOrderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discardOrderButtonActionPerformed(evt);
            }
        });

        pipeSizeLabel.setText("Size:");

        titleLabel1.setFont(new java.awt.Font("Serif", 2, 14));
        titleLabel1.setText("Pipes 'R' Us");
        titleLabel1.setToolTipText("For all your pipe needs!");

        pipeInsulCheckBox.setText("Insulation");
        pipeInsulCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pipeInsulCheckBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addOrderLayout = new javax.swing.GroupLayout(addOrder.getContentPane());
        addOrder.getContentPane().setLayout(addOrderLayout);
        addOrderLayout.setHorizontalGroup(
            addOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addOrderLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(addOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addOrderLayout.createSequentialGroup()
                        .addComponent(titleLabel1)
                        .addGap(65, 65, 65)
                        .addComponent(pipeInsulCheckBox))
                    .addGroup(addOrderLayout.createSequentialGroup()
                        .addComponent(pipeSizeLabel)
                        .addGap(113, 113, 113)
                        .addComponent(pipeReinforceCheckBox))
                    .addGroup(addOrderLayout.createSequentialGroup()
                        .addComponent(pipeSizeLengthLabel)
                        .addGap(43, 43, 43)
                        .addComponent(pipeSizeLengthTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(pipeChemResCheckBox))
                    .addGroup(addOrderLayout.createSequentialGroup()
                        .addComponent(pipeSizeDiaLabel)
                        .addGap(29, 29, 29)
                        .addComponent(pipeSizeDiaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(addOrderLayout.createSequentialGroup()
                        .addComponent(pipeGradeLabel)
                        .addGap(50, 50, 50)
                        .addComponent(pipeGradeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(pipeQuantityLabel)
                        .addGap(26, 26, 26)
                        .addComponent(pipeQuantitySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(addOrderLayout.createSequentialGroup()
                        .addComponent(pipeColoursLabel)
                        .addGap(41, 41, 41)
                        .addComponent(pipeColoursComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(submitOrderButton)
                        .addGap(26, 26, 26)
                        .addComponent(discardOrderButton))))
        );
        addOrderLayout.setVerticalGroup(
            addOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addOrderLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(addOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleLabel1)
                    .addGroup(addOrderLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(pipeInsulCheckBox)))
                .addGap(4, 4, 4)
                .addGroup(addOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addOrderLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(pipeSizeLabel))
                    .addComponent(pipeReinforceCheckBox))
                .addGap(12, 12, 12)
                .addGroup(addOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addOrderLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(pipeSizeLengthLabel))
                    .addComponent(pipeSizeLengthTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(addOrderLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(pipeChemResCheckBox)))
                .addGap(2, 2, 2)
                .addGroup(addOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addOrderLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(pipeSizeDiaLabel))
                    .addComponent(pipeSizeDiaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(addOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addOrderLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(pipeGradeLabel))
                    .addGroup(addOrderLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(pipeGradeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(addOrderLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(pipeQuantityLabel))
                    .addComponent(pipeQuantitySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(addOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addOrderLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(pipeColoursLabel))
                    .addComponent(pipeColoursComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(submitOrderButton)
                    .addComponent(discardOrderButton)))
        );

        javax.swing.GroupLayout ColoursLayout = new javax.swing.GroupLayout(Colours.getContentPane());
        Colours.getContentPane().setLayout(ColoursLayout);
        ColoursLayout.setHorizontalGroup(
            ColoursLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ColoursLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(colorChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 626, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ColoursLayout.setVerticalGroup(
            ColoursLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ColoursLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(colorChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(-723724,true));

        titleLabel.setFont(new java.awt.Font("Serif", 2, 14));
        titleLabel.setText("Pipes 'R' Us");
        titleLabel.setToolTipText("For all your pipe needs!");

        submitOrdersButton.setText("Submit");

        resetOrdersButton.setText("Reset");
        resetOrdersButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetOrdersButtonActionPerformed(evt);
            }
        });

        orderList.setBackground(new java.awt.Color(-723724,true));
        orderList.setFont(new java.awt.Font("SansSerif", 0, 12));
        orderList.setOpaque(false);
        orderScrollPane.setViewportView(orderList);

        addOrderButton.setText("Add");
        addOrderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addOrderButtonActionPerformed(evt);
            }
        });

        editOrderButton.setText("Edit");

        deleteOrderButton.setText("Delete");

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addOrderButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(editOrderButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(deleteOrderButton))
                    .addComponent(orderScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(totalCostLabel)
                            .addComponent(itemAmountLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(submitOrdersButton)
                        .addGap(18, 18, 18)
                        .addComponent(resetOrdersButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addOrderButton)
                            .addComponent(editOrderButton)
                            .addComponent(deleteOrderButton)))
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
                        .addComponent(submitOrdersButton)
                        .addComponent(resetOrdersButton)))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void addOrderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addOrderButtonActionPerformed
    System.out.println(orders);
//    Colours.setVisible(true);
    Colours.setBounds(0,0,800,400);
    colorChooser.setPreviewPanel(new JPanel());

    addOrder.setVisible(true);
}//GEN-LAST:event_addOrderButtonActionPerformed

public void resetAddOrder(){
    pipeSizeLengthTextField.setText("0.0");
    pipeSizeDiaTextField.setText("0.0");
    
    pipeChemResCheckBox.setSelected(false);
    pipeInsulCheckBox.setSelected(false);
    pipeReinforceCheckBox.setSelected(false);
    
    pipeQuantitySpinner.setValue(0);
    
    pipeGradeComboBox.setSelectedIndex(0);
    pipeColoursComboBox.setSelectedIndex(0);
}

    private void resetOrdersButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetOrdersButtonActionPerformed
       updateItemList();
    }//GEN-LAST:event_resetOrdersButtonActionPerformed

    private void pipeSizeLengthTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pipeSizeLengthTextFieldActionPerformed
        pipe.setLength(Double.parseDouble(pipeSizeLengthTextField.getText()));
    }//GEN-LAST:event_pipeSizeLengthTextFieldActionPerformed

    private void pipeSizeLengthTextFieldPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_pipeSizeLengthTextFieldPropertyChange
        pipe.setLength(Double.parseDouble(pipeSizeLengthTextField.getText()));
    }//GEN-LAST:event_pipeSizeLengthTextFieldPropertyChange

    private void pipeGradeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pipeGradeComboBoxActionPerformed
        pipe.setGrade(Integer.parseInt((String) pipeGradeComboBox.getSelectedItem()));
    }//GEN-LAST:event_pipeGradeComboBoxActionPerformed

    private void pipeColoursComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pipeColoursComboBoxActionPerformed
        pipe.setColours(Integer.parseInt((String) pipeColoursComboBox.getSelectedItem()));
    }//GEN-LAST:event_pipeColoursComboBoxActionPerformed

    private void pipeSizeDiaTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pipeSizeDiaTextFieldActionPerformed
        pipe.setOutDia(Double.parseDouble((String) pipeSizeDiaTextField.getText()));
    }//GEN-LAST:event_pipeSizeDiaTextFieldActionPerformed

    private void pipeSizeDiaTextFieldPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_pipeSizeDiaTextFieldPropertyChange
        pipe.setOutDia(Double.parseDouble((String) pipeSizeDiaTextField.getText()));
    }//GEN-LAST:event_pipeSizeDiaTextFieldPropertyChange

    private void pipeChemResCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pipeChemResCheckBoxActionPerformed
        pipe.setChemRes(pipeChemResCheckBox.isSelected());
    }//GEN-LAST:event_pipeChemResCheckBoxActionPerformed

    private void pipeReinforceCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pipeReinforceCheckBoxActionPerformed
        pipe.setReinforce(pipeReinforceCheckBox.isSelected());
    }//GEN-LAST:event_pipeReinforceCheckBoxActionPerformed

    private void pipeQuantitySpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_pipeQuantitySpinnerStateChanged
        order.setQuantity((Integer) pipeQuantitySpinner.getValue());
    }//GEN-LAST:event_pipeQuantitySpinnerStateChanged

    private void submitOrderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitOrderButtonActionPerformed
        order.setPipe(pipe);

        Date dateTime = new Date();
        order.setDateTime(dateTime);

        order.calcCost();
        
        System.out.println(order.getCost());  
        
        orders.add(order);

        updateItemList();

        addOrder.setVisible(false);
        
        resetAddOrder();
        
        order = new Order();
        pipe = new Pipe();
    }//GEN-LAST:event_submitOrderButtonActionPerformed
    
    private void discardOrderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discardOrderButtonActionPerformed
        System.out.println(order);
    }//GEN-LAST:event_discardOrderButtonActionPerformed

    private void pipeInsulCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pipeInsulCheckBoxActionPerformed
        pipe.setInsul(pipeInsulCheckBox.isSelected());
    }//GEN-LAST:event_pipeInsulCheckBoxActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog Colours;
    private javax.swing.JDialog addOrder;
    private javax.swing.JButton addOrderButton;
    private javax.swing.JColorChooser colorChooser;
    private javax.swing.JButton deleteOrderButton;
    private javax.swing.JButton discardOrderButton;
    private javax.swing.JButton editOrderButton;
    private javax.swing.JLabel itemAmountLabel;
    private javax.swing.JList orderList;
    private javax.swing.JScrollPane orderScrollPane;
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
    private javax.swing.JButton resetOrdersButton;
    private javax.swing.JButton submitOrderButton;
    private javax.swing.JButton submitOrdersButton;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel titleLabel1;
    private javax.swing.JLabel totalCostLabel;
    // End of variables declaration//GEN-END:variables
}
