package com.jersey.persistance;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jersey.representations.Widget;

public interface WidgetDao extends JpaRepository<Widget, Long>{
}
