/**
 * 
 */
package br.ufrn.view.ajax;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * Show message with JSF AJAX support 
 * 
 * @author jadson
 * 
 *  <p><i>This program is distributed without any warranty and it
 * can be freely redistributed for research, classes or private studies, 
 * since the copyright notices are not removed.</i></p>
 *
 */
@ManagedBean
@ViewScoped
public class AjaxMBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String name;

	public String getSayHello(){
	   if("".equals(name) || name ==null)
		   return "";
	   
		return " Hello " + name+ " with AJax ";
	   
	}
	
	public String getName() {return name;}
	public void setName(String name) { this.name = name;}
}