/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hib.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Adamoc
 */

@Entity
@Table(name = "Proba1234")
public class User implements Serializable {
    @Id
    @Column(name = "user_name", unique = true, nullable = false)
    public final String name;
    
    @Column(name = "user_password", unique = false, nullable = false)
    private final String password;
    
    @Column(name = "user_seats", unique = false, nullable = false)
    private HashMap<String, ArrayList<Integer>> booking;

    public User(String name, String password, HashMap<String, ArrayList<Integer>> booking) {
        this.name = name;
        this.password = password;
        this.booking = booking;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public HashMap<String, ArrayList<Integer>> getBooking() {
        return booking;
    }

    @Override
    public String toString() {
        return "User{" + "name=" + name + ", password=" + password + ", booking=" + booking + '}';
    }


    
    
    
    
    
}
