package info.leanix.unittest.spike;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {

    String actualResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";

    @Test
    public void jsonAssertTest_StrictTrue_ExactMatchExceptForSpaces() throws JSONException {
        String expectedResponse =  "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, true);
    }
    @Test
    public void jsonAssertTest_StrictFalse() throws JSONException {
        String expectedResponse =  "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, false);
    }
    @Test
    public void jsonAssertTest_WithoutEscapeCharacters() throws JSONException {
        String expectedResponse =  "{id:1,name:Ball,price:10}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, false);
    }
}
