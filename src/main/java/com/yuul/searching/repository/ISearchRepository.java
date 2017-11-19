package com.yuul.searching.repository;

import com.yuul.searching.model.Search;
import com.yuul.searching.model.internal.Advertisement;
import org.springframework.data.repository.CrudRepository;

public interface ISearchRepository extends CrudRepository <Advertisement, Integer> {
}
