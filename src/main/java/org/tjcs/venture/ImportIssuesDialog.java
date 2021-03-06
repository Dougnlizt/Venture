/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tjcs.venture;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.tjcs.venture.Utilities.Columns;

/**
 *
 * @author dougthompson
 */
public class ImportIssuesDialog extends javax.swing.JDialog {

    /**
     * Creates new form ImportIssuesDialog
     */
    public ImportIssuesDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        parentFrame = (LotteryFrame) (JFrame) parent;
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
        jTextPane1 = new javax.swing.JTextPane();

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

        jTextPane1.setEditable(false);
        jTextPane1.setBorder(null);
        jTextPane1.setText("The following records could not be imported, and will not be included in the lottery.  Please check the spreadsheet, adjust the data as needed, then re-import."); // NOI18N
        jTextPane1.setDragEnabled(false);
        jTextPane1.setFocusable(false);
        jTextPane1.setOpaque(false);
        jTextPane1.setRequestFocusEnabled(false);
        jScrollPane2.setViewportView(jTextPane1);

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
            java.util.logging.Logger.getLogger(ImportIssuesDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ImportIssuesDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ImportIssuesDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ImportIssuesDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ImportIssuesDialog dialog = new ImportIssuesDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables
    
    private final LotteryFrame parentFrame;
    List<XSSFRow> problemRows = new ArrayList<>();
    Map<XSSFRow, String> problemRowsMap = new TreeMap<>();

    private void initMyComponents() {
        //buildTable();
        this.setTitle("Spreadsheet Import Issues");
        //jTextPane1.setOpaque(false);
        //jTextPane1.setBorder(BorderFactory.createEmptyBorder());
        jTextPane1.setBackground(new Color(0,0,0,0));
    }

    public void setProblemRows(List<XSSFRow> problemRows) {
        this.problemRows = problemRows;
    }

    public void setProblemRowsMap(Map<XSSFRow, String> problemRowsMap) {
        this.problemRowsMap = problemRowsMap;
    }
    
    public void buildTable() {
        List<DB_RecordCell> dbRecordCellList = new ArrayList<>();
        JTableProspectiveStudents prospectiveStudentsTable;
        prospectiveStudentsTable = new JTableProspectiveStudents();
        prospectiveStudentsTable.setAllowClassColumnSorting(false);
        String[] headerCols = new String[] {Columns.DATA_ROW_NUM.getColumnName(),
                                            Columns.LAST_NAME.getColumnName(),
                                            Columns.FIRST_NAME.getColumnName(),
                                            Columns.TIER.getColumnName(),
                                            Columns.GRADE.getColumnName(),
                                            Columns.FAMILY_KEY.getColumnName(),
                                            Columns.IMPORT_ISSUE_REASON.getColumnName(),
                                            };

        prospectiveStudentsTable.setTableHeaderRow(headerCols);
        
        int lastNameColIndex = Utilities.Columns.getColumnSpreadsheetIndex(Utilities.Columns.LAST_NAME);
        int firstNameColIndex = Utilities.Columns.getColumnSpreadsheetIndex(Utilities.Columns.FIRST_NAME);
        int tierColIndex = Utilities.Columns.getColumnSpreadsheetIndex(Utilities.Columns.TIER);
        int gradeColIndex = Utilities.Columns.getColumnSpreadsheetIndex(Utilities.Columns.GRADE);
        int familyKeyColIndex = Utilities.Columns.getColumnSpreadsheetIndex(Utilities.Columns.LAST_NAME);
        
        int rowCounter = 0;
        
        for (Map.Entry<XSSFRow, String> entry : problemRowsMap.entrySet()) {
            XSSFRow row = entry.getKey();
            String reason = entry.getValue();
        //for (XSSFRow row : problemRows) {
            int colCounter = 0;
            DB_RecordCell tempCell = new DB_RecordCell(String.valueOf(row.getRowNum() + 1), true, rowCounter, colCounter);
            dbRecordCellList.add(tempCell);
            tempCell = getCellValue(row, lastNameColIndex, rowCounter, colCounter++);
            dbRecordCellList.add(tempCell);
            tempCell = getCellValue(row, firstNameColIndex, rowCounter, colCounter++);
            dbRecordCellList.add(tempCell);
            tempCell = getCellValue(row, tierColIndex, rowCounter, colCounter++);
            dbRecordCellList.add(tempCell);
            tempCell = getCellValue(row, gradeColIndex, rowCounter, colCounter++);
            dbRecordCellList.add(tempCell);
            tempCell = getCellValue(row, familyKeyColIndex, rowCounter, colCounter++);
            dbRecordCellList.add(tempCell);
            tempCell = new DB_RecordCell(reason, rowCounter, colCounter++);
            dbRecordCellList.add(tempCell);
            rowCounter++;
        }
        
        Object[][] tableItems = new Object[rowCounter][headerCols.length];
        
        rowCounter = 0;
        int colCounter = 0;
        for (DB_RecordCell dB_RecordCell : dbRecordCellList) {
            tableItems[rowCounter][colCounter++] = dB_RecordCell;
            if (colCounter > headerCols.length - 1) {
                rowCounter ++;
                colCounter = 0;
            }
        }
        
        prospectiveStudentsTable.setProspectiveStudents(tableItems);
        prospectiveStudentsTable.setTableHeaderRow(headerCols);
        prospectiveStudentsTable.initTable();
        prospectiveStudentsTable.applyFilter(null, false);
        jScrollPaneInvalidRecords.setViewportView(prospectiveStudentsTable);
    }
    
    private DB_RecordCell getCellValue(XSSFRow row, int colIndex, int rowCounter, int colCounter) {
        if (row == null || colIndex < 0 || rowCounter < 0 || colCounter < 0) return null;
        String tempValue = "";
        if (row.getCell(colIndex) != null) {
            tempValue = row.getCell(colIndex).toString();
        }
        return new DB_RecordCell(tempValue, rowCounter, colCounter);
    }

    @Override
    public void dispose() {
        parentFrame.resetCursor();
        super.dispose();
    }
    
}
