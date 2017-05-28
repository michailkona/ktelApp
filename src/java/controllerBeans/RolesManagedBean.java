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
import model.Roles;
import org.hibernate.Session;

/**
 *
 * @author konstantina
 */
@ManagedBean(name = "rolesManagedBean")
@ViewScoped
public class RolesManagedBean implements Serializable{
    
    private List<Roles> rolesList = new ArrayList();
    private Roles selectedRole; //epilogi apo to pinaka me xeraki
    private List<Roles> filteredRolesList=new ArrayList();
    private Roles rolesToInsert=new Roles();

    /**
     * Creates a new instance of RolesManagedBean
     */
    public RolesManagedBean() {
        
        
    }
    
    @PostConstruct
    public void init() {
        
       loadTable();
    }
    
    public void loadTable() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();

            rolesList = session.createCriteria(Roles.class).list();

            session.getTransaction().commit();
            
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        filteredRolesList=rolesList;

    }
    
    

    public List<Roles> getRoles() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();

            rolesList = session.createCriteria(Roles.class).list();

            session.getTransaction().commit();
            
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        return rolesList;

    }
    
    public void insert() throws IOException{
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            
            session.save(rolesToInsert);

            session.getTransaction().commit();
            
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        
        FacesContext.getCurrentInstance().getExternalContext().redirect("/ktelApp/roles/ViewRoles.xhtml");
     
    }
    
    public void delete() throws IOException{
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            
           
            session.delete(selectedRole);

            session.getTransaction().commit();
            
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        
        FacesContext.getCurrentInstance().getExternalContext().redirect("/ktelApp/roles/ViewRoles.xhtml");
     
    }
    

    //getters and setters
    public List<Roles> getRolesList() {
        return rolesList;
    }

    public void setRolesList(List<Roles> rolesList) {
        this.rolesList = rolesList;
    }

    public Roles getSelectedRole() {
        return selectedRole;
    }

    public void setSelectedRole(Roles selectedRole) {
        this.selectedRole = selectedRole;
    }

    public List<Roles> getFilteredRolesList() {
        return filteredRolesList;
    }

    public void setFilteredRolesList(List<Roles> filteredRolesList) {
        this.filteredRolesList = filteredRolesList;
    }

    public Roles getRolesToInsert() {
        return rolesToInsert;
    }

    public void setRolesToInsert(Roles rolesToInsert) {
        this.rolesToInsert = rolesToInsert;
    }
    
    
    
}
