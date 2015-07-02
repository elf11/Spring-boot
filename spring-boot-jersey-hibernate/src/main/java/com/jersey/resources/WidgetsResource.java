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
import com.jersey.persistance.WidgetDao;
import com.jersey.representations.Dashboard;
import com.jersey.representations.Widget;

@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Component
@Transactional
public class WidgetsResource {
	
	private final WidgetDao widgetDao;
	private final ReportDao reportDao;
	
	@Inject
    public WidgetsResource(WidgetDao widgetDao, ReportDao reportDao) {
		this.widgetDao = widgetDao;
		this.reportDao = reportDao;
	}

	@Path("/widgets")
	@GET
    public List<Widget> getAll(){
        return this.widgetDao.findAll();
    }
	
	/**
     * Create new Widget
     * @param widget
     * @return new widget
     */
	@Path("/widgets")
	@POST
    public Widget createWidget(@Valid Widget widget) {
        return widgetDao.save(widget);
    }
	
	/**
     * Get single Widget
     * @param id
     * @return widget
     */
    @GET
    @Path("/widgets/{id}")
    public Widget getWidget(@PathParam("id")long id) {
        Widget widget = widgetDao.findOne(id);
        if(widget == null){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }else {
            return widget;
        }
    }
    
    /**
     * Update existing Widget
     * @param id
     * @param widget
     * @return updated widget
     */
    @PUT
    @Path("/widgets/{id}")
    public Widget updateWidget(@PathParam("id")long id, @Valid Widget widget) {
        if(widgetDao.findOne(id) == null){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }else {
            widget.setId(id);
            return widgetDao.save(widget);
        }
    }
    
    /**
     * Delete widget
     * @param id
     */
    @DELETE
    @Path("/widgets/{id}")
    public void deleteWidget(@PathParam("id")long id) {
        Widget widget = widgetDao.findOne(id);
        if(widget == null){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }else {
        	widgetDao.delete(widget);
        }
    }
    
    @GET
    @Path("/widgets/{id}/reports")
    public Widget getAllReportsForWidget(@PathParam("id")long id) {
        Widget widget = widgetDao.findOne(id);
        if (widget == null) {
            throw new WebApplicationException((Response.Status.NOT_FOUND));
        }

        //Poke products
        widget.getReports().size();
        return widget;
    }
    
}
