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
    private HashMap<String, ArrayList<Seat>> booking;
    
    //visszaadja, hogy az adott felhasználónak van-e foglalása az adott helyre    
    public boolean hasSeat(Show show, Seat s){
        String sname = show.name; //az el?adások név szerinti tárolása miatt
        if (booking.containsKey(sname)){
            if (booking.get(sname).contains(s))
                return true;
            }
        return false;
    }
    
    //foglalás hozzáadása
    public void addBooking(Show show, Seat s){
        String sname = show.name; //az el?adások név szerinti tárolása miatt
        if (!booking.containsKey(sname)) {
            ;
        }
    }
    
    //foglalás törlése
    public void deleteBooking(Show show, Seat s){
        String sname = show.name;
        booking.get(sname).remove(s); //hely törlése a listáról
        if (booking.get(sname).isEmpty())
            booking.remove(sname); //ha a lista üressé vált, a lista törlése
    }

    //a bejelentkezéskor beírt jelszó helyes-e
    public boolean isCorrectPassword(String other) {
        return password.equals(other);
    }
       
    //kiírja a felhasználó foglalásait
    public String printBooking() {
        StringBuilder sb = new StringBuilder();
        if (booking.isEmpty()) //ha nincs foglalás
            sb.append("There is no booking.");
        booking.entrySet().forEach((item) -> { //map entry-k bejárása
            sb.append(item.getKey()).append(": "); //el?adás neve
        });
        return sb.toString();
    }
    
    
    //konstruktor, tostring, getterek
    public User(String name, String password) {
        this.name = name;
        this.password = password;
        this.booking = new HashMap<>();
    }

    @Override
    public String toString() {        
        return "Username: " + name + ", password: " + password + "\n" + printBooking();
    }
    
    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
    
    public HashMap<String, ArrayList<Seat>> getBooking() {
        return booking;
    }
    
    
    
    
    /*
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
    */

    
    
    
    
    
}
