/**
 * 
 */
package br.ufrn.view.validators;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * MBean to test JSF Validator
 * 
 * @author jadson
 *
 * <p><i>This program is distributed without any warranty and it
 * can be freely redistributed for research, classes or private studies, 
 * since the copyright notices are not removed.</i></p>
 *
 */
@ManagedBean(name="validatorMBean")
@ViewScoped
public class ValidatorMBean {

	private String name;
	
	private int age;
	
	private int year;

	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public int getAge() {return age;}
	public void setAge(int age) {this.age = age;}
	public int getYear() {return year;}
	public void setYear(int year) {this.year = year;}
	
	
}
