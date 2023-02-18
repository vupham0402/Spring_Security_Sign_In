package com.vupham0402.spring_security_sign_in.repository;

import com.vupham0402.spring_security_sign_in.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    List<UserEntity> findByEmailAndPassword(String email, String password);

    List<UserEntity> findByEmail(String email);
}
