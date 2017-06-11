/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import commons.User;
import java.util.*;
import javax.annotation.PostConstruct;

/**
 *
 * @author alexandru
 */
public class DataBase {
    
    static Map<String, User> userMap = new HashMap<>();
    //Map<String, Resource> resourceMap = new HashMap<>();
    @PostConstruct
    public void init() {
        System.err.println("Am trecut pe aici.\n\n\n\n\n\n\n");
        userMap.put("post", new User("post"));
        userMap.put("Andreea", new User("Ada ada"));
    // ...
    }
    
    
}
