/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twdatabase;

import java.sql.Date;
import java.sql.SQLException;

/**
 *
 * @author ada
 */
public class TwDatabase {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        UserController.addUser("idUser1", "name", "profile_image_url1", new Date(10, 10, 1898), "school", "session_id2");
        Resource rr=new Resource("id2", new Date(2017-1900, 8-1, 27),"resourceType", "/", "titlu", "location", "idUser1");
        ResourceController r=new ResourceController();
        r.add_resource(rr);
        Database.commit();
    }
    
}
