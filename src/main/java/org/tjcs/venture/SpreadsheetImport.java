/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tjcs.venture;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import org.tjcs.venture.Utilities.Columns;

/**
 *
 * @author dougthompson
 */
public class SpreadsheetImport extends javax.swing.JDialog {

    /**
     * Creates new form SpreadsheetImport
     */
    public SpreadsheetImport(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        parentFrame = (LotteryFrame) parent;
        initComponents();
        initMyComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelCustomActions = new javax.swing.JPanel();
        jButtonCancel = new javax.swing.JButton();
        jButtonSaveAndClose = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanelCustomActions.setLayout(new java.awt.GridBagLayout());

        jButtonCancel.setText("Cancel");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        jButtonSaveAndClose.setText("Save and Close");
        jButtonSaveAndClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveAndCloseActionPerformed(evt);
            }
        });

        jLabel1.setText("Select the spreadsheet column that");

        jLabel2.setText("corresponds to the description");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanelCustomActions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 55, Short.MAX_VALUE)
                                .addComponent(jButtonSaveAndClose)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonCancel)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelCustomActions, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancel)
                    .addComponent(jButtonSaveAndClose))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSaveAndCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveAndCloseActionPerformed
        parentFrame.saveSettings();
        //parentFrame.setContinueLoad(true);
        //this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        this.dispose();
    }//GEN-LAST:event_jButtonSaveAndCloseActionPerformed

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        //parentFrame.setContinueLoad(false);
        this.dispose();
    }//GEN-LAST:event_jButtonCancelActionPerformed

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
            java.util.logging.Logger.getLogger(SpreadsheetImport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SpreadsheetImport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SpreadsheetImport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SpreadsheetImport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SpreadsheetImport dialog = new SpreadsheetImport(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonSaveAndClose;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanelCustomActions;
    // End of variables declaration//GEN-END:variables

    private final LotteryFrame parentFrame;
    
    private void initMyComponents() {
        this.setTitle("Spreadsheet Import Settings");
        initColumnFields();
    }
    
    private void initColumnFields() {
        GridBagConstraints gbc;
        
        int rowCount = 0;
        
        jPanelCustomActions.removeAll();
        gbc = new GridBagConstraints();
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        gbc.gridx = 0;
        gbc.gridy = rowCount ++;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        Insets insetsHeaderLeft = new Insets(4, 10, 0, 10);
        Insets insetsHeaderRight = new Insets(4, 20, 0, 0);

        JLabel columnHeading = new JLabel("Description");
        Font boldFont = columnHeading.getFont();
        boldFont = new Font(boldFont.getFamily(), Font.BOLD, boldFont.getSize());

        columnHeading.setFont(boldFont);
        gbc.gridx = 0;
        //gbc.gridy = rowCount++;
        gbc.insets = insetsHeaderLeft;
        jPanelCustomActions.add(columnHeading, gbc);
        gbc.gridx = 1;
        gbc.insets = insetsHeaderRight;
        columnHeading = new JLabel("<html><center>Spreadsheet<br/>Column</center></html>");
        columnHeading.setFont(boldFont);
        jPanelCustomActions.add(columnHeading, gbc);
            
        List<String> charactersArray = Utilities.getSpreadsheetColumnLetters();
        
        String[] items = charactersArray.toArray(new String[0]);
        
        Dimension preferredSpreadsheetColumnDimensions = new Dimension(5, 28);
        
        Insets insetsLeft = new Insets(2, 5, 2, 5);
        Insets insetsRight = new Insets(2, 20, 2, 10);
        
        for (Columns column : Columns.values()) {
            if (!column.isFromSpreadsheet()) continue;
            JLabel columnLabel = new JLabel(column.getColumnName());
            JComboBox spreadsheetColumnn = new JComboBox(items);
            spreadsheetColumnn.setSelectedItem(column.getSpreadsheetColumn());
            spreadsheetColumnn.setToolTipText("Select the matching column in the spreadsheet");
            spreadsheetColumnn.setPreferredSize(preferredSpreadsheetColumnDimensions);
            spreadsheetColumnn.setSize(preferredSpreadsheetColumnDimensions);
            spreadsheetColumnn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    column.setSpreadsheetColumn((String) spreadsheetColumnn.getSelectedItem());
                    //parentFrame.saveSettings();
                }
            });
            
            gbc.gridx = 0;
            gbc.gridy = rowCount++;
            gbc.insets = insetsLeft; //new Insets(0, 0, 0, 0);
            jPanelCustomActions.add(columnLabel, gbc);
            gbc.gridx = 1;
            gbc.insets = insetsRight;
            jPanelCustomActions.add(spreadsheetColumnn, gbc);
        }
        
        jPanelCustomActions.revalidate();
        jPanelCustomActions.repaint();
        pack();
    }
}
