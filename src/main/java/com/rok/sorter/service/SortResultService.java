package com.rok.sorter.service;

import com.rok.sorter.model.SortResult;

import java.util.List;

/**
 * Created by roman.kulikov on 5/16/2017.
 * All rights reserved =D
 */
public interface SortResultService {

    List<SortResult> fetchAllSortResults();

    SortResult createSortResult(Double[] array);
}
