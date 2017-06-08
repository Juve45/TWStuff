/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import facebook4j.Facebook;
import facebook4j.FacebookFactory;
import facebook4j.conf.*;

/**
 *
 * @author ada
 */
public class Alex {
    
    public void myFunction()
    {
        
ConfigurationBuilder cb = new ConfigurationBuilder();
cb.setDebugEnabled(true)
  .setOAuthAppId("630154653854447")
  .setOAuthAppSecret("9d01262093e875c8554f1c8fdc35aa7e")
  .setOAuthAccessToken("**************************************************")
  .setOAuthPermissions("email,publish_stream,...");
FacebookFactory ff = new FacebookFactory(cb.build());
Facebook facebook = ff.getInstance();
    

    }
    
}
