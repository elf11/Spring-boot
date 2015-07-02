package com.jersey.persistance;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jersey.representations.Report;

public interface ReportDao extends JpaRepository<Report, Long>{
}
