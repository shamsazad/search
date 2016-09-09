package com.yuul.searching.service;

import com.yuul.searching.Model.Search;
import com.yuul.searching.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class SearchService {
    private final SearchRepository searchRepository;

    @Autowired
    public SearchService(SearchRepository searchRepository) {
        this.searchRepository = searchRepository;
    }

    public Search create(Search search){
        return searchRepository.save(search);
    }

    public Search findOne(int id) {
        return searchRepository.findOne(id);
    }
}
