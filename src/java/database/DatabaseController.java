/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import core.*;
/**
 *
 * @author ada
 */
public class DatabaseController {
    
    public static ArrayList<Resource> getResourcesByExactPath(String path) throws SQLException {
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
                    resources.add(new Resource(rs2.getString("id_resource"), rs2.getDate("created_at"), rs2.getString("resource_type"), rs2.getString("path"), rs2.getString("title"), rs2.getString("location")));
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
    public static ArrayList<Resource> getResourcesByPath(String path) throws SQLException {
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
                    resources.add(new Resource(rs2.getString("id_resource"), rs2.getDate("created_at"), rs2.getString("resource_type"), rs2.getString("path"), rs2.getString("title"), rs2.getString("location")));
                }
            }
        }

        return resources;
    }

    public static ArrayList<Resource> getResourcesByDate(Date date) throws SQLException {
        Connection con = Database.getConnection();

        ArrayList<Resource> resources = new ArrayList<>(100);
        try (PreparedStatement pstmt = con.prepareStatement("select id_resource,created_at,resorce_type,path,title,location from resources where date like ?")) {

            pstmt.setDate(1, date);

            ResultSet rs1;
            rs1 = null;
            rs1 = pstmt.executeQuery();
            while (rs1.next()) {

                resources.add(new Resource(rs1.getString("id_resource"), rs1.getDate("created_at"), rs1.getString("resource_type"), rs1.getString("path"), rs1.getString("title"), rs1.getString("location")));
            }
        }

        return resources;
    }

    public static ArrayList<Resource> getResourcesByTitle(String title) throws SQLException {
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

                resources.add(new Resource(rs1.getString("id_resource"), rs1.getDate("created_at"), rs1.getString("resource_type"), rs1.getString("path"), rs1.getString("title"), rs1.getString("location")));
            }
        }

        return resources;
    }

    public static ArrayList<Resource> getResourcesByExactTitle(String title) throws SQLException {
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

                resources.add(new Resource(rs1.getString("id_resource"), rs1.getDate("created_at"), rs1.getString("resource_type"), rs1.getString("path"), rs1.getString("title"), rs1.getString("location")));
            }
        }

        return resources;
    }

    public static ArrayList<Resource> getResourcesByExactLocation(String location) throws SQLException {
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

                resources.add(new Resource(rs1.getString("id_resource"), rs1.getDate("created_at"), rs1.getString("resource_type"), rs1.getString("path"), rs1.getString("title"), rs1.getString("location")));
            }
        }

        return resources;
    }

    public static ArrayList<Resource> getResourcesByLocation(String location) throws SQLException {
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

                resources.add(new Resource(rs1.getString("id_resource"), rs1.getDate("created_at"), rs1.getString("resource_type"), rs1.getString("path"), rs1.getString("title"), rs1.getString("location")));
            }
        }

        return resources;
    }
     public static ArrayList<Resource> getResourcesByAdvancedSearch(String title,String tag,String location, Date date) throws SQLException {
        Connection con = Database.getConnection();
        location = "'%" + location + "%'";
        location = location.toLowerCase();
        ArrayList<Resource> resources = new ArrayList<>(100);
        try (PreparedStatement pstmt = con.prepareStatement("select id_resource,created_at,resorce_type,path,title,location from resources where trim(lower(title)) like ? and trim(lower(tag)) like ? and trim(lower(location)) like ? and created_at like ?")) {

            pstmt.setString(1, title);
 pstmt.setString(2, tag);
   pstmt.setString(3,location);
  pstmt.setDate(4,date);
            ResultSet rs1;
            rs1 = null;
            rs1 = pstmt.executeQuery();
            while (rs1.next()) {

                resources.add(new Resource(rs1.getString("id_resource"), rs1.getDate("created_at"), rs1.getString("resource_type"), rs1.getString("path"), rs1.getString("title"), rs1.getString("location")));
            }
        }

        return resources;
    }
     public static ArrayList<Resource> getResourcesByTag(String tagString) throws SQLException
    {
        
         Connection con = Database.getConnection();
        tagString = "'" + tagString + "'";
        tagString = tagString.toLowerCase();
        ArrayList<Resource> resources = new ArrayList<>(100);
        try (PreparedStatement pstmt = con.prepareStatement("select id_resource from resources_tags where lower(tag)=?")) {

            pstmt.setString(1, tagString);

            ResultSet rs1, rs2 = null;
            rs1 = pstmt.executeQuery();
            while (rs1.next()) {

                try (PreparedStatement pstmt2 = con.prepareStatement("select id_resource,created_at,resorce_type,path,title,location from resources where id_resource like ?")) {

                    pstmt2.setString(1, "'%" + rs1.getString("id_resource") + "%'");
                    rs2 = pstmt2.executeQuery();
                    resources.add(new Resource(rs2.getString("id_resource"), rs2.getDate("created_at"), rs2.getString("resource_type"), rs2.getString("path"), rs2.getString("title"), rs2.getString("location")));
                }
            }
        }
        return resources;
    }
}
