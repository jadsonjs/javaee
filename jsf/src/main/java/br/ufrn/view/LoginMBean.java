/**
 * 
 */
package br.ufrn.view;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;


/**
 * A example of JSF Managed Bean
 * @author jadson
 *
 * <p><i>This program is distributed without any warranty and it
 * can be freely redistributed for research, classes or private studies, 
 * since the copyright notices are not removed.</i></p>
 * 
 */
@ManagedBean(name = "loginMBean")
@ViewScoped
public class LoginMBean {
	
	public String login;
	
	public String password;
	
	public String logar(){
		addInfoMessage("Sucess!!!");
		return null;
	}
	
    public String getMessage() {
       return "Hello World!";
    }
    
    public void addInfoMessage(String mensagem) {
		FacesContext.getCurrentInstance()
			.addMessage("normal", new FacesMessage(FacesMessage.SEVERITY_INFO, "Informação", mensagem)); 
	}

	public String getLogin() {return login;}
	public void setLogin(String login) {this.login = login;}
	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}
    
}
