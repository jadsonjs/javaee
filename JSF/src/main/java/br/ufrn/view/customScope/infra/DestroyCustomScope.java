package br.ufrn.view.customScope.infra;

import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;

/**
 * An action to destroy explicitly the conversation scope and all MBeans keep in session by it.
 * 
 * @author jadson
 *
 * <pre>
 * This code was taking from: 
 * Creating a JSF 2 Custom Scopes without 3rd party libraries
 * http://blog.oio.de/2012/07/24/jsf-2-custom-scopes-without-3rd-party-libraries/
 * @author Thomas Asel
 * 
 * </pre>
 *
 */
public class DestroyCustomScope implements ActionListener {

    @Override
    public void processAction(final ActionEvent event) throws AbortProcessingException {

            FacesContext facesContext = FacesContext.getCurrentInstance();
            
            Map<String, Object> sessionMap = facesContext.getExternalContext().getSessionMap();

            CustomScope customScope = (CustomScope) sessionMap.get(CustomScope.SCOPE_NAME);
            
            if(customScope != null) { // if it was created
                customScope.notifyDestroy(facesContext);

                sessionMap.remove(CustomScope.SCOPE_NAME);
            }
            
    }

}
