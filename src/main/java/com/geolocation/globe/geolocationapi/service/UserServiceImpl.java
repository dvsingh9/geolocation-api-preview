package com.geolocation.globe.geolocationapi.service;

import com.geolocation.globe.geolocationapi.clients.Geolocation;
import com.geolocation.globe.geolocationapi.clients.GeolocationClient;
import com.geolocation.globe.geolocationapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final GeolocationClient geolocationClient;

    @Autowired
    public UserServiceImpl(GeolocationClient geolocationClient) {
        this.geolocationClient = geolocationClient;
    }

    /**
     * @param username
     * @param password
     * @param ipAddress
     * @return newly created user
     */
    @Override
    public User createUser(String username, String password, String ipAddress) {
        Geolocation geolocation = geolocationClient.geolocation(ipAddress);
        if(geolocation != null) {
            if(geolocation.getCountry().equals("Canada")) {
                return User.builder()
                        .userId(UUID.randomUUID())
                        .city(geolocation.getCity())
                        .username(username)
                        .build();
            }
        }
        return null;
    }


}
