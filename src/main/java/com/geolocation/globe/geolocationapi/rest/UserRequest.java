package com.geolocation.globe.geolocationapi.rest;

import com.geolocation.globe.geolocationapi.rest.validations.ValidPassword;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data @Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class UserRequest {

    @NotBlank(message = "User name cannot be blank")
    String username;

    @NotBlank(message = "Password cannot be blank")
    @ValidPassword
    String password;

    @NotBlank(message = "IP address cannot be blank")
    String ipAddress;
}
