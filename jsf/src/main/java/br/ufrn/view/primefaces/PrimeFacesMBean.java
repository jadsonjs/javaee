/**
 * 
 */
package br.ufrn.view.primefaces;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import br.ufrn.domain.Person;

/**
 * Shows Examples of primefaces components
 * @author jadson
 *
 * <p><i>This program is distributed without any warranty and it
 * can be freely redistributed for research, classes or private studies, 
 * since the copyright notices are not removed.</i></p>
 */
@ManagedBean
@ViewScoped
public class PrimeFacesMBean {

	private String txt1;
	
	private List<Person> people;
    
    private Person selectedPerson;
     
    
    @PostConstruct
    public void init() {
    	people = new ArrayList<>();
    	people.add(new Person("John"));
    	people.add(new Person("Mary"));
    	people.add(new Person("Jackson"));
    	people.add(new Person("Douglas"));
    	people.add(new Person("Joseph"));
    	people.add(new Person("Paul"));
    	people.add(new Person("Michael"));
    	people.add(new Person("Chris"));
    	people.add(new Person("Smith"));
    	people.add(new Person("Washington"));
    }
 
    
    public List<String> completeText(String query) {
        List<String> results = new ArrayList<String>();
        for(int i = 0; i < 10; i++) {
            results.add(query + i);
        }
         
        return results;
    }
    
    public List<Person> getPeople() {return people;}
    public Person getSelectedPerson() {return selectedPerson;}
    public void setSelectedPerson(Person selectedPerson) {this.selectedPerson = selectedPerson;}
	public String getTxt1() {return txt1;}
	public void setTxt1(String txt1) {this.txt1 = txt1;}
	
}
