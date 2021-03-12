package com.lomari.sturdysuccotash.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SignupDTO {
    private String emailAddress;
    private String password;
    private String fullName;
    private String address;
    private String phoneNumber;
}
