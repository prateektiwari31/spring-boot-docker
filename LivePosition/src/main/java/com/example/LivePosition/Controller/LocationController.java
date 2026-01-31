package com.example.LivePosition.Controller;

import com.example.LivePosition.DTO.LocationRequest;
import com.example.LivePosition.DTO.LocationResponse;
import com.example.LivePosition.Service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @PostMapping("/location")
    public LocationResponse getLocation(@RequestBody LocationRequest req) {
        return locationService.getLocationDetails(
                req.getLatitude(),
                req.getLongitude()
        );
    }
}
