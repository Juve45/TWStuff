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
/**
 * 
 */
    String idResource;
    /**
     * 
     */
    String location;
    /**
     * 
     */
    String name;
   /**
    * 
    */
    Date createdAt;
    /**
    * 
    */
    String type;
    /**
    * 
    */
    String path;
    /**
    * 
    */
    String idUser;
    /**
    * 
    */
    String dataPath;
    /**
    * 
    */
    
    
    /**
     * 
     * @param idResource
     * @param createdAt
     * @param type
     * @param path
     * @param name
     * @param location
     * @param idUser
     * @param dataPath 
     */
    public Resource(String idResource, Date createdAt, String type, String path, String name,String location,String idUser, String dataPath) {
        this.idResource=idResource;
        this.createdAt=createdAt;
        this.type=type;
        this.path =path;
        this.location=location;
        this.name=name;
        this.idUser=idUser;
        this.dataPath=dataPath;
    }
    /**
     * 
     * @return 
     */
    public String getIdResource()
    {
        return this.idResource;
    }
    /**
     * 
     * @return 
     */
    public String getIdUser()
    {
        return this.idResource;
    }
    /**
     * 
     * @return 
     */
     public String getName()
    {
        return this.name;
    }
     /**
      * 
      * @return 
      */
      public String getLocationResource()
    {
        return this.location;
    }
      /**
       * 
       * @return 
       */
      public Date getDateCreated()
    {
        return this.createdAt;
    }
      /**
       * 
       * @return 
       */
        public String getResourceType()
    {
        return this.type;
    }
        /**
         * 
         * @return 
         */
         public String getPath()
    {
        return this.path;
    }
         /**
          * 
          * @return 
          */
          public String getDataPath()
    {
        return this.dataPath;
    }

         
}
