package com.jersey.resources;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jersey.persistance.ReportDao;
import com.jersey.representations.Report;

@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Component
@Transactional
public class ReportsResource {
	
	private final ReportDao reportDao;
	
	@Inject
    public ReportsResource(ReportDao reportDao) {
		this.reportDao = reportDao;
	}
	
	@Path("/reports")
	@GET
    public List<Report> getAll(){
        return this.reportDao.findAll();
    }
	
	/**
     * Create new Report
     * @param report
     * @return new report
     */
	@Path("/reports")
	@POST
    public Report createReport(@Valid Report report) {
        return reportDao.save(report);
    }
	
	/**
     * Get single Report
     * @param id
     * @return report
     */
    @GET
    @Path("/reports/{id}")
    public Report getReport(@PathParam("id")long id) {
        Report report = reportDao.findOne(id);
        if(report == null){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }else {
            return report;
        }
    }
    
    /**
     * Update existing Report
     * @param id
     * @param report
     * @return updated report
     */
    @PUT
    @Path("/reports/{id}")
    public Report updateReport(@PathParam("id")long id, @Valid Report report) {
        if(reportDao.findOne(id) == null){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }else {
            report.setId(id);
            return reportDao.save(report);
        }
    }
    
    /**
     * Delete report
     * @param id
     */
    @DELETE
    @Path("/reports/{id}")
    public void deleteReport(@PathParam("id")long id) {
        Report report = reportDao.findOne(id);
        if(report == null){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }else {
            reportDao.delete(report);
        }
    }

}
