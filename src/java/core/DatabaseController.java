/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author alexandru
 */
public class DatabaseController {
    
    
    /**
     * Gets a user from the database, based on username.
     * @param username - the username of the user account.
     * @return A User object associated with the user required
     */
    public User getUserByName(String username)
    {
        return null;
    
    }
    
        private final static String selectStatement = "select id_resource,created_at,type,path,name,location,id_user,data_path from resources where ";
/**
 * 
 * @param rs2
 * @return
 * @throws SQLException 
 */
    private static Resource resultToResource(ResultSet rs2) throws SQLException {
        Resource res = new Resource(rs2.getString("id_resource"), rs2.getDate("created_at"), rs2.getString("type"), rs2.getString("path"), rs2.getString("name"), rs2.getString("location"), rs2.getString("id_user"),rs2.getString("data_path"));
        return res;
    }
/**
 * 
 * @param path
 * @return
 * @throws SQLException 
 */
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

                try (PreparedStatement pstmt2 = con.prepareStatement(selectStatement + "id_resource like ?")) {

                    pstmt2.setString(1, "'%" + rs1.getString("id_resource") + "%'");
                    rs2 = pstmt2.executeQuery();
                    
                    
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

                try (PreparedStatement pstmt2 = con.prepareStatement(selectStatement + "id_resource like ?")) {

                    pstmt2.setString(1, "'%" + rs1.getString("id_resource") + "%'");

                    rs2 = pstmt2.executeQuery();
                    resources.add(resultToResource(rs2));
                }
            }
        }

        return resources;
    }
/**
 * 
 * @param date
 * @return
 * @throws SQLException 
 */
    public static ArrayList<Resource> getResourcesByDate(Date date) throws SQLException {
        Connection con = Database.getConnection();

        ArrayList<Resource> resources = new ArrayList<>(100);
        try (PreparedStatement pstmt = con.prepareStatement(selectStatement + "date like ?")) {

            pstmt.setDate(1, date);

            ResultSet rs1;
            rs1 = null;
            rs1 = pstmt.executeQuery();
            while (rs1.next()) {

                 resources.add(resultToResource(rs1));
            }
        }

        return resources;
    }
    /**
     * 
     * @param name
     * @return
     * @throws SQLException 
     */

    public static ArrayList<Resource> getResourcesByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        name = "'%" + name + "%'";
        name = name.toLowerCase();
        ArrayList<Resource> resources = new ArrayList<>(100);
        try (PreparedStatement pstmt = con.prepareStatement(selectStatement + "trim(lower(name))  like ?")) {

            pstmt.setString(1, name);

            ResultSet rs1;
            rs1 = null;
            rs1 = pstmt.executeQuery();
            while (rs1.next()) {

                 resources.add(resultToResource(rs1));
            }
        }

        return resources;
    }
/**
 * 
 * @param name
 * @return
 * @throws SQLException 
 */
    public static ArrayList<Resource> getResourcesByExactName(String name) throws SQLException {
        Connection con = Database.getConnection();
        name = "'" + name + "'";
        name = name.toLowerCase();
        ArrayList<Resource> resources = new ArrayList<>(100);
        try (PreparedStatement pstmt = con.prepareStatement(selectStatement + "trim(lower(name)) like ?")) {

            pstmt.setString(1, name);

            ResultSet rs1;
            rs1 = null;
            rs1 = pstmt.executeQuery();
            while (rs1.next()) {

                 resources.add(resultToResource(rs1));
            }
        }

        return resources;
    }
/**
 * 
 * @param location
 * @return
 * @throws SQLException 
 */
    public static ArrayList<Resource> getResourcesByExactLocation(String location) throws SQLException {
        Connection con = Database.getConnection();
        location = "'" + location + "'";
        location = location.toLowerCase();
        ArrayList<Resource> resources = new ArrayList<>(100);
        try (PreparedStatement pstmt = con.prepareStatement(selectStatement + "trim(lower(location)) like ?")) {

            pstmt.setString(1, location);

            ResultSet rs1;
            rs1 = null;
            rs1 = pstmt.executeQuery();
            while (rs1.next()) {

                 resources.add(resultToResource(rs1));
            }
        }

        return resources;
    }
/**
 * 
 * @param location
 * @return
 * @throws SQLException 
 */
    public static ArrayList<Resource> getResourcesByLocation(String location) throws SQLException {
        Connection con = Database.getConnection();
        location = "'%" + location + "%'";
        location = location.toLowerCase();
        ArrayList<Resource> resources = new ArrayList<>(100);
        try (PreparedStatement pstmt = con.prepareStatement(selectStatement + "trim(lower(location)) like ?")) {

            pstmt.setString(1, location);

            ResultSet rs1;
            rs1 = null;
            rs1 = pstmt.executeQuery();
            while (rs1.next()) {

                 resources.add(resultToResource(rs1));
            }
        }

        return resources;
    }
/**
 * 
 * @param name
 * @param tag
 * @param location
 * @param date
 * @return
 * @throws SQLException 
 */
    public static ArrayList<Resource> getResourcesByAdvancedSearch(String name, String tag, String location, Date date) throws SQLException {
        Connection con = Database.getConnection();
        location = "'%" + location + "%'";
        location = location.toLowerCase();
        ArrayList<Resource> resources = new ArrayList<>(100);
        try (PreparedStatement pstmt = con.prepareStatement(selectStatement + "trim(lower(name)) like ? and trim(lower(tag)) like ? and trim(lower(location)) like ? and created_at like ?")) {

            pstmt.setString(1, name);
            pstmt.setString(2, tag);
            pstmt.setString(3, location);
            pstmt.setDate(4, date);
            ResultSet rs1;
            rs1 = null;
            rs1 = pstmt.executeQuery();
            while (rs1.next()) {

                
            }
        }

        return resources;
    }
/**
 * 
 * @param tagString
 * @return
 * @throws SQLException 
 */
    public static ArrayList<Resource> getResourcesByTag(String tagString) throws SQLException {

        Connection con = Database.getConnection();
        tagString = "'" + tagString + "'";
        tagString = tagString.toLowerCase();
        ArrayList<Resource> resources = new ArrayList<>(100);
        try (PreparedStatement pstmt = con.prepareStatement("select id_resource from resources_tags where lower(tag)=?")) {

            pstmt.setString(1, tagString);

            ResultSet rs1, rs2 = null;
            rs1 = pstmt.executeQuery();
            while (rs1.next()) {

                try (PreparedStatement pstmt2 = con.prepareStatement(selectStatement + "id_resource like ?")) {

                    pstmt2.setString(1, "'%" + rs1.getString("id_resource") + "%'");
                    rs2 = pstmt2.executeQuery();
                     resources.add(resultToResource(rs2));
                }
            }
        }
        return resources;
    }
    /**
     * 
     * @param resource
     * @throws SQLException 
     */
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
    
    
    
    

