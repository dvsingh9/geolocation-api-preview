package com.geolocation.globe.geolocationapi.rest;

import com.geolocation.globe.geolocationapi.model.User;
import com.geolocation.globe.geolocationapi.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/addUser")
    public UserResponse addUser(@Valid @RequestBody UserRequest userRequest) {
        User user = userService.createUser(userRequest.getUsername(), userRequest.getPassword(), userRequest.getIpAddress());
        return UserResponse.builder()
                .userId(user.getUserId())
                .message(String.format("Hi %s, thanks for choosing us. Welcome to %s", user.getUsername(), user.getCity()))
                .build();
    }

}
