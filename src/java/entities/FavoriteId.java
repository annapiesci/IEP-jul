package entities;
// Generated 15-Jul-2017 18:20:13 by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * FavoriteId generated by hbm2java
 */
@Embeddable
public class FavoriteId  implements java.io.Serializable {


     private int idUser;
     private int idFavoriteUser;

    public FavoriteId() {
    }

    public FavoriteId(int idUser, int idFavoriteUser) {
       this.idUser = idUser;
       this.idFavoriteUser = idFavoriteUser;
    }
   


    @Column(name="idUser", nullable=false)
    public int getIdUser() {
        return this.idUser;
    }
    
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }


    @Column(name="idFavoriteUser", nullable=false)
    public int getIdFavoriteUser() {
        return this.idFavoriteUser;
    }
    
    public void setIdFavoriteUser(int idFavoriteUser) {
        this.idFavoriteUser = idFavoriteUser;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof FavoriteId) ) return false;
		 FavoriteId castOther = ( FavoriteId ) other; 
         
		 return (this.getIdUser()==castOther.getIdUser())
 && (this.getIdFavoriteUser()==castOther.getIdFavoriteUser());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIdUser();
         result = 37 * result + this.getIdFavoriteUser();
         return result;
   }   


}


