package com.rok.sorter.service;

/**
 * Created by roman.kulikov on 5/16/2017.
 * All rights reserved =D
 */

import java.util.ArrayList;
import java.util.List;

import com.rok.sorter.logic.RandomSorter;
import com.rok.sorter.model.SortResult;
import org.springframework.stereotype.Service;

@Service("sortInfoService")
public class SortResultServiceImpl implements SortResultService {

    public List<SortResult> fetchAllSortResults() {
        return new ArrayList<>();
    }

    public SortResult createSortResult(Double[] numbers) {
        RandomSorter sorter = new RandomSorter(numbers);
        return sorter.sort();
    }

}
