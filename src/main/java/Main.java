import java.util.List;

public class Main {

    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("Please provide a city name as an argument.");
            System.exit(1);
        }
        String cityName = args[0];

        GoEuroApiClient apiClient = new GoEuroApiClient();
        List<City> cities = apiClient.sendQuery(cityName);
        CSVExporter csvExporter = new CSVExporter();
        csvExporter.write(cities);
    }
}
