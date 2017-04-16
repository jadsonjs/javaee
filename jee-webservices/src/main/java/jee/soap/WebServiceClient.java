/**
 * 
 */
package jee.soap;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

/**
 * @author Jadson Santos - jadson@info.ufrn.br
 *
 */
public class WebServiceClient {

	public static void main(String[] args) throws Exception {

		// the wsdl document published 
		URL url = new URL("http://localhost:9999/ws/webservice?wsdl");

		// the service URI, the name of service (both in the wsdl above)
		QName qname = new QName("http://soap.jee/", "WebServiceEndPointImplService");

		Service service = Service.create(url, qname);

		WebServiceEndPoint hello = service.getPort(WebServiceEndPoint.class);

		System.out.println(hello.sayHello(" test"));

	}
}

