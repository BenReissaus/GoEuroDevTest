import java.util.List;

public class Main {

    public static void main(String[] args) {
        GoEuroApiClient apiClient = new GoEuroApiClient();
        List<City> cities = apiClient.sendQuery("Berlin");
        CSVExporter csvExporter = new CSVExporter();
        csvExporter.write(cities);
    }
}
