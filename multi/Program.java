import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Base64;

public class Program {
    
    public static void main(String[] args) {
      java.net.URL url = null;
      String username = "user";
      String password = "gitpwd";
      String file = "";
      try {
          url = new java.net.URL("https://raw.githubusercontent.com/lrjoshi/webpage/master/public/post/c159s.csv");
          java.net.URLConnection uc;
          uc = url.openConnection();

          uc.setRequestProperty("X-Requested-With", "Curl");
          java.util.ArrayList<String> list = new java.util.ArrayList<String>();
          String userpass = username + ":" + password;
          String basicAuth = "Basic " + new String(Base64.getEncoder().encode(userpass.getBytes()));//needs Base64 encoder, apache.commons.codec
          uc.setRequestProperty("Authorization", basicAuth);

          BufferedReader reader = new BufferedReader(new InputStreamReader(uc.getInputStream()));
          String line = null;
          while ((line = reader.readLine()) != null)
              file = file + line + "\n";
          System.out.println(file);

      } catch (IOException e) {
          System.out.println("Wrong username and password");
      }
    }
        
}
