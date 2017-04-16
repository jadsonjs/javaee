package br.ufrn.view.customScope.infra;

import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;

/**
 * An action Create the CustomScope from our application.
 * 
 * This class have to be call when the user use the link in the main menu. <br/> <br/>
 * 
 * Example: <br/><br/>
 * 
 * <pre>
 * 
 * < h:commandLink action="#{eventosMBean.iniciarGerenciamentoEventos}" value="Gerenciar" onclick="setAba('gestaoEvento')">
 * 		< f:actionListener type="br.ufrn.sigeventos.arq.jsf.CreateConversationScope" />
 * < /h:commandLink> 
 * 
 * </pre>
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
public class CreateCustomScope implements ActionListener {

    @Override
    public void processAction(final ActionEvent event) throws AbortProcessingException {

            FacesContext facesContext = FacesContext.getCurrentInstance();
            Map<String, Object> sessionMap = facesContext.getExternalContext().getSessionMap();

            CustomScope convesationScope = new CustomScope();
            sessionMap.put(CustomScope.SCOPE_NAME, convesationScope);

            convesationScope.notifyCreate(facesContext);
    }

}
