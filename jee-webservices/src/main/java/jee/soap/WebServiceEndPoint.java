/**
 * 
 */
package jee.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

/**
 * The @WebService annotation defines the class as a web service endpoint.
 * 
 * A service endpoint interface or service endpoint implementation (SEI) is a Java interface or class, 
 * respectively, that declares the methods that a client can invoke on the service
 * 
 * @author Jadson Santos - jadsonjs@gmail.com
 *
 */
@WebService
@SOAPBinding(style = Style.RPC)
public interface WebServiceEndPoint {
	
	@WebMethod
	String sayHello(String name);

}
