/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author alexandru
 */
public class HttpRequestHandler {
    
    public static String doRequest(String url, String json, int timeout, String method) {
        HttpURLConnection connection = null;
        try {

            URL u = new URL(url);
            connection = (HttpURLConnection) u.openConnection();
            connection.setRequestMethod(method);

            connection.addRequestProperty("grant_type", "authorization_code");
            connection.addRequestProperty("code", json);
            connection.addRequestProperty("grant_type", "authorization_code");
            
            //set the sending type and receiving type to json
            //connection.setRequestProperty("Content-Type", "application/json");
            //connection.setRequestProperty("Accept", "application/json");

            connection.setAllowUserInteraction(false);
            connection.setConnectTimeout(timeout);
            connection.setReadTimeout(timeout);

            if (json != null) {
                //set the content length of the body
                connection.setRequestProperty("Content-length", json.getBytes().length + "");
                connection.setDoInput(true);
                connection.setDoOutput(true);
                connection.setUseCaches(false);

                //send the json as body of the request
                OutputStream outputStream = connection.getOutputStream();
                outputStream.write(json.getBytes("UTF-8"));
                outputStream.close();
            }

            //Connect to the server
            connection.connect();

            int status = connection.getResponseCode();
            //Log.i("HTTP Client", "HTTP status code : " + status);
            switch (status) {
                case 200:
                case 201:
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    StringBuilder sb = new StringBuilder();
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        sb.append(line + "\n");
                    }
                    bufferedReader.close();
                    //Log.i("HTTP Client", "Received String : " + sb.toString());
                    //return received string
                    return sb.toString();
            }

        } catch (MalformedURLException ex) {
            //Log.e("HTTP Client", "Error in http connection" + ex.toString());
        } catch (IOException ex) {
//        Log.e("HTTP Client", "Error in http connection" + ex.toString());
        } catch (Exception ex) {
            //      Log.e("HTTP Client", "Error in http connection" + ex.toString());
        } finally {
            if (connection != null) {
                try {
                    connection.disconnect();
                } catch (Exception ex) {
                    //            Log.e("HTTP Client", "Error in http connection" + ex.toString());
                }
            }
        }
        return null;
    }

}
