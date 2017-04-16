/**
 * 
 */
package br.ufrn.view.customScope;

import javax.faces.bean.CustomScoped;
import javax.faces.bean.ManagedBean;

/**
 * Use case with several pages that keep information using a custom scope
 * 
 * @author jadson
 * 
 * <p><i>This program is distributed without any warranty and it
 * can be freely redistributed for research, classes or private studies, 
 * since the copyright notices are not removed.</i></p>
 * 
 */
@ManagedBean
@CustomScoped("#{MY_SCOPE}")
public class PersonRegistrationMBean {

	/** This information will be keep between pages when using custom Scope*/
	private String text;
	
	
	public String moveToPage2(){
	    return "/pages/customScope/page2";
	}
	
	public String moveToPage3(){
	    return "/pages/customScope/page3";
	}

	public String getText() {return text;}
	public void setText(String text) {this.text = text;}
	
}
