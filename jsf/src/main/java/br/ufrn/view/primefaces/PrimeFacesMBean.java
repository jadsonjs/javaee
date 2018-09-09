/**
 * 
 */
package br.ufrn.view.primefaces;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

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
    
    /**
     * Bar chart with primefaces
     */
    private BarChartModel barModel;
    
    /**
     * Imagens names for the galleria
     */
    private List<String> imagesNames;
    
    
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
    	
    	initImagens();
    	
    	initBarModel();
    	
    }
 
    
    public List<String> completeText(String query) {
        List<String> results = new ArrayList<String>();
        for(int i = 0; i < 10; i++) {
            results.add(query + i);
        }
         
        return results;
    }
    
    
    public void initImagens() {
    	imagesNames = new ArrayList<String>();
        for (int i = 1; i <= 5; i++) {
        	imagesNames.add("picture" + i + ".jpg");
        }
    }
 
 
    
    
    private void initBarModel() {
    	barModel = new BarChartModel();
 
        ChartSeries boys = new ChartSeries();
        boys.setLabel("Boys");
        boys.set("2004", 120);
        boys.set("2005", 100);
        boys.set("2006", 44);
        boys.set("2007", 150);
        boys.set("2008", 25);
 
        ChartSeries girls = new ChartSeries();
        girls.setLabel("Girls");
        girls.set("2004", 52);
        girls.set("2005", 60);
        girls.set("2006", 110);
        girls.set("2007", 135);
        girls.set("2008", 120);
 
        barModel.addSeries(boys);
        barModel.addSeries(girls);
        
        barModel.setTitle("Bar Chart");
        barModel.setLegendPosition("ne");
         
        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Gender");
         
        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Births");
        yAxis.setMin(0);
        yAxis.setMax(200);
        
    }
    
    public void save() {
        addMessage("Success", "Data saved");
    }
     
    public void update() {
        addMessage("Success", "Data updated");
    }
     
    public void delete() {
        addMessage("Success", "Data deleted");
    }
     
    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    
    public List<Person> getPeople() {return people;}
    public Person getSelectedPerson() {return selectedPerson;}
    public void setSelectedPerson(Person selectedPerson) {this.selectedPerson = selectedPerson;}
	public String getTxt1() {return txt1;}
	public void setTxt1(String txt1) {this.txt1 = txt1;}
	
	
	public BarChartModel getBarModel() {
        return barModel;
    }

	public List<String> getImagesNames() {
		return imagesNames;
	}

}
