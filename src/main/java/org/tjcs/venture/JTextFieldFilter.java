/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tjcs.venture;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * Sends action events to listeners when text is inserted, removed, or changed.  Ideal for
 * applications that need to know right away when a text field's contents have changed.
 * @author dthompson
 */
public class JTextFieldFilter extends JTextField implements DocumentListener {

    public JTextFieldFilter() {
        getDocument().addDocumentListener(this);
    }

    public static final String INSERT = "Insert";
    public static final String REMOVE = "Remove";
    public static final String CHANGE = "Change";

    @Override
    public void insertUpdate(DocumentEvent e) {
        fire(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, INSERT));
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        fire(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, REMOVE));
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        fire(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, CHANGE));
    }

    @SuppressWarnings("unchecked")
    private List<ActionListener> _listeners = Collections.synchronizedList(new LinkedList<ActionListener>());

    private void fire(ActionEvent e) {
        for (int i = (_listeners.size() - 1); i >= 0; i--) {
            (_listeners.get(i)).actionPerformed(e);
        }
    }

    @Override
    public void addActionListener(ActionListener l) {
        _listeners.add(l);
    }

    @Override
    public void removeActionListener(ActionListener l) {
        _listeners.remove(l);
    }
}