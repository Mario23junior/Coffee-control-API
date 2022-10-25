package br.com.coffe.controller;

import java.util.List;

import br.com.coffe.model.Coffe;
import br.com.coffe.repository.cofferRepository;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;

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
}
