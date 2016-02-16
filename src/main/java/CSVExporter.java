import java.io.*;
import java.util.List;

/**
 * Created by Benjamin Reissaus on 16/02/16.
 */
public class CSVExporter {


    private String filePath = "data.csv";
    private static final String CSV_HEADER = "_id,name,type,longitude,latitude";
    private static final String DELIMITER = ",";
    private static final String NEW_LINE = "\n";

    public CSVExporter(){}
    public CSVExporter(String filePath) {
        this.filePath = filePath;
    }

    public void write(List<City> cities) {

        try {
            PrintWriter writer = new PrintWriter(new File(this.filePath), "UTF-8");
            writer.write(CSV_HEADER);
            writer.write(NEW_LINE);

            for (City city : cities) {
                writer.write(city.getId());
                writer.write(DELIMITER);
                writer.write(city.getName());
                System.out.println(city.getName());
                writer.write(DELIMITER);
                writer.write(city.getType());
                writer.write(DELIMITER);
                GeoPosition geoPosition = city.getGeoPosition();
                writer.write(geoPosition.getLongitude());
                writer.write(DELIMITER);
                writer.write(geoPosition.getLatitude());
                writer.write(NEW_LINE);
            }

            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
