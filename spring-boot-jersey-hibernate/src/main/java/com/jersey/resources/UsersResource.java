package com.jersey.resources;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jersey.persistance.UserDao;
import com.jersey.representations.Username;

@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Component
@Transactional
public class UsersResource {
	
	private final UserDao userDao;
	
	@Inject
    public UsersResource(UserDao userDao) {
		this.userDao = userDao;
	}
	
	/**
	 * 
	 * @param user
	 * @return user login
	 */
	@Path("/login")
	@POST
    public Username loginUser(@Valid Username user) {
		//TODO add a real method instead of this dummy response
		if(userDao.findOne(user.getId()) == null){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }else {
            return userDao.findOne(user.getId());
        }
    }
	
	/**
	 * 
	 * @param user
	 * @return user logout
	 */
	
	@Path("/logout")
	@POST
    public Username logoutUser(@Valid Username user) {
		//TODO add a real method instead of this dummy response
		if(userDao.findOne(user.getId()) == null){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }else {
            return userDao.findOne(user.getId());
        }
    }

}
