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
public class UserView {
    
    public String getView(User u)
    {
        Gson g = new Gson();
        String json = g.toJson(u);
        return json;
    }
    
}
