import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.List;

/**
 * Created by Benjamin Reissaus on 16/02/16.
 */
public class TestCSVExporter {

    private CSVExporter csvExporter;
    private List<City> cities;
    private final File output = new File("data.csv");

    @Before
    public void setUp(){
        csvExporter = new CSVExporter();

        GoEuroApiClient goEuroApiClient = new GoEuroApiClient();
        cities = goEuroApiClient.sendQuery("Berlin");
    }

    @Test
    public void testOutputfileExistance() {

        CSVExporter csvExporter = new CSVExporter();
        csvExporter.write(cities);

        final File output = new File("data.csv");
        Assert.assertTrue(output.exists());
    }

    @Test
    public void testOutputfileHeader() throws IOException {

        CSVExporter csvExporter = new CSVExporter();
        csvExporter.write(cities);

        BufferedReader reader = new BufferedReader(new FileReader(output));
        String header = "_id,name,type,latitude,longitude";
        Assert.assertEquals(header, reader.readLine());
        reader.close();
    }

    @Test
    public void testOutputFileLineNumbers() throws IOException {

        CSVExporter csvExporter = new CSVExporter();
        csvExporter.write(cities);

        BufferedReader reader = new BufferedReader(new FileReader(output));
        int numberLines = 0;
        while(reader.readLine() != null){
            numberLines++;
        }

        // 1 extra line for header
        Assert.assertEquals(numberLines - 1, cities.size());
        reader.close();
    }

    @Test
    public void testOutputFileLineStructure() throws IOException {

        CSVExporter csvExporter = new CSVExporter();
        csvExporter.write(cities);

        BufferedReader reader = new BufferedReader(new FileReader(output));
        String line;
        while((line = reader.readLine()) != null){

            // each line must contain 4 commas
            Assert.assertTrue(line.matches("([^,]*,){4}[^,]*"));
        }

        reader.close();
    }
}

