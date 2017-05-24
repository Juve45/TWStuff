/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

/**
 *
 * @author alexandru
 */
public class DataBaseController {
    
    public User getUserByName(String username)
    {
        return DataBase.userMap.get(username);
    }
    
}
