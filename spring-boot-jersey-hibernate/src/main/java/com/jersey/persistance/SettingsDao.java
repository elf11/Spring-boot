package com.jersey.persistance;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jersey.representations.Settings;

public interface SettingsDao extends JpaRepository<Settings, Long>{
}
