import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import org.apache.http.HttpStatus;

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

    public List<City> sendQuery(String city) {

        List<City> cities = null;

        try {
            URL apiUrl = new URL(this.apiUrl + city);

            // set up connection and request parameters
            HttpURLConnection con = (HttpURLConnection) apiUrl.openConnection();
            con.setRequestMethod("GET");


            int responseCode = con.getResponseCode();
            if(responseCode == HttpStatus.SC_OK) { // server answered with 200

                // retrieve JSON Object and deserialize it into list of City objects
                ObjectMapper objMapper = new ObjectMapper();
                cities = Arrays.asList(objMapper.readValue(con.getInputStream(), City[].class));

            } else {

                System.out.println("The query could not be processed properly. The server answered with: "
                        + responseCode + " - " + con.getResponseMessage());
                System.exit(1);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cities;
    }
}
