package com.jersey.persistance;

import com.jersey.representations.Dashboard;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DashboardDao extends JpaRepository<Dashboard, Long> {
}
