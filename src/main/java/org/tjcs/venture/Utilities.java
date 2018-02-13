/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tjcs.venture;

import java.awt.Component;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author dougthompson
 */
public class Utilities {
    public enum Tier {
        CHILDREN_OF_EMPLOYEES_1(1, "Children of Employees and Founders"),
        SIBLINGS_IN_DISTRICT_2(2, "Applicants that reside in Vallivue School District with siblings currently enrolled in TJCS"),
        SIBLINGS_IN_NEARBY_COUNTIES_3(3, "Applicants that reside in Canyon and Owyhee County with siblings currently enrolled in TJCS"),
        SIBLINGS_ALL_OTHER_4(4, "All other applicants with siblings currently enrolled in TJCS"),
        DISTRICT_RESIDENTS_5(5, "Applicants that reside in Vallivue District."),
        NEARBY_COUNTY_RESIDENTS_6(6, "Applicants that reside in Canyon or Owyhee County"),
        ALL_OTHER_7(7, "All other applicants"),
        UNKNOWN(-1, "Tier is not known"),
        ;
        private final int number;
        private final String description;

        private Tier(int number, String description) {
            this.number = number;
            this.description = description;
        }
        
        public static Tier getTier(String number) {
            if (number == null || number.trim().isEmpty()) return UNKNOWN;
            int tierNumber = -1;
            try {
                tierNumber = Integer.parseInt(number.trim());
            } catch (Exception ex) {
                return UNKNOWN;
            }
            return getTier(tierNumber);
        }
        
        public static Tier getTier(int tierNumber) {
            for (Tier value : Tier.values()) {
                if (value.number == tierNumber) return value;
            }
            return UNKNOWN;
        }
        
        public static String getNumberStr(Tier tier) {
            for (Tier value : Tier.values()) {
                if (value == tier) return String.valueOf(value.number);
            }
            return String.valueOf(UNKNOWN.number);
        }
    }
    
    public enum Grade {
        TWELFTH(12, "12th"),
        ELEVENTH(11, "11th"),
        TENTH(10, "10th"),
        NINTH(9, "9th"),
        EIGHTH(8, "8th"),
        SEVENTH(7, "7th"),
        SIXTH(6, "6th"),
        FIFTH(5, "5th"),
        FOURTH(4, "4th"),
        THIRD(3, "3rd"),
        SECOND(2, "2nd"),
        FIRST(1, "1st"),
        KINDER(0, "Kinder"),
        UNKNOWN(-1, "Unknown"),
        ;
        private final int number;
        private final String gradeDescription;

        private Grade(int gradeNumber, String gradeDescription) {
            this.number = gradeNumber;
            this.gradeDescription = gradeDescription;
        }
        
        public static Grade getGrade(int gradeNumber) {
            for (Grade value : Grade.values()) {
                if (value.number == gradeNumber) return value;
            }
            return UNKNOWN;
        }

        public int getNumber() {
            return number;
        }

        public String getGradeDescription() {
            return gradeDescription;
        }
        
        public static Grade getGrade(String gradeNumber) {
            if (gradeNumber == null || gradeNumber.trim().isEmpty()) return UNKNOWN;
            int grdNumber = -1;
            try {
                grdNumber = Integer.parseInt(gradeNumber.trim());
            } catch (Exception ex) {
                return UNKNOWN;
            }
            return getGrade(grdNumber);
        }
        
        public static String getNumberStr(Grade grade) {
            for (Grade value : Grade.values()) {
                if (value == grade) return String.valueOf(value.number);
            }
            return String.valueOf(Grade.UNKNOWN.number);
        }
    }
    
    public enum Columns {
        LOTTERY_DRAW(0, "Lottery Draw", null, false),
        LAST_NAME(1, "Last Name", "C", true),
        FIRST_NAME(2, "First Name", "D", true),
        TIER(3, "Tier", "E", true),
        GRADE(4, "Grade", "W", true),
        FAMILY_KEY(5, "Family Key", "C", false),
        WAIT_LIST_SIBLINGS(6, "Wait List Siblings", null, false),
        ;
        private int order;
        private String columnName;
        private String spreadsheetColumn;
        private boolean fromSpreadsheet;

        private Columns(int order, String columnName, String spreadsheetColumn, boolean fromSpreadsheet) {
            this.order = order;
            this.columnName = columnName;
            this.spreadsheetColumn = spreadsheetColumn;
            this.fromSpreadsheet = fromSpreadsheet;
        }

        public int getOrder() {
            return order;
        }

        public String getColumnName() {
            return columnName;
        }

        public String getSpreadsheetColumn() {
            return spreadsheetColumn;
        }

        public void setSpreadsheetColumn(String spreadsheetColumn) {
            this.spreadsheetColumn = spreadsheetColumn;
        }        

        public boolean isFromSpreadsheet() {
            return fromSpreadsheet;
        }
        
        public static Columns getColumn(int colNum) {
            for (Columns value : Columns.values()) {
                if (value.order == colNum) {
                    return value;
                }
            }
            return null;
        }
        
        public static Columns getColumn(String colNum) {
            if (colNum == null || colNum.trim().isEmpty()) return null;
            int colNumber = -1;
            try {
                colNumber = Integer.parseInt(colNum.trim());
            } catch (Exception ex) {
                return null;
            }
            return getColumn(colNumber);
        }
        
        public static String[] getColumnHeaders() {
            String[] colHeaders = new String[Columns.values().length];
            int i = 0;
            for (Columns value : Columns.values()) {
                colHeaders[i ++] = value.columnName;
            }
            return colHeaders;
        }
        
        public static int getColumnIndex(Columns col) {
            int colIndex = -1;
            if (col.spreadsheetColumn != null) {
                List<String> charArray = getSpreadsheetColumnLetters();
                colIndex = charArray.indexOf(col.spreadsheetColumn);
            }
            return colIndex;
        }
    }
    
    public static Path selectFile(Component parent, String fileName) {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        Path currPath = null;
        if (fileName != null) {
            currPath = Paths.get(fileName);
        }
        if (currPath != null) {
            chooser.setCurrentDirectory(currPath.toFile());
        }
        int returnValue = chooser.showDialog(parent, "Select Master File");
        switch(returnValue) {
            case JFileChooser.CANCEL_OPTION:
                return null;
            case JFileChooser.ERROR_OPTION:
                JOptionPane.showMessageDialog(parent, "There was an error", "Error Selecting File", JOptionPane.OK_OPTION);
                return null;
            case JFileChooser.APPROVE_OPTION:
                break;
        }
        File fileItem = chooser.getSelectedFile();
        Path newPath = fileItem.toPath();
        
        return newPath;
        
    }
    
    public static List<String> getSpreadsheetColumnLetters() {
        int asciA_StartsAt = 65;
        List<String> charactersArray = new ArrayList<>();
        for (int i = 0; i < 26; i ++) {
            String character = String.valueOf((char) (asciA_StartsAt + i));
            charactersArray.add(character);
        }
        for (int i = 0; i < 26; i ++) {
            String firstCharacter = String.valueOf((char) (asciA_StartsAt + i));
            for (int j = 0; j < 26; j ++) {
                String secondCharacter = String.valueOf((char) (asciA_StartsAt + j));
                charactersArray.add(firstCharacter + secondCharacter);
            }
        }
        return charactersArray;
    }
    
}
