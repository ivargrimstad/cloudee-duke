package eu.agilejava.cloudeeduke.rest;

import eu.agilejava.cloudeeduke.birthday.BirthdayService;
import eu.agilejava.cloudeeduke.birthday.BirthdayServiceClient;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.metrics.annotation.Metered;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;

@Path("hello")
@RequestScoped
public class HelloWorldEndpoint {

    @Inject
    @ConfigProperty(name = "message", defaultValue = "Hello")
    private String message;


    @Inject
    @RestClient
    private BirthdayService birthdayService;

    @GET
    @Produces("text/plain")
    @Metered
    public Response doGet() {

        return Response.ok(String.format("Duke says %s, it's %d days to my Birthday!", message,
                birthdayService.daysToBirthday("1995-07-17"))).build();
    }
}