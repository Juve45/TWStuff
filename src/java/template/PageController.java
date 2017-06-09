package template;  

import freemarker.template.*;
import java.io.*;
import java.lang.annotation.Annotation;
import java.util.*;
import java.util.logging.*;
import javax.servlet.http.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import session.SessionController;

@RestController
public class PageController {
    
    public static Map<String, String> sessionMap = new HashMap<>();
    static String PATH = "/home/alexandru/Documents/Fac/TW/BackEndServer/web";
    
    /**
     * TODO
     * 
     */
    @RequestMapping(value = {"/home/**"}, method = RequestMethod.GET)
    public @ResponseBody String resolveUserGet(HttpServletRequest request) throws IOException, TemplateException { 
        
        HttpSession mySession = SessionController.session(false);
        System.out.println("this is my session:" + mySession.getId());
        if(mySession == null)
        {
            System.out.println("hmm??");
            return "Not Authorized";
        }
        else 
        {
            System.out.println("========================================");
            System.out.println(mySession.getId());
            System.out.println(mySession.getCreationTime());
            System.out.println(System.currentTimeMillis()/1000);
        }
        
        //primesc
        System.err.println("Am ajuns la Metoda!???!!");
        String path = request.getRequestURI();
        System.out.println("Full path : " + path);
        return PageView.getHomeView(path);
    }     
    
   
    
    
    /**
     * TODO
     * 
     */
    @RequestMapping(value = {"/home"}, method = RequestMethod.GET)
    public @ResponseBody String resolveUserGet(Model m) throws IOException, TemplateException { 
        
        HttpSession mySession = SessionController.session(false);
        //System.out.println("this is my session:" + mySession.getId());
        if(mySession == null)
        {
            System.out.println("hmm??");
            return "Not Authorized";
        }
        
        System.err.println("Am ajuns la Metoda!!!");
        
        return PageView.getHomeView("/BackEndServer/page/home");
    }
    
    /**
     * TODO
     * 
     */
    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public @ResponseBody String resolveLogin(Model m) throws IOException, TemplateException { 
        System.err.println("Am ajuns la Metoda!!!");
        
        return PageView.getLoginView("/BackEndServer/page/login");
    }
    
    
    /**
     * 
     * Function that resolves GET queries for user entity
     * Returnes a JSON that contains information about the requested user.
     * 
     * @param m - This models the params of the GET command
     * @param page
     * @param userId - This is the userId for which we request the information
     * @return A JSON with the data model of the specific user.
     * @throws java.io.IOException
     * @throws freemarker.template.TemplateException
     */
    @RequestMapping(value = "/{page}", method = RequestMethod.GET)
    public @ResponseBody String resolveUserGetOld(Model m, @PathVariable String page) throws IOException, TemplateException { 
        System.err.println("Am ajuns la Metoda!!!");
        
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_25);
        cfg.setDirectoryForTemplateLoading(new File(PATH));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);

        
        Map root = new HashMap();
        //root.put("style", "../style2.css");
        //root.put("js", "../folder.js");
        root.put("root", "/BackEndServer");
        root.put("user", "name");
        root.put("page", page+".ftlh");
        
        ArrayList<String> navItem = new ArrayList<>();
        navItem.add(page);
        root.put("navItem", navItem);
        Template temp = cfg.getTemplate("index.ftlh");

        Writer out = new StringWriter();
        //Writer out = new PrintWriter(new File("tmp"+userId+".html"));
        temp.process(root, out);
        String s = out.toString();
        return s;
    }
    
    
        
    /**
     * TODO
     * 
     */
    @RequestMapping(value = {"/session"}, method = RequestMethod.POST)
    public @ResponseBody String startSession(HttpServletRequest request, @RequestParam("session") String ses) throws IOException, TemplateException { 
        
        System.out.println("I am in page/session ================================ ");
        HttpSession mySession = SessionController.session(true);
        mySession.getId();
        sessionMap.put(mySession.getId(), ses);
        System.out.println("Sessions:" + mySession.getId() + " == " + ses);
        //pornesc o sesiune pentru ID-ul de aici. Requesturile la server le fac cu sesiunea mea. 
        //Aici tin map=ul invers. Caut o sesiune si primesc codul de la sesiunea de pe backend, 
        //pe care o trimit la query pe backend
        String path = request.getRequestURI();
        System.out.println("Full path : " + path);
        return PageView.getHomeView(path);
    }  
}  