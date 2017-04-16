/**
 * 
 */
package br.ufrn.view.converters.infra;


import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.ufrn.domain.Person;

/**
 * Convert a person name to upper case
 * 
 * @author jadson
 *
 * <p><i>This program is distributed without any warranty and it
 * can be freely redistributed for research, classes or private studies, 
 * since the copyright notices are not removed.</i></p>
 *
 */
@FacesConverter("br.ufrn.view.converters.infra.PersonConverter")
public class PersonConverter implements Converter{

	/**
	 * To define how the data is converted from the presentation view to the model view, the Converter 
	 * implementation must implement the getAsObject(FacesContext, UIComponent, String) method from the Converter interface.
	 * 
	 * During the apply request values phase, when the components' decode methods are processed, the JavaServer Faces implementation 
	 * looks up the component's local value in the request and calls the getAsObject method. When calling this method, the JavaServer 
	 * Faces implementation passes in the current FacesContext instance, the component whose data needs conversion, and the local 
	 * value as a String. The method then writes the local value to a character array, trims the hyphens and blanks, adds the rest 
	 * of the characters to a String, and returns the String. 
	 * 
	 * http://docs.oracle.com/javaee/1.4/tutorial/doc/JSFDevelop4.html
	 */
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		if(value == null || value.isEmpty() ){
			FacesMessage msg = new FacesMessage("Person Name Conversion error.", "Invalid Person Name.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ConverterException(msg);
		}
		Person p = new Person(value.toUpperCase());
		return p;
	}
	
	/**
	 * To define how the data is converted from the model view to the presentation view, the Converter implementation must 
	 * implement the getAsString(FacesContext, UIComponent, Object) method from the Converter interface.
	 * 
	 * During the render response phase, in which the components' encode methods are called, the JavaServer Faces implementation 
	 * calls the getAsString method in order to generate the appropriate output. When the JavaServer Faces implementation calls this 
	 * method, it passes in the current FacesContext, the UIComponent whose value needs to be converted, and the bean value to be converted. 
	 * Because this converter does a String-to-String conversion, this method can cast the bean value to a String. 
	 * 
	 * http://docs.oracle.com/javaee/1.4/tutorial/doc/JSFDevelop4.html
	 */
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		return value.toString();
	}
	
}