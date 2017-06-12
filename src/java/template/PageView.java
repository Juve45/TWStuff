/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package template;

import commons.Resource;
import com.google.gson.Gson;
import commons.User;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.http.client.methods.HttpGet;
import session.SessionController;
import static template.PageController.PATH;

/**
 *
 * @author alexandru
 */
public class PageView {
    
    
    public static Configuration initCfg() throws IOException
    {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_25);
        cfg.setDirectoryForTemplateLoading(new File(PATH));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);
        return cfg;
    }
    
    
    static HashMap<String, Object> initMap() throws IOException
    {
        HashMap This = new HashMap<>();
        
        HttpSession hs = SessionController.session(false);
        
        This.put("root","/BackEndServer");
        This.put("startPath", "/BackEndServer/page/home");
        GetMethod pm = new GetMethod("http://localhost:8080/BackEndServer/API/user?session="+ PageController.sessionMap.get(hs.getId()));
        System.out.println("session to send: " + PageController.sessionMap.get(hs.getId()));
        HttpMethodParams params = new HttpMethodParams();
        params.setParameter("session", "asd");//PageController.sessionMap.get(hs.getId()));
        //params.setParameter("salut", PageController.sessionMap.get(hs.getId()));
        pm.setParams(params);
        System.out.println("Sesiunea: " + pm.getParams().getParameter("session"));
        
        HttpClient httpClient = new HttpClient();
        System.out.println("URI: " + pm.getURI());
        int resp = httpClient.executeMethod(pm);
        String msg = pm.getResponseBodyAsString();
        System.out.println("Am primit:" + msg);
        if(msg.contains("unlucky"))
            return null;
        User x = new Gson().fromJson(msg, User.class);
        This.put("user", x);
        This.put("userId", x.getId());
        //System.out.println("Pic: " + x.getPicURL());
        return This;
    }
    
    /**
     * TOODO This is in PageView!!!!!!!!!
     * Processes the request for 
     * @param path
     * @return
     * @throws IOException
     * @throws MalformedTemplateNameException
     * @throws TemplateException 
     */
    static String getHomeView(String path) throws IOException, MalformedTemplateNameException, TemplateException, SQLException
    {
        System.out.println("HOME PAGE VIEW ===================== ");
        Configuration cfg;
        cfg = initCfg();
        
        Map root = initMap();
       if(root == null)
            return "Not Authorized!";
        Gson g = new Gson();
        Template temp = cfg.getTemplate("index.ftlh");
        
        ArrayList<String> navItem = new ArrayList<>();
        
        String x[] = path.split("/");
        System.out.println("Path is: "+path);
        System.out.println(x.length);
        for(int i=3; i < x.length; i++)
        {
            System.out.println("s: "+x[i]);
            navItem.add(x[i]);
        }
        root.put("navItem", navItem);
        
        //ArrayList<Resource> str = init(), str2 = new ArrayList<>();
        ArrayList<Resource> str = new database.ResourceController().getResourcesByUserAndPath((String) root.get("userId"), path),
                str2 = new ArrayList<>();
        for(Resource rs : str)
        {
            if(path.equals("/BackEndServer/page/home"+rs.getPath()))
                str2.add(rs);
        }
        
        root.put("folders", str2);
        Writer out = new StringWriter();
        root.put("page", "home.ftlh");
        temp.process(root, out);
        String s = out.toString();
        return s;
    }
     /**
     * TOODO This is in PageView!!!!!!!!!
     * Processes the request for 
     * @param path
     * @return
     * @throws IOException
     * @throws MalformedTemplateNameException
     * @throws TemplateException 
     */
    static String getLoginView(String path) throws IOException, MalformedTemplateNameException, TemplateException
    {
        
        Configuration cfg = initCfg();
              
        Map root = new HashMap();
        root.put("user", "home page");
        root.put("root","/BackEndServer");
        Template temp = cfg.getTemplate("login.ftlh");
        
        ArrayList<String> navItem = new ArrayList<>();
        
        ArrayList<Resource> str = init(), str2 = new ArrayList<>();
        
        Writer out = new StringWriter();
        temp.process(root, out);
        String s = out.toString();
        return s;
    }
    
    
    static String getProfileView(String path) throws IOException, TemplateException
    {
        Configuration cfg = initCfg();
        
        
        Map root = initMap();
        if(root == null)
            return "Not Authorized!";
        Template temp = cfg.getTemplate("index.ftlh");
        ArrayList<String> navItem = new ArrayList<>();
        String x[] = path.split("/");
        for(int i=3; i < x.length; i++)
        {
            System.out.println("s: "+x[i]);
            navItem.add(x[i]);
        }
        root.put("navItem", navItem);
        System.out.println(root.get("user"));
        Writer out = new StringWriter();
        root.put("page", "profile.ftlh");
        temp.process(root, out);
        String s = out.toString();
        return s;
        
    }
    
    static String getDefaultView(String path, String page) throws IOException, TemplateException
    {
        Configuration cfg = initCfg();
        Map root = initMap();
        if(root == null)
            return "Not Authorized!";
        Template temp = cfg.getTemplate("index.ftlh");
        ArrayList<String> navItem = new ArrayList<>();
        String x[] = path.split("/");
        for(int i=3; i < x.length; i++)
        {
            System.out.println("s: "+x[i]);
            navItem.add(x[i]);
        }
        root.put("navItem", navItem);
        Writer out = new StringWriter();
        root.put("page", page + ".ftlh");
        temp.process(root, out);
        String s = out.toString();
        return s;
        
    }
    
    static ArrayList<Resource> init()
    {
        ArrayList<Resource> a = new ArrayList<>();
        a.add(new Resource("Folder1", "", "folder", ""));
        a.add(new Resource("Folder2", "", "folder", ""));
        a.add(new Resource("Folder2", "/Folder1", "folder", ""));
        a.add(new Resource("Folder3", "/Folder1", "folder", ""));
        a.add(new Resource("Folder4", "/Folder1", "folder", ""));
        a.add(new Resource("FolderAscuns", "/Folder1/Folder2", "folder", ""));
        a.add(new Resource("Sal", "/Folder1/Folder2", "folder", ""));
        a.add(new Resource("FolderAscuns2", "/Folder1/Folder2/Sal", "folder", ""));
        a.add(new Resource("Sandokan", "/Folder1", "image", "https://i.ytimg.com/vi/mSUlhKVI1XQ/hqdefault.jpg"));
        a.add(new Resource("Sandokan", "", "image", "https://i.ytimg.com/vi/mSUlhKVI1XQ/hqdefault.jpg"));
        a.add(new Resource("Iepuras Video MP4", "", "video", "http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4"));
        a.add(new Resource("Iepuras Video", "/Folder2", "video", "http://www.webestools.com/page/media/videoTag/BigBuckBunny.webm"));
        a.add(new Resource("Sandokan", "/Folder1", "image", "https://i.ytimg.com/vi/mSUlhKVI1XQ/hqdefault.jpg"));
        a.add(new Resource("Sandokan", "/Folder2", "image", "https://i.ytimg.com/vi/mSUlhKVI1XQ/hqdefault.jpg"));
        a.add(new Resource("LEGO MP4", "", "video", "http://techslides.com/demos/sample-videos/small.mp4"));
        a.add(new Resource("Sandokan", "/Folder1/Folder2", "image", "https://i.ytimg.com/vi/mSUlhKVI1XQ/hqdefault.jpg"));
        a.add(new Resource("Sandokan", "/Folder1/Folder3", "image", "https://i.ytimg.com/vi/mSUlhKVI1XQ/hqdefault.jpg"));
        a.add(new Resource("Golummm", "", "image", "http://static.ziarelive.ro/images/stories/2012-10/67/interpretul-lui-gollum-va-regiza-filmul-ferma-animalelor.-vezi-cum-arata-in-realitate-cel-care-a-intruchipat-creatura-din-stapanul-inelelor.jpg"));
        a.add(new Resource("PDF File", "", "document", "http://www.axmag.com/download/pdfurl-guide.pdf"));
        return a;
    }
    
}
