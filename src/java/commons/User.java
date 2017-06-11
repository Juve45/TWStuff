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
    String fbId;
    String picURL;
    String name;
    transient HttpSession session = null;
    //transient String sessionId;
    transient String facebookSecret;
    
    public User(String userName) {
        name = userName;
    }
    
    public User(String userName, String pic) {
        name = userName;
        picURL = pic;
    }

    
    public User(String Id, String userName, String pic) {
        fbId = Id;
        name = userName;
        picURL = pic;
    }

    public String getName() {
        return name;
    }

    public void setName(String userName) {
        name = userName;
    }
    
    public String getFbId()
    {
        return fbId;
    }
    
    public void startSession()
    {
        
    }

    public String getPicURL() {
        return picURL;
    }

    public void setPicURL(String picURL) {
        this.picURL = picURL;
    }
    
    
    
    
    
}
