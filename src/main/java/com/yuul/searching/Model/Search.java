package com.yuul.searching.Model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

public class Search {

    @NotNull
    String location;
    @Id
    @GeneratedValue
    int id;
}
