package com.yuul.searching.repository;

import com.yuul.searching.Model.Search;
import org.springframework.data.repository.CrudRepository;

public interface ISearchRepository extends CrudRepository <Search, Integer> {
}
