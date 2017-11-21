package com.yuul.searching.model.external;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class GoogleGeometry implements Serializable {

    private final Bound bounds;
    private final Location location;
    private final Viewport viewport;

    @JsonCreator
    public GoogleGeometry( @JsonProperty("bounds") Bound bounds, @JsonProperty("location") Location location,
            @JsonProperty("viewport") Viewport viewport) {
        this.bounds = bounds;
        this.location = location;
        this.viewport = viewport;
    }
    @Getter
    @EqualsAndHashCode
    @ToString
    public static class Bound implements Serializable {

        private final Northeast northeast;
        private final Southwest southwest;

        @JsonCreator
        public Bound(@JsonProperty("northeast") Northeast northeast,
                @JsonProperty("southwest") Southwest southwest) {
            this.northeast = northeast;
            this.southwest = southwest;
        }

        @Getter
        @ToString
        @EqualsAndHashCode
        public static class Northeast implements Serializable {

            private final Double lat;
            private final Double lng;

            @JsonCreator
            public Northeast(@JsonProperty("lat") Double lat, @JsonProperty("lng") Double lng) {
                this.lat = lat;
                this.lng = lng;
            }
        }
        @Getter
        @ToString
        @EqualsAndHashCode
        public static class Southwest implements Serializable {

            private final Double lat;
            private final Double lng;

            @JsonCreator
            public Southwest(@JsonProperty("lat") Double lat, @JsonProperty("lng") Double lng) {
                this.lat = lat;
                this.lng = lng;
            }
        }
    }

    @Getter
    @ToString
    @EqualsAndHashCode
    public static class Location implements  Serializable {

        private final Double lat;
        private final Double lng;

        @JsonCreator
        public Location(Double lat, Double lng) {
            this.lat = lat;
            this.lng = lng;
        }
    }

    @Getter
    @EqualsAndHashCode
    @ToString
    @AllArgsConstructor
    public static class Viewport implements Serializable {

        private final Northeast northeast;
        private final Southwest southwest;


        @Getter
        @ToString
        @EqualsAndHashCode
        @AllArgsConstructor
        public static class Northeast implements Serializable {

            private final Double lat;
            private final Double lng;

        }
        @Getter
        @ToString
        @EqualsAndHashCode
        @AllArgsConstructor
        public static class Southwest implements Serializable {

            private final Double lat;
            private final Double lng;

        }
    }
}
