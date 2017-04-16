/**
 * 
 */
package br.ufrn.view.customScope.infra;

import java.beans.FeatureDescriptor;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

import javax.el.ELContext;
import javax.el.ELResolver;
import javax.el.PropertyNotFoundException;
import javax.faces.context.FacesContext;


/**
 *    For JSF to be able to resolve the EL expression, we need to define a custom ELResolver. ELResolvers do exactly that:<br/> 
 * They try to resolve EL expressions. You can have any number of ELResolvers in your application.<br/><br/> 
 *    They are chained together in the order of their occurrence in the faces-config.xml. This is the code for the ELResolver for our custom scope.<br/>
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
 */
public class CustomScopeELResolver extends ELResolver {

    @Override
    public Object getValue(final ELContext elContext, final Object base, final Object property) {

            if (property == null) {
                    throw new PropertyNotFoundException();
            }

            FacesContext facesContext = (FacesContext) elContext.getContext(FacesContext.class);

            if ((null == base)  && CustomScope.SCOPE_NAME.equals(property.toString())  ) {

                    // Scope is referenced directly
                    CustomScope scope = getScope(facesContext);
                    elContext.setPropertyResolved(true);
                    return scope;

            } else if ((null != base) && (base instanceof CustomScope)   ) {

                    // An object within the scope is referenced
                    return resolve(facesContext, (CustomScope) base, property.toString());

            } else if (null == base) {
            	
                    CustomScope customScope = getScope(facesContext);
                    return null != customScope ? resolve(facesContext, customScope, property.toString()):null;

            }
            return null;
    }


    /**
     * Resolve the key on the given {@link CustomScope}
     * @param facesContext
     * @param scope
     * @param key
     * @return scoped
     */
    public Object resolve(final FacesContext facesContext, final CustomScope scope, final String key) {

            Object value = scope.get(key);
            facesContext.getELContext().setPropertyResolved(value != null);
            return value;

    }


    /**
     * Responsible to retrieve the scope
     * @param facesContext
     * @return
     */
    private CustomScope getScope(final FacesContext facesContext) {

            Map<String, Object> sessionMap = facesContext.getExternalContext().getSessionMap();
            CustomScope customScope = (CustomScope) sessionMap.get(CustomScope.SCOPE_NAME);

            return customScope;
    }


    @Override
    public Class<?> getType(final ELContext elContext, final Object base, final Object property) {
            return Object.class;
    }

    @Override
    public void setValue(final ELContext elContext, final Object base, final Object property, final Object value) {
            // do nothing
    }

    @Override
    public boolean isReadOnly(final ELContext elContext, final Object base, final Object property) {
            return true;
    }

    @Override
    public Iterator<FeatureDescriptor> getFeatureDescriptors(final ELContext elContext, final Object base) {
            return Collections.<FeatureDescriptor>emptyList().iterator();
    }

    @Override
    public Class<?> getCommonPropertyType(final ELContext elContext, final Object base) {
            if (base != null) {
                    return null;
            }
            return String.class;
    }

}
