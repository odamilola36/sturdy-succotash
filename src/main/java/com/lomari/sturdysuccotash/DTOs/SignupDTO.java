package com.lomari.sturdysuccotash.DTOs;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupDTO {
    private String emailAddress;
    private String password;
    private String fullName;
    private String address;
    private String phoneNumber;
}
