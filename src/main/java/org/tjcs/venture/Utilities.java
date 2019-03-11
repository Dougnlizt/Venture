/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tjcs.venture;

import java.awt.Color;
import java.awt.Component;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author dougthompson
 */
public class Utilities {
//    public static Color LIGHT_GREEN_COLOR = new Color(0xBB, 0xED, 0xC3);
//    public static Color MEDIUM_GREEN_COLOR = new Color(0xCA, 0xDB, 0xC8);
//    public static Color DARK_GREEN_COLOR = new Color(0x0B, 0x51, 0x01);
    //public static Color LIGHT_GREEN_COLOR = new Color(0x99, 0x9F, 0xF8); //#757AF3
    //public static Color LIGHT_GREEN_COLOR = new Color(0xB9, 0xBF, 0xF8); //#757AF3
    public static Color LIGHT_GREEN_COLOR = new Color(0xC1, 0xE8, 0xB6); //#C1E8B6
    //public static Color MEDIUM_GREEN_COLOR = new Color(0x75, 0x7A, 0xF3); //#4348F2
    //public static Color MEDIUM_GREEN_COLOR = new Color(0x99, 0x9F, 0xF8); //#757AF3
    public static Color MEDIUM_GREEN_COLOR = new Color(0xA2, 0xE0, 0x92); //#A2E092
//    public static Color DARK_GREEN_COLOR = new Color(0x0E, 0x3A, 0xE2);
    //public static Color DARK_GREEN_COLOR = new Color(0x00, 0x00, 0x00);
    public static Color BLACK_COLOR = new Color(0x00, 0x00, 0x00);
    public static Color YELLOW_COLOR = Color.YELLOW;
    public static String EMPTY_LOTTERY_DRAW_NUMBER = "-----";
    public static List<String> charactersArray = new ArrayList<>();
    static {
        int asciA_StartsAt = 65;        
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
    }
    
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

        public int getNumber() {
            return number;
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
        TWELFTH(12, "12th", false),
        ELEVENTH(11, "11th", false),
        TENTH(10, "10th", false),
        NINTH(9, "9th", false),
        EIGHTH(8, "8th", false),
        SEVENTH(7, "7th", false),
        SIXTH(6, "6th", false),
        FIFTH(5, "5th", false),
        FOURTH(4, "4th", false),
        THIRD(3, "3rd", false),
        SECOND(2, "2nd", false),
        FIRST(1, "1st", false),
        KINDER(0, "Kinder", false),
        UNKNOWN(-1, "Unknown", false),
        ;
        private final int number;
        private final String gradeDescription;
        private boolean lotteryComplete;

        private Grade(int gradeNumber, String gradeDescription, boolean lotteryComplete) {
            this.number = gradeNumber;
            this.gradeDescription = gradeDescription;
            this.lotteryComplete = lotteryComplete;
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

        public boolean isLotteryComplete() {
            return lotteryComplete;
        }

        public void setLotteryComplete(boolean lotteryComplete) {
            this.lotteryComplete = lotteryComplete;
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
        FAMILY_KEY(5, "Family Key", "C", true),
        WAIT_LIST_SIBLINGS(6, "Wait List Siblings", null, false),
        DATA_ROW_NUM(7, "Data Row #", null, false),
        IMPORT_ISSUE_REASON(8, "Reason", null, false),
        OLD_TIER(9, "Old Tier", null, false),
        NEW_TIER(10, "New Tier", null, false),
        ;
        private int uniqueIndex;
        private String columnName;
        private String spreadsheetColumn;
        private boolean fromSpreadsheet;

        private Columns(int uniqueIndex, String columnName, String spreadsheetColumn, boolean fromSpreadsheet) {
            this.uniqueIndex = uniqueIndex;
            this.columnName = columnName;
            this.spreadsheetColumn = spreadsheetColumn;
            this.fromSpreadsheet = fromSpreadsheet;
        }

        public int getUniqueIndex() {
            return uniqueIndex;
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
        
        public static Columns getColumnFromUniqueIndex(int colNum) {
            for (Columns value : Columns.values()) {
                if (value.uniqueIndex == colNum) {
                    return value;
                }
            }
            return null;
        }
        
        public static Columns getColumnFromUniqueIndex(String colNum) {
            if (colNum == null || colNum.trim().isEmpty()) return null;
            int colNumber = -1;
            try {
                colNumber = Integer.parseInt(colNum.trim());
            } catch (Exception ex) {
                return null;
            }
            return Columns.getColumnFromUniqueIndex(colNumber);
        }
        
        public static Columns getColumnFromHeader(String colName) {
            if (colName == null || colName.trim().isEmpty()) return null;
            for (Columns value : Columns.values()) {
                if (value.columnName.equalsIgnoreCase(colName)) {
                    return value;
                }
            }
            return null;
        }
        
        public static Columns getColumnFromSpreadsheetColumn(String colLetterName) {
            if (colLetterName == null || colLetterName.trim().isEmpty()) return null;
            for (Columns value : Columns.values()) {
                if (value.spreadsheetColumn != null
                        && value.spreadsheetColumn.equalsIgnoreCase(colLetterName)) {
                    return value;
                }
            }
            return null;
        }
        
        public static String[] getColumnHeaders() {
            String[] colHeaders = new String[Columns.values().length];
            int i = 0;
            for (Columns value : Columns.values()) {
                colHeaders[i ++] = value.columnName;
            }
            return colHeaders;
        }
        
        public static int getColumnSpreadsheetIndex(Columns col) {
            int colIndex = -1;
            if (col.spreadsheetColumn != null) {
                colIndex = charactersArray.indexOf(col.spreadsheetColumn);
            }
            return colIndex;
        }
       
        public static Columns getColumnFromSpreadsheetIndex(int spreadsheetColIndex) {
            return getColumnFromSpreadsheetColumn(charactersArray.get(spreadsheetColIndex));
        }
    }
    
    public enum ColumnsExport {
        LAST_NAME(0, "Last Name", "A", null, true),
        FIRST_NAME(1, "First Name", "B", null, true),
        TIER(2, "Tier", "C", null, true),
        EMPTY_COL(3, "", "D", null, true),
        LOTTERY_DRAW(4, "Lottery Draw", "E", null, true),
        WAIT_LIST_NUMBER(5, "Waitlist Number", "F", null, true),
        NOTES(6, "Notes", "G", 100, true),
        ;
        private int order;
        private String columnName;
        private String spreadsheetColumn;
        private Integer numCharsForWidth;
        private boolean fromSpreadsheet;

        private ColumnsExport(int order, String columnName, String spreadsheetColumn, Integer numCharsForWidth, boolean fromSpreadsheet) {
            this.order = order;
            this.columnName = columnName;
            this.spreadsheetColumn = spreadsheetColumn;
            if (numCharsForWidth == null) {
                this.numCharsForWidth = columnName.length();
            } else {
                this.numCharsForWidth = numCharsForWidth;
            }
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

        public Integer getNumCharsForWidth() {
            return numCharsForWidth;
        }

        public boolean isFromSpreadsheet() {
            return fromSpreadsheet;
        }
        
        public static ColumnsExport getColumn(int colNum) {
            for (ColumnsExport value : ColumnsExport.values()) {
                if (value.order == colNum) {
                    return value;
                }
            }
            return null;
        }
        
        public static ColumnsExport getColumn(String colNum) {
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
            String[] colHeaders = new String[ColumnsExport.values().length];
            int i = 0;
            for (ColumnsExport value : ColumnsExport.values()) {
                colHeaders[i ++] = value.columnName;
            }
            return colHeaders;
        }
        
        public static int getColumnIndex(ColumnsExport col) {
            int colIndex = -1;
            if (col.spreadsheetColumn != null) {
                //List<String> charArray = getSpreadsheetColumnLetters();
                colIndex = charactersArray.indexOf(col.spreadsheetColumn);
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
    
    public static Path selectDir(Component parent, String fileName) {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        Path currPath = null;
        if (fileName != null) {
            currPath = Paths.get(fileName);
        }
        if (currPath != null) {
            chooser.setCurrentDirectory(currPath.toFile());
        }
        int returnValue = chooser.showDialog(parent, "Select Export Destination Directory");
        switch(returnValue) {
            case JFileChooser.CANCEL_OPTION:
                return null;
            case JFileChooser.ERROR_OPTION:
                JOptionPane.showMessageDialog(parent, "There was an error", "Error Selecting Directory", JOptionPane.OK_OPTION);
                return null;
            case JFileChooser.APPROVE_OPTION:
                break;
        }
        File fileItem = chooser.getSelectedFile();
        Path newPath = fileItem.toPath();
        
        return newPath;
        
    }
    
    public static List<String> getSpreadsheetColumnLetters() {
        return charactersArray;
    }
    
    public static String getProspectiveStudentsAsString(List<ProspectiveStudent> prospectiveStudents) {
        return getProspectiveStudentsAsString(prospectiveStudents, false);
    }
    
    public static String getProspectiveStudentsAsString(List<ProspectiveStudent> prospectiveStudents, boolean includePreviousTier) {
        StringBuilder sb = new StringBuilder("");
        sb.append(Columns.LAST_NAME.getColumnName()).append(",")
                .append(Columns.FIRST_NAME.getColumnName()).append(",")
                .append(Columns.GRADE.getColumnName()).append(",");
        if (includePreviousTier) {
            sb.append(Columns.OLD_TIER.getColumnName()).append(",")
                    .append(Columns.NEW_TIER.getColumnName()).append(",");
        } else {
            sb.append(Columns.TIER.getColumnName()).append(",");
        }
        sb.append(Columns.FAMILY_KEY.getColumnName()).append("\n");
        for (ProspectiveStudent prospectiveStudent : prospectiveStudents) {
            //Create a new comma delimited row for each prospective student with the data accordingly
            sb.append(prospectiveStudent.getLastName()).append(",")
                    .append(prospectiveStudent.getFirstName()).append(",")
                    .append(prospectiveStudent.getGrade().number).append(",");
            if (includePreviousTier) {
                sb.append(prospectiveStudent.getOldTier().getNumber()).append(",");                
            }
            sb.append(prospectiveStudent.getTier().getNumber()).append(",");
            sb.append(prospectiveStudent.getFamilyKey()).append("\n");
        }
        return sb.toString();
    }
    
    public static boolean isDevelopment() {
        Path currentPath = Paths.get(System.getProperty("user.dir"));
        if (currentPath.resolve("target").resolve("test-classes").toFile().exists()) {
            return true;
        }
        return false;
    }
}
