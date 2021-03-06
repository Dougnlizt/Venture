/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tjcs.venture;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.tjcs.venture.Utilities.Columns;

/**
 *
 * @author dougthompson
 */
public class SiblingsUpdatedDialog extends javax.swing.JDialog {

    /**
     * Creates new form ImportIssuesDialog
     */
    public SiblingsUpdatedDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
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

        jScrollPaneInvalidRecords = new javax.swing.JScrollPane();
        jTableInvalidRecords = new javax.swing.JTable();
        jButtonOK = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPaneDescription = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTableInvalidRecords.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPaneInvalidRecords.setViewportView(jTableInvalidRecords);

        jButtonOK.setText("Close");
        jButtonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOKActionPerformed(evt);
            }
        });

        jScrollPane2.setBorder(null);
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextPaneDescription.setEditable(false);
        jTextPaneDescription.setBorder(null);
        jTextPaneDescription.setText("The following are a list of those siblings who had their tiers updated because of siblings in older grades who were selected for their grade."); // NOI18N
        jTextPaneDescription.setDragEnabled(false);
        jTextPaneDescription.setFocusable(false);
        jTextPaneDescription.setOpaque(false);
        jTextPaneDescription.setRequestFocusEnabled(false);
        jScrollPane2.setViewportView(jTextPaneDescription);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPaneInvalidRecords, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonOK))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 616, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneInvalidRecords, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonOK)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOKActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonOKActionPerformed

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
            java.util.logging.Logger.getLogger(SiblingsUpdatedDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SiblingsUpdatedDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SiblingsUpdatedDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SiblingsUpdatedDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SiblingsUpdatedDialog dialog = new SiblingsUpdatedDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButtonOK;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPaneInvalidRecords;
    private javax.swing.JTable jTableInvalidRecords;
    private javax.swing.JTextPane jTextPaneDescription;
    // End of variables declaration//GEN-END:variables
    
    private List<ProspectiveStudent> tierChangeList = new ArrayList<>();

    private void initMyComponents() {
        //buildTable();
        this.setTitle("Siblings With Tier Changes");
        jTextPaneDescription.setBackground(new Color(0,0,0,0));
    }

    public void setTierChangeList(List<ProspectiveStudent> tierChangeList) {
        this.tierChangeList = tierChangeList;
        Collections.sort(this.tierChangeList);
    }
    
    public void buildTable() {
        List<DB_RecordCell> dbRecordCellList = new ArrayList<>();
        JTableProspectiveStudents prospectiveStudentsTable;
        prospectiveStudentsTable = new JTableProspectiveStudents();
        //prospectiveStudentsTable.setAllowClassColumnSorting(true);
        String[] headerCols = new String[] {Columns.LAST_NAME.getColumnName(),
                                            Columns.FIRST_NAME.getColumnName(),
                                            Columns.GRADE.getColumnName(),
                                            Columns.OLD_TIER.getColumnName(),
                                            Columns.NEW_TIER.getColumnName(),
                                            };

        prospectiveStudentsTable.setTableHeaderRow(headerCols);
        
//        int lastNameColIndex = Utilities.Columns.getColumnSpreadsheetIndex(Utilities.Columns.LAST_NAME);
//        int firstNameColIndex = Utilities.Columns.getColumnSpreadsheetIndex(Utilities.Columns.FIRST_NAME);
//        int gradeColIndex = 2;
//        int oldTierIndex = 3;
//        int newTierIndex = 4;
        
        int rowCounter = 0;
        
        for (ProspectiveStudent prospectiveStudent : tierChangeList) {
            int colCounter = 0;
            DB_RecordCell tempCell = new DB_RecordCell(prospectiveStudent.getLastName(), rowCounter, colCounter++);
            tempCell.setProspectiveStudent(prospectiveStudent);
            dbRecordCellList.add(tempCell);
            tempCell = new DB_RecordCell(prospectiveStudent.getFirstName(), rowCounter, colCounter++);
            tempCell.setProspectiveStudent(prospectiveStudent);
            dbRecordCellList.add(tempCell);
            tempCell = new DB_RecordCell(Utilities.Grade.getNumberStr(prospectiveStudent.getGrade()), true, rowCounter, colCounter++);
            tempCell.setProspectiveStudent(prospectiveStudent);
            dbRecordCellList.add(tempCell);
            tempCell = new DB_RecordCell(Utilities.Tier.getNumberStr(prospectiveStudent.getOldTier()), true, rowCounter, colCounter++);
            tempCell.setProspectiveStudent(prospectiveStudent);
            dbRecordCellList.add(tempCell);
            tempCell = new DB_RecordCell(Utilities.Tier.getNumberStr(prospectiveStudent.getTier()), true, rowCounter, colCounter++);
            tempCell.setProspectiveStudent(prospectiveStudent);
            dbRecordCellList.add(tempCell);
            rowCounter++;
        }
        
        Object[][] tableItems = new Object[rowCounter][5];
        
        rowCounter = 0;
        int colCounter = 0;
        for (DB_RecordCell dB_RecordCell : dbRecordCellList) {
            tableItems[rowCounter][colCounter++] = dB_RecordCell;
            if (colCounter > 4) {
                rowCounter ++;
                colCounter = 0;
            }
        }
        
        prospectiveStudentsTable.setProspectiveStudents(tableItems);
        prospectiveStudentsTable.setTableHeaderRow(headerCols);
        prospectiveStudentsTable.initTable();
        prospectiveStudentsTable.applyFilter(null, false);
        if (tierChangeList.isEmpty()) {
            jScrollPaneInvalidRecords.setVisible(false);
            jTextPaneDescription.setText("No Siblings Updated");
        } else {
            jScrollPaneInvalidRecords.setViewportView(prospectiveStudentsTable);
        }
    }
    
    @Override
    public void dispose() {
        super.dispose();
    }
    
}
