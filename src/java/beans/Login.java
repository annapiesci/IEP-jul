/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.User;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.hibernate.Query;
import util.HibernateUtil;

/**
 *
 * @author Ana
 */
@ManagedBean(name = "login")
@SessionScoped
public class Login {

    private String name;
     private String surname;
     private String email;
     private String institution;
     private String username;
     private String password;
     private String confirmedPsw;
     private String gender;
     private String picture;
     private String shirtSize;
     private String linkedin;
     
    
    private User u;
    private boolean logged = false;
    
    private HibernateUtil h = new HibernateUtil();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getConfirmedPsw() {
        return confirmedPsw;
    }

    public void setConfirmedPsw(String confirmedPsw) {
        this.confirmedPsw = confirmedPsw;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getShirtSize() {
        return shirtSize;
    }

    public void setShirtSize(String shirtSize) {
        this.shirtSize = shirtSize;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }
    
    

    public User getUser() {
        return u;
    }

    public void setUser(User u) {
        this.u = u;
        logged = true;
    }
    
    
    
    public boolean checkUser() {
        h.getSession().beginTransaction();
        Query q = h.getSession().createQuery("from User where username=:username and password=:password");
        q.setString("username", username);
        q.setString("password", password);
        
        h.getSession().getTransaction().commit();        
        List l;
        l = q.list();
        
        if (l.size() == 1) {
            u = (User) l.get(0);
            logged = true;
            return true;
        }
     
        return false;
    }
    
    public boolean newUser() {
        if (!password.equals(confirmedPsw)) return false;
        h.getSession().beginTransaction();
        Query q;
        q = h.getSession().createQuery("from User where username=:username");
        q.setString("username", username);
        
        List l = q.list();
        
        if (!l.isEmpty()) {
            h.getSession().getTransaction().commit();
            return false;
        }
        
        else {
            u = new User();
            u.setName(name);
            u.setSurname(surname);
            u.setEmail(email);
            u.setInstitution(institution);
            u.setUsername(username);
            u.setPassword(password);
            u.setConfirmedPsw(confirmedPsw);
            u.setGender(gender);
            u.setPicture(picture);
            u.setShirtSize(shirtSize);
            u.setLinkedin(linkedin);
            u.setRole("R");
            h.getSession().save(u);
            h.getSession().getTransaction().commit();
            logged = true;
            return true;
        }
        
    }
    
    public boolean logout() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
        session.invalidate();
        logged = false;
        return true;
    }
    
    public boolean isLogged() {
        return logged;
    }
     
    public Login() {
    }
    
}
