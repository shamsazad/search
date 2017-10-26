package com.yuul.searching.model.external;

import com.fasterxml.jackson.annotation.JsonCreator;
import java.io.Serializable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@Setter
public class Location implements Serializable {

    private String place_id;
    private final Double lat;
    private final Double lng;

    @JsonCreator
    public Location(Double lat, Double lng) {
        this.lat = lat;
        this.lng = lng;
    }
}
