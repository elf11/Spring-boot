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

import com.jersey.persistance.DashboardDao;
import com.jersey.persistance.WidgetDao;
import com.jersey.representations.Dashboard;

@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Component
@Transactional
public class DashboardsResource {

	private final DashboardDao dashDao;
	private final WidgetDao widgetDao;
	
	@Inject
    public DashboardsResource(DashboardDao dashboardDao, WidgetDao widgetDao) {
		this.dashDao = dashboardDao;
		this.widgetDao = widgetDao;
	}
	
	@Path("/dashboards")
	@GET
    public List<Dashboard> getAll(){
        return this.dashDao.findAll();
    }
	
	/**
     * Create new Dashboard
     * @param dash
     * @return new dashboard
     */
	@Path("/dashboards")
	@POST
    public Dashboard createDash(@Valid Dashboard dash) {
        return dashDao.save(dash);
    }
	
	/**
     * Get single Dashboard
     * @param id
     * @return dashboard
     */
    @GET
    @Path("/dashboards/{id}")
    public Dashboard getDash(@PathParam("id")long id) {
        Dashboard dash = dashDao.findOne(id);
        if(dash == null){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }else {
            return dash;
        }
    }
    
    /**
     * Update existing Dashboard
     * @param id
     * @param dash
     * @return updated dashboard
     */
    @PUT
    @Path("/dashboards/{id}")
    public Dashboard updateDash(@PathParam("id")long id, @Valid Dashboard dash) {
        if(dashDao.findOne(id) == null){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }else {
            dash.setId(id);
            return dashDao.save(dash);
        }
    }
    
    /**
     * Delete dashboard
     * @param id
     */
    @DELETE
    @Path("/dashboards/{id}")
    public void deleteDash(@PathParam("id")long id) {
        Dashboard dash = dashDao.findOne(id);
        if(dash == null){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }else {
            dashDao.delete(dash);
        }
    }
    
    /**
     * Get all the widgets for a dashboard using the dashboard id
     * @param id dashboard id
     * @return all the widgets for a dashboard using lazy loading
     */
    @GET
    @Path("/dashboards/{id}/widgets")
    public Dashboard getAllWidgetsForDashboard(@PathParam("id")long id) {
        Dashboard dash = dashDao.findOne(id);
        if (dash == null) {
            throw new WebApplicationException((Response.Status.NOT_FOUND));
        }

        //Poke products
        dash.getWidgets().size();
        return dash;
    }
}
