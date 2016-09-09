package com.yuul.searching.controller;

import com.yuul.searching.Model.Search;
import com.yuul.searching.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/yuul/search/")
public class SearchController {

    @Autowired
    SearchService searchService;

    @RequestMapping(value = "/{location}", method = RequestMethod.GET)
    @ResponseBody
    public Search get(@PathVariable int id) {

        return searchService.findOne(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public HttpStatus post(@RequestBody Search search) {
        Search searchSaved = searchService.create(search);
        return null;
    }
}
