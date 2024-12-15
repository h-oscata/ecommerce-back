package com.umarket.chat_service.controller;

import com.umarket.chat_service.Service.ChatService;
import com.umarket.chat_service.model.UtilModal.Product;
import com.umarket.chat_service.model.UtilModal.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UtilController {

    @Autowired
    private ChatService utilService;

    @GetMapping("/id")
    public Integer obtenerIdPorCorreo(@RequestParam String email) {
        return utilService.obtenerIdPorCorreo(email);
    }

    @GetMapping("/idP")
    public Integer obtenerIdPorProducto(@RequestParam int product_id) {
        return utilService.obtenerIdPorProducto(product_id);
    }
}