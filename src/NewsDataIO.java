import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.*;
import com.google.gson.reflect.*;

public class NewsDataIO {

    public static Map<String, Object> jsonToMap(String str) {
        Map<String, Object> map = new Gson().fromJson(
                str, new TypeToken<HashMap<String, Object>>() {}.getType()
        );

        return map;
    }

    public static void main(String[] args) throws IOException {

        String API_KEY = "pub_1720d76ce70402502a760bd1c934f2ea0662";
        String myUrl = "https://newsdata.io/api/1/news?apikey=" + API_KEY;

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
            System.out.println("NewsDataIO API");

            Map<String, Object> respMap = jsonToMap(result.toString()); // Guarda toda la info del fichero JSON
            Object res = respMap.get("results");
            System.out.println();

            System.out.println("Todo el fichero JSON: \n");
            System.out.println(respMap);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
