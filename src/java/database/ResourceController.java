/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import com.sun.corba.se.spi.activation.LocatorOperations;
import commons.Resource;
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

    public void addResource(Resource resource) throws SQLException {
        Connection con = Database.getConnection();
        Statement st = con.createStatement();
        try (PreparedStatement pstmt = con.prepareStatement("INSERT INTO resources (id_resource,created_at, resource_type,id_user,path,data_path,title,location)\n"
                + "    VALUES (?,?,?,?,?,?,?,?);")) {
            pstmt.setString(1, resource.getId());
            pstmt.setDate(2, resource.getCreatedAt());
            pstmt.setString(3, resource.getType());
            pstmt.setString(4, resource.getIdUser());
            pstmt.setString(5, resource.getPath());
            pstmt.setString(6, resource.getDataPath());
            pstmt.setString(7, resource.getName());           
            pstmt.setString(8, resource.getLocation());
            pstmt.executeUpdate();
            con.commit();
        }
    }

    public ArrayList<Resource> getResourcesByExactPath(String path) throws SQLException {
        Connection con = Database.getConnection();
        path = "'" + path + "'";
        path = path.toLowerCase();
        ArrayList<Resource> resources = new ArrayList<>(100);
        try (PreparedStatement pstmt = con.prepareStatement("select id_resource from resources where lower(path)=?")) {

            pstmt.setString(1, path);

            ResultSet rs1, rs2 = null;
            rs1 = pstmt.executeQuery();
            while (rs1.next()) {

                try (PreparedStatement pstmt2 = con.prepareStatement("select id_resource,created_at,resorce_type,path,title,location from resources where id_resource like ?")) {

                    pstmt2.setString(1, "'%" + rs1.getString("id_resource") + "%'");
                    rs2 = pstmt2.executeQuery();
 resources.add(new Resource(rs2.getString("id_resource"), rs2.getString("id_user"), rs2.getString("title"), rs2.getString("path"), rs2.getString("resource_type"), rs2.getString("data_path"), rs2.getDate("created_at"), rs2.getString("location")));
                }
            }
        }
        return resources;
    }

    /**
     *
     * @param path
     * @return
     * @throws SQLException
     */
    public ArrayList<Resource> getResourcesByPath(String path) throws SQLException {
        Connection con = Database.getConnection();
        path = "'%" + path + "%'";
        path = path.toLowerCase();
        ArrayList<Resource> resources = new ArrayList<>(100);
        try (PreparedStatement pstmt = con.prepareStatement("select id_resource from resources where lower(path)=?")) {

            pstmt.setString(1, path);

            ResultSet rs1, rs2 = null;
            rs1 = pstmt.executeQuery();
            while (rs1.next()) {

                try (PreparedStatement pstmt2 = con.prepareStatement("select id_resource,created_at,resorce_type,path,title,location from resources where id_resource like ?")) {

                    pstmt2.setString(1, "'%" + rs1.getString("id_resource") + "%'");
                    rs2 = pstmt2.executeQuery();
 resources.add(new Resource(rs2.getString("id_resource"), rs2.getString("id_user"), rs2.getString("title"), rs2.getString("path"), rs2.getString("resource_type"), rs2.getString("data_path"), rs2.getDate("created_at"), rs2.getString("location")));
                }
            }
        }

        return resources;
    }

    public ArrayList<Resource> getResourcesByDate(Date date) throws SQLException {
        Connection con = Database.getConnection();

        ArrayList<Resource> resources = new ArrayList<>(100);
        try (PreparedStatement pstmt = con.prepareStatement("select id_resource,created_at,resorce_type,path,title,location from resources where date like ?")) {

            pstmt.setDate(1, date);

            ResultSet rs1;
            rs1 = null;
            rs1 = pstmt.executeQuery();
            while (rs1.next()) {

                resources.add(new Resource(rs1.getString("id_resource"), rs1.getString("id_user"), rs1.getString("title"), rs1.getString("path"), rs1.getString("resource_type"), rs1.getString("data_path"), rs1.getDate("created_at"), rs1.getString("location")));
            }
        }

        return resources;
    }

    public ArrayList<Resource> getResourcesByTitle(String title) throws SQLException {
        Connection con = Database.getConnection();
        title = "'%" + title + "%'";
        title = title.toLowerCase();
        ArrayList<Resource> resources = new ArrayList<>(100);
        try (PreparedStatement pstmt = con.prepareStatement("select id_resource,created_at,resorce_type,path,title,location from resources where trim(lower(title))  like ?")) {

            pstmt.setString(1, title);

            ResultSet rs1;
            rs1 = null;
            rs1 = pstmt.executeQuery();
            while (rs1.next()) {

                resources.add(new Resource(rs1.getString("id_resource"), rs1.getString("id_user"), rs1.getString("title"), rs1.getString("path"), rs1.getString("resource_type"), rs1.getString("data_path"), rs1.getDate("created_at"), rs1.getString("location")));
            }
        }

        return resources;
    }

    public ArrayList<Resource> getResourcesByExactTitle(String title) throws SQLException {
        Connection con = Database.getConnection();
        title = "'" + title + "'";
        title = title.toLowerCase();
        ArrayList<Resource> resources = new ArrayList<>(100);
        try (PreparedStatement pstmt = con.prepareStatement("select id_resource,created_at,resorce_type,path,title,location from resources where trim(lower(title)) like ?")) {

            pstmt.setString(1, title);

            ResultSet rs1;
            rs1 = null;
            rs1 = pstmt.executeQuery();
            while (rs1.next()) {

                resources.add(new Resource(rs1.getString("id_resource"), rs1.getString("id_user"), rs1.getString("title"), rs1.getString("path"), rs1.getString("resource_type"), rs1.getString("data_path"), rs1.getDate("created_at"), rs1.getString("location")));
            }
        }

        return resources;
    }

    public ArrayList<Resource> getResourcesByExactLocation(String location) throws SQLException {
        Connection con = Database.getConnection();
        location = "'" + location + "'";
        location = location.toLowerCase();
        ArrayList<Resource> resources = new ArrayList<>(100);
        try (PreparedStatement pstmt = con.prepareStatement("select id_resource,created_at,resorce_type,path,title,location from resources where trim(lower(location)) like ?")) {

            pstmt.setString(1, location);

            ResultSet rs1;
            rs1 = null;
            rs1 = pstmt.executeQuery();
            while (rs1.next()) {

                resources.add(new Resource(rs1.getString("id_resource"), rs1.getString("id_user"), rs1.getString("title"), rs1.getString("path"), rs1.getString("resource_type"), rs1.getString("data_path"), rs1.getDate("created_at"), rs1.getString("location")));
            }
        }

        return resources;
    }

    public ArrayList<Resource> getResourcesByLocation(String location) throws SQLException {
        Connection con = Database.getConnection();
        location = "'%" + location + "%'";
        location = location.toLowerCase();
        ArrayList<Resource> resources = new ArrayList<>(100);
        try (PreparedStatement pstmt = con.prepareStatement("select id_resource,created_at,resorce_type,path,title,location from resources where trim(lower(location)) like ?")) {

            pstmt.setString(1, location);

            ResultSet rs1;
            rs1 = null;
            rs1 = pstmt.executeQuery();
            while (rs1.next()) {

                resources.add(new Resource(rs1.getString("id_resource"), rs1.getString("id_user"), rs1.getString("title"), rs1.getString("path"), rs1.getString("resource_type"), rs1.getString("data_path"), rs1.getDate("created_at"), rs1.getString("location")));
            }
        }

        return resources;
    }
     public ArrayList<Resource> getResourcesByAdvancedSearch(String title,String tag,String location, Date date) throws SQLException {
        Connection con = Database.getConnection();
        location = "'%" + location + "%'";
        location = location.toLowerCase();
        ArrayList<Resource> resources = new ArrayList<>(100);
        try (
                //PreparedStatement pstmt = con.prepareStatement("select id_resource,created_at,resorce_type,path,title,location from resources where trim(lower(title)) like ? and trim(lower(tag)) like ? and trim(lower(location)) like ? and created_at like ?")) {
                PreparedStatement pstmt = con.prepareStatement("select id_resource,"
                        + "created_at,resorce_type,path,title,location from resources "
                        + "where trim(lower(title)) like ? and trim(lower(tag)) like ? "
                        + "and trim(lower(location)) like ? and created_at like ?")) {

            pstmt.setString(1, title);
 pstmt.setString(2, tag);
   pstmt.setString(3,location);
  pstmt.setDate(4,date);
            ResultSet rs1;
            rs1 = null;
            rs1 = pstmt.executeQuery();
            while (rs1.next()) {

                resources.add(new Resource(rs1.getString("id_resource"), rs1.getString("id_user"), rs1.getString("title"), rs1.getString("path"), rs1.getString("resource_type"), rs1.getString("data_path"), rs1.getDate("created_at"), rs1.getString("location")));
            }
        }

        return resources;
    }
     
      public ArrayList<Resource> getResourcesByUserAndPath(String userId, String path) throws SQLException {
        Connection con = Database.getConnection();
        ArrayList<Resource> resources = new ArrayList<>(100);
        try (
                //PreparedStatement pstmt = con.prepareStatement("select id_resource,created_at,resorce_type,path,title,location from resources where trim(lower(title)) like ? and trim(lower(tag)) like ? and trim(lower(location)) like ? and created_at like ?")) {
                PreparedStatement pstmt = con.prepareStatement("select * from resources "
                        + "where id_user = ?")) {

            pstmt.setString(1, userId);
            ResultSet rs1;
            System.out.println("sql: " + pstmt.toString());
            //rs1 = null;
            rs1 = pstmt.executeQuery();
            while (rs1.next()) {

                resources.add(new Resource(rs1.getString("id_resource"), rs1.getString("id_user"), rs1.getString("title"), rs1.getString("path"), rs1.getString("resource_type"), rs1.getString("data_path"), rs1.getDate("created_at"), rs1.getString("location")));
            }
        }

        return resources;
    }

}
