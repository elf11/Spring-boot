package com.jersey.representations;

import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Widget {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@JoinColumn(name = "dashboard_id")
    @NotNull
	private Long dashboard_id;
	
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
	
    @NotNull
    @Column(name = "type")
    private String type;
	
    @NotNull
    @Column(name = "source")
    private String source;
	
    @NotNull
    @Column(name = "sourceDetail")
    private String sourceDetail;
    
    @NotNull
    @Column(name = "destination")
	private String destination;
	
    @NotNull
    @Column(name = "destinationDetail")
    private String destinationDetail;
    
    @NotNull
    @Column(name = "timePeriod")
	private Long timePeriod;
    
    @NotNull
    @Column(name = "chartType")
	private String chartType;
    
    @NotNull
    @Column(name = "displays")
	private Long displays;
    
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "widget_id")
    private Set<Report> reports;
    
    
 // Do not delete, all entities must have an empty constructor
 	public Widget() {
 	}
 	
 	public Widget(Long id, String name, String description, String createdOn, String lastUpdateOn, 
 			String type, String source, String sourceDetail, String destination, String destinationDetail, Long timePeriod, 
 			String chartType, Long displays) {
 		this.id = id;
 		this.name = name;
 		this.description = description;
 		this.createdOn = createdOn;
 		this.lastUpdateOn = lastUpdateOn;
 		this.type = type;
 		this.source = source;
 		this.sourceDetail = sourceDetail;
 		this.destination = destination;
 		this.destinationDetail = destinationDetail;
 		this.timePeriod = timePeriod;
 		this.chartType = chartType;
 		this.displays = displays;
 	}
	
	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
	
	public Long getDashboard_id() {
		return dashboard_id;
	}
	public void setDashboard_id(Long dashboard_id) {
		this.dashboard_id = dashboard_id;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getSourceDetail() {
		return sourceDetail;
	}
	public void setSourceDetail(String sourceDetail) {
		this.sourceDetail = sourceDetail;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getDestinationDetail() {
		return destinationDetail;
	}
	public void setDestinationDetail(String destinationDetail) {
		this.destinationDetail = destinationDetail;
	}
	public Long getTimePeriod() {
		return timePeriod;
	}
	public void setTimePeriod(Long timePeriod) {
		this.timePeriod = timePeriod;
	}
	public String getChartType() {
		return chartType;
	}
	public void setChartType(String chartType) {
		this.chartType = chartType;
	}
	public Long getDisplays() {
		return displays;
	}
	public void setDisplays(Long displays) {
		this.displays = displays;
	}
	
	public Set<Report> getReports() {
        return reports;
    }

    public void setReports(Set<Report> reports) {
        this.reports = reports;
    }
}
