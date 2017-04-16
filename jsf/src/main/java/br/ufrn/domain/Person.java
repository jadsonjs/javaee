package br.ufrn.domain;

/**
 * Person.java 
 * 
 * <p>A simple domain object.</p>
 * 
 * @author Jadson Santos - jadson@info.ufrn.br
 * @version 1.0
 * @since 24/05/2014
 * 
 * <p><i>This program is distributed without any warranty and it
 * can be freely redistributed for research, classes or private studies, 
 * since the copyright notices are not removed.</i></p>
 */
public class Person {
	
    private String name;

    public Person() {
    	
    }
    
    public Person(String name) {
        this.name = name;
    }

	public String getName() {return name;}
	public void setName(String name) {this.name = name;}

	@Override
	public String toString() {
		return "Person [name=" + name + "]";
	}
    
}
