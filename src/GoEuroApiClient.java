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

    public void query(String city) {

    }

}
