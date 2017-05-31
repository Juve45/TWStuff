/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twdatabase;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ada
 */
public class TagsController {
    
    public static void addTag(String id_resource, String tag) throws SQLException {
        Connection con = Database.getConnection();
        Statement st = con.createStatement();
        try (PreparedStatement pstmt = con.prepareStatement("INSERT INTO users (id_resource,tag)\n"
                + "    VALUES (?,?,?,?,?,?);")) {
            pstmt.setString(1, id_resource);
            pstmt.setString(2, tag);
           

            pstmt.executeUpdate();

        }
    }
    
}
