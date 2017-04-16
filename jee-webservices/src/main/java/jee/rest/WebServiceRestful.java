/**
 * 
 */
package jee.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import jee.domain.Person;

/**
 * Root resource classes are "plain old Java objects" (POJOs) that are either annotated with @Path or have 
 * at least one method annotated with @Path or a request method designator, such as @GET, @PUT, @POST, or @DELETE. 
 * 
 * Resource methods are methods of a resource class annotated with a request method designator. 
 * 
 * @author Jadson Santos - jadsonjs@gmail.com
 *
 */
@Path("services")                    // The @Path annotation's value is a relative URI path indicating where the Java class will be hosted
public class WebServiceRestful {
	
	
	@Context
	private UriInfo context;

	 
	/**
     * Retrieves representation of an instance of helloWorld.HelloWorld
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/get")
    @Produces("text/html")
    public String getHtml() {
        return "<html lang=\"en\"><body><h1>My First Restful WebService!!</h1></body></html>";
    }
    
    
    @POST
    @Path("/post")
    @Consumes("text/plain")
    public void postHtml(String message) {
        System.out.println(">>>>> "+message);
    }
    
    
    @GET
	@Path("/person")
	@Produces(MediaType.APPLICATION_JSON)
	public Person getPerson() {
    	Person person = new Person();
    	person.setId(10);
		person.setName("Sandman");
		return person;
	}

	@POST
	@Path("/person")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createPerson(Person person) {
		String result = "Person saved : " + person;
		System.out.println(">>>>> "+result);
		return Response.status(201).entity(result).build();
	}
	 
}
