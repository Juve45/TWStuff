/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twdatabase;

import java.sql.Date;

/**
 *
 * @author ada
 */
public class Resource {

    String idResource;
    Date createdAt;
    String resourceType;
    String path;
    public Resource(String idResource, Date createdAt, String resourceType, String path) {
        this.idResource=idResource;
        this.createdAt=createdAt;
        this.resourceType=resourceType;
        this.path =path;
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
