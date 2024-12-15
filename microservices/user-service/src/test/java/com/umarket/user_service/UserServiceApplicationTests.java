package com.umarket.user_service;

import com.umarket.user_service.businesslogic.dtos.LoginRequestDTO;
import com.umarket.user_service.businesslogic.dtos.LoginResponseDTO;
import com.umarket.user_service.businesslogic.models.User;
import com.umarket.user_service.businesslogic.services.UserService;
import com.umarket.user_service.dataaccess.repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

@SpringBootTest
class UserServiceApplicationTests {

	@MockBean
	private UserRepository userRepository;

	@Autowired
	private UserService userService;

	@Test
	public void testLoginSuccess() {
		// Datos simulados
		String email = "test@gmail.com";
		String password = "test";
		User user = new User();
		user.setUser_id(1);
		user.setName("name");
		user.setLastname("last");
		user.setEmail(email);
		user.setPassword(password);

		Mockito.when(userRepository.findByEmail(email)).thenReturn(Optional.of(user));

		LoginRequestDTO request = new LoginRequestDTO(email, password);
		LoginResponseDTO response = userService.login(request);

		Assertions.assertEquals("name", response.getName());
		Assertions.assertEquals("last", response.getLastname());
		Assertions.assertEquals(email, response.getEmail());
	}

	@Test
	public void testLoginInvalidPassword() {
		// Datos simulados
		String email = "test@gmail.com";
		String password = "test";
		User user = new User();
		user.setUser_id(1);
		user.setName("name");
		user.setLastname("last");
		user.setEmail(email);
		user.setPassword(password);

		Mockito.when(userRepository.findByEmail(email)).thenReturn(Optional.of(user));

		LoginRequestDTO request = new LoginRequestDTO(email, "notest");

		Assertions.assertThrows(RuntimeException.class, () -> {
			userService.login(request);
		});
	}

	@Test
	public void testLoginUserNotFound() {
		// Simular que el usuario no existe
		Mockito.when(userRepository.findByEmail("notfound@gmail.com")).thenReturn(Optional.empty());

		// Intentar login con usuario inexistente
		LoginRequestDTO request = new LoginRequestDTO("notfound@gmail.com", "test");

		// Verificar que lanza excepción
		Assertions.assertThrows(RuntimeException.class, () -> {
			userService.login(request);
		});
	}

}
