/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postgetapi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author ada
 */
public class get {
     private final String USER_AGENT = "Mozilla/5.0";

	public void sendGet() throws Exception {

		String url =  "https://graph.facebook.com/v2.9/me?fields=id%2Cname&access_token=EAAI9H1BL6u8BAGMsxYVshVhTAtAAkN3nINUtrGM8WjSQVLZBCDLE6XDKC2aZAiIN6uzSOTZArZCd9mx6bEH3lZAE7JK9gENNQZBSVCQdIGQjn1i0Rh7UUkaoXdOYf8UFRAunTcf3aioPGl6jtAoYoGQNvNIwQw5gmrjZBWrTkK3DpVlHeiKaXdZBTFUo7yr5RtoZD";
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		System.out.println(response.toString());

	}
}
