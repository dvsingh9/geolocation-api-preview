package com.geolocation.globe.geolocationapi.clients;


import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class GeolocationClient {

    WebClient client = WebClient.create("http://ip-api.com");

    public Geolocation geolocation(String ipAddres) {
        // call IP api
        return client.get()
                .uri("/json/"+ipAddres)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Geolocation.class)
                .block();
    }

}
