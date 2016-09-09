package com.yuul.searching.repository;

import com.yuul.searching.Model.Search;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface SearchRepository extends CrudRepository <Search, Integer> {
}
