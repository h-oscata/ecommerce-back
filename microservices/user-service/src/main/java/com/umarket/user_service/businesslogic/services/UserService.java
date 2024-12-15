package com.umarket.user_service.businesslogic.services;

import com.umarket.user_service.businesslogic.dtos.EditUserRequestDTO;
import com.umarket.user_service.businesslogic.dtos.LoginRequestDTO;
import com.umarket.user_service.businesslogic.dtos.LoginResponseDTO;
import com.umarket.user_service.businesslogic.dtos.RegisterRequestDTO;
import com.umarket.user_service.businesslogic.models.User;
import com.umarket.user_service.dataaccess.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public LoginResponseDTO login(LoginRequestDTO request){
        User user =userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));

        if(!passwordEncoder.matches(request.getPassword(), user.getPassword())){
            throw new RuntimeException("Invalid email or password");
        }

        return new LoginResponseDTO(user.getName(), user.getLastname(), user.getEmail(), user.getPhone(), user.getProfile_picture(), user.getAddress());

    }

    public void register(RegisterRequestDTO request){
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email already in use");
        }

        User newUser = new User();
        newUser.setName(request.getName());
        newUser.setLastname(request.getLastname());
        newUser.setEmail(request.getEmail());
        newUser.setPassword(passwordEncoder.encode(request.getPassword()));
        newUser.setPhone(request.getPhone());
        newUser.setProfile_picture(request.getProfile_picture());
        newUser.setAddress(request.getAddress());

        userRepository.save(newUser);
    }

    public User editUserProfile(String email, EditUserRequestDTO request) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setName(request.getName());
        user.setLastname(request.getLastName());
        user.setPhone(request.getPhone());
        user.setProfile_picture(request.getProfilePicture());
        user.setAddress(request.getAddress());

        return userRepository.save(user);
    }

    public void deleteUser(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        userRepository.delete(user);
    }
}
