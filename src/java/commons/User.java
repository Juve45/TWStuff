/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commons;

import java.util.ArrayList;
import java.util.Random;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.servlet.http.HttpSession;
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
    transient HttpSession session = null;
    transient String sessionId;
    transient String facebookSecret;
    
    public User(String username) {
        this.username = username;
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
    
    public void startSession()
    {
        
    }
    
}
