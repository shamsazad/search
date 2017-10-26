package com.yuul.searching.model.external;

import com.fasterxml.jackson.annotation.JsonCreator;
import java.io.Serializable;
import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class Result implements Serializable{

    private List<Object> address_components;
    private String formatted_address;
    private GoogleGeometry geometry;
    private String place_id;
    private List<String> types;

    @JsonCreator
    public Result(List<Object> address_components, String formatted_address,
            GoogleGeometry geometry, String place_id, List<String> types) {

        this.address_components = address_components;
        this.formatted_address = formatted_address;
        this.geometry = geometry;
        this.place_id = place_id;
        this.types =types;

    }
}
