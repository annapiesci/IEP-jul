/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.hibernate.Query;
import util.HibernateUtil;

/**
 *
 * @author Ana
 */
@ManagedBean(name = "login")
@SessionScoped
public class Login {

    private String username;
    private String password;
    
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
    
    public boolean checkUser() {
        h.getSession().beginTransaction();
        Query q = h.getSession().createQuery("from User where username=:username and password=:password");
        q.setString("username", username);
        q.setString("password", password);
        
        h.getSession().getTransaction().commit();
        
        List l;
        l = q.list();
        
        if (l.size() == 1) return true;
     
        return false;
    }
    
    public Login() {
    }
    
}
