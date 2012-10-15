package br.com.projeto.cinema.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.projeto.cinema.bean.Filme;
import br.com.projeto.cinema.dao.FilmeDAO;

@RequestScoped
@ManagedBean
public class Hello {
     
    @PostConstruct
    public void init(){
        System.out.println(" Bean executado! ");
    }
     
    public String getMessage(){
        return "Hello World JSF!";
    }
    
    
	private final static String[] colors;  
    
    private final static String[] manufacturers;  
      
    static {  
        colors = new String[10];  
        colors[0] = "Black";  
        colors[1] = "White";  
        colors[2] = "Green";  
        colors[3] = "Red";  
        colors[4] = "Blue";  
        colors[5] = "Orange";  
        colors[6] = "Silver";  
        colors[7] = "Yellow";  
        colors[8] = "Brown";  
        colors[9] = "Maroon";  
          
        manufacturers = new String[10];  
        manufacturers[0] = "Mercedes";  
        manufacturers[1] = "BMW";  
        manufacturers[2] = "Volvo";  
        manufacturers[3] = "Audi";  
        manufacturers[4] = "Renault";  
        manufacturers[5] = "Opel";  
        manufacturers[6] = "Volkswagen";  
        manufacturers[7] = "Chrysler";  
        manufacturers[8] = "Ferrari";  
        manufacturers[9] = "Ford";  
    }  
  
    private List<Filme> cars;  
      
    private Filme selectedCar;  
  
    public Hello() {  
        cars = new ArrayList<Filme>();  
          try {
			cars = new FilmeDAO().getAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       // populateRandomCars(cars, 50);  
    }  
      
    public Filme getSelectedCar() {  
        return selectedCar;  
    }  
  
    public void setSelectedCar(Filme selectedCar) {  
        this.selectedCar = selectedCar;  
    }  
  
    private void populateRandomCars(List<Filme> list, int size) {  
        for(int i = 0 ; i < size ; i++)  
            //list.add(new Filme(getRandomModel(), getRandomYear(), getRandomManufacturer(), getRandomColor()));  
        list.add(new Filme());  
    }  
  
    public List<Filme> getCars() {  
        return cars;  
    }  
  
    private int getRandomYear() {  
        return (int) (Math.random() * 50 + 1960);  
    }  
      
    private String getRandomColor() {  
        return colors[(int) (Math.random() * 10)];  
    }  
      
    private String getRandomManufacturer() {  
        return manufacturers[(int) (Math.random() * 10)];  
    }  
      
    private String getRandomModel() {  
        return UUID.randomUUID().toString().substring(0, 8);  
    }  
    



}
