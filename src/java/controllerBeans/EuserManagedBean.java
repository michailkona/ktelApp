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
import model.City;
import model.Euser;

import org.hibernate.Session;

/**
 *
 * @author konstantina
 */
@ManagedBean(name = "euserManagedBean")
@ViewScoped
public class EuserManagedBean implements Serializable{
    
    private List<Euser> euserList = new ArrayList();
    private Euser selectedEuser; //epilogi apo to pinaka 
    private List<Euser> filteredEuserList=new ArrayList();
    private Euser euserToInsert=new Euser();

    /**
     * Creates a new instance of RolesManagedBean
     */
    public EuserManagedBean() {
        
        
    }
    
    @PostConstruct
    public void init() {
        
       loadTable();
    }
    
    public void loadTable() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();

            euserList = session.createCriteria(Euser.class).list();

            session.getTransaction().commit();
            
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        filteredEuserList=euserList;

    }
    
    

    public List<Euser> getEuser() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();

            euserList = session.createCriteria(Euser.class).list();

            session.getTransaction().commit();
            
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        return euserList;

    }
    
    public void insert() throws IOException{
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            
            session.save(euserToInsert);

            session.getTransaction().commit();
            
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        
        FacesContext.getCurrentInstance().getExternalContext().redirect("/ktelApp/euser/ViewEuser.xhtml");
     
    }
    
    public void delete() throws IOException{
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            
           
            session.delete(selectedEuser);

            session.getTransaction().commit();
            
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        
        FacesContext.getCurrentInstance().getExternalContext().redirect("/ktelApp/euser/ViewEuser.xhtml");
     
    }
    

    //getters and setters

    public List<Euser> getEuserList() {
        return euserList;
    }

    public void setEuserList(List<Euser> euserList) {
        this.euserList = euserList;
    }

    public Euser getSelectedEuser() {
        return selectedEuser;
    }

    public void setSelectedEuser(Euser selectedEuser) {
        this.selectedEuser = selectedEuser;
    }

    public List<Euser> getFilteredEuserList() {
        return filteredEuserList;
    }

    public void setFilteredEuserList(List<Euser> filteredEuserList) {
        this.filteredEuserList = filteredEuserList;
    }

    public Euser getEuserToInsert() {
        return euserToInsert;
    }

    public void setEuserToInsert(Euser euserToInsert) {
        this.euserToInsert = euserToInsert;
    }

    
   
   
}
