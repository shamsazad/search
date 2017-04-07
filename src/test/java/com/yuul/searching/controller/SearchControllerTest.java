package com.yuul.searching.controller;

import com.yuul.searching.Model.Search;
import com.yuul.searching.repository.ISearchRepository;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import org.springframework.beans.factory.annotation.Autowired;

public class SearchControllerTest {

    private SearchController service;
    private Search result;
    @Autowired
    private ISearchRepository searchRepository;
    @Autowired
    private Search search;

    @Before
    private void insertValueInDatabase() {
        search.setId(1);
        search.setLocation("Montreal");
        searchRepository.save(search);
    }
    @Test
    public void shouldGetService(){
        this.result = this.service.get(1);
        assertThat(23).equal(this.searchRepository.findOne(1));
    }

}
