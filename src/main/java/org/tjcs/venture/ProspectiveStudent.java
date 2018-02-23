/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tjcs.venture;

import java.util.ArrayList;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.tjcs.venture.Utilities.Grade;
import org.tjcs.venture.Utilities.Tier;

/**
 *
 * @author dougthompson
 */
public class ProspectiveStudent implements Comparable<ProspectiveStudent> {
    private int LotteryDrawNumber = -1;
    private boolean availableSeatOffered = false;
    private boolean changeInTier;
    private List<ProspectiveStudent> siblingsOnWaitlist = new ArrayList<>();
    
    private String lastName;
    private String firstName;
    private Tier tier;
    private Tier oldTier;
    private String familyKey;
    private Grade grade;
    private XSSFRow rowFromSpreadsheet;

    public ProspectiveStudent(XSSFRow row, String lastName, String firstName, Tier tier, String familyKey, Grade grade) {
        this.rowFromSpreadsheet = row;
        this.lastName = lastName;
        this.firstName = firstName;
        this.tier = tier;
        this.familyKey = familyKey;
        this.grade = grade;
    }

    public XSSFRow getRowFromSpreadsheet() {
        return rowFromSpreadsheet;
    }
    
    public XSSFCell getColumnFromSourceSpreadsheet(int colIndex) {
        if (rowFromSpreadsheet == null) return null;
        return rowFromSpreadsheet.getCell(colIndex);
    }
    
    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public Tier getTier() {
        return tier;
    }

    public void setTier(Tier tier) {
        this.tier = tier;
    }

    public Tier getOldTier() {
        return oldTier;
    }

    public void setOldTier(Tier oldTier) {
        this.oldTier = oldTier;
    }
    
    public String getFamilyKey() {
        return familyKey;
    }

    public int getLotteryDrawNumber() {
        return LotteryDrawNumber;
    }

    public void setLotteryDrawNumber(int LotteryDrawNumber) {
        this.LotteryDrawNumber = LotteryDrawNumber;
    }

    public boolean isAvailableSeatOffered() {
        return availableSeatOffered;
    }

    public void setAvailableSeatOffered(boolean availableSeatOffered) {
        this.availableSeatOffered = availableSeatOffered;
    }

    public Grade getGrade() {
        return grade;
    }

    public boolean isChangeInTier() {
        return changeInTier;
    }

    public void setChangeInTier(boolean changeInTier) {
        this.changeInTier = changeInTier;
    }

    public List<ProspectiveStudent> getSiblingsOnWaitlist() {
        return siblingsOnWaitlist;
    }

    @Override
    public String toString() {
        return lastName + ", " + firstName;
    }

    @Override
    public int compareTo(ProspectiveStudent o) {
        //First by grade, then last name, then first name
        int compareVal = this.grade.compareTo(o.grade);
        if (compareVal == 0) {
            compareVal = this.lastName.compareTo(o.lastName);
            if (compareVal == 0) {
                compareVal = this.firstName.compareTo(o.firstName);
            }
        }
        return compareVal;
    }
    
}
