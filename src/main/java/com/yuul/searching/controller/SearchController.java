package com.yuul.searching.controller;

import com.yuul.searching.model.Search;
import com.yuul.searching.model.external.GoogleGeometry.Bound;
import com.yuul.searching.model.external.GoogleGeometry.Viewport;
import com.yuul.searching.model.external.LocationUi;
import com.yuul.searching.service.SearchService;
import java.io.IOException;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(value = "/eventTrigger", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public LocationUi post(@RequestBody Bound bounds) throws IOException {
        return searchService.eventTrigger(bounds);
    }

    /*@RequestMapping(method = RequestMethod.POST, path="/abc")
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
    }*/
}
