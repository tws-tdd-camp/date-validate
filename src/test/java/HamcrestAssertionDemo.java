import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.IsNull.notNullValue;

class HamcrestAssertionDemo {

    @Test
    void hamcrestAssertion() {
        assertThat("some text", allOf(notNullValue(), containsString("x")));
    }

    @Test
    void hasItemsAssertion() {
        List<String> actual = Arrays.asList("a", "b", "c");

        assertThat(actual, contains("a", "b", "c"));
        assertThat(actual, hasItems("c", "b"));
        assertThat(actual, containsInAnyOrder("c", "b", "a"));
    }


}


