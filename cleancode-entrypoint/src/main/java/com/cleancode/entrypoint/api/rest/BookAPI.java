package com.cleancode.entrypoint.api.rest;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.cleancode.contracts.dto.BookDTO;
import com.cleancode.contracts.manager.BookManager;

@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
public class BookAPI {
	
	
	@Inject
	private BookManager ibookManager;
	
	 
	@POST
	public Response cria(@Valid BookDTO bookDTO) {
		BookDTO b = this.ibookManager.persist(bookDTO);
		return Response.status(Status.CREATED).entity(b).build();
	}

}