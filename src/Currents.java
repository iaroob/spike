import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.*;
import com.google.gson.reflect.*;

public class Currents {

    public static Map<String, Object> jsonToMap(String str) {
        Map<String, Object> map = new Gson().fromJson(
                str, new TypeToken<HashMap<String, Object>>() {}.getType()
        );

        return map;
    }

    public static void main(String[] args) throws IOException {

        String API_KEY = "QvCXINeI0wOX3t4rl5U-5tcIaaCNnV2fYCBtayiJplft3n7_";
        String myUrl = "https://api.currentsapi.services/v1/latest-news?"+"language=us&"+"apiKey="+API_KEY;

        try {
            StringBuilder result = new StringBuilder();
            URL url = new URL(myUrl);
            URLConnection conn = url.openConnection();
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;

            while ((line = rd.readLine()) != null) {
                result.append(line);
            }

            rd.close();
            System.out.println("Currents API");

            Map<String, Object> respMap = jsonToMap(result.toString()); // Guarda toda la info del fichero JSON

            System.out.println("Todo el fichero JSON: \n");
            System.out.println(respMap);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
