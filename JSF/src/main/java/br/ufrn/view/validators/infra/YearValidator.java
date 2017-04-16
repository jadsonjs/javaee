/**
 * 
 */
package br.ufrn.view.validators.infra;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * Custom Validator for a birthday year
 * 
 * @author jadson
 *
 * <p><i>This program is distributed without any warranty and it
 * can be freely redistributed for research, classes or private studies, 
 * since the copyright notices are not removed.</i></p>
 *
 */
@FacesValidator("br.ufrn.view.validators.infra.YearValidator")
public class YearValidator implements Validator {

	/**
	 *  The FormatValidator class also defines accessor methods for setting the attribute formatPatterns, which specifies the acceptable 
	 *  format patterns for input into the fields. In addition, the class overrides the validate method of the Validator interface. 
	 *  This method validates the input and also accesses the custom error messages to be displayed when the String is invalid.
	 *  
	 *  The validate method performs the actual validation of the data. It takes the FacesContext instance, the component whose data 
	 *  needs to be validated, and the value that needs to be validated. A validator can validate only data of a UIInput component or a 
	 *  component that extends UIInput. 
	 *  
	 *  http://docs.oracle.com/javaee/1.4/tutorial/doc/JSFDevelop6.html
	 */
	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

		try{
			int year = Integer.parseInt(value.toString());
			
			if(year < 1900 || year > 2015){
				showsValidatorMessage();
			}
		}catch(NumberFormatException nfe){
			showsValidatorMessage();
		}

	}

	/**
	 * Show the message for not valid values
	 */
	private void showsValidatorMessage() {
		FacesMessage msg = new FacesMessage("validation failed.", "Invalid Year.");
		msg.setSeverity(FacesMessage.SEVERITY_ERROR);
		throw new ValidatorException(msg);
	}

}
