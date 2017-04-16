/**
 * 
 */
package br.ufrn.view.internationalization;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 * @author jadson
 *
 * <p><i>This program is distributed without any warranty and it
 * can be freely redistributed for research, classes or private studies, 
 * since the copyright notices are not removed.</i></p>
 */
@ManagedBean
@SessionScoped
public class LocaleMBean {
	
	/** Keep a map of languages */
	public static Map<Short, Object> countriesMap;
	
	static{
		countriesMap = new LinkedHashMap<Short, Object>();
		countriesMap.put(Lingaguem.PORTUGUES.getValor(), new Locale ("pt", "BR"));
		countriesMap.put(Lingaguem.ENGLISH.getValor(),   new Locale ("en", "US"));
		countriesMap.put(Lingaguem.ESPANHOL.getValor(),  new Locale ("es", "ES"));
	}
	
	/** We have to keep the locale in session */
	private Locale locale = FacesContext.getCurrentInstance().getExternalContext().getRequestLocale();
	
	/**
	 * Muda o locale usado para o PT BR
	 * @param e
	 *  
	 * <p> Criado em:  06/09/2013  </p>
	 *
	 */
	public void changeLocalePortugues(ActionEvent e){
		locale = (Locale) countriesMap.get(Lingaguem.PORTUGUES.getValor());
		FacesContext.getCurrentInstance().getViewRoot().setLocale( locale );
	}

	/**
	 * Muda o locale usado para o EN US
	 * @param e
	 *  
	 * <p> Criado em:  06/09/2013  </p>
	 * 
	 */
	public void changeLocaleEnglish(ActionEvent e){
		locale = (Locale) countriesMap.get(Lingaguem.ENGLISH.getValor());
		FacesContext.getCurrentInstance().getViewRoot().setLocale( locale );
	}
	
	/**
	 * Muda o locale usado para o ES ES
	 * @param e
	 *  
	 * <p> Criado em:  06/09/2013  </p>
	 */
	public void changeLocaleEspanol(ActionEvent e){
		locale = (Locale) countriesMap.get(Lingaguem.ESPANHOL.getValor());
		FacesContext.getCurrentInstance().getViewRoot().setLocale( locale );
	}

	public Locale getLocale() {return locale;}
	public void setLocale(Locale locale) {this.locale = locale;}	
}
