package com.yuul.searching.model.external;

import com.fasterxml.jackson.annotation.JsonCreator;
import java.io.Serializable;
import java.util.List;
import lombok.Getter;

@Getter
public class GoogleGeometryApi implements Serializable{

    private List<Result> results;
    private String status;

    @JsonCreator
    public GoogleGeometryApi(List<Result> results, String status) {
        this.results = results;
        this.status = status;
    }

}
