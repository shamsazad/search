package com.yuul.searching.controller;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import com.yuul.searching.Model.Search;
import com.yuul.searching.repository.ISearchRepository;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SearchControllerTest {

    @Autowired
    private SearchController service;
    @Autowired
    private ISearchRepository searchRepository;

    Search search = new Search();

    @Before
    public void insertValueInDatabase() {
        search.setId(1);
        search.setLocation("Montreal");
        searchRepository.save(search);
    }
    @Test
    public void shouldGetService(){

        assertThat(search.getId(),equalTo(service.get(1).getId()));
    }

}
