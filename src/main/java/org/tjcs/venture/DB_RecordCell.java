/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tjcs.venture;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JLabel;

/**
 *
 * @author dthompson
 */
public class DB_RecordCell extends JLabel implements ActionListener, Comparable<DB_RecordCell> {

    private String _value;
    private boolean _searchMatch = false;
    private int _searchStart = 0;
    private int _searchEnd = 0;
    public final static String DOUBLE_CLICKED = "Double Clicked";
    public final static String SELECTED = "Selected";
    private int row = 0;
    private int col = 0;
    private ProspectiveStudent prospectiveStudent;
    private boolean intValue = false;

    public DB_RecordCell(String value, int row, int col) {
        _value = value;
        this.row = row;
        this.col = col;
    }

    public DB_RecordCell(String value, boolean intValue, int row, int col) {
        _value = value;
        this.row = row;
        this.col = col;
        this.intValue = intValue;
    }

    public boolean isSearchMatch() {
        return _searchMatch;
    }

    public void setSearchMatch(boolean searchMatch) {
        this._searchMatch = searchMatch;
    }

    public int getSearchStart() {
        return _searchStart;
    }

    public void setSearchStart(int searchStart) {
        this._searchStart = searchStart;
    }

    public int getSearchEnd() {
        return _searchEnd;
    }

    public void setSearchEnd(int searchEnd) {
        this._searchEnd = searchEnd;
    }

    public enum OptionItems {id, value, active} //OPTION_ID_STR, OPTION_VALUE_ST, OPTION_ACTIVE_STR}

    @Override
    public String toString() {
        return _value;
    }

    public String getValue() {
        return _value;
    }

    public void setValue(String value) {
        this._value = value;
    }

    public ProspectiveStudent getProspectiveStudent() {
        return prospectiveStudent;
    }

    public void setProspectiveStudent(ProspectiveStudent prospectiveStudent) {
        this.prospectiveStudent = prospectiveStudent;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Not sure this does what I expect it to... may not be needed.
     * @return
     */
    @Override
    public Color getForeground() {
        Color foregroundColor = super.getForeground();
        //if (hasPendingChanges()) {
        //    foregroundColor = StandardColors.RED;
        //}
        return foregroundColor;
    }

    @SuppressWarnings("unchecked")
    private List<ActionListener> _listeners = Collections.synchronizedList(new LinkedList());

    public void fire(ActionEvent e) {
        for (int i = (_listeners.size() - 1); i >= 0; i--) {
            (_listeners.get(i)).actionPerformed(e);
        }
    }

    public void addActionListener(ActionListener l) {
        _listeners.add(l);
    }

    public void removeActionListener(ActionListener l) {
        _listeners.remove(l);
    }
    
    @Override
    public int compareTo(DB_RecordCell o) {
        if (intValue && o.intValue) {
            //Compare as ints
            return ((Integer) Integer.parseInt(_value)).compareTo(((Integer) Integer.parseInt(o._value)));
        }
        return this._value.compareToIgnoreCase(o._value);
    }
}
