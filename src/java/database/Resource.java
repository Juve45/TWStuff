/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Date;

/**
 *
 * @author ada
 */
public class Resource {

    //unique code of the resource
    String idResource;
    //
    Date createdAt;
    //folder, image, video, 
    String resourceType;
    String path;
    public Resource(String idResource, Date createdAt, String resourceType, String path) {
        this.idResource=idResource;
        this.createdAt=createdAt;
        this.resourceType=resourceType;
        this.path =path;
    }

    Resource(String string, Date date, String string0, String string1, String string2, String string3) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public String getIdResource()
    {
        return this.idResource;
    }
      public Date getDateCreated()
    {
        return this.createdAt;
    }
        public String getResourceType()
    {
        return this.resourceType;
    }
}
