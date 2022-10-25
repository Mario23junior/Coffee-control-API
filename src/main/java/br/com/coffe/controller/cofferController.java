package br.com.coffe.controller;

import java.net.URI;
import java.util.List;

import br.com.coffe.model.Coffe;
import br.com.coffe.repository.cofferRepository;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;
import jakarta.ws.rs.core.UriBuilder;

@Path("/project/api/coffe/")
public class cofferController {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response list() {
		List<Coffe> findList = cofferRepository.findAll();
		ResponseBuilder response = Response.ok();
		response.entity(findList);

		return response.build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response save(Coffe coffe) {
		
		Coffe saveOper = cofferRepository.save(coffe);
		final URI coffeUri = UriBuilder
				.fromResource(cofferController.class)
				.path("/project/api/coffe/{id}")
				.build(saveOper.getId());
		
		ResponseBuilder response = Response.created(coffeUri);
		response.entity(saveOper);
		
		return response.build();
	}
}
