package com.umarket.chat_service.Repository;

import com.umarket.chat_service.model.UtilModal.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "SELECT user_id FROM user WHERE email = :email", nativeQuery = true)
    Integer obtenerIdPorCorreo(@Param("email") String email);

}
