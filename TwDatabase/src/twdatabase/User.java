/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twdatabase;

import java.sql.Date;

/**
 *
 * @author ada
 */
public class User {
  String id;
String usename;
String profile_image_url;
Date birthdate;
String school;
String sessionId;
/**
 * 
 * @param id
 * @param usename
 * @param profile_image_url
 * @param birthdate
 * @param school
 * @param session_id 
 */
    public User(String id, String usename, String profile_image_url, Date birthdate, String school, String sessionId) {
        this.id = id;
        this.usename = usename;
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
        return usename;
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
