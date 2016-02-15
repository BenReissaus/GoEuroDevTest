import org.json.simple.JSONArray;

public class Main {

    public static void main(String[] args) {
        GoEuroApiClient apiClient = new GoEuroApiClient();
        JSONArray jsonArray = apiClient.sendQuery("Berlin");
        System.out.println(jsonArray.toJSONString());
    }
}
