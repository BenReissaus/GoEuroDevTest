import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * Created by Benjamin Reissaus on 12/02/16.
 */
public class GoEuroApiClient {

    private String apiUrl = "http://api.goeuro.com/api/v2/position/suggest/en/";

    public GoEuroApiClient(){
    }

    public GoEuroApiClient(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public JSONArray sendQuery(String city) {

        JSONArray jsonArray = null;

        // send request to api
        try {
            URL apiUrl = new URL(this.apiUrl + city);

            // set up connection and request parameters
            HttpURLConnection con = (HttpURLConnection) apiUrl.openConnection();
            con.setRequestMethod("GET");


            // load JSON resource
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new InputStreamReader(con.getInputStream()));


            if (obj instanceof JSONArray) {
                jsonArray = (JSONArray) obj;
                return jsonArray;
            }
            else {
                System.out.println("Something other than a JSON Array was returned from the API. Can't handle that, sorry!");
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return jsonArray;
    }
}
