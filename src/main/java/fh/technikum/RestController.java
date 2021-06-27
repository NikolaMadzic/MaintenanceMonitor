package fh.technikum;

import javax.ws.rs.*;
import javax.ws.rs.container.*;
import javax.ws.rs.core.*;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.net.URI;
import java.util.*;

@Path("/api")
public class RestController implements ContainerResponseFilter{
    private String status = "-";

    /*
    https://www.it-swarm.com.de/de/java/umgang-mit-cors-mit-jax-rs-mit-jersey/1051787715/
    Wird benötigt, sonst kommt im Browser in der JavaScript-Console der Fehler:
    Origin null is not allowed by Access-Control-Allow-Origin.
     */
    @Override
    public void filter(ContainerRequestContext request,
                       ContainerResponseContext response) throws IOException {
        response.getHeaders().add("Access-Control-Allow-Origin", "*");
        response.getHeaders().add("Access-Control-Allow-Headers",
                "Origin, content-type, accept, authorization");
        response.getHeaders().add("Access-Control-Allow-Credentials", "true");
        response.getHeaders().add("Access-Control-Allow-Methods",
                "GET, POST, PUT, DELETE, OPTIONS, HEAD");
    }

    @GET
    @Path("/statusMeldung/{value}")
    @Produces(MediaType.TEXT_PLAIN)
    public String statusMeldung(@PathParam("value") String value) {
        status = value;
        System.out.println("statusMeldung: Status= "+status+"   Value= "+value);
        return String.format("%s", value);
    }

    @GET
    @Path("/maintenanceMode")
    @Produces(MediaType.TEXT_PLAIN)
    public Response maintenanceMode() {
        System.out.println("maintenanceMode: Status= "+status);
        return Response
                .status(Response.Status.OK)
                //https://stackoverflow.com/questions/36570751/no-access-control-allow-origin-header-is-present-on-origin-null-is-ther
                .entity(this.status)
                .build();
    }
}
