package com.cap.BookStroreRest.DataTransferObject;

import lombok.*;


@Data
public class LoginRequest {

    private String accessToken;
    private String refreshToken;
    private String email;
    private String password;

}
