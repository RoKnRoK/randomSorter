package com.rok.sorter.model;

import javax.persistence.*;

/**
 * Created by roman.kulikov on 5/16/2017.
 * All rights reserved =D
 */
@SuppressWarnings("unused")
@Entity
public class SortResult {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    private String sortedArray;
    @Column
    private int changesOfPositionsCount;
    @Column
    private String timeEstimated;

    public SortResult() {
    }

    public SortResult(String sortedArray, int changesOfPositionsCount, String timeEstimated) {
        this.sortedArray = sortedArray;
        this.changesOfPositionsCount = changesOfPositionsCount;
        this.timeEstimated = timeEstimated;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSortedArray() {
        return sortedArray;
    }

    public void setSortedArray(String sortedArray) {
        this.sortedArray = sortedArray;
    }

    public int getChangesOfPositionsCount() {
        return changesOfPositionsCount;
    }

    public void setChangesOfPositionsCount(int changesOfPositionsCount) {
        this.changesOfPositionsCount = changesOfPositionsCount;
    }

    public String getTimeEstimated() {
        return timeEstimated;
    }

    public void setTimeEstimated(String timeEstimated) {
        this.timeEstimated = timeEstimated;
    }
}
