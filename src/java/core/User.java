/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.util.ArrayList;
import java.util.Random;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author alexandru
 */
@Entity
@XmlRootElement
public class User {
    @Id
    Long id;
    String username;
    ArrayList<String> list;
    transient String passwordHash;
    
    public User(String username) {
        this.username = username;
        list = new ArrayList<>();
        list.add("asd");
        list.add("asd1");
        list.add("asd2");
        this.passwordHash = "dada";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public Long getId()
    {
        return id;
    }
    
}
