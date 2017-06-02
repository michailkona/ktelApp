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
import model.Dromologio;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author konstantina
 */
@ManagedBean(name = "dromologioManagedBean")
@ViewScoped
public class DromologioManagedBean implements Serializable{

    private List<Dromologio> dromologioList = new ArrayList();
    private Dromologio selectedDromologio; //epilogi apo to pinaka 
    private List<Dromologio> filteredDromologioList=new ArrayList();
    private Dromologio dromologioToInsert=new Dromologio();
    
     private String busString;
     private String cityanaxorisiString;
     private String cityafiksiString;
      private List<Bus> busList= new ArrayList();
       private List<City> cityList= new ArrayList();
   

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
            
            Bus bus = new Bus();
            City cityAnaxorisi= new City();
            City cityAfiksi= new City();
            
            String stringQuery = "From Bus b Where b.busArithmosKikloforias= :busArithmosKikloforias";
            Query query = session.createQuery(stringQuery);
            query.setParameter("busArithmosKikloforias", busString);
            List<Bus> result = query.list();
            
            bus.setBusId(result.get(0).getBusId());
            dromologioToInsert.setBus(bus);
            
            String cityAnaxorisiString = "From City c Where c.cityName= :cityName";
            Query queryAnaxorisi = session.createQuery(cityAnaxorisiString);
            queryAnaxorisi.setParameter("cityName", cityanaxorisiString);
            List<City> resultanaxorisi = queryAnaxorisi.list();
            
            cityAnaxorisi.setCityId(resultanaxorisi.get(0).getCityId());
            dromologioToInsert.setCityByCityIdAnaxorisi(cityAnaxorisi);
            
            String cityAfiksiQuery = "From City c Where c.cityName= :cityName";
            Query queryAfiksi = session.createQuery(cityAfiksiQuery);
            queryAfiksi.setParameter("cityName", cityafiksiString);
            List<City> resultafiksi = queryAfiksi.list();
            
            cityAfiksi.setCityId(resultafiksi.get(0).getCityId());
            dromologioToInsert.setCityByCityIdAfiksi(cityAfiksi);
            
            
            session.save(dromologioToInsert);

            session.getTransaction().commit();
            
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        
        FacesContext.getCurrentInstance().getExternalContext().redirect("/ktelApp/dromologio/ViewDromologio.xhtml");
     
    }
    
    public void delete( ) throws IOException{
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            
          
            
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

    public String getBusString() {
        return busString;
    }

    public void setBusString(String busString) {
        this.busString = busString;
    }

    public String getCityanaxorisiString() {
        return cityanaxorisiString;
    }

    public void setCityanaxorisiString(String cityanaxorisiString) {
        this.cityanaxorisiString = cityanaxorisiString;
    }

    public String getCityafiksiString() {
        return cityafiksiString;
    }

    public void setCityafiksiString(String cityafiksiString) {
        this.cityafiksiString = cityafiksiString;
    }

    public List<Bus> getBusList() {
        return busList;
    }

    public void setBusList(List<Bus> busList) {
        this.busList = busList;
    }

    public List<City> getCityList() {
        return cityList;
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }

  
    
}
