/**
 * 
 */
package br.ufrn.view.customScope.infra;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


/**
 * This MBean allow to create e destroy custom scope easily from the view 
 * 
 * @author jadson
 * 
 * <p><i>This program is distributed without any warranty and it
 * can be freely redistributed for research, classes or private studies, 
 * since the copyright notices are not removed.</i></p>
 *
 */
@ManagedBean
@RequestScoped
public class CustomScopeMBean {

	/**
	 * Create conversation scope
	 * 
	 * Call at menu.xhtml and home.xhtml 
	 * 
	 * @return
	 */
	public String getCreateCustomScope(){
		new CreateCustomScope().processAction(null);
		return "";
	}
	
	/**
	 * Destroy conversation scope
	 * 
	 * Call at menu.xhtml and home.xhtml 
	 * 
	 * @return
	 */
	public String getDestroyCustomScope(){
		new DestroyCustomScope().processAction(null);
		return "";
	}
	
}
