package com.geolocation.globe.geolocationapi.model;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data @Builder
public class User {

    UUID userId;

    String username;

    String password;

    String ipAddreress;

    String city;
}
