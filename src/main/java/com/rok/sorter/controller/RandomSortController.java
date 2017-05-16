package com.rok.sorter.controller;

import com.rok.sorter.logic.RandomSorter;
import com.rok.sorter.model.SortResult;
import com.rok.sorter.service.SortResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Created by roman.kulikov on 5/16/2017.
 * All rights reserved =D
 */

@RestController
@RequestMapping("/sortResult")
public class RandomSortController {

    @Autowired
    SortResultService sortResultService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public SortResult sort(@RequestParam(name="array") Double[] numbers) {
        return sortResultService.createSortResult(numbers);
    }

    @RequestMapping(value = "/fetchAll", method = RequestMethod.GET)
    @ResponseBody
    public List<SortResult> fetchAll() {
        return sortResultService.fetchAllSortResults();
    }

}
