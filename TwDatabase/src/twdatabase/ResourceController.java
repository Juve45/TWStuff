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
public class ResourceController {
       public void add_resource(String id_resource, Date created_at, String resource_type) throws SQLException {
        Connection con = Database.getConnection();
        Statement st = con.createStatement();
        try (PreparedStatement pstmt = con.prepareStatement("INSERT INTO users (id_resource,created_at, resource_type)\n"
                + "    VALUES (?,?,?,?,?,?);")) {
            pstmt.setString(1, id_resource);
            pstmt.setDate(2, created_at);
            pstmt.setString(3, resource_type);

            pstmt.executeUpdate();

        }
    }
}
