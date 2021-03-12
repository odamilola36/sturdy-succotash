package com.lomari.sturdysuccotash.DTOs;

import lombok.Getter;
import lombok.Setter;
//
//@Setter
//@Getter
public class LoginDTO {
    private String emailAddress;
    private String password;

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPassword() {
        return password;
    }
}
