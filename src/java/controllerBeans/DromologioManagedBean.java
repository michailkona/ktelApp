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
import model.Dromologio;
import model.DromologioId;
import model.UsersId;
import org.hibernate.Session;

/**
 *
 * @author konstantina
 */
@ManagedBean(name = "dromologioManagedBean")
@ViewScoped
public class DromologioManagedBean implements Serializable{

    private List<Dromologio> dromologioList = new ArrayList();
    private Dromologio selectedDromologio; //epilogi apo to pinaka me xeraki
    private List<Dromologio> filteredDromologioList=new ArrayList();
    private Dromologio dromologioToInsert=new Dromologio();
    
     private int cityByCityCityIdAnaxorisi;
     private int cityByCityCityIdAfiksi;
      private int busBusId;
   

    /**
     * Creates a new instance of UsersManagedBean
     */
    public DromologioManagedBean() {
    }

    @PostConstruct
    public void init() {
        
       loadTable();
    }
    
    public void loadTable() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();

            dromologioList = session.createCriteria(Dromologio.class).list();

            session.getTransaction().commit();
            
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        filteredDromologioList=dromologioList;

    }
    
    

    public List<Dromologio> getDromologio() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();

            dromologioList = session.createCriteria(Dromologio.class).list();

            session.getTransaction().commit();
            
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        return dromologioList;

    }
    
    public void insert() throws IOException{
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            
            DromologioId dromologioId=new DromologioId();
            
            dromologioId.setCityCityIdAfiksi(cityByCityCityIdAfiksi);
            dromologioId.setCityCityIdAnaxorisi(cityByCityCityIdAnaxorisi);
            dromologioId.setBusBusId(busBusId);
            
            dromologioToInsert.setId(dromologioId);
            
            
            session.save(dromologioToInsert);

            session.getTransaction().commit();
            
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        
        FacesContext.getCurrentInstance().getExternalContext().redirect("/ktelApp/dromologio/ViewDromologio.xhtml");
     
    }
    
    public void delete(DromologioId dromologioId) throws IOException{
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            
           selectedDromologio.setId(dromologioId);
            
            session.delete(selectedDromologio);

            session.getTransaction().commit();
            
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        
        FacesContext.getCurrentInstance().getExternalContext().redirect("/ktelApp/dromologio/ViewDromologio.xhtml");
     
    }
    
    
    

    //getters and setters

    public List<Dromologio> getDromologioList() {
        return dromologioList;
    }

    public void setDromologioList(List<Dromologio> dromologioList) {
        this.dromologioList = dromologioList;
    }

    public Dromologio getSelectedDromologio() {
        return selectedDromologio;
    }

    public void setSelectedDromologio(Dromologio selectedDromologio) {
        this.selectedDromologio = selectedDromologio;
    }

    public List<Dromologio> getFilteredDromologioList() {
        return filteredDromologioList;
    }

    public void setFilteredDromologioList(List<Dromologio> filteredDromologioList) {
        this.filteredDromologioList = filteredDromologioList;
    }

    public Dromologio getDromologioToInsert() {
        return dromologioToInsert;
    }

    public void setDromologioToInsert(Dromologio dromologioToInsert) {
        this.dromologioToInsert = dromologioToInsert;
    }

    public int getCityByCityCityIdAnaxorisi() {
        return cityByCityCityIdAnaxorisi;
    }

    public void setCityByCityCityIdAnaxorisi(int cityByCityCityIdAnaxorisi) {
        this.cityByCityCityIdAnaxorisi = cityByCityCityIdAnaxorisi;
    }

    public int getCityByCityCityIdAfiksi() {
        return cityByCityCityIdAfiksi;
    }

    public void setCityByCityCityIdAfiksi(int cityByCityCityIdAfiksi) {
        this.cityByCityCityIdAfiksi = cityByCityCityIdAfiksi;
    }

    public int getBusBusId() {
        return busBusId;
    }

    public void setBusBusId(int busBusId) {
        this.busBusId = busBusId;
    }
    
}
