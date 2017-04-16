/**
 * 
 */
package br.ufrn.view.customScope.infra;

import java.util.concurrent.ConcurrentHashMap;

import javax.faces.context.FacesContext;
import javax.faces.event.PostConstructCustomScopeEvent;
import javax.faces.event.PreDestroyCustomScopeEvent;
import javax.faces.event.ScopeContext;

/**
 * This implements a Custom Scope, something between the ViewScope and the SessionScope.
 * <br/><br/>
 * <i>
 * First of all, we need a class that will represent our custom scope. This class will be responsible for storing named objects. 
 * Stored objects will be accessible using EL expressions. So, instead of putting our managed beans into request scope, 
 * we will be able to put them into our custom scope. The class therefore needs to implement the map interface.
 * </i>
 *
 * @author jadson
 *
 * <pre>
 * This code was based from: 
 * Creating a JSF 2 Custom Scopes without 3rd party libraries
 * http://blog.oio.de/2012/07/24/jsf-2-custom-scopes-without-3rd-party-libraries/
 * @author Thomas Asel
 *
 */
public class CustomScope extends ConcurrentHashMap<String, Object> {
	
	private static final long serialVersionUID = 6013804747421198557L;

    public static final String SCOPE_NAME = "MY_SCOPE";  /*Can be any one */

    public CustomScope(){
           super();
    }

    public void notifyCreate(final FacesContext ctx) {
    	ScopeContext context = new ScopeContext(SCOPE_NAME, this);
        ctx.getApplication().publishEvent(ctx, PostConstructCustomScopeEvent.class, context);
    }

    public void notifyDestroy(final FacesContext ctx) {
    	ScopeContext scopeContext = new ScopeContext(SCOPE_NAME,this);
        ctx.getApplication().publishEvent(ctx, PreDestroyCustomScopeEvent.class, scopeContext);
    }
}

