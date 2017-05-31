/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twdatabase;

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

    public static void addUser(String id_user, String name, String profile_image_url, Date birthday, String school, String session_id) throws SQLException {
        Connection con = Database.getConnection();
        Statement st = con.createStatement();
        try (PreparedStatement pstmt = con.prepareStatement("INSERT INTO users (id_user,name,profile_image_url,birthday,school,session_id)\n"
                + "    VALUES (?,?,?,?,?,?);")) {
            pstmt.setString(1, id_user);
            pstmt.setString(2, name);
            pstmt.setString(3, profile_image_url);
            pstmt.setDate(4, birthday);
            pstmt.setString(5, school);
            pstmt.setString(6, session_id);
            System.out.println("am ajuns aici la user");

            pstmt.executeUpdate();

        }
    }

}
