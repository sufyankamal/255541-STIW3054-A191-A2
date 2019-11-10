import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class analyze extends Thread {

    array url;
    JSONObject[] data;
    private List<String> arrayURL = new ArrayList<>();

    public analyze(array url1) {
        this.url = url1;
    }

    public void analyze() {
        arrayURL = url.getArrayURL();
        data = new JSONObject[arrayURL.size()];
        int i = 0;
        for (String link : arrayURL) {
            try {
                String Link = link.concat("?client_id=0a7e1f9cbc12c80138fe&client_secret=c4de03d8e58af0363a71c3efbeb6e7a695122de1");
                URL obj = new URL(Link);
                HttpURLConnection con = (HttpURLConnection) obj.openConnection();

                int responseCode = con.getResponseCode();
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                data[i] = new JSONObject(response.toString());
                i++;
            } catch (Exception e) {
                e.printStackTrace();
            }


        }

    }
    public JSONObject[] getdata() {return data;}
}