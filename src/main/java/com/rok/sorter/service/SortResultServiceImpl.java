package com.rok.sorter.service;

/*
  Created by roman.kulikov on 5/16/2017.
  All rights reserved =D
 */

import com.rok.sorter.dao.SortResultDao;
import com.rok.sorter.logic.RandomSorter;
import com.rok.sorter.model.SortResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sortInfoService")
public class SortResultServiceImpl implements SortResultService {

    @Autowired
    private SortResultDao sortResultDao;

    public List<SortResult> fetchAllSortResults() {
        return sortResultDao.fetchAllSortResults();
    }

    public void clearAllSortResults() {
        sortResultDao.clearAllSortResults();
    }

    public SortResult createSortResult(Double[] numbers) {
        RandomSorter sorter = new RandomSorter(numbers);
        SortResult sortResult = sorter.sort();
        sortResultDao.addSortResult(sortResult);
        return sortResult;
    }

}
