/**
 * 
 */
package jee.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * 
 * The @WebService annotation defines the class as a web service endpoint.
 * 
 * A service endpoint interface or service endpoint implementation (SEI) is a Java interface or class, 
 * respectively, that declares the methods that a client can invoke on the service
 * 
 * @author Jadson Santos - jadson@info.ufrn.br
 *
 */
@WebService(endpointInterface = "jee.soap.WebServiceEndPoint")
public class WebServiceEndPointImpl implements WebServiceEndPoint{
	
	private final String message = "Hello with JAX-WS, ";

    /**
     * @param name
     * @return
     */
    @WebMethod
    public String sayHello(String name) {
        return message + name + ".";
    }

}
