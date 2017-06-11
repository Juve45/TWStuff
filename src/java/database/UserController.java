/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import commons.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ada
 */
public class UserController {

    public void addUser(User u) throws SQLException {
        Connection con = Database.getConnection();
        Statement st = con.createStatement();
        try (PreparedStatement pstmt = con.prepareStatement("INSERT INTO users (id_user,name,profile_image_url,birthday,school,session_id,facebook_secret,facebook_id)\n"
                + "    VALUES (?,?,?,?,?,?,?,?);")) {
            pstmt.setString(1, u.getId());
            pstmt.setString(2,u.getUsername());
            pstmt.setString(3, u.getPicUrl());
            pstmt.setDate(4, u.getBirthday());
            pstmt.setString(5, u.getInstitution());
            pstmt.setString(6, u.getSessionId());
            pstmt.setString(7, u.getFacebookSecret());
            pstmt.setString(8, u.getFacebookId());

            pstmt.executeUpdate();

        }
    }

}
