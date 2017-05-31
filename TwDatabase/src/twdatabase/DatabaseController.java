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
import java.util.ArrayList;

/**
 *
 * @author ada
 */
public class DatabaseController {

    private final static String selectStatement = "select id_resource,created_at,type,path,name,location,id_user,data_path from resources where ";

    private static Resource resultToResource(ResultSet rs2) throws SQLException {
        Resource res = new Resource(rs2.getString("id_resource"), rs2.getDate("created_at"), rs2.getString("type"), rs2.getString("path"), rs2.getString("name"), rs2.getString("location"), rs2.getString("id_user"),rs2.getString("data_path"));
        return res;
    }

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
}
