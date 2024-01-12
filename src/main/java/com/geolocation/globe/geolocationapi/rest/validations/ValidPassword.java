package com.geolocation.globe.geolocationapi.rest.validations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Target(FIELD)
@Retention(RUNTIME)
@Constraint(validatedBy = { PasswordValidator.class })
public @interface ValidPassword {

    String message() default "Password should be 8 char long containing 1 special char, 1 upper letter, 1 lower letter";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
