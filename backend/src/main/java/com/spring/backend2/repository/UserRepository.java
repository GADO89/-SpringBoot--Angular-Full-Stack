package com.spring.backend2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.backend2.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
