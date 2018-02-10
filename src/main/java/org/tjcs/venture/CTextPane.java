/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tjcs.venture;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.UIDefaults;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @author dougthompson
 */
public class CTextPane extends JTextPane {

    public CTextPane() {
        super();
        doc = getStyledDocument();
        defaultAttrSet = new SimpleAttributeSet(getInputAttributes());
        defaultPaneBGColor = getBackground();
    }
    
    
    /**
    * This will control whether the enclosing ScrollPane will have a horizontal
    * scrollbar. Default is to not have a horizontal scrollbar so the lines
    * will wrap.
    */
    private boolean lineWrapEnabled = true;
    Color defaultPaneBGColor = getBackground();
    private MutableAttributeSet defaultAttrSet = null;
    /**
    * This contains the actual text displayed in the text pane.
    */
    private StyledDocument doc = null;


    public void enableLineWrap(boolean enable) {
        lineWrapEnabled = enable;
    }

    /**
     * This will set the width of the Text Pane to match the largest line
     * inserted into the document rather than the size of the JScrollPane. This
     * allows us to have the Text Pane NOT have line wrapping. Refer to the
     * javadoc for an explanation of the parameters.
     */
    @Override
    public void setBounds(int x, int y, int width, int height) {
        Dimension size = this.getPreferredSize();
        if (lineWrapEnabled) {
            super.setBounds(x, y, width, height);
        } else {
            super.setBounds(x, y, Math.max(size.width, width), height);
        }
    }

    /**
     * Highlights the text based on the start and end position. The default
     * attribute set is used and modified based on the font/color passed in
     * (null is allowed). If either the start or end positions are invalid (i.e.
     * startPos gt endPos), no action is taken.
     *
     * @param startPos The starting character that will have the text's
     * attributes modified
     * @param endPos The ending character for the range of characters to have
     * the attributes applied
     * @param font Type of font to use for the selected text range
     * @param color Color to use for the selected text range
     * @param highlightColor The Color object to use for highlighting
     */
    public void highlightText(int startPos, int endPos, Font font, Color color, Color highlightColor) {
        SimpleAttributeSet tmpAttrSet = new SimpleAttributeSet(defaultAttrSet);
        if (font != null) {
            if (font.getSize() > 0) {
                StyleConstants.setFontSize(tmpAttrSet, font.getSize());
            }
            StyleConstants.setItalic(tmpAttrSet, (font.getStyle() & Font.ITALIC) != 0);
            StyleConstants.setBold(tmpAttrSet, (font.getStyle() & Font.BOLD) != 0);
        }
        if (color != null) {
            StyleConstants.setForeground(tmpAttrSet, color);
        }
        if (highlightColor == null) {
            StyleConstants.setBackground(tmpAttrSet, defaultPaneBGColor);
        } else {
            StyleConstants.setBackground(tmpAttrSet, highlightColor);
        }
        doc.setCharacterAttributes(startPos, (endPos - startPos), tmpAttrSet, true);
    }

    public void setBackgroundColor(Color c) {
        // this is to fix a problem with the Nimbus look and feel not displaying the background correctly.
        UIDefaults defaults = new UIDefaults();
        defaults.put("TextPane[Enabled].backgroundPainter", c);
        putClientProperty("Nimbus.Overrides", defaults);
        putClientProperty("Nimbus.Overrides.InheritDefaults", true);
        setBackground(c);
        defaultPaneBGColor = c;
    }

}
