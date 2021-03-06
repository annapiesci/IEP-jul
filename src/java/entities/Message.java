package entities;
// Generated 15-Jul-2017 18:20:13 by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Message generated by hbm2java
 */
@Entity
@Table(name="message"
    ,catalog="pia1"
)
public class Message  implements java.io.Serializable {


     private Integer idMessage;
     private User userByIdUserFor;
     private User userByIdUserFrom;
     private String content;
     private String subject;

    public Message() {
    }

	
    public Message(User userByIdUserFor, User userByIdUserFrom, String content) {
        this.userByIdUserFor = userByIdUserFor;
        this.userByIdUserFrom = userByIdUserFrom;
        this.content = content;
    }
    public Message(User userByIdUserFor, User userByIdUserFrom, String content, String subject) {
       this.userByIdUserFor = userByIdUserFor;
       this.userByIdUserFrom = userByIdUserFrom;
       this.content = content;
       this.subject = subject;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idMessage", unique=true, nullable=false)
    public Integer getIdMessage() {
        return this.idMessage;
    }
    
    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idUserFor", nullable=false)
    public User getUserByIdUserFor() {
        return this.userByIdUserFor;
    }
    
    public void setUserByIdUserFor(User userByIdUserFor) {
        this.userByIdUserFor = userByIdUserFor;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idUserFrom", nullable=false)
    public User getUserByIdUserFrom() {
        return this.userByIdUserFrom;
    }
    
    public void setUserByIdUserFrom(User userByIdUserFrom) {
        this.userByIdUserFrom = userByIdUserFrom;
    }

    
    @Column(name="content", nullable=false, length=500)
    public String getContent() {
        return this.content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }

    
    @Column(name="subject", length=45)
    public String getSubject() {
        return this.subject;
    }
    
    public void setSubject(String subject) {
        this.subject = subject;
    }




}


