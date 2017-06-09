/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import java.util.*;
import javax.servlet.http.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 *
 * @author alexandru
 */
public class SessionController {
    public static HashMap<String, HttpSession> activeSessions = new HashMap<>();
    public static HashMap<String, String> fbToken = new HashMap<>();
    
    /**
     * If there is no active session for the specified ID, then the method 
     * returns null.
     */
    public static HttpSession findSessionById(String id)
    {
        HttpSession candidate = activeSessions.get(id);
        if(candidate == null) return null;
        if(System.currentTimeMillis()/1000 - candidate.getLastAccessedTime() < candidate.getMaxInactiveInterval())
            return candidate;
        else 
        {
            candidate.invalidate();
            return null;
        }
    }
    /**
     * This function should be temporary
     * @param sessionId 
     */
    public static String getFbToken(String sessionId)
    {
        return fbToken.get(sessionId);
    }
        
    /**
     * 
     * @return HttpSession of the current object
     * @param create A boolean that tells if the server
     * should create a new session if no session is already started.
     *  * true - allow create
     */
    public static HttpSession session(boolean create) {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        return attr.getRequest().getSession(create); 
    }
    
    
}
