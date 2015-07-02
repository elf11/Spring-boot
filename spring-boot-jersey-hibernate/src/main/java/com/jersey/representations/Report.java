package com.jersey.representations;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Report {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@JoinColumn(name = "widget_id")
    @NotNull
	private Long widget_id;
	
	@NotNull
    @Column(name = "name")
	private String name;
	
	@NotNull
	@Column(name = "description")
	private String description;
	
	@NotNull
	@Column(name = "createdOn")
	private String createdOn;
	
	@NotNull
	@Column(name = "lastUpdateOn")
	private String lastUpdateOn;
	
	// Do not delete, all entities must have an empty constructor
	public Report() {
	}
		
	public Report(Long id, String name, String description, String createdOn, String lastUpdateOn) {
		this.name = name;
		this.description = description;
		this.createdOn = createdOn;
		this.lastUpdateOn = lastUpdateOn;
	}
	
	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
	
	public Long getWidget_id() {
		return widget_id;
	}
	public void setWidget_id(Long widget_id) {
		this.widget_id = widget_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}
	public String getLastUpdateOn() {
		return lastUpdateOn;
	}
	public void setLastUpdateOn(String lastUpdateOn) {
		this.lastUpdateOn = lastUpdateOn;
	}
}
