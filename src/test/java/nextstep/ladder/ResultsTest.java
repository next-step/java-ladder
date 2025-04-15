package nextstep.ladder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ResultsTest {

    @Test
    void testEmpty() {
        assertThrows(IllegalArgumentException.class, () -> Results.of(new String[0], new Location(1)));
    }
}
