import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class main {

    public static void main(String[] args) throws IOException, InterruptedException {

        String url = "";

        try {
            String link = "https://api.github.com/users/zhamri/followers?per_page=100&client_id=0a7e1f9cbc12c80138fe&client_secret=c4de03d8e58af0363a71c3efbeb6e7a695122de1";
            URL url1 = new URL(link);
            HttpURLConnection con = (HttpURLConnection) url1.openConnection();

            int responseCode = con.getResponseCode();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);

            }
            in.close();
            JSONArray data = new JSONArray(response.toString());
            array object = new array();
            for (int i = 0; i < data.length(); i++) {
                url = data.getJSONObject(i).getString("url");
                object.setArrayURL(url);

            }
            analyze a = new analyze(object);
            a.analyze();
            output out = new output(a.getdata());
            out.output();
            writeExcel write = new writeExcel();
            write.writeExcel();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}


