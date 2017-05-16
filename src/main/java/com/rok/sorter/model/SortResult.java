package com.rok.sorter.model;

/**
 * Created by roman.kulikov on 5/16/2017.
 * All rights reserved =D
 */
public class SortResult {
    private String sortedArray;
    private int changesOfPositionsCount;
    private long millisecondsEstimated;

    public SortResult(String sortedArray, int changesOfPositionsCount, long millisecondsEstimated) {
        this.sortedArray = sortedArray;
        this.changesOfPositionsCount = changesOfPositionsCount;
        this.millisecondsEstimated = millisecondsEstimated;
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

    public long getMillisecondsEstimated() {
        return millisecondsEstimated;
    }

    public void setMillisecondsEstimated(long millisecondsEstimated) {
        this.millisecondsEstimated = millisecondsEstimated;
    }
}
