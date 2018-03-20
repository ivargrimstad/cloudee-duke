package eu.agilejava.cloudeeduke.rest;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;

@Path("hello")
@RequestScoped
public class HelloWorldEndpoint {

	@GET
	@Produces("text/plain")
	public Response doGet() {
		return Response.ok("Duke says Hello!").build();
	}
}