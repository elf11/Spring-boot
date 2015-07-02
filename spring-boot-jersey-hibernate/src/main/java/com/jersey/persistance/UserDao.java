package com.jersey.persistance;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jersey.representations.Username;

public interface UserDao extends JpaRepository<Username, Long> {
}
