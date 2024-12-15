package com.umarket.user_service.businesslogic.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EditUserRequestDTO {
    private String name;
    private String lastName;
    private String phone;
    private String profilePicture;
    private String address;
}
