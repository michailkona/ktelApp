package model;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Dromologio generated by hbm2java
 */
public class Dromologio  implements java.io.Serializable {


     private Integer dromologioId;
     private Bus bus;
     private City cityByCityIdAnaxorisi;
     private City cityByCityIdAfiksi;
     private Date dromologioDate;
     private Date dromologioTimeAnaxorisi;
     private Date dromologioTimeAfiksi;
     private String dromologioTypeDromologio;
     private String dromologioPrice;
     private Set tickets = new HashSet(0);
     private Set demas = new HashSet(0);

    public Dromologio() {
    }

	
    public Dromologio(Bus bus, City cityByCityIdAnaxorisi, City cityByCityIdAfiksi, Date dromologioDate, Date dromologioTimeAnaxorisi, Date dromologioTimeAfiksi, String dromologioTypeDromologio, String dromologioPrice) {
        this.bus = bus;
        this.cityByCityIdAnaxorisi = cityByCityIdAnaxorisi;
        this.cityByCityIdAfiksi = cityByCityIdAfiksi;
        this.dromologioDate = dromologioDate;
        this.dromologioTimeAnaxorisi = dromologioTimeAnaxorisi;
        this.dromologioTimeAfiksi = dromologioTimeAfiksi;
        this.dromologioTypeDromologio = dromologioTypeDromologio;
        this.dromologioPrice = dromologioPrice;
    }
    public Dromologio(Bus bus, City cityByCityIdAnaxorisi, City cityByCityIdAfiksi, Date dromologioDate, Date dromologioTimeAnaxorisi, Date dromologioTimeAfiksi, String dromologioTypeDromologio, String dromologioPrice, Set tickets, Set demas) {
       this.bus = bus;
       this.cityByCityIdAnaxorisi = cityByCityIdAnaxorisi;
       this.cityByCityIdAfiksi = cityByCityIdAfiksi;
       this.dromologioDate = dromologioDate;
       this.dromologioTimeAnaxorisi = dromologioTimeAnaxorisi;
       this.dromologioTimeAfiksi = dromologioTimeAfiksi;
       this.dromologioTypeDromologio = dromologioTypeDromologio;
       this.dromologioPrice = dromologioPrice;
       this.tickets = tickets;
       this.demas = demas;
    }
   
    public Integer getDromologioId() {
        return this.dromologioId;
    }
    
    public void setDromologioId(Integer dromologioId) {
        this.dromologioId = dromologioId;
    }
    public Bus getBus() {
        return this.bus;
    }
    
    public void setBus(Bus bus) {
        this.bus = bus;
    }
    public City getCityByCityIdAnaxorisi() {
        return this.cityByCityIdAnaxorisi;
    }
    
    public void setCityByCityIdAnaxorisi(City cityByCityIdAnaxorisi) {
        this.cityByCityIdAnaxorisi = cityByCityIdAnaxorisi;
    }
    public City getCityByCityIdAfiksi() {
        return this.cityByCityIdAfiksi;
    }
    
    public void setCityByCityIdAfiksi(City cityByCityIdAfiksi) {
        this.cityByCityIdAfiksi = cityByCityIdAfiksi;
    }
    public Date getDromologioDate() {
        return this.dromologioDate;
    }
    
    public void setDromologioDate(Date dromologioDate) {
        this.dromologioDate = dromologioDate;
    }
    public Date getDromologioTimeAnaxorisi() {
        return this.dromologioTimeAnaxorisi;
    }
    
    public void setDromologioTimeAnaxorisi(Date dromologioTimeAnaxorisi) {
        this.dromologioTimeAnaxorisi = dromologioTimeAnaxorisi;
    }
    public Date getDromologioTimeAfiksi() {
        return this.dromologioTimeAfiksi;
    }
    
    public void setDromologioTimeAfiksi(Date dromologioTimeAfiksi) {
        this.dromologioTimeAfiksi = dromologioTimeAfiksi;
    }
    public String getDromologioTypeDromologio() {
        return this.dromologioTypeDromologio;
    }
    
    public void setDromologioTypeDromologio(String dromologioTypeDromologio) {
        this.dromologioTypeDromologio = dromologioTypeDromologio;
    }
    public String getDromologioPrice() {
        return this.dromologioPrice;
    }
    
    public void setDromologioPrice(String dromologioPrice) {
        this.dromologioPrice = dromologioPrice;
    }
    public Set getTickets() {
        return this.tickets;
    }
    
    public void setTickets(Set tickets) {
        this.tickets = tickets;
    }
    public Set getDemas() {
        return this.demas;
    }
    
    public void setDemas(Set demas) {
        this.demas = demas;
    }




}


