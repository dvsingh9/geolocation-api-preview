package com.geolocation.globe.geolocationapi.clients;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor
@NoArgsConstructor
public class Geolocation {

    String status;
    String city;
    String country;

}
