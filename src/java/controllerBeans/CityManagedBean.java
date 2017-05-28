/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllerBeans;

import hibernate.HibernateUtil;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import model.City;

import org.hibernate.Session;

/**
 *
 * @author konstantina
 */
@ManagedBean(name = "cityManagedBean")
@ViewScoped
public class CityManagedBean implements Serializable{
    
    private List<City> cityList = new ArrayList();
    private City selectedCity; //epilogi apo to pinaka me xeraki
    private List<City> filteredCityList=new ArrayList();
    private City cityToInsert=new City();

    /**
     * Creates a new instance of RolesManagedBean
     */
    public CityManagedBean() {
        
        
    }
    
    @PostConstruct
    public void init() {
        
       loadTable();
    }
    
    public void loadTable() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();

            cityList = session.createCriteria(City.class).list();

            session.getTransaction().commit();
            
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        filteredCityList=cityList;

    }
    
    

    public List<City> getCity() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();

            cityList = session.createCriteria(City.class).list();

            session.getTransaction().commit();
            
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        return cityList;

    }
    
    public void insert() throws IOException{
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            
            session.save(cityToInsert);

            session.getTransaction().commit();
            
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        
        FacesContext.getCurrentInstance().getExternalContext().redirect("/ktelApp/city/ViewCity.xhtml");
     
    }
    
    public void delete() throws IOException{
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            
           
            session.delete(selectedCity);

            session.getTransaction().commit();
            
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        
        FacesContext.getCurrentInstance().getExternalContext().redirect("/ktelApp/city/ViewCity.xhtml");
     
    }
    

    //getters and setters

    public List<City> getCityList() {
        return cityList;
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }

    public City getSelectedCity() {
        return selectedCity;
    }

    public void setSelectedCity(City selectedCity) {
        this.selectedCity = selectedCity;
    }

    public List<City> getFilteredCityList() {
        return filteredCityList;
    }

    public void setFilteredCityList(List<City> filteredCityList) {
        this.filteredCityList = filteredCityList;
    }

    public City getCityToInsert() {
        return cityToInsert;
    }

    public void setCityToInsert(City cityToInsert) {
        this.cityToInsert = cityToInsert;
    }
   
}
