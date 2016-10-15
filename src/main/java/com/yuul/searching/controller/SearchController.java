package com.yuul.searching.controller;

import com.yuul.searching.Model.Search;
import com.yuul.searching.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/yuul/search/")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public Search get(@PathVariable int id) {

        return searchService.findOne(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @CrossOrigin
    public void post(@RequestBody Search search) {
        Search searchSaved = searchService.create(search);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public Iterable<Search> getAll() {
        return searchService.findAll();
    }
}
