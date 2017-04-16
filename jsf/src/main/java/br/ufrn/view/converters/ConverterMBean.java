/**
 * 
 */
package br.ufrn.view.converters;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * 
 * MBean to test JSF Conveter
 * 
 * @author jadson
 *
 * <p><i>This program is distributed without any warranty and it
 * can be freely redistributed for research, classes or private studies, 
 * since the copyright notices are not removed.</i></p>
 *
 */
@ManagedBean(name="converterMBean")
@ViewScoped
public class ConverterMBean {

	private double amount = 0.1d;
	
	private Date date;
	
	private String name;

	public double getAmount() {return amount;}
	public void setAmount(double amount) {this.amount = amount;}
	public Date getDate() {return date;}
	public void setDate(Date date) {this.date = date;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
}
