package com.jersey.representations;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Settings {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
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
	public Settings() {
	}
	
	public Settings(Long id, String name, String description, String createdOn, String lastUpdateOn) {
		this.id = id;
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
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String desc) {
        this.description = desc;
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
