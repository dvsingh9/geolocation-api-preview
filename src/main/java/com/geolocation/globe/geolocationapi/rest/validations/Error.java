package com.geolocation.globe.geolocationapi.rest.validations;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Error {

    private String code;
    private String field;
    private String detail;
    private String source;
}
