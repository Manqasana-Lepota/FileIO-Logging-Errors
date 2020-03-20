import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VisitorTest {

    @Test

    public void saveVisitorTest() {

        String expected = "Successfully saved !!";
        String results = Visitor.save("Successfully saved !!");

        Assert.assertEquals(expected,results);


    }

    public void loadVisitorTest() {

    }

}