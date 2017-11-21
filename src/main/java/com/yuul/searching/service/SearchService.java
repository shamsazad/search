package com.yuul.searching.service;

import com.yuul.searching.gateway.GoogleGeoCodeService;
import com.yuul.searching.model.external.GoogleGeometry.Bound;
import com.yuul.searching.model.external.GoogleGeometryApi;
import com.yuul.searching.model.external.Location;
import com.yuul.searching.model.external.LocationUi;
import com.yuul.searching.model.internal.Advertisement;
import com.yuul.searching.repository.ISearchRepository;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchService {

    private GoogleGeoCodeService googleGeoCodeService;
    private ISearchRepository searchRepository;
    private LocationUi locationUi = new LocationUi();

    @Autowired
    public SearchService( GoogleGeoCodeService googleGeoCodeService, ISearchRepository searchRepository) {
        this.googleGeoCodeService = googleGeoCodeService;
        this.searchRepository = searchRepository;
    }


    public LocationUi findApartment(String address) throws IOException {

        GoogleGeometryApi googleGeometryApi = googleGeoCodeService.getAddressWithGeoLocation(address);
        List<Location> locationList = new ArrayList<>();

        Location location = new Location(googleGeometryApi.getResults().get(0).getGeometry().getLocation().getLat(),
                googleGeometryApi.getResults().get(0).getGeometry().getLocation().getLat());
        location.setPlace_id(googleGeometryApi.getResults().get(0).getPlace_id());

        locationList.add(location);
        locationUi.setLocationList(locationList);

        List<Location> locations = getAllTheLocationsWithinViewPort(location);

        locationUi.setLocation(location);
        return locationUi;
    }

    private List<Location> getAllTheLocationsWithinViewPort(Location location) {
        return null;
    }

    public LocationUi eventTrigger(Bound bounds) {

        Location location = new Location(bounds.getNortheast().getLat(),
                bounds.getNortheast().getLng());
        List<Location> locationList = new ArrayList<>();

        List<Location> locations = getAllTheLocationsWithinViewPort(location);

        location.setPlace_id("dummyId");
        locationList.add(location);
        locationUi.setLocationList(locationList);
        locationUi.setLocation(location);


        return locationUi;
    }

    public void createAdd(Advertisement advertisement) throws IOException {

        GoogleGeometryApi googleGeometryApi = googleGeoCodeService.getAddressWithGeoLocation(advertisement.getAddress());
        Location location = new Location(googleGeometryApi.getResults().get(0).getGeometry().getLocation().getLat(),
                googleGeometryApi.getResults().get(0).getGeometry().getLocation().getLat());
       // advertisement.setViewport(googleGeometryApi.getResults().get(0).getGeometry().getViewport());
        searchRepository.save(advertisement);
    }
}
