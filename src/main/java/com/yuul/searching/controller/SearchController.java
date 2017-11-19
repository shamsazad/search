package com.yuul.searching.controller;

import com.yuul.searching.model.Search;
import com.yuul.searching.model.external.GoogleGeometry.Bound;
import com.yuul.searching.model.external.GoogleGeometry.Viewport;
import com.yuul.searching.model.external.LocationUi;
import com.yuul.searching.model.internal.Advertisement;
import com.yuul.searching.service.SearchService;
import java.io.IOException;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/yuul/search/")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @RequestMapping(value = "/{address}", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public LocationUi get(@PathVariable String address) throws IOException {
        return searchService.findApartment(address);
    }

    @RequestMapping(value = "/eventTrigger", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @CrossOrigin
    public LocationUi post(@RequestBody Bound bounds) throws IOException {
        return searchService.eventTrigger(bounds);
    }

    @RequestMapping(method = RequestMethod.POST, path="/postAdd")
    @ResponseStatus(HttpStatus.CREATED)
    @CrossOrigin
    public void post(@RequestBody Advertisement advertisement) {
        searchService.createAdd(advertisement);
    }

    /*@RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public Iterable<Search> getAll() {
        return searchService.findAll();
    }*/
}
