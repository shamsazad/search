package com.yuul.searching.service;

import com.yuul.searching.Model.Search;
import com.yuul.searching.repository.ISearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Service
public class SearchService {

    @Autowired
    private ISearchRepository searchRepository;

    public Search create(Search search){
        return searchRepository.save(search);
    }

    public Search findOne(int id) {
        return searchRepository.findOne(id);
    }

    public Iterable<Search> findAll() {
        return searchRepository.findAll();
    }
}
