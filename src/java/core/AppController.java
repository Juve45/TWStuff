package core;  
import commons.User;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.Picture;
import facebook4j.auth.AccessToken;
import vimeo.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;
import sun.misc.BASE64Encoder;
import session.*;

@RestController
public class AppController {
    
    
    /**
     * 
     * Function that resolves GET queries for user entity
     * Returnes a JSON that contains information about the requested user.
     * 
     * @param m - This models the params of the GET command
     * @param userId - This is the userId for which we request the information
     * @return A JSON with the data model of the specific user.
     */
    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)  
    public @ResponseBody String resolveUserGet(Model m, @PathVariable String userId) { 
        HttpSession s = SessionController.findSessionById(userId);
        if(s == null) 
            return "unlucky [aka Session not started]";
        User alex= new User("asdf");
        m.addAttribute("sfa", "mfasaaa");
        return new UserController().getViewAsString(userId);
    }  
    
    
    /**
     * 
     * Function that resolves GET queries for user entity
     * Returnes a JSON that contains information about the requested user.
     * 
     * @param m - This models the params of the GET command
     * @param userId - This is the userId for which we request the information
     * @return A JSON with the data model of the specific user.
     */
    @RequestMapping(value = "/user", method = RequestMethod.POST)  
    public @ResponseBody String resolveUser(Model m, @RequestParam("session") String sesId) throws FacebookException { 
        System.out.println("USER POST ============================== ");
        //sesId = sesId.substring(8);
        System.out.println("session recieved: " + sesId);
        HttpSession s = SessionController.findSessionById(sesId);
        if(s == null) 
            return "unlucky [aka Session not started]";
        
        String aToken = SessionController.getFbToken(sesId);
        
        Facebook fb = new FacebookFactory().getInstance();
        fb.setOAuthAppId("630154653854447", "9d01262093e875c8554f1c8fdc35aa7e");
        fb.setOAuthPermissions("public_profile");
        fb.setOAuthAccessToken(new AccessToken(aToken, null));
        facebook4j.User me = fb.getMe();
        
        System.out.println("A Token: " + aToken);
        System.out.println("user : " + me.getName());
        Picture pic = me.getPicture();
        URL url =fb.getPictureURL();
        System.out.println("url: " + url.toString());
        
        /*
        User alex= new User("asdf");
        m.addAttribute("sfa", "mfasaaa");
        return new UserController().getViewAsString(sesId);
        */
        return "{\"name\" : \"" + me.getName() + "\","
                + "\"pic\" : \"" + url.toString() + "\""
                + "}";
    }  
    
    /**
     *  Function that resolves GET queries for resource entity
     * Returnes a JSON that contains information about the requested resource.
     * 
     * @param m - This models the params of the GET command
     * @param resId - This is the userId for which we request the information
     * @return A JSON with the data model of the specific resource.
     */
    @RequestMapping(value = "/API/resource/{resId}", method = RequestMethod.GET)  
    public @ResponseBody Model resolveResourceGet(Model m, @PathVariable String resId) { 
        User alex= new User("asdf");
        m.addAttribute("sfa", "mfasaaa");
        
        //HttpPost post;
        return m;
    }
    
    @RequestMapping(value = "/vimeo", method = RequestMethod.GET)  
    public @ResponseBody String resolveVimeoCode(@RequestParam("code") String code) { 
        User alex= new User("asdf");
        String clientId = "";
        String clientSecret = "";
        PostMethod post = new PostMethod();
        post.addParameter("grant_type", "authorization_code");
        post.addParameter("code", code);
        post.addParameter("redirect_uri", "http://localhost:8080/BackEndServer/API/vimeo");
        BASE64Encoder encoder = new BASE64Encoder();
        
        //post.addRequestHeader(new Header("Authorization : basic ", base64(clientId + ":" + clientSecret)));
        //return (String) m.asMap().get("code");
        return code;
    }  
    
        @RequestMapping(value = "/facebookLogin", method = RequestMethod.POST)  
    public @ResponseBody String resolveFBLogin(@RequestParam("accessToken") String aToken) throws FacebookException { 
        
            System.out.println("Fb session start! ====================== ");
            Facebook fb = new FacebookFactory().getInstance();
            fb.setOAuthAppId("630154653854447", "9d01262093e875c8554f1c8fdc35aa7e");
            fb.setOAuthPermissions("public_profile");
            fb.setOAuthAccessToken(new AccessToken(aToken, null));
            facebook4j.User me = fb.getMe();
            HttpSession httpSession = SessionController.session(true);
            String sessionId = httpSession.getId();
            
            SessionController.activeSessions.put(sessionId, httpSession);
            SessionController.fbToken.put(httpSession.getId(), aToken);
            System.out.println("A Token: " + aToken);
            System.out.println("user : " + me.getName());
            System.out.println("session generated in back-end: " + sessionId);
            System.out.println("");
        //post.addRequestHeader(new Header("Authorization : basic ", base64(clientId + ":" + clientSecret)));
        //return (String) m.asMap().get("code");
        return sessionId;
    }  
    

    /**
     * This should init the server
     * @throws Exception 
     */
    @PostConstruct
	public void initIt() {
        try {
            Properties prop = new Properties();
            prop.load(new FileInputStream(new File("/home/alexandru/Documents/Fac/TW/BackEndServer/src/conf/config.properties")));
            String path = prop.getProperty("path");
            System.out.println("Init method after properties are set : " + path);
            
            
            Vimeo vimeo = new Vimeo("7c11eb4f535b7d58bb5a7e55223a57ea");
            //VimeoResponse vr = vimeo.getMe();
            //System.out.println(vr.toString());
            
        } catch (IOException ex) {
            Logger.getLogger(AppController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    // From here it is all bullshit. Must be deleted. 
    
    @RequestMapping(value = "/API/start", method = RequestMethod.GET)  
    public @ResponseBody String startSession(Model m) { 
        HttpSession s = SessionController.session(true);
        return "created session";
    }  
    
    
    
    @RequestMapping(value="/API/{userId}", method={RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public String resolvePost(@PathVariable String userId){
        
            return new UserController().getViewAsString(userId);
    }
    
    
    @RequestMapping("/hello")  
    public ModelAndView helloWorld() {  
        String message = "<h5>HELLO SPRING MVC HOW R U</h5>";  
        System.out.println("asdfsd");
        
        return new ModelAndView("hellopage", "message", message);  
    }  
    
    
    @RequestMapping("/init")  
    public @ResponseBody String init() {
        DataBase.userMap.put("Alex", new User("Alex Juve45"));
        return "gata";
    }  
    
    
    @RequestMapping(value = "/add", method=RequestMethod.GET)  
    public @ResponseBody String addUser(Model m) {
        
        DataBase.userMap.put((String) m.asMap().get("username"), new User((String) m.asMap().get("username")));
        return "gata";
    }  
    
    
    
    
}  