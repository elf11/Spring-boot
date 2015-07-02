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

import com.jersey.persistance.SettingsDao;
import com.jersey.representations.Settings;

@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Component
@Transactional
public class SettingsResource {
	
	private final SettingsDao settingsDao;
	
	@Inject
    public SettingsResource(SettingsDao settingsDao) {
		this.settingsDao = settingsDao;
	}
	
	@Path("/settings")
	@GET
    public List<Settings> getAll(){
        return this.settingsDao.findAll();
    }
	
	/**
     * Create new Settings
     * @param settings
     * @return new settings
     */
	@Path("/settings")
	@POST
    public Settings createSettings(@Valid Settings settings) {
        return settingsDao.save(settings);
    }
	
	/**
     * Get single Settings
     * @param id
     * @return settings
     */
    @GET
    @Path("/settings/{id}")
    public Settings getSettings(@PathParam("id")long id) {
        Settings settings = settingsDao.findOne(id);
        if(settings == null){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }else {
            return settings;
        }
    }
    
    /**
     * Update existing Settings
     * @param id
     * @param settings
     * @return updated settings
     */
    @PUT
    @Path("/settings/{id}")
    public Settings updateSettings(@PathParam("id")long id, @Valid Settings settings) {
        if(settingsDao.findOne(id) == null){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }else {
            settings.setId(id);
            return settingsDao.save(settings);
        }
    }
    
    /**
     * Delete settings
     * @param id
     */
    @DELETE
    @Path("/settings/{id}")
    public void deleteSettings(@PathParam("id")long id) {
        Settings settings = settingsDao.findOne(id);
        if(settings == null){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }else {
            settingsDao.delete(settings);
        }
    }

}
