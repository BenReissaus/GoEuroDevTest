import java.util.List;

public class Main {

    public static void main(String[] args) {
        GoEuroApiClient apiClient = new GoEuroApiClient();
        List<City> cities = apiClient.sendQuery("Berlin");
        System.out.println(cities);
    }
}
