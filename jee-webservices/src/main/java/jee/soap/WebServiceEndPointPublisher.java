/**
 * 
 */
package jee.soap;

import javax.xml.ws.Endpoint;

/**
 * @author Jadson Santos - jadson@info.ufrn.br
 *
 */
public class WebServiceEndPointPublisher {
	
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:9999/ws/webservice", new WebServiceEndPointImpl());
	}

}

