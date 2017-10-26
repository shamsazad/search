package com.yuul.searching.model.external;

import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@Setter
public class LocationUi {

    private Location location;
    private List<Location> locationList;

    public LocationUi(){

    }

    @JsonCreator
    public LocationUi(Location location, List<Location> locationList) {
        this.location = location;
        this.locationList = locationList;
    }
}
