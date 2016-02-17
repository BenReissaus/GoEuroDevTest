import org.junit.*;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import java.util.List;

/**
 * Created by Benjamin Reissaus on 16/02/16.
 */
public class TestGoEuroApiClient {

    private static GoEuroApiClient apiClient;

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @BeforeClass
    public static void setUp(){
        apiClient = new GoEuroApiClient();
    }

    @Test
    public void testQueryResultNotNull() {
        List<City> cities = apiClient.sendQuery("Berlin");
        Assert.assertNotEquals(null, cities);
    }

    @Test
    public void testQueryResultMoreThanOne() {
        List<City> cities = apiClient.sendQuery("Berlin");
        Assert.assertTrue(cities.size() > 0);
    }

    @Test
    public void testQueryResultContent() {
        List<City> cities = apiClient.sendQuery("Berlin");
        for (City city : cities) {
            Assert.assertTrue(city.getFullName().contains("Berlin"));
        }
    }

    @Test
    public void testBadQuery() {
        exit.expectSystemExitWithStatus(1);
        List<City> cities = apiClient.sendQuery("/");
    }

    @Test
    public void testEmptyResult() {
        List<City> cities = apiClient.sendQuery("aaaabbbbcccc");
        Assert.assertEquals(0, cities.size());
    }
}
