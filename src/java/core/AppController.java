package core;  
import java.util.ArrayList;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.*;  

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
    @RequestMapping(value = "/API/user/{userId}", method = RequestMethod.GET)  
    public @ResponseBody String resolveUserGet(Model m, @PathVariable String userId) { 
        HttpSession s = session(false);
        if(s == null) 
            return "unlucky";
        User alex= new User("asdf");
        m.addAttribute("sfa", "mfasaaa");
        return new UserController().getViewAsString(userId);
    }  
    
    /**
     *  Function that resolves GET queries for resource entity
     * Returnes a JSON that contains information about the requested resource.
     * 
     * @param m - This models the params of the GET command
     * @param resId - This is the userId for which we request the information
     * @return A JSON with the data model of the specific resource.
     */
    @RequestMapping(value = "/API/resource/{resPath}", method = RequestMethod.GET)  
    public @ResponseBody String resolveResourceGet(Model m, @PathVariable String resPath) { 
        User alex= new User("asdf");
        ArrayList<Resource> ans;
        return null;
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
    
    
    
    
    
    
    
    // From here it is all bullshit. Must be deleted. 
    
    @RequestMapping(value = "/API/start", method = RequestMethod.GET)  
    public @ResponseBody String startSession(Model m) { 
        HttpSession s = session(true);
        return "created session";
    }  
    
    
    
    @RequestMapping(value="/API/{userId}", method={RequestMethod.POST})
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
}  