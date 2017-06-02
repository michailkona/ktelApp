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
import model.Bus;


import org.hibernate.Session;

/**
 *
 * @author konstantina
 */
@ManagedBean(name = "busManagedBean")
@ViewScoped
public class BusManagedBean implements Serializable{
    
    private List<Bus> busList = new ArrayList();
    private Bus selectedBus; //epilogi apo to pinaka 
    private List<Bus> filteredBusList=new ArrayList();
    private Bus busToInsert=new Bus();

    /**
     * Creates a new instance of RolesManagedBean
     */
    public BusManagedBean() {
        
        
    }
    
    @PostConstruct
    public void init() {
        
       loadTable();
    }
    
    public void loadTable() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();

            busList = session.createCriteria(Bus.class).list();

            session.getTransaction().commit();
            
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        filteredBusList=busList;

    }
    
    

    public List<Bus> getBus() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();

            busList = session.createCriteria(Bus.class).list();

            session.getTransaction().commit();
            
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        return busList;

    }
    
    public void insert() throws IOException{
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            
            session.save(busToInsert);

            session.getTransaction().commit();
            
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        
        FacesContext.getCurrentInstance().getExternalContext().redirect("/ktelApp/bus/ViewBus.xhtml");
     
    }
    
    public void delete() throws IOException{
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            
           
            session.delete(selectedBus);

            session.getTransaction().commit();
            
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        
        FacesContext.getCurrentInstance().getExternalContext().redirect("/ktelApp/bus/ViewBus.xhtml");
     
    }
    

    //getters and setters

    public List<Bus> getBusList() {
        return busList;
    }

    public void setBusList(List<Bus> busList) {
        this.busList = busList;
    }

    public Bus getSelectedBus() {
        return selectedBus;
    }

    public void setSelectedBus(Bus selectedBus) {
        this.selectedBus = selectedBus;
    }

    public List<Bus> getFilteredBusList() {
        return filteredBusList;
    }

    public void setFilteredBusList(List<Bus> filteredBusList) {
        this.filteredBusList = filteredBusList;
    }

    public Bus getBusToInsert() {
        return busToInsert;
    }

    public void setBusToInsert(Bus busToInsert) {
        this.busToInsert = busToInsert;
    }

   
   
}
