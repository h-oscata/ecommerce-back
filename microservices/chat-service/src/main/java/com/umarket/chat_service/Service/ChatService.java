package com.umarket.chat_service.Service;

import com.umarket.chat_service.Repository.ProductRepository;
import com.umarket.chat_service.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;

    public Integer obtenerIdPorCorreo(String email ){
        return userRepository.obtenerIdPorCorreo(email);
    }

    public Integer obtenerIdPorProducto(int idP) {
        return productRepository.obtenerIdPorProducto(idP);
    }

}
