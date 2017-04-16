package br.ufrn.domain;

import org.junit.Test;

import br.ufrn.domain.Person;
import static org.junit.Assert.*;

/**
 * PersonTest.java 
 * 
 * <p>Simple JUnit Test</p>
 * 
 * @author Jadson Santos - jadson@info.ufrn.br
 * @version 1.0
 * @since 24/05/2014
 * 
 * <p><i>This program is distributed without any warranty and it
 * can be freely redistributed for research, classes or private studies, 
 * since the copyright notices are not removed.</i></p>
 */
public class PersonTest {
    
	/** Test if we can create a person with a name*/
	@Test
    public void canConstructAPersonWithAName() {
        Person person = new Person("Larry");
        assertEquals("Larry", person.getName());
    }
}
