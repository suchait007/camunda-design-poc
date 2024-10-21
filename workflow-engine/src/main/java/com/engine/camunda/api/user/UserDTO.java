package com.engine.camunda.api.user;

import lombok.Data;


@Data
public class UserDTO {

    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
