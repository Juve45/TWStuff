package core;  
import com.google.gson.Gson;
import commons.*;
import database.ResourceController;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.Photo;
import facebook4j.Picture;
import facebook4j.ResponseList;
import facebook4j.api.PhotoMethods;
import facebook4j.auth.AccessToken;
import vimeo.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.Pair;
import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import jdk.jfr.events.FileWriteEvent;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.servlet.*;
import sun.misc.BASE64Encoder;
import session.*;

@RestController
public class AppController{
    
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
     * @param sesId
     * @return A JSON with the data model of the specific user.
     */
    @RequestMapping(value = "/user", method = RequestMethod.GET)  
    public @ResponseBody String resolveUser(HttpServletRequest request, @PathParam("session") String sesId) throws FacebookException, SQLException { 
        
        sesId = request.getParameter("session");
        HttpSession s = SessionController.findSessionById(sesId);
        if(s == null) 
            return "unlucky [aka Session not started]";
        
        String aToken = SessionController.getFbToken(sesId);
        
        //facebook stuff
        Facebook fb = new FacebookFactory().getInstance();
        fb.setOAuthAppId("630154653854447", "9d01262093e875c8554f1c8fdc35aa7e");
        fb.setOAuthPermissions("public_profile, user_photos");
        //aToken = "EAACEdEose0cBAPTlSxgwUNzkpw8barnTrfKZAb1JSjHlCDd5P2DC14Jt4E566eCyBYVODpvMLzbjGyt9Wfu1IcEvSeZCqe49EKrIQ5GYnU1sMM30KykS7yvvOW6pbzIJshXZBqogEdD2hopDdwJZCVSKF3e2GEv2smsV4tXpN6ZCRP7j2HBaSyIap4LDAahwZD";
        fb.setOAuthAccessToken(new AccessToken(aToken, null));
        
        
        facebook4j.User me = fb.getMe();
        String userId = me.getId();
        
        URL url =fb.getPictureURL();
        
        User u = new User(me.getId(), me.getName(), url.toString());
  /*      
        if(new database.UserController().getUser(userId) == null)
            new database.UserController().addUser(u);
*/        
        ResponseList<Photo> r = fb.getUploadedPhotos();
        System.out.println("Number of photos: " + r.size());
        for(Photo p : r)
        {
            System.out.println("Photo -- " + p.getLink());
        }
        
        System.out.println("A Token: " + aToken);
        System.out.println("user : " + me.getName());
        Picture pic = me.getPicture();
        
        return new UserView().getView(u);
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
            SessionController.sessionUserId.put(httpSession.getId(), me.getId());
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
    
    @RequestMapping(value = "/upload", method = RequestMethod.POST)  
    public @ResponseBody String upload(HttpServletRequest request, MultipartHttpServletRequest mfile) throws IOException, SQLException { 
        Enumeration <String> l = request.getHeaderNames();
        while(l.hasMoreElements())
        {
            System.out.println("enum: " + l.nextElement());
        }
        System.out.println(request.getHeader("content-type"));
        
        MultipartFile file = mfile.getFile("a");
        
        byte[] b = file.getBytes();
        FileOutputStream fos = new FileOutputStream(new File("/home/alexandru/Documents/Fac/TW/BackEndServer/web/" + file.getName()+".png"));
        fos.write(b);
        fos.close();
        String sesId = request.getParameter("session");
        HttpSession s = SessionController.findSessionById(sesId);
        Resource r = new Resource("10", SessionController.sessionUserId.get(s.getId()), file.getName(), "", "image", file.getName()+".png", new Date(30, 2, 2), "Iasi");
        new ResourceController().addResource(r);
        Iterator it = mfile.getFileNames();
        while(it.hasNext())
        System.out.println("M: " +it.next());
        return "created session";
    }  
    
    
    
    @RequestMapping(value="/API/{userId}", method={RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public String resolvePost(@PathVariable String userId){
        
            return new UserController().getViewAsString(userId);
    }
    
    @RequestMapping(value="/hello", method={RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public String asd(){
        
            return "ASDasdasd asd";
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