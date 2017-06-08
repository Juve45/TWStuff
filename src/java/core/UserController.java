/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

//import com.google.gson.Gson;
import java.util.HashMap;

/**
 *
 * @author alexandru
 */
public class UserController {
    
    public String getViewAsString(String username)
    {
        /*
        Gson g = new Gson();
        User user = new DataBaseController().getUserByName(username);
        String ans;
        HashMap<String, String> err = new HashMap<>();
        err.put("error", "no such user");
        if (user == null)
            ans = g.toJson(err);
        else ans = g.toJson(user);
        System.out.println(ans);
        return ans;*/
        return  "e ok";
    }
    
    
}
