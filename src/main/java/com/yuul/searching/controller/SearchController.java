package com.yuul.searching.controller;

import com.yuul.searching.Model.Search;
import com.yuul.searching.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;

@RestController
@RequestMapping("/yuul/search/")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
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
    public Iterable<Search> getAll() {
        return searchService.findAll();
    }
}
