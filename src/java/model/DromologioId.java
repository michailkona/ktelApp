package model;



/**
 * DromologioId generated by hbm2java
 */
public class DromologioId  implements java.io.Serializable {


     private int dromologioId;
     private int cityCityIdAnaxorisi;
     private int cityCityIdAfiksi;
     private int busBusId;

    public DromologioId() {
    }

    public DromologioId(int dromologioId, int cityCityIdAnaxorisi, int cityCityIdAfiksi, int busBusId) {
       this.dromologioId = dromologioId;
       this.cityCityIdAnaxorisi = cityCityIdAnaxorisi;
       this.cityCityIdAfiksi = cityCityIdAfiksi;
       this.busBusId = busBusId;
    }
   
    public int getDromologioId() {
        return this.dromologioId;
    }
    
    public void setDromologioId(int dromologioId) {
        this.dromologioId = dromologioId;
    }
    public int getCityCityIdAnaxorisi() {
        return this.cityCityIdAnaxorisi;
    }
    
    public void setCityCityIdAnaxorisi(int cityCityIdAnaxorisi) {
        this.cityCityIdAnaxorisi = cityCityIdAnaxorisi;
    }
    public int getCityCityIdAfiksi() {
        return this.cityCityIdAfiksi;
    }
    
    public void setCityCityIdAfiksi(int cityCityIdAfiksi) {
        this.cityCityIdAfiksi = cityCityIdAfiksi;
    }
    public int getBusBusId() {
        return this.busBusId;
    }
    
    public void setBusBusId(int busBusId) {
        this.busBusId = busBusId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof DromologioId) ) return false;
		 DromologioId castOther = ( DromologioId ) other; 
         
		 return (this.getDromologioId()==castOther.getDromologioId())
 && (this.getCityCityIdAnaxorisi()==castOther.getCityCityIdAnaxorisi())
 && (this.getCityCityIdAfiksi()==castOther.getCityCityIdAfiksi())
 && (this.getBusBusId()==castOther.getBusBusId());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getDromologioId();
         result = 37 * result + this.getCityCityIdAnaxorisi();
         result = 37 * result + this.getCityCityIdAfiksi();
         result = 37 * result + this.getBusBusId();
         return result;
   }   


}

