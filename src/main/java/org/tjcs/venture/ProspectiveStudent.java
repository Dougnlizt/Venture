/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tjcs.venture;

import java.util.ArrayList;
import java.util.List;
import org.tjcs.venture.Utilities.Grade;
import org.tjcs.venture.Utilities.Tier;

/**
 *
 * @author dougthompson
 */
public class ProspectiveStudent {
    private int LotteryDrawNumber = -1;
    private boolean changeInTier;
    private List<ProspectiveStudent> siblingsOnWaitlist = new ArrayList<>();
    
    private String lastName;
    private String firstName;
    private Tier tier;
    private String familyKey;
    private Grade grade;

    public ProspectiveStudent(String lastName, String firstName, Tier tier, String familyKey, Grade grade) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.tier = tier;
        this.familyKey = familyKey;
        this.grade = grade;
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

    public String getFamilyKey() {
        return familyKey;
    }

    public int getLotteryDrawNumber() {
        return LotteryDrawNumber;
    }

    public void setLotteryDrawNumber(int LotteryDrawNumber) {
        this.LotteryDrawNumber = LotteryDrawNumber;
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
    
    
    
}
