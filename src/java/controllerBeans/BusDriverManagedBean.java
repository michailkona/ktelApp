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
import model.Busdriver;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author konstantina
 */
@ManagedBean(name = "busDriverManagedBean")
@ViewScoped
public class BusDriverManagedBean implements Serializable{

    private List<Busdriver> busDriverList = new ArrayList();
    private Busdriver selectedBusDriver; //epilogi eggrafis apo to pinaka 
    private List<Busdriver> filteredBusDriverList=new ArrayList();
    private Busdriver busDriverToInsert=new Busdriver();
    
    private String busString;
    private List<Bus> busList= new ArrayList();
    
     

    /**
     * Creates a new instance of UsersManagedBean
     */
    public BusDriverManagedBean() {
    }

    @PostConstruct
    public void init() {
        
       loadTable();
    }
    
    public void loadTable() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();

            busDriverList = session.createCriteria(Busdriver.class).list();

            session.getTransaction().commit();
            
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        filteredBusDriverList=busDriverList;

    }
    
    
    public List<Busdriver> getBusdriver() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();

            busDriverList = session.createCriteria(Busdriver.class).list();

            session.getTransaction().commit();
            
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        return busDriverList;

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
            Bus bus = new Bus();
            
            String stringQuery = "From Bus b Where b.busArithmosKikloforias= :busArithmosKikloforias";
            Query query = session.createQuery(stringQuery);
            query.setParameter("busArithmosKikloforias", busString);
            List<Bus> result = query.list();
            
            bus.setBusId(result.get(0).getBusId());
            busDriverToInsert.setBus(bus);
            
         
            session.save(busDriverToInsert);

            session.getTransaction().commit();
            
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        
        FacesContext.getCurrentInstance().getExternalContext().redirect("/ktelApp/busdriver/ViewBusdriver.xhtml");
     
    }
    
    public void delete() throws IOException{
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            
            
            session.delete(selectedBusDriver);

            session.getTransaction().commit();
            
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        
        FacesContext.getCurrentInstance().getExternalContext().redirect("/ktelApp/busdriver/ViewBusdriver.xhtml");
     
    }
    
    
    

    //getters and setters

    public List<Busdriver> getBusDriverList() {
        return busDriverList;
    }

    public void setBusDriverList(List<Busdriver> busDriverList) {
        this.busDriverList = busDriverList;
    }

    public Busdriver getSelectedBusDriver() {
        return selectedBusDriver;
    }

    public void setSelectedBusDriver(Busdriver selectedBusDriver) {
        this.selectedBusDriver = selectedBusDriver;
    }

    public List<Busdriver> getFilteredBusDriverList() {
        return filteredBusDriverList;
    }

    public void setFilteredBusDriverList(List<Busdriver> filteredBusDriverList) {
        this.filteredBusDriverList = filteredBusDriverList;
    }

    public Busdriver getBusDriverToInsert() {
        return busDriverToInsert;
    }

    public void setBusDriverToInsert(Busdriver busDriverToInsert) {
        this.busDriverToInsert = busDriverToInsert;
    }

    public String getBusString() {
        return busString;
    }

    public void setBusString(String busString) {
        this.busString = busString;
    }

    public List<Bus> getBusList() {
        return busList;
    }

    public void setBusList(List<Bus> busList) {
        this.busList = busList;
    }

    

    
   
    
}
