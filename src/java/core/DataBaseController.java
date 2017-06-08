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
    
    
    /**
     * Gets a user from the database, based on username.
     * @param username - the username of the user account.
     * @return A User object associated with the user required
     */
    public User getUserByName(String username)
    {
        //Andreea implementeaza
        return DataBase.userMap.get(username); /// temporary.
    }
    
    /**
     * Adds a new user in the users table in the database
     * @param user The user that will be added into the database
     */
    public void addUser(User user)
    {
        
    }
    

    
    
    
    
}
