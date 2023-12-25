package info.leanix.unittest.spike;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HamCrestMatcherTest {
    @Test
    public void learning() {
        List<Integer> numbers = Arrays.asList(12,12,45);
        assertThat(numbers,hasSize(3));
        assertThat(numbers, hasItems(12,45));
        assertThat(numbers,everyItem(greaterThan(10)));
        assertThat(numbers,everyItem(lessThan(100)));

        assertThat("", isEmptyString());
        assertThat("ABCD", containsString("BCD"));
        assertThat("ABCD", startsWith("ABC"));
        assertThat("ABCD", endsWith("BCD"));
    }
}
