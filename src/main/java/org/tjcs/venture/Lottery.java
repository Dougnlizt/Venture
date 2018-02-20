/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tjcs.venture;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.tjcs.venture.Utilities.Grade;
import org.tjcs.venture.Utilities.Tier;

/**
 *
 * @author dougthompson
 */
public class Lottery {
    private final Grade grade;
    private final int openSeats;
    private List<ProspectiveStudent> studentsAddedToClass = new ArrayList<>();
    private List<ProspectiveStudent> studentsOnWaitList = new ArrayList<>();
    private Map<Tier, List<ProspectiveStudent>> tierPS_List = new TreeMap<>();

    public Lottery(Grade grade, int openSeats) {
        this.grade = grade;
        this.openSeats = openSeats;
    }

    public Grade getGrade() {
        return grade;
    }

    public int getOpenSeats() {
        return openSeats;
    }

    public List<ProspectiveStudent> getStudentsAddedToClass() {
        return studentsAddedToClass;
    }

    public List<ProspectiveStudent> getStudentsOnWaitList() {
        return studentsOnWaitList;
    }

    public Map<Tier, List<ProspectiveStudent>> getTierPS_List() {
        return tierPS_List;
    }
    
    public List<ProspectiveStudent> getStudentsByTier(Tier tier) {
        for (Map.Entry<Tier, List<ProspectiveStudent>> entry : tierPS_List.entrySet()) {
            Tier key = entry.getKey();
            if (key == tier) {
                return entry.getValue();
            }
        }
        return new ArrayList<>();
    }
    
    public List<ProspectiveStudent> getAllStudents() {
        List<ProspectiveStudent> tempList = new ArrayList<>();
        for (Map.Entry<Tier, List<ProspectiveStudent>> entry : tierPS_List.entrySet()) {
            tempList.addAll(entry.getValue());
        }
        return tempList;
        
    }
    
}
