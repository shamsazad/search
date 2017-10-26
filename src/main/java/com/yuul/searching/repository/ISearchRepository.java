package com.yuul.searching.repository;

import com.yuul.searching.model.Search;
import org.springframework.data.repository.CrudRepository;

public interface ISearchRepository extends CrudRepository <Search, Integer> {
}
