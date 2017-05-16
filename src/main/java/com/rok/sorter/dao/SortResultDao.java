package com.rok.sorter.dao;

import com.rok.sorter.model.SortResult;

import java.util.List;

/**
 * Created by roman.kulikov on 5/16/2017.
 * All rights reserved =D
 */
public interface SortResultDao {

    List<SortResult> fetchAllSortResults();

    void addSortResult(SortResult sortResult);
}
