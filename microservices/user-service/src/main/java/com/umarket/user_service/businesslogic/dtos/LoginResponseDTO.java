package com.umarket.user_service.businesslogic.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponseDTO {
    private String name;
    private String lastname;
    private String email;
    private String phone;
    private String profile_picture;
    private String address;
}
