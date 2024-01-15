package com.cms.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cms.models.User;

public interface UserDao extends JpaRepository<User, Long> {

	Optional<User> findByEmail(String email);
}
