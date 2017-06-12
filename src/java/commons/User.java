/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commons;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Random;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.servlet.http.HttpSession;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ada
 */
@Entity
@XmlRootElement
public class User {
    @Id
    String id;
    String username;
    Date birthday;
    String institution;
    String facebookId;
    String picUrl;
    transient HttpSession session = null;
    transient String sessionId;
    transient String facebookSecret;
    
    public User(String username) {
        this.username = username;
    }

    public User(String id, String username, Date birthday, String institution, String facebookId, String picUrl, String sessionId, String facebookSecret) {
        this.id = id;
        this.username = username;
        this.birthday = birthday;
        this.institution = institution;
        this.facebookId = facebookId;
        this.picUrl = picUrl;
        this.sessionId = sessionId;
        this.facebookSecret = facebookSecret;
    }

    public User(String fbId, String uName, String pic) {
        facebookId = fbId;
        id = facebookId;
        username = uName;
        picUrl = pic;
        facebookSecret = "";
    }
    
    
    
    public Date getBirthday() {
        return birthday;
    }

    public String getFacebookId() {
        return facebookId;
    }

    public String getFacebookSecret() {
        return facebookSecret;
    }

    public String getInstitution() {
        return institution;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public HttpSession getSession() {
        return session;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setFacebookId(String facebookId) {
        this.facebookId = facebookId;
    }

    public void setFacebookSecret(String facebookSecret) {
        this.facebookSecret = facebookSecret;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
    
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getId()
    {
        return id;
    }
    
    public void startSession()
    {
        
    }
    
}
