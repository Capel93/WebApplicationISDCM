/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RestClient;

/**
 *
 * @author Josep D. Capdevila
 */
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;



public class PostViews {

	public static void ViewsPost(int id) {
                System.out.print(String.valueOf(id));
                excutePost("http://localhost:8080/ISDCMRest/webresources/views?id="+String.valueOf(id));
               
	}
        
         public static String excutePost(String targetURL) {
            HttpURLConnection connection = null;  
            try {
              //Create connection
              URL url = new URL(targetURL);
              connection = (HttpURLConnection)url.openConnection();
              connection.setRequestMethod("POST");

              //connection.setRequestProperty("Content-Type", application/x-www-form-urlencoded");

              //connection.setRequestProperty("Content-Length", Integer.toString(urlParameters.getBytes().length));
              //connection.setRequestProperty("Content-Language", "en-US");  

              connection.setUseCaches(false);
              connection.setDoOutput(true);

              //Send request
             /* DataOutputStream wr = new DataOutputStream (
                  connection.getOutputStream());
              wr.writeBytes(urlParameters);
              wr.close();
*/
              //Get Response  
              InputStream is = connection.getInputStream();
              BufferedReader rd = new BufferedReader(new InputStreamReader(is));
              StringBuilder response = new StringBuilder(); // or StringBuffer if not Java 5+ 
              String line;
              while((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
              }
              rd.close();
              return response.toString();
            } catch (Exception e) {
              e.printStackTrace();
              return null;
            } finally {
              if(connection != null) {
                connection.disconnect(); 
              }
            }
          }


}