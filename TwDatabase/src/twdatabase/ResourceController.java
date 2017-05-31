/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twdatabase;

import com.sun.corba.se.spi.activation.LocatorOperations;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author ada
 */
public class ResourceController {

    public void add_resource(Resource resource) throws SQLException {
        Connection con = Database.getConnection();
        Statement st = con.createStatement();
        try (PreparedStatement pstmt = con.prepareStatement("INSERT INTO resources (id_resource,created_at, resource_type,id_user,path,location,name,data_path)\n"
                + "    VALUES (?,?,?,?,?,?,?,?);")) {
            pstmt.setString(1, resource.getIdResource());
            pstmt.setDate(2, resource.getDateCreated());
            pstmt.setString(3, resource.getResourceType());
            pstmt.setString(4, resource.getIdUser());
            pstmt.setString(5, resource.getPath());
            pstmt.setString(6, resource.getLocationResource());
            pstmt.setString(7, resource.getName());
            pstmt.setString(8, resource.getDataPath());
            pstmt.executeUpdate();

        }
    }

}
