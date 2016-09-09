package com.yuul.searching.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/yuul/search/")
public class SearchController {

    @RequestMapping(value = "/{location}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity get(@PathVariable final String location) {
        return null;
    }
}
