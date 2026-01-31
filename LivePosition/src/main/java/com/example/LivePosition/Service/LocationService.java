package com.example.LivePosition.Service;

import com.example.LivePosition.DTO.LocationResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class LocationService {

    private final RestTemplate restTemplate = new RestTemplate();

    public LocationResponse getLocationDetails(double lat, double lon) {

        String url = "https://nominatim.openstreetmap.org/reverse?format=json"
                + "&lat=" + lat
                + "&lon=" + lon
                + "&addressdetails=1";

        Map response = restTemplate.getForObject(url, Map.class);
        Map address = (Map) response.get("address");

        LocationResponse res = new LocationResponse();
        res.setPlace((String) response.get("display_name"));
        res.setCity((String) address.get("city"));
        res.setState((String) address.get("state"));
        res.setPincode((String) address.get("postcode"));
        res.setCountry((String) address.get("country"));

        return res;
    }
}

