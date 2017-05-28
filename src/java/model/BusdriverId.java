package model;



/**
 * BusdriverId generated by hbm2java
 */
public class BusdriverId  implements java.io.Serializable {


     private int busdriverId;
     private int busBusId;

    public BusdriverId() {
    }

    public BusdriverId(int busdriverId, int busBusId) {
       this.busdriverId = busdriverId;
       this.busBusId = busBusId;
    }
   
    public int getBusdriverId() {
        return this.busdriverId;
    }
    
    public void setBusdriverId(int busdriverId) {
        this.busdriverId = busdriverId;
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
		 if ( !(other instanceof BusdriverId) ) return false;
		 BusdriverId castOther = ( BusdriverId ) other; 
         
		 return (this.getBusdriverId()==castOther.getBusdriverId())
 && (this.getBusBusId()==castOther.getBusBusId());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getBusdriverId();
         result = 37 * result + this.getBusBusId();
         return result;
   }   


}

