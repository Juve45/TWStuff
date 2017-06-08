package template;  

import freemarker.template.*;
import java.io.*;
import java.lang.annotation.Annotation;
import java.util.*;
import java.util.logging.*;
import javax.servlet.http.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class PageController {
    
    static String PATH = "/home/alexandru/Documents/Fac/TW/BackEndServer/web";
    
    /**
     * TODO
     * 
     */
    @RequestMapping(value = {"/home/**"}, method = RequestMethod.GET)
    public @ResponseBody String resolveUserGet(HttpServletRequest request) throws IOException, TemplateException { 
        System.err.println("Am ajuns la Metoda!!!");
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
        System.err.println("Am ajuns la Metoda!!!");
        
        return PageView.getHomeView("/BackEndServer/page/home");
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
    
}  