package com.ws101.marino.bantillo.EcommerceApi.repository;

import com.ws101.marino.bantillo.EcommerceApi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
