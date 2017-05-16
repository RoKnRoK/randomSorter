package com.rok.sorter.rest;

import com.rok.sorter.logic.RandomSorter;
import com.rok.sorter.model.SortResult;
import org.springframework.web.bind.annotation.*;

import java.util.*;


/**
 * Created by roman.kulikov on 5/16/2017.
 * All rights reserved =D
 */

@RestController
public class RandomSortController {

    @RequestMapping(value = "/eval/{numbers}", method = RequestMethod.GET)
    @ResponseBody
    public SortResult eval(@PathVariable Double[] numbers) {

        RandomSorter sorter = new RandomSorter(numbers);
        return sorter.sort();

    }


}
