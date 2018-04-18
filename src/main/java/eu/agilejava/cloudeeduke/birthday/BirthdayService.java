package eu.agilejava.cloudeeduke.birthday;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("birthday")
public interface BirthdayService {

    @GET
    String daysToBirthday(@QueryParam("date") String date);
}
