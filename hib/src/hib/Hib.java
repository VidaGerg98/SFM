/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hib;

import hib.model.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Adamoc
 */
public class Hib {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        User usera = new User("a", "a", null);
        User userb = new User("b", "b", null);
        User userc = new User("c", "c", null);
        User userd = new User("d", "d", null);
        User usere = new User("e", "e", null);
        session.save(usera);
        session.save(userb);
        session.save(userc);
        session.save(userd);
        session.save(usere);
        session.getTransaction().commit();
        
        session.beginTransaction();
        User user = (User) session.get(User.class, "b");
        System.out.println(user);
        session.getTransaction().commit();
        
        session.beginTransaction();
        List<User> list = session.createQuery("from User").list();
        session.getTransaction().commit();
        ArrayList<User> alist = new ArrayList<>();
        alist.addAll(list);
        for (User user1 : alist) {
            System.out.println(user1);
        }
        session.close();
        NewHibernateUtil.closeSessionFactory();
    }
    
}
