package com.rok.sorter.model;

import javax.persistence.*;

/**
 * Created by roman.kulikov on 5/16/2017.
 * All rights reserved =D
 */
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
    private long nanosecondsEstimated;

    public SortResult() {
    }

    public SortResult(String sortedArray, int changesOfPositionsCount, long nanosecondsEstimated) {
        this.sortedArray = sortedArray;
        this.changesOfPositionsCount = changesOfPositionsCount;
        this.nanosecondsEstimated = nanosecondsEstimated;
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

    public long getNanosecondsEstimated() {
        return nanosecondsEstimated;
    }

    public void setNanosecondsEstimated(long nanosecondsEstimated) {
        this.nanosecondsEstimated = nanosecondsEstimated;
    }
}
