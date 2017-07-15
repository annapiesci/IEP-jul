package entities;
// Generated 15-Jul-2017 18:20:13 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Conference generated by hbm2java
 */
@Entity
@Table(name="conference"
    ,catalog="pia1"
)
public class Conference  implements java.io.Serializable {


     private Integer idConference;
     private String title;
     private String country;
     private String city;
     private String venue;
     private String rooms;
     private Date starts;
     private Date ends;
     private String field;
     private String password;
     private Set users = new HashSet(0);
     private Set presentations = new HashSet(0);
     private Set sessions = new HashSet(0);
     private Set users_1 = new HashSet(0);

    public Conference() {
    }

	
    public Conference(String title, String country, String city, String venue, String rooms, String password) {
        this.title = title;
        this.country = country;
        this.city = city;
        this.venue = venue;
        this.rooms = rooms;
        this.password = password;
    }
    public Conference(String title, String country, String city, String venue, String rooms, Date starts, Date ends, String field, String password, Set users, Set presentations, Set sessions, Set users_1) {
       this.title = title;
       this.country = country;
       this.city = city;
       this.venue = venue;
       this.rooms = rooms;
       this.starts = starts;
       this.ends = ends;
       this.field = field;
       this.password = password;
       this.users = users;
       this.presentations = presentations;
       this.sessions = sessions;
       this.users_1 = users_1;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idConference", unique=true, nullable=false)
    public Integer getIdConference() {
        return this.idConference;
    }
    
    public void setIdConference(Integer idConference) {
        this.idConference = idConference;
    }

    
    @Column(name="title", nullable=false, length=60)
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    
    @Column(name="country", nullable=false, length=60)
    public String getCountry() {
        return this.country;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }

    
    @Column(name="city", nullable=false, length=60)
    public String getCity() {
        return this.city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }

    
    @Column(name="venue", nullable=false, length=60)
    public String getVenue() {
        return this.venue;
    }
    
    public void setVenue(String venue) {
        this.venue = venue;
    }

    
    @Column(name="rooms", nullable=false, length=60)
    public String getRooms() {
        return this.rooms;
    }
    
    public void setRooms(String rooms) {
        this.rooms = rooms;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="starts", length=10)
    public Date getStarts() {
        return this.starts;
    }
    
    public void setStarts(Date starts) {
        this.starts = starts;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="ends", length=10)
    public Date getEnds() {
        return this.ends;
    }
    
    public void setEnds(Date ends) {
        this.ends = ends;
    }

    
    @Column(name="field", length=60)
    public String getField() {
        return this.field;
    }
    
    public void setField(String field) {
        this.field = field;
    }

    
    @Column(name="password", nullable=false, length=45)
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="moderator", catalog="pia1", joinColumns = { 
        @JoinColumn(name="idConf", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="idModerator", nullable=false, updatable=false) })
    public Set getUsers() {
        return this.users;
    }
    
    public void setUsers(Set users) {
        this.users = users;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="conference")
    public Set getPresentations() {
        return this.presentations;
    }
    
    public void setPresentations(Set presentations) {
        this.presentations = presentations;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="conference")
    public Set getSessions() {
        return this.sessions;
    }
    
    public void setSessions(Set sessions) {
        this.sessions = sessions;
    }

@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="attends", catalog="pia1", joinColumns = { 
        @JoinColumn(name="idConfFK", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="idUserFK", nullable=false, updatable=false) })
    public Set getUsers_1() {
        return this.users_1;
    }
    
    public void setUsers_1(Set users_1) {
        this.users_1 = users_1;
    }




}

