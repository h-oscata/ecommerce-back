package com.umarket.user_service.businesslogic.dtos;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RegisterRequestDTO {
    private String name;
    private String lastname;
    private String email;
    private String password;
    private String phone;
    private String profile_picture;
    private String address;
}