/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commons;

import java.sql.Date;

/**
 *
 * @author alexandru
 */
public class Resource {
    
    String id;
    String idUser;
    /**
     * Name of the resource
     */
    private String name;
    
    /**
     * The theoretical path of the resource (the path displayed in browser
     * when a user tries to access it).
     */
    private String path;
    
    /**
     * Folder, Image, Video, Document
     */
    private String type;
    
    /**
     * The link to the resource on server(image, video, etc)
     * If the resource is a folder, this field will be ignored.
     */
    private String dataPath;

    // java.sql.Date
    private Date createdAt;
    
    
    
    //old
    
    public Resource(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public Resource() {
    }

    
    /**
     * This is the basic constructor
     */
    public Resource(String name, String path, String type, String dataPath) {
        this.name = name;
        this.path = path;
        this.type = type;
        this.dataPath = dataPath;
    }
    
    /**
     * 
     * @return 
     */
    public String getName() {
        return name;
    }
    
    /**
     * 
     * @return 
     */
    public String getPath() {
        return path;
    }
    
    /**
     * <code>Set</code> sets the name of this resource
     * @param name the name that will be set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @param path 
     */
    public void setPath(String path) {
        this.path = path;
    }

    public String getType() {
        return type;
    }

    public void setDataPath(String dataPath) {
        this.dataPath = dataPath;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDataPath() {
        return dataPath;
    }
    
    
}
