/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.sql.Date;
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
           String id;
String username;
   
    
    transient HttpSession session = null;
    transient String sessionId;
    transient String facebookSecret;
    
    
String profile_image_url;
Date birthdate;
String school;

/**
 * 
 * @param id
 * @param username
 * @param profile_image_url
 * @param birthdate
 * @param school
 * @param session_id 
 */
    public User(String id, String username, String profile_image_url, Date birthdate, String school, String sessionId) {
        this.id = id;
        this.username = username;
        this.profile_image_url = profile_image_url;
        this.birthdate = birthdate;
        this.school = school;
        this.sessionId =sessionId;
    }
    /**
     * 
     * @return 
     */
    public String getUsename() {
        return username;
    }

    public String getSessionId() {
        return sessionId;
    }

    public String getSchool() {
        return school;
    }

    public String getProfile_image_url() {
        return profile_image_url;
    }

    public String getId() {
        return id;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    
    
   
    
}
