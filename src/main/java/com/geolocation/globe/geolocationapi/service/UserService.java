package com.geolocation.globe.geolocationapi.service;

import com.geolocation.globe.geolocationapi.model.User;

public interface UserService {

    User createUser(String username, String password, String ipAddress);
}
