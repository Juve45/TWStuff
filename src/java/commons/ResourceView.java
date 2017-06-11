/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commons;

import com.google.gson.Gson;

/**
 *
 * @author alexandru
 */
public class ResourceView {
    
    public String getView(Resource u)
    {
        Gson g = new Gson();
        String json = g.toJson(u);
        return json;
    }
    
    public Resource fromView(String json)
    {
        Gson g = new Gson();
        return g.fromJson(json, Resource.class);
    }
    
}
