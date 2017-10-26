package com.yuul.searching.gateway;

import com.google.gson.Gson;
import com.yuul.searching.model.external.GoogleGeometryApi;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class GoogleGeoCodeService {

    private final String googleUri = "https://maps.googleapis.com/maps/api/geocode/json";
    private final String key = "AIzaSyC_ErmfaXptjlCpp7UcEaONwQAenMopuFo";

    public GoogleGeometryApi getAddressWithGeoLocation(String address) throws IOException {

        String pricesUrl = UriComponentsBuilder.fromHttpUrl(googleUri)
                .query("address="+address)
                .query("key="+key)
                .toUriString();
        String charset = "UTF-8";

        URL url = new URL(pricesUrl);
        Reader reader = new InputStreamReader(url.openStream(), charset);

        GoogleGeometryApi googleGeometryApi = new Gson().fromJson(reader, GoogleGeometryApi.class);
        return googleGeometryApi;
    }
}
