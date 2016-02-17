import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

/**
 * Created by Benjamin Reissaus on 17/02/16.
 */
public class TestMain {

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void testWrongNumberArguments() {
        exit.expectSystemExitWithStatus(1);
        Main.main(new String[] {});
    }
}
