/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tjcs.venture;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;
import org.tjcs.venture.Utilities.Columns;

/**
 *
 * @author dougthompson
 */
public class JTableProspectiveStudents extends JTable {

    public JTableProspectiveStudents() {
        super();
        //setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        setRowSelectionAllowed(false);
    }

    private Object[][] recordCellArray = new Object[0][0];
    private String[] tableHeaderRow = new String[0];
    private ProspectiveStudentsTableModel tableModel = new ProspectiveStudentsTableModel();
    private int maxOptionWidth = 0;
    private final Color evenRowBG = new Color(0xFF, 0xFF, 0xFF);
    private final Color oddRowBG = new Color(0xEE, 0xEE, 0xEE);
    private final Font fontBold = new Font(null, Font.BOLD, 12);
    private boolean allowClassColumnSorting = true;

    @SuppressWarnings("unchecked")
    private List<ActionListener> listeners = Collections.synchronizedList(new LinkedList());

    private void fire(ActionEvent e) {
        for (int i = (listeners.size() - 1); i >= 0; i--) {
            (listeners.get(i)).actionPerformed(e);
        }
    }

    public void addActionListener(ActionListener l) {
        listeners.add(l);
    }

    public void removeActionListener(ActionListener l) {
        listeners.remove(l);
    }

    public void setProspectiveStudents(Object[][] prospectiveStudents) {
        this.recordCellArray = prospectiveStudents;
    }

    public Object[][] getProspectiveStudents() {
        return recordCellArray;
    }

    public void setTableHeaderRow(String[] headerCols) {
        tableHeaderRow = headerCols;
    }

    public String[] getTableHeaderRow() {
        return tableHeaderRow;
    }

    public boolean isAllowClassColumnSorting() {
        return allowClassColumnSorting;
    }

    public void setAllowClassColumnSorting(boolean allowClassColumnSorting) {
        this.allowClassColumnSorting = allowClassColumnSorting;
    }

    @Override
    public boolean isFocusable() {
        return false;
    }

    private class ProspectiveStudentsTableModel extends AbstractTableModel {

//        /*
//         * JTable uses this method to determine the default renderer/
//         * editor for each cell.  If we didn't implement this method,
//         * then the last column would contain text ("true"/"false"),
//         * rather than a check box.
//         */
//        public Class getColumnClass(int c) {
//            return getValueAt(0, c).getClass();
//        }
//
        /**
         * This allows sorting to occur for columns depending on their class type (i.e. int).
         * Otherwise, it sorts ints by strings instead (resulting in 1,2,3...10,11 instead
         * of 1,10,11,2,3...)
         * @param columnIndex
         * @return 
         */
        @Override
        public Class<?> getColumnClass(int columnIndex) {
            if (!allowClassColumnSorting
                    || recordCellArray == null
                    || recordCellArray.length == 0) {
                return Object.class;
            }
            return getValueAt(0, columnIndex).getClass();
        }

        @Override
        public int getRowCount() {
            if (recordCellArray == null) {
                return 0;
            } else {
                return recordCellArray.length;
            }
        }


        @Override
        public int getColumnCount() {
            return tableHeaderRow.length;
        }
//
//        public String getColumnName(int col) {
//            return tableHeaderRow[col];
//        }
//
        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            if (recordCellArray == null || rowIndex > recordCellArray.length - 1) {
                return null;
            } else {
                Columns col = getColFromHeader(columnIndex); // Columns.getColumn(columnIndex);
                //Columns col = Columns.getColumn(columnIndex);
                DB_RecordCell cellObj = (DB_RecordCell) recordCellArray[rowIndex][columnIndex];
                if (col == Columns.GRADE
                        || col == Columns.LOTTERY_DRAW
                        || col == Columns.TIER
                        || col == Columns.WAIT_LIST_SIBLINGS) {
                    String value = cellObj.toString();
                    try {
                        return Integer.parseInt(value);
                    } catch (Exception ex) {
                        return value;
                    }
                }
                return cellObj; // recordCellArray[rowIndex][columnIndex];
            }
        }
//
//        /*
//         * Don't need to implement this method unless your table's
//         * editable.
//         */
        @Override
        public boolean isCellEditable(int row, int col) {
            //Note that the data/cell address is constant,
            //no matter where the cell appears onscreen.
            return false;
        }
        
        public void setRowCount(int numRows) {
            recordCellArray = new Object[0][0];
            repaint();
        }

//
//        /*
//         * Don't need to implement this method unless your table's
//         * data can change.
//         */
//        public void setValueAt(Object value, int row, int col) {
//            registerData[row][col] = value;
//            fireTableCellUpdated(row, col);
//        }
    }
    
    private Columns getColFromHeader(int columnIndex) {
        String columnHeader = tableHeaderRow[columnIndex];
        return Columns.getColumnFromHeader(columnHeader);
    }

    public void initTable() {
        tableModel = new ProspectiveStudentsTableModel();

        setModel(tableModel);

        //Set up table header
        getTableHeader().setResizingAllowed(true);
        getTableHeader().setReorderingAllowed(false);
        getTableHeader().setDefaultRenderer(new ColumnHeaderRenderer());

        //Get Column models, use them to set col horizontal alignment
        TableColumn col = null;

        int colWidth = 10;
        int totalWidth = 0;
        int cellWidth = 0;

        for (int colIndex = 0; colIndex < tableHeaderRow.length; colIndex++) {
            col = getColumnModel().getColumn(colIndex);
            //col.setHeaderRenderer(new ColumnHeaderRenderer());
            col.setCellRenderer(new DB_ValueCellRenderer());
            cellWidth = 0;
            TableCellRenderer renderer = col.getHeaderRenderer();
            for (int r = 0; r < getRowCount(); r ++) {
                renderer = getCellRenderer(r, 0);
                Component comp = renderer.getTableCellRendererComponent(this, getValueAt(r, 0),
                    false, false, r, 0);
                cellWidth = Math.max(cellWidth, comp.getPreferredSize().width);
                Object cellVal = getValueAt(r, 0);
                if (cellVal instanceof DB_RecordCell
                        && ((DB_RecordCell) cellVal).getValue() != null) {
                    maxOptionWidth = Math.max(maxOptionWidth, ((DB_RecordCell) cellVal).getValue().length());
                }
            }
            colWidth = cellWidth + 4;
            colWidth = Math.max(colWidth, 80);
            col.setPreferredWidth(colWidth);
            totalWidth += colWidth;
        }

        //If the total width is less than the viewable width, allow to auto resize to
            //fill up the area.  Otherwise, turn auto resize off so the scrollbar is used
            //NOTE:  There are two ways to handle this.  Using auto resize on/off allows
            //the table to auto-resize when resizing the window.  This is great unless
            //the window is made too small, then a refresh of the data needs to take place
            //in order to get the scrollbar back.  The other method keeps the scroll bar,
            //however the widths of the cells do not auto-resize when changing the window's size.
            //I will opt for the auto_resize option for the time being.  The other method can be
            //tested by uncommenting out the code and always setting the auto_resize to off.
//        if (totalWidth < _viewableWidth) {
            //setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
//        } else {
            //setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//        }

    }

    public void applyFilter(final String regEx, final boolean matchCase) {
        @SuppressWarnings("unchecked")
        TableRowSorter<ProspectiveStudentsTableModel> sorter = (TableRowSorter<ProspectiveStudentsTableModel>) getRowSorter();
        if (sorter == null) {
            //If the model isn't of type calibration table model, then it may not have yet been
                //initialized.  If not, then return.
            if (getModel() instanceof ProspectiveStudentsTableModel) {
                sorter = new TableRowSorter<>((ProspectiveStudentsTableModel) getModel());
                setRowSorter(sorter);
                sorter.setSortsOnUpdates(true);
            } else {
                return;
            }
        }

        //OK, now apply any filtering
        if (regEx == null || regEx.isEmpty()) {
            sorter.setRowFilter(null);
            return;
        }
        
        //Create a custom filter to allow only showing rows that match
        RowFilter<ProspectiveStudentsTableModel, Object> rf = null;
        try {
            rf = new RowFilter<ProspectiveStudentsTableModel, Object>() {
                private Matcher matcher;
                boolean useAsRegExp = false;
                private int rowCounter = -1;
                {
                    matcher = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE).matcher("");
                }

                @Override
                public boolean include(RowFilter.Entry<? extends ProspectiveStudentsTableModel, ? extends Object> entry) {
                    try {
                        //Check to see if it matches
                        //String value;
                        //Since already figured out which cell matches and which one doesn't, and to only bother checking
                            //certain columns, use the record already in the cell to return if there was a matched search.
                            //Already doing this so that I can highlight the value of the found match.
                        rowCounter ++;
                        if (((DB_RecordCell) recordCellArray[rowCounter][Columns.LAST_NAME.getOrder()]).isSearchMatch()) {
                            return true;
                        }
                        if (((DB_RecordCell) recordCellArray[rowCounter][Columns.FIRST_NAME.getOrder()]).isSearchMatch()) {
                            return true;
                        }
                        if (((DB_RecordCell) recordCellArray[rowCounter][Columns.FAMILY_KEY.getOrder()]).isSearchMatch()) {
                            return true;
                        }
                        return false;
//                        //Check each column value for this entry (row)
//                        for (int i = entry.getValueCount() - 1; i >=0; i--) {
//                            value = entry.getStringValue(i);
//                            matcher.reset(value);
//                            if (matcher.find()) {
//                                return true;
//                            }
//                        }
//                        return false;
                    } catch (Exception ex) {
                        return false;
                    }
                }
                
            };        
        } catch (Exception ex) {
            rf = null;
        }        
        sorter.setRowFilter(rf);
    }
    
    public int numRowsViewable() {
        if (getRowSorter() == null) {
            return getProspectiveStudents().length;
        }
        return getRowSorter().getViewRowCount();
    }

    public void clearAll() {
        setProspectiveStudents(new Object[0][0]);
    }

    private class DB_ValueCellRenderer extends DefaultTableCellRenderer {

        public DB_ValueCellRenderer() {
            setHorizontalAlignment(LEFT);
        }
        
        @Override
        public Component getTableCellRendererComponent(JTable table, Object obj, boolean isSelected,
                boolean hasFocus, int row, int column) {

            super.getTableCellRendererComponent(table, obj, isSelected, hasFocus, row, column);
            Component comp = this;
            DB_RecordCell recordCell = (DB_RecordCell) recordCellArray[row][column];
            //if (obj instanceof DB_RecordCell) {
                //DB_RecordCell recordCell = (DB_RecordCell) obj;
                Color bgColor = null;
                if (recordCell.getProspectiveStudent() != null
                        && recordCell.getProspectiveStudent().isAvailableSeatOffered()) {
                    bgColor = Utilities.LIGHT_GREEN_COLOR;
                    setBackground(bgColor);
                } else {
                    bgColor = (row % 2 == 0) ? evenRowBG : oddRowBG;
                    setBackground(bgColor);
                }

                //If this option was found as part of a search, highlight accordingly...
                if (recordCell.isSearchMatch()) {
                    String optionValue = recordCell.getValue();
                    int matchStart = recordCell.getSearchStart();
                    int matchEnd = recordCell.getSearchEnd();

                    CTextPane newCell = new CTextPane();
                    newCell.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));
                    newCell.setEditable(false);
                    newCell.enableLineWrap(false);
                    newCell.setText(optionValue);
                    newCell.setBackgroundColor(bgColor);
                    newCell.highlightText(matchStart, matchEnd, this.getFont(), this.getForeground(), Color.YELLOW);
                    //NOTE:  Opacity has no impact with the Nimbus L&F
                    comp = newCell;
                }
            //}
            return comp;
        }
    }

    public void scrollToItem(DB_RecordCell cellValue) {
        for (int row = 0; row < recordCellArray.length; row ++) {
            if (((DB_RecordCell) recordCellArray[row][0]) == cellValue) {
                scrollRectToVisible(getCellRect(row, 0, true));
                break;
            }
        }
    }

    public void selectItem(DB_RecordCell cellValue) {
        for (int row = 0; row < recordCellArray.length; row ++) {
            if (((DB_RecordCell) recordCellArray[row][0]) == cellValue) {
                changeSelection(row, 0, false, false);
                scrollRectToVisible(getCellRect(row, 0, true));
                break;
            }
        }
    }

    class ColumnHeaderRenderer extends JLabel implements TableCellRenderer {

        public ColumnHeaderRenderer() {
            setBorder(BorderFactory.createEtchedBorder());
        }
        
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                boolean hasFocus, int row, int column) {
            String headerName = "unknown";
            setFont(fontBold);
            headerName = tableHeaderRow[column];
            if (headerName == null) {
                headerName = "unknown";
            }
            //setText(DataConverter.capitalizeFirstLetter(headerName));
            setText(headerName);
            setToolTipText(headerName);
            setHorizontalAlignment(CENTER);            
            return this;
        }

        // The following methods override the defaults for performance reasons
        @Override
        public void validate() {}
        @Override
        public void revalidate() {}
        @Override
        protected void firePropertyChange(String propertyName, Object oldValue, Object newValue) {}
        @Override
        public void firePropertyChange(String propertyName, boolean oldValue, boolean newValue) {}

    }

}
